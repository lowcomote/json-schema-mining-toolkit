package jku.bise.jsonschemavalidator.applicationservice.schemavalidator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONTokener;

import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft4SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft6SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft7SchemaValidator;

public class SchemaValidator {
	
	private final static String SCHEMA = "$schema";
	private final static String HASH_TAG ="#";
	
	private  Draft4SchemaValidator draft4SchemaValidator;
	private  Draft6SchemaValidator draft6SchemaValidator;
	private  Draft7SchemaValidator draft7SchemaValidator;
	
	public SchemaValidator() throws IOException {
		this.draft4SchemaValidator= new Draft4SchemaValidator();
		this.draft6SchemaValidator= new Draft6SchemaValidator();
		this.draft7SchemaValidator= new Draft7SchemaValidator();
	}

	public void validateDirectory (String pathToDir) throws IOException {
		File dir = new File(pathToDir);
		if(dir.isDirectory()) {
			for (File file : dir.listFiles()) {
	            FileReader fileReader = new FileReader(file);
	            JSONObject jsonObject = new JSONObject(new JSONTokener(fileReader));
	            validate ( jsonObject) ;
	        }
		}
	}
	
	public void validate (File file ) throws IOException {
		FileReader fileReader = new FileReader(file);
        JSONObject jsonObject = new JSONObject(new JSONTokener(fileReader));
        validate (jsonObject);
	}
	
	public void validate(JSONObject jsonObject) throws IOException {
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
	
}
