package jku.bise.jsonschemavalidator.applicationservice.schemagrams;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import jku.bise.jsonschemavalidator.exception.ApplicationServiceException;
import jku.bise.jsonschemavalidator.exception.JsonParseException;

@Service
public class SchemaGramsApplicationService {

	private static Logger logger = LoggerFactory.getLogger(SchemaGramsApplicationService.class);
	
	public List<SchemaGramsDTO> findSchemaMetricsInFileOrDirectory(String pathToDir) throws ApplicationServiceException   {
		List<SchemaGramsDTO> schemaGramsDTOs = new ArrayList<SchemaGramsDTO>();
		File fileOrdir = new File(pathToDir);
		if (fileOrdir.isDirectory())
			for (File file : fileOrdir.listFiles()) {
				SchemaGramsDTO schemaGramsDTO =createSchemaGramsDTO(file);
				schemaGramsDTOs.add(schemaGramsDTO);
			}
		else {
			SchemaGramsDTO schemaGramsDTO = createSchemaGramsDTO(fileOrdir);
			schemaGramsDTOs.add(schemaGramsDTO);
		}
		return schemaGramsDTOs;
	}
	
	public SchemaGramsDTO createSchemaGramsDTO(File file) throws ApplicationServiceException {
		try {
			JSONObject jsonObject = Utils.buildJsonObjectFromFile(file);
			return createSchemaGramsDTO(file.getName(),  jsonObject);
		} catch (JsonParseException e) {
			throw new ApplicationServiceException(e.getMessage(),e);
		}
	}
	
	private SchemaGramsDTO createSchemaGramsDTO(String name, JSONObject jsonObject) {
		SchemaGramsDTO schemaGramsDTO = new SchemaGramsDTO();
		schemaGramsDTO.setName(name);
		List<String> keywordList=null;
		String schema = Utils.getSchemaDraftWithoutHashtag(jsonObject);
		schemaGramsDTO.setSchema(schema);
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
			addUnigrams(jsonObject, schemaGramsDTO, keywordList);
			//addBigrams(ROOT_PARENT,jsonObject, schemaGramsDTO,keywordList);
			String parent = stripDot(name);
			addBigrams(parent,jsonObject, schemaGramsDTO,keywordList);
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
			JSONObject childNode =  jsonObject.optJSONObject(key);
			if(childNode!=null) {
				addUnigrams(childNode,  schemaGramsDTO,  keywords);
			}
		});
	}
	
	private void addBigrams(String parent, JSONObject jsonObject, SchemaGramsDTO schemaGramsDTO, List<String> keywords) {
		Set<String> keys= jsonObject.keySet();
		
		keys.forEach(key->{
			String nextParent = parent;
			if(!keywords.contains(key)) {
				nextParent=key;
				//if(!ROOT_PARENT.equals(parent)) {
					String camelParent = toCamelCase(parent);
					String antiCamelKey= toAntiCamelCase(key);
					String bigram = camelParent+"."+antiCamelKey;
					schemaGramsDTO.addBigram(bigram);
					
				//}
			}
			JSONObject childNode =  jsonObject.optJSONObject(key);
			if(childNode!=null) {
				addBigrams(nextParent,childNode,  schemaGramsDTO,  keywords);
			}
		});
	}
	
	private String toCamelCase(String s) {
		String camelCase= s.substring(0, 1).toUpperCase() + s.substring(1);
		return camelCase;
	}
	
	private String toAntiCamelCase(String s) {
		String antiCamelCase= s.substring(0, 1).toLowerCase() + s.substring(1);
		return antiCamelCase;
	}
	private String stripDot(String s) {
		String strip = s;
		int lastDotIndex = s.lastIndexOf(".");
		if(lastDotIndex>=0) {
			strip=s.substring(0, lastDotIndex);
		}
		return strip;
	}
	
}
