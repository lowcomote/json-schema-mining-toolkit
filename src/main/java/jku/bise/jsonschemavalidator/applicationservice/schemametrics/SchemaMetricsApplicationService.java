package jku.bise.jsonschemavalidator.applicationservice.schemametrics;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import jku.bise.jsonschemavalidator.exception.JsonParseException;

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

	public JsonSchemaMetricsDTO findSchemaMetrics(File file, String csvFileName) throws ApplicationServiceException  {
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
			}
			return  jsonSchemaMetricsDTO;
		} catch (JsonParseException e) {
			throw new ApplicationServiceException(e.getMessage(),e);
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
		return jsonSchemaMetricsDTO;
	}
	
	/**
	 * TODO rename
	 * @param jsonObject
	 * @param keywords
	 * @param jsonSchemaMetricsDTO
	 */
	private void findMetrics(JSONObject jsonObject, List<String> keywords, JsonSchemaMetricsDTO jsonSchemaMetricsDTO, GraphMetricDTO parentGraphMetricDTO) {
		GraphMetricDTO localGraphMetricDTO = parentGraphMetricDTO.clone();
		localGraphMetricDTO.incrementDepthSchema();
		Set<String> keys =jsonObject.keySet();
		keys.stream().forEach(key->{
			if(keywords.contains(key)) {
				int count = jsonSchemaMetricsDTO.getKeywordsCount(key);
				jsonSchemaMetricsDTO.putKeywordsCount(key, count+1);
				accumulateType(key, jsonObject,  jsonSchemaMetricsDTO) ;
			}
			JSONObject child = jsonObject.optJSONObject(key);

			if(child!=null) {
				if(CommonDraftsKeywords.PROPERTIES.equals(key)) {
					localGraphMetricDTO.setFanOut(child.keySet().size());
				}
				findMetrics(child,  keywords,   jsonSchemaMetricsDTO, localGraphMetricDTO.clone());
			}else {
				// it is a leaf
				jsonSchemaMetricsDTO.getGraphMetricDTO().incrementWidth();
			}
			updateJsonSchemaGraphMetric(jsonSchemaMetricsDTO, localGraphMetricDTO);
		});
	}
	
	/**
	 * This method accumulates the occurrences for each type if potentialTypeKeyword is "type"
	 * @param potentialTypeKeyword
	 * @param jsonObject
	 * @param jsonSchemaMetricsDTO
	 */
	private void accumulateType(String potentialTypeKeyword, JSONObject jsonObject, JsonSchemaMetricsDTO jsonSchemaMetricsDTO) {
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
	
	private void updateJsonSchemaGraphMetric(JsonSchemaMetricsDTO jsonSchemaMetricsDTO, GraphMetricDTO localGraphMetricDTO) {
		GraphMetricDTO jsonSchemaGraphMetricDTO = jsonSchemaMetricsDTO.getGraphMetricDTO();
		if(jsonSchemaGraphMetricDTO.getDepthSchema()<localGraphMetricDTO.getDepthSchema()) {
			jsonSchemaGraphMetricDTO.setDepthSchema(localGraphMetricDTO.getDepthSchema());
		}
		if(jsonSchemaGraphMetricDTO.getFanOut()<localGraphMetricDTO.getFanOut()) {
			jsonSchemaGraphMetricDTO.setFanOut(localGraphMetricDTO.getFanOut());
		}
		
	}
	
	
	
	
}
