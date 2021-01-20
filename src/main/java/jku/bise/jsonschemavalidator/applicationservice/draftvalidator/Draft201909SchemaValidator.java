package jku.bise.jsonschemavalidator.applicationservice.draftvalidator;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.qindesign.json.schema.Annotation;
import com.qindesign.json.schema.Error;
import com.qindesign.json.schema.JSONPath;
import com.qindesign.json.schema.MalformedSchemaException;
import com.qindesign.json.schema.Option;
import com.qindesign.json.schema.Options;
import com.qindesign.json.schema.Specification;
import com.qindesign.json.schema.Validator;
import com.qindesign.json.schema.net.URI;

import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft03Keywords;
import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft201909Keywords;
import jku.bise.jsonschemavalidator.common.Utils;
import jku.bise.jsonschemavalidator.dto.SchemaViolationDetailDTO;
import jku.bise.jsonschemavalidator.exception.SchemaValidatorException;

@Service
public class Draft201909SchemaValidator {

	private static Logger logger = LoggerFactory.getLogger(Draft201909SchemaValidator.class);
	
	private static final Specification spec = Specification.DRAFT_2019_09;
	
	private  Validator validator;
	
	
	
	public Draft201909SchemaValidator () throws URISyntaxException, IOException, MalformedSchemaException {
		Options opts = new Options();
		opts.set(Option.FORMAT, true);
		opts.set(Option.CONTENT, true);
		opts.set(Option.DEFAULT_SPECIFICATION, spec);
		
		URI schemaID = new URI(new URL(Draft201909Keywords.JSON_SCHEMA_DRAFT_2019_09_URL).toURI());
		
		JsonElement schema = Utils.buildJsonElementFromURL(Draft201909Keywords.JSON_SCHEMA_DRAFT_2019_09_URL);
		
		this.validator = new Validator(schema, schemaID, null, null, opts);
	}
	
	//public List<String> validate (File file) throws SchemaValidatorException{
	public List<SchemaViolationDetailDTO> validate (File file) throws SchemaValidatorException{
		try {
			JsonElement jsonElement = Utils.buildJsonElementFromFile(file);
			return validate(jsonElement);
		} catch (Exception e) {
			throw new SchemaValidatorException(e.getMessage());
		}
	}
	
	//public List<String> validate (JsonElement jsonElement) throws MalformedSchemaException {
	public List<SchemaViolationDetailDTO> validate (JsonElement jsonElement) throws MalformedSchemaException {
		Map<JSONPath, Map<String, Map<JSONPath, Annotation<?>>>> annotations = new HashMap<>();
	    Map<JSONPath, Map<JSONPath, Error <?>>> errors = new HashMap<>();
	    boolean result = validator.validate(jsonElement, annotations, errors);
	    List<SchemaViolationDetailDTO> schemaViolationDetailDTOs = createSchemaViolationDetailList(result,errors);
		return schemaViolationDetailDTOs;
//	    List<String> messages =createErrorList(result,errors);
//		return messages;
	}
	
	private List<SchemaViolationDetailDTO> createSchemaViolationDetailList(boolean result, Map<JSONPath, Map<JSONPath, Error <?>>> errors) {
		//List<String> messages = new ArrayList<String>();
		List<SchemaViolationDetailDTO> schemaViolationDetailDTOs = new ArrayList<SchemaViolationDetailDTO>();
		if(!result) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			errors.entrySet().stream()
	        	.sorted(Map.Entry.comparingByKey())
	        	.forEach(e -> {
	        		e.getValue().values().stream()
	        			.filter(err -> !err.isPruned() && !err.result)
	        			.sorted(Comparator.comparing(err -> err.loc.keyword))
	        			.forEach(err -> {
	        				if(!err.loc.instance.toString().isBlank()) {
	        					JsonObject error = new JsonObject();
		        				SchemaViolationDetailDTO schemaViolationDetailDTO = new SchemaViolationDetailDTO();
		        				String pointerToViolation = err.loc.instance.toString();
		        				schemaViolationDetailDTO.setPointerToViolation(pointerToViolation);
		        				error.addProperty("instanceLocation", pointerToViolation);
		        				int level = Utils.countMatchesSlash(pointerToViolation);
		        				schemaViolationDetailDTO.setLevel(level);
//		        				String keyword = extractKeywordFromPointer(pointerToViolation);
//		        				schemaViolationDetailDTO.setKeyword(keyword);
		        				
		        				try {
									String keyword = Utils.digestSlashAndDot(err.loc.keyword.toString());
									schemaViolationDetailDTO.setKeyword(keyword);
								} catch (Exception e1) {
									e1.printStackTrace();
								}
		        				
		        				
		        				
		        				
		        				error.addProperty("keywordLocation", err.loc.keyword.toString());
		        				error.addProperty("absoluteKeywordLocation", err.loc.absKeyword.toString());
		        				
		        				if (err.value != null) {
		        					error.addProperty("error", err.value.toString());
		        					schemaViolationDetailDTO.setMessage(err.value.toString());
		        				}
		        				//String message = error.toString();
		        				String message = gson.toJson(error);
		        				schemaViolationDetailDTO.setExtendedMessage(message);
		        				schemaViolationDetailDTOs.add(schemaViolationDetailDTO);
		        				//messages.add(message);
		        				if(logger.isDebugEnabled()) {
		        					logger.debug("Draft 2019-09 validator message . {}",message);
		        				}
	        				}
	        			});
	        	});
		}
		//return messages;
		return schemaViolationDetailDTOs;
	}
	
	@Deprecated
	private List<String> createErrorList(boolean result, Map<JSONPath, Map<JSONPath, Error <?>>> errors) {
		List<String> messages = new ArrayList<String>();
		if(!result) {
			errors.entrySet().stream()
	        	.sorted(Map.Entry.comparingByKey())
	        	.forEach(e -> {
	        		e.getValue().values().stream()
	        			.filter(err -> !err.isPruned() && !err.result)
	        			.sorted(Comparator.comparing(err -> err.loc.keyword))
	        			.forEach(err -> {
	        				JsonObject error = new JsonObject();
	        				error.addProperty("keywordLocation", err.loc.keyword.toString());
	        				error.addProperty("absoluteKeywordLocation", err.loc.absKeyword.toString());
	        				error.addProperty("instanceLocation", err.loc.instance.toString());
	        				if (err.value != null) {
	        					error.addProperty("error", err.value.toString());
	        				}
	        				String message = error.toString();
	        				messages.add(message);
	        				if(logger.isDebugEnabled()) {
	        					logger.debug("Draft 2019-09 validator message . {}",message);
	        				}
	        			});
	        	});
		}
		return messages;
	}
	
	/**
	 * TODO move in a base class
	 * @param pointer
	 * @return
	 */
	@Deprecated
	private String extractKeywordFromPointer(String pointer) {
		String keyword="";
		String[] splittedPointer = pointer.split("/");
		for(int i=splittedPointer.length-1; i>=0; i-- ) {
			if(Draft201909Keywords.KEYWORDS_LIST.contains(splittedPointer[i])) {
				keyword=splittedPointer[i];
				break;
			}
		}
		return keyword;
	}
	
	
	
}
