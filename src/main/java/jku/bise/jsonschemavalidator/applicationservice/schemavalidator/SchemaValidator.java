package jku.bise.jsonschemavalidator.applicationservice.schemavalidator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONTokener;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;

import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft3SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft4SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft6SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft7SchemaValidator;

public class SchemaValidator {
	
	private final static String SCHEMA = "$schema";
	private final static String HASH_TAG ="#";
	
	private  Draft4SchemaValidator draft4SchemaValidator;
	private  Draft6SchemaValidator draft6SchemaValidator;
	private  Draft7SchemaValidator draft7SchemaValidator;
	private  Draft3SchemaValidator draft3SchemaValidator;
	
	public SchemaValidator() throws IOException {
		this.draft4SchemaValidator= new Draft4SchemaValidator();
		this.draft6SchemaValidator= new Draft6SchemaValidator();
		this.draft7SchemaValidator= new Draft7SchemaValidator();
		this.draft3SchemaValidator= new Draft3SchemaValidator();
	}

	public void validateDirectory (String pathToDir) throws IOException {
		File dir = new File(pathToDir);
		if(dir.isDirectory()) {
			for (File file : dir.listFiles()) {
//	            FileReader fileReader = new FileReader(file);
//	            JSONObject jsonObject = new JSONObject(new JSONTokener(fileReader));
//	            validateDraft4Or6Or7 ( jsonObject) ;
				validate(file);
	        }
		}
	}
	
	public void validate (File file ) throws IOException {
		FileReader fileReader = new FileReader(file);
        JSONObject jsonObject = new JSONObject(new JSONTokener(fileReader));
        if(isDraft4Or6Or7(jsonObject)) {
        	validateDraft4Or6Or7 (jsonObject);
        }else {
        	if(isDraft3(jsonObject)) {
        		JsonNode jsonNode = JsonLoader.fromFile(file);
        		validateDraft3(jsonNode);
        	}
        }
	}
	
	public void validateDraft3(JsonNode jsonNode) throws IOException {
		draft3SchemaValidator.validate(jsonNode);
		
	}
	
	public void validateDraft4Or6Or7(JSONObject jsonObject) throws IOException {
		if(jsonObject.has(SCHEMA)) {
			String schema = jsonObject.getString(SCHEMA);
			if(schema.equals(Draft7SchemaValidator.JSON_SCHEMA_DRAFT_O7_URL+HASH_TAG)) {
				this.draft7SchemaValidator.validate(jsonObject);
			}else if(schema.equals(Draft6SchemaValidator.JSON_SCHEMA_DRAFT_O6_URL+HASH_TAG)) {
				this.draft6SchemaValidator.validate(jsonObject);
			}else if(schema.equals(Draft4SchemaValidator.JSON_SCHEMA_DRAFT_O4_URL+HASH_TAG)) {
				this.draft4SchemaValidator.validate(jsonObject);
			}
			
		}
	}
	
	private boolean isDraft4Or6Or7(JSONObject jsonObject) {
		boolean isDraft4Or6Or7= false;
		if(jsonObject.has(SCHEMA)) {
			String schema = jsonObject.getString(SCHEMA);
			if((Draft7SchemaValidator.JSON_SCHEMA_DRAFT_O7_URL+HASH_TAG).equals(schema)||
					(Draft6SchemaValidator.JSON_SCHEMA_DRAFT_O6_URL+HASH_TAG).equals(schema)||
					(Draft4SchemaValidator.JSON_SCHEMA_DRAFT_O4_URL+HASH_TAG).equals(schema)
					) {
				isDraft4Or6Or7=true;
			}
			
		}
		return isDraft4Or6Or7;
	}
	
	private boolean isDraft3(JSONObject jsonObject) {
		boolean isDraft3= false;
		if(jsonObject.has(SCHEMA)) {
			String schema = jsonObject.getString(SCHEMA);
			if((Draft3SchemaValidator.JSON_SCHEMA_DRAFT_O3_URL+HASH_TAG).equals(schema)) {
				isDraft3=true;
			}
			
		}
		return isDraft3;
	}
	
}
