package jku.bise.jsonschemavalidator.applicationservice.schemagrams;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft03Keywords;
import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft04Keywords;
import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft06Keywords;
import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft07Keywords;
import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft201909Keywords;
import jku.bise.jsonschemavalidator.common.Utils;
import jku.bise.jsonschemavalidator.dto.SchemaGramsDTO;

@Service
public class SchemaGramsApplicationService {

	private static Logger logger = LoggerFactory.getLogger(SchemaGramsApplicationService.class);
	
	
	
	
	public List<SchemaGramsDTO> buildGramsInFileOrDirectory(String pathToDir)    {
		List<SchemaGramsDTO> schemaGramsDTOs = new ArrayList<SchemaGramsDTO>();
		File fileOrdir = new File(pathToDir);
		if (fileOrdir.isDirectory())
			for (File file : fileOrdir.listFiles()) {
				SchemaGramsDTO schemaGramsDTO =createSchemaGramsDTO(file);
				if(schemaGramsDTO!=null) {
					schemaGramsDTOs.add(schemaGramsDTO);
				}
			}
		else {
			SchemaGramsDTO schemaGramsDTO = createSchemaGramsDTO(fileOrdir);
			if(schemaGramsDTO!=null) {
				schemaGramsDTOs.add(schemaGramsDTO);
			}
		}
		return schemaGramsDTOs;
	}
	
	public SchemaGramsDTO createSchemaGramsDTO(File file) {
		try {
			JSONObject jsonObject = Utils.buildJsonObjectFromFile(file);
			//return createSchemaGramsDTO(file.getName(),  jsonObject);
			return createSchemaGramsDTO(file.getName(),  jsonObject);
		} catch (Exception e) {
			if(logger.isDebugEnabled()) 
				logger.error("{} with {}",file.toString(), e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	private SchemaGramsDTO createSchemaGramsDTO(String name, JSONObject jsonObject) throws Exception {
		
			SchemaGramsDTO schemaGramsDTO = new SchemaGramsDTO();
			schemaGramsDTO.setName(name);
			List<String> keywordList=null;
			String schema = Utils.getSchemaDraftWithoutHashtag(jsonObject);
			schemaGramsDTO.setSchema(schema);
			//String parent = "";
			if(schema!=null) {
				if(Utils.isDraft4(schema)) {
					keywordList = Draft04Keywords.KEYWORDS_LIST;
					//String keyId= Draft04Keywords.ID;
					//parent = getParentName(jsonObject, keyId, name);
				}else if (Utils.isDraft6(schema)){
					keywordList = Draft06Keywords.KEYWORDS_LIST;
					//String keyId= Draft06Keywords.ID;
					//parent = getParentName(jsonObject, keyId, name);
				}else if (Utils.isDraft7(schema)) {
					keywordList = Draft07Keywords.KEYWORDS_LIST;
					//String keyId= Draft07Keywords.ID;
					//parent = getParentName(jsonObject, keyId, name);
				}else if (Utils.isDraft3(schema)) {
					keywordList = Draft03Keywords.KEYWORDS_LIST;
					//String keyId= Draft03Keywords.ID;
					//parent = getParentName(jsonObject, keyId, name);
				} else if (Utils.isDraft201909(schema)) {
					keywordList = Draft201909Keywords.KEYWORDS_LIST;
					//String keyId= Draft201909Keywords.ID;
					//parent = getParentName(jsonObject, keyId, name);
				}
			}
			if(keywordList!=null) {
				addUnigrams(jsonObject, schemaGramsDTO, keywordList);
				//String parent = Utils.stripDot(name);
				addBigrams("",jsonObject, schemaGramsDTO,keywordList);
			}
			if(logger.isDebugEnabled()) {
				logger.debug("GRAMS : {}", schemaGramsDTO.toString());
			}
			return schemaGramsDTO;
		
	}
	
	private void addUnigrams(JSONObject jsonObject, SchemaGramsDTO schemaGramsDTO, List<String> keywords) {
		Set<String> keys= jsonObject.keySet();
		keys.forEach(key->{
			if(!keywords.contains(key)) {
				schemaGramsDTO.addUnigram(key);
			}
			JSONObject childNodeJSONObject =  jsonObject.optJSONObject(key);
			if(childNodeJSONObject!=null) {
				addUnigrams(childNodeJSONObject,  schemaGramsDTO,  keywords);
			}else {
				JSONArray childNodeJSONArray = jsonObject.optJSONArray(key);
				if(childNodeJSONArray!=null) {
					for (int i=0; i<childNodeJSONArray.length(); i++) {
						JSONObject childNodeJSONArrayJSONObject = childNodeJSONArray.optJSONObject(i);
						if(childNodeJSONArrayJSONObject!=null) {
							addUnigrams(childNodeJSONArrayJSONObject,  schemaGramsDTO,  keywords);
						}
					}
				}
			}
		});
	}
	
	private void addBigrams(String parent, JSONObject jsonObject, SchemaGramsDTO schemaGramsDTO, List<String> keywords) {
		Set<String> keys= jsonObject.keySet();
		
		keys.forEach(key->{
			String nextParent = parent;
			if(!keywords.contains(key)) {
				nextParent=key;
				String camelParent = toCamelCase(parent);
				String antiCamelKey= toAntiCamelCase(key);
				String bigram = camelParent+"."+antiCamelKey;
				schemaGramsDTO.addBigram(bigram);
			}
			JSONObject childNode =  jsonObject.optJSONObject(key);
			if(childNode!=null) {
				addBigrams(nextParent,childNode,  schemaGramsDTO,  keywords);
			}else {
				JSONArray childNodeJSONArray = jsonObject.optJSONArray(key);
				if(childNodeJSONArray!=null) {
					for (int i=0; i<childNodeJSONArray.length(); i++) {
						JSONObject childNodeJSONArrayJSONObject = childNodeJSONArray.optJSONObject(i);
						if(childNodeJSONArrayJSONObject!=null) {
							addBigrams(nextParent, childNodeJSONArrayJSONObject,  schemaGramsDTO,  keywords);
						}
					}
				}
			}
		});
	}
	
	private String toCamelCase(String s) {
		if(!s.isBlank()) {
			return s.substring(0, 1).toUpperCase() + s.substring(1);
		}else {
			return s;
		}
	}
	
	private String toAntiCamelCase(String s) {
		String antiCamelCase= s.substring(0, 1).toLowerCase() + s.substring(1);
		return antiCamelCase;
	}
	

	
}
