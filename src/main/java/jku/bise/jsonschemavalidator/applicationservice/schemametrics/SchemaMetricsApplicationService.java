package jku.bise.jsonschemavalidator.applicationservice.schemametrics;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.CommonDraftsKeywords;
import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft03Keywords;
import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft04Keywords;
import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft06Keywords;
import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft07Keywords;
import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft201909Keywords;
import jku.bise.jsonschemavalidator.common.Utils;
import jku.bise.jsonschemavalidator.dto.GraphMetricDTO;
import jku.bise.jsonschemavalidator.dto.JsonSchemaMetricsDTO;
import jku.bise.jsonschemavalidator.exception.ApplicationServiceException;

@Service
public class SchemaMetricsApplicationService {
	private static Logger logger = LoggerFactory.getLogger(SchemaMetricsApplicationService.class);
	
	public List<JsonSchemaMetricsDTO> findSchemaMetricsInFileOrDirectory(String pathToDir, String csvFileName) throws ApplicationServiceException  {
		List<JsonSchemaMetricsDTO> jsonSchemaMetricsDTOs = new ArrayList<JsonSchemaMetricsDTO>();
		File fileOrdir = new File(pathToDir);
		if (fileOrdir.isDirectory())
			for (File file : fileOrdir.listFiles()) {
				JsonSchemaMetricsDTO jsonSchemaMetricsDTO =findSchemaMetrics(file, csvFileName);
				if(jsonSchemaMetricsDTO!=null) {
					jsonSchemaMetricsDTOs.add(jsonSchemaMetricsDTO);
				}
			}
		else {
			JsonSchemaMetricsDTO jsonSchemaMetricsDTO = findSchemaMetrics(fileOrdir, csvFileName);
			if(jsonSchemaMetricsDTO!=null) {
				jsonSchemaMetricsDTOs.add(jsonSchemaMetricsDTO);
			}
		}
		return jsonSchemaMetricsDTOs;
	}

	public JsonSchemaMetricsDTO findSchemaMetrics(File file, String csvFileName)   {
		logger.debug("findSchemaMetrics");
		JsonSchemaMetricsDTO jsonSchemaMetricsDTO = null;
		try {
			List<String> keywordList=null;
			JSONObject jsonObject = Utils.buildJsonObjectFromFile(file);
			String schema = Utils.getSchemaDraftWithoutHashtag(jsonObject);
			if(schema!=null) {
				if(Utils.isDraft4(schema)) {
					keywordList = Draft04Keywords.KEYWORDS_LIST;
				}else if (Utils.isDraft6(schema)){
					keywordList = Draft06Keywords.KEYWORDS_LIST;
				}else if (Utils.isDraft7(schema)) {
					keywordList = Draft07Keywords.KEYWORDS_LIST;
				}else if (Utils.isDraft3(schema)) {
					keywordList = Draft03Keywords.KEYWORDS_LIST;
				} else if (Utils.isDraft201909(schema)) {
					keywordList = Draft201909Keywords.KEYWORDS_LIST;
				}
			}
			if(keywordList!=null) {
				jsonSchemaMetricsDTO = findSchemaMetrics( jsonObject, keywordList);
				jsonSchemaMetricsDTO.setName(file.getName());
				jsonSchemaMetricsDTO.setSchema(schema);
				if(logger.isDebugEnabled()) {
					logger.debug("Metrics : {}", jsonSchemaMetricsDTO.toString());
				}
			}
			return  jsonSchemaMetricsDTO;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public JsonSchemaMetricsDTO findSchemaMetrics(JSONObject jsonObject, List<String> keywords) {
		JsonSchemaMetricsDTO jsonSchemaMetricsDTO = new JsonSchemaMetricsDTO();
		keywords.stream().forEach(key->{
			jsonSchemaMetricsDTO.putKeywordsCount(key, 0);
		});
		 CommonDraftsKeywords.TYPE_LIST.stream().forEach(type->{
			jsonSchemaMetricsDTO.putTypesCount(type, 0);
		});
		GraphMetricDTO parentGraphMetricDTO = jsonSchemaMetricsDTO.getGraphMetricDTO().clone();
		findMetrics(jsonObject, keywords, jsonSchemaMetricsDTO,parentGraphMetricDTO);
		processReferences(jsonSchemaMetricsDTO);
		
		return jsonSchemaMetricsDTO;
	}
	
	
	private void findMetrics(JSONObject jsonObject, List<String> keywords, JsonSchemaMetricsDTO jsonSchemaMetricsDTO, GraphMetricDTO parentGraphMetricDTO) {
		try {
			String parentKey = Utils.digestSlashAndDot(parentGraphMetricDTO.getPointer());
			boolean isParentKeyProperty = CommonDraftsKeywords.PROPERTIES.equals(parentKey);
			
			Set<String> keys =jsonObject.keySet();
			for(String key :keys) {
				boolean isLeaf=true;
				GraphMetricDTO localKeyGraphMetricDTO = parentGraphMetricDTO.clone();
				localKeyGraphMetricDTO.appendToPointer(key);
				localKeyGraphMetricDTO.incrementDepthSchema();
				updateDepthSchema(jsonSchemaMetricsDTO, localKeyGraphMetricDTO );
				
				boolean isKeyword= updateKeywordsAndTypeCounter(jsonObject, keywords, jsonSchemaMetricsDTO,  key);
//				boolean isKeyword=false;
//				if(keywords.contains(key)) {
//					isKeyword = true;
//					int count = jsonSchemaMetricsDTO.getKeywordsCount(key);
//					jsonSchemaMetricsDTO.putKeywordsCount(key, count+1);
//					updateTypeCounters(key, jsonObject,  jsonSchemaMetricsDTO) ;
//				}
				
				updateFanOut(jsonSchemaMetricsDTO, jsonObject, key);
				
				JSONObject child = jsonObject.optJSONObject(key);
				if(child!=null) {
					isLeaf=false;
//					if(CommonDraftsKeywords.PROPERTIES.equals(key)) {
//						localKeyGraphMetricDTO.setFanOut(child.keySet().size());
//					}

					//if(isParentKeyProperty && child.has(CommonDraftsKeywords.REF)) {
					if(child.has(CommonDraftsKeywords.REF)) {
						String ref = child.getString(CommonDraftsKeywords.REF);
						
						//jsonSchemaMetricsDTO.getReferencer().put(ref, localKeyGraphMetricDTO);
						jsonSchemaMetricsDTO.putReferencer(ref, localKeyGraphMetricDTO);
					}
					/**
					 * if key is not keyword and its value is a schema (JsonObject) it is a reachable object
					 */
					if(!isKeyword) {
						/**
						 * Reachable object. 
						 */
						jsonSchemaMetricsDTO.getReferable().put(localKeyGraphMetricDTO.getPointer(), localKeyGraphMetricDTO);
						String idKey = getIdKey(keywords);
						if(child.has(idKey)) {
							/**
							 * We can reference child with its id too. If it has one.
							 */
							String id = jsonObject.getString(idKey);
							jsonSchemaMetricsDTO.getReferable().put(id, localKeyGraphMetricDTO);
						}
						/**
						 * FAN IN: if its parent is "property" it is already reference by its father.
						 */
						if(isParentKeyProperty) {
							localKeyGraphMetricDTO.setFanIn(1);
						}
					}
					
					findMetrics(child,  keywords,   jsonSchemaMetricsDTO, localKeyGraphMetricDTO);
					updateDepthResolvedTree(parentGraphMetricDTO, localKeyGraphMetricDTO);
//					if(parentGraphMetricDTO.getDepthResolvedTree()<=localKeyGraphMetricDTO.getDepthResolvedTree()) {
//						parentGraphMetricDTO.setDepthResolvedTree(localKeyGraphMetricDTO.getDepthResolvedTree()+1);
//					}
					
				}else {
					/**
					 * It could be an array
					 */
					JSONArray childArray = jsonObject.optJSONArray(key);
					if(childArray!=null) {
						//boolean isLeaf=true;
						for (int i=0; i<childArray.length();i++) {
							JSONObject childArrayJSONObject = childArray.optJSONObject(i);
							if(childArrayJSONObject !=null) {
								isLeaf=false;
								findMetrics(childArrayJSONObject,  keywords,   jsonSchemaMetricsDTO, localKeyGraphMetricDTO);
							}
						}
//						if(isLeaf) {
//							jsonSchemaMetricsDTO.getGraphMetricDTO().incrementWidth();
//						}
					}/*else {
					
						
						jsonSchemaMetricsDTO.getGraphMetricDTO().incrementWidth();
					}*/
				}
				if(isLeaf) {
					/**
					 *  A key is leaf when its child is not a JsonObject and is not an array with json objects inside
					 */
					jsonSchemaMetricsDTO.getGraphMetricDTO().incrementWidth();
					updateDepthResolvedTree(parentGraphMetricDTO, localKeyGraphMetricDTO);
				}
			}
			//updateJsonSchemaGraphMetric(jsonSchemaMetricsDTO, parentGraphMetricDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private void updateDepthResolvedTree(GraphMetricDTO parentGraphMetricDTO,  GraphMetricDTO localKeyGraphMetricDTO) {
		if(parentGraphMetricDTO.getDepthResolvedTree()<=localKeyGraphMetricDTO.getDepthResolvedTree()) {
			parentGraphMetricDTO.setDepthResolvedTree(localKeyGraphMetricDTO.getDepthResolvedTree()+1);
		}
	}
	
	private void updateDepthSchema(JsonSchemaMetricsDTO jsonSchemaMetricsDTO, GraphMetricDTO localKeyGraphMetricDTO) {
		if(jsonSchemaMetricsDTO.getGraphMetricDTO().getDepthSchema()<localKeyGraphMetricDTO.getDepthSchema()) {
			jsonSchemaMetricsDTO.getGraphMetricDTO().setDepthSchema(localKeyGraphMetricDTO.getDepthSchema());
		}
		
	}

	/**
	 * 
	 * If parent.childKey is a JSONObject the fanout is the number of its keys
	 * If parent.childKey is a JSONArray the fanout is the number of its elements that are JSONObject
	 * 
	 * @param jsonSchemaMetricsDTO
	 * @param parent
	 * @param childKey
	 */
	private void updateFanOut(JsonSchemaMetricsDTO jsonSchemaMetricsDTO, JSONObject parent, String childKey) {
		int fanOut = 0;
		JSONObject childObject = parent.optJSONObject(childKey);
		if(childObject!=null) {
			fanOut = childObject.keySet().size();
		}else {
			JSONArray childArray=parent.optJSONArray(childKey);
			if(childArray!=null) {
				for (int i=0; i<childArray.length();i++) {
					if(childArray.optJSONObject(i)!=null) {
						fanOut++;
					}
				}
			}
		}
		if(jsonSchemaMetricsDTO.getGraphMetricDTO().getFanOut()<fanOut) {
			jsonSchemaMetricsDTO.getGraphMetricDTO().setFanOut(fanOut);
		}
		
		
	}
	
	private boolean updateKeywordsAndTypeCounter(JSONObject jsonObject, List<String> keywords,  JsonSchemaMetricsDTO jsonSchemaMetricsDTO, String key) {
		boolean isKeyword = false;
		if(keywords.contains(key)) {
			isKeyword = true;
			int count = jsonSchemaMetricsDTO.getKeywordsCount(key);
			jsonSchemaMetricsDTO.putKeywordsCount(key, count+1);
			updateTypeCounters(key, jsonObject,  jsonSchemaMetricsDTO) ;
		}
		return isKeyword;
	}
	
	private void processReferences(JsonSchemaMetricsDTO jsonSchemaMetricsDTO) {
		GraphMetricDTO mainGraphMetricDTO = jsonSchemaMetricsDTO.getGraphMetricDTO();
		Map<String, List<GraphMetricDTO>> referencers = jsonSchemaMetricsDTO.getReferencer();
		Map<String, GraphMetricDTO> referables = jsonSchemaMetricsDTO.getReferable();
		
		for(Iterator<Entry<String, List<GraphMetricDTO>>> referencersIterator = referencers.entrySet().iterator(); referencersIterator.hasNext();) {
			Entry<String, List<GraphMetricDTO>> referencersEntry = referencersIterator.next(); 
			String ref = referencersEntry.getKey();
			List<GraphMetricDTO> referencerGraphMetricDTOs = referencersEntry.getValue();
			GraphMetricDTO referredGraphMetricDTO = referables.get(ref);
			
			if(referredGraphMetricDTO!=null) {
				for (Iterator<GraphMetricDTO>  referencerGraphMetricDTOsIterator = referencerGraphMetricDTOs.iterator(); referencerGraphMetricDTOsIterator.hasNext();) {
					
					GraphMetricDTO referencerGraphMetricDTO = referencerGraphMetricDTOsIterator.next();
					referredGraphMetricDTO.incrementFanIn();
					/**
					 * DEPTH_RESOLVED_TREE we sum +2 because the $ref and the root of the referred
					 */
					int depthResolvedTree =referredGraphMetricDTO.getDepthResolvedTree()+referencerGraphMetricDTO.getDepthSchema()+2;
					if(mainGraphMetricDTO.getDepthResolvedTree()<depthResolvedTree) {
						mainGraphMetricDTO.setDepthResolvedTree(depthResolvedTree);
					}
					
					/**
					 * Recursion management
					 */
					if(referencerGraphMetricDTO.getPointer().startsWith(referredGraphMetricDTO.getPointer())) {
						mainGraphMetricDTO.incrementRecursions();
						int cicleLength = referencerGraphMetricDTO.getDepthSchema()-referredGraphMetricDTO.getDepthSchema();
						if(cicleLength < mainGraphMetricDTO.getMinCycleLen()) {
							mainGraphMetricDTO.setMinCycleLen(cicleLength);
						}
						if(cicleLength>mainGraphMetricDTO.getMaxCycleLen()) {
							mainGraphMetricDTO.setMaxCycleLen(cicleLength);
						}
					}
				}
				referencersIterator.remove();
			}
		}
		
		/**
		 * UNSOLVED_REFS: elements not removed from referencers does not reach any referable.
		 */
		mainGraphMetricDTO.setUnsolvedRefs(referencers.size());
		
		/**
		 * Find distinct referables elements. There can be duplicated in case of id present in the referable GraphMetricDTO
		 */
		List<GraphMetricDTO> distinctReferables = referables.values().stream().distinct().collect(Collectors.toList());
		
		/**
		 * FAN_IN: find max fanIn;
		 */
		Optional<GraphMetricDTO> maxFanInGraphMetricDTO = distinctReferables.stream().max(Comparator.comparing(GraphMetricDTO::getFanIn));
		maxFanInGraphMetricDTO.ifPresent( max-> {mainGraphMetricDTO.setFanIn(max.getFanIn());});
		
		/**
		 * UNREACHABLES:  referable elements with fanIn == 0 have not ben reached
		 */
		int unreachables = (int) distinctReferables.stream().filter(referable -> referable.getFanIn()==0).count();
		mainGraphMetricDTO.setUnreachables(unreachables);
		
	}
	
	
	
	/**
	 * This method accumulates the occurrences for each type if potentialTypeKeyword is "type"
	 * @param potentialTypeKeyword
	 * @param jsonObject
	 * @param jsonSchemaMetricsDTO
	 */
	private void updateTypeCounters(String potentialTypeKeyword, JSONObject jsonObject, JsonSchemaMetricsDTO jsonSchemaMetricsDTO) {
		if(CommonDraftsKeywords.TYPE.equals(potentialTypeKeyword)) {
			if(jsonObject.isNull(potentialTypeKeyword)) {
				int count = jsonSchemaMetricsDTO.getTypesCount(CommonDraftsKeywords.TYPE_NULL);
				jsonSchemaMetricsDTO.putTypesCount(CommonDraftsKeywords.TYPE_NULL, count+1);
			}else if (jsonObject.optJSONArray(potentialTypeKeyword)!=null) {
				int count = jsonSchemaMetricsDTO.getTypesCount(CommonDraftsKeywords.ARRAY_OF_TYPES);
				jsonSchemaMetricsDTO.putTypesCount(CommonDraftsKeywords.ARRAY_OF_TYPES, count+1);
			}else {
				String type = jsonObject.optString(potentialTypeKeyword);
				if(type!=null && CommonDraftsKeywords.TYPE_LIST.contains(type)) {
					int count = jsonSchemaMetricsDTO.getTypesCount(type);
					jsonSchemaMetricsDTO.putTypesCount(type, count+1);
				}
			}
		}
	}
	
	private String getIdKey(List<String> keywords) {
		if(keywords.contains(Draft03Keywords.ID)) {
			return Draft03Keywords.ID;
		}else {
			return Draft07Keywords.ID;
		}
	}
	
	
	
	
}
