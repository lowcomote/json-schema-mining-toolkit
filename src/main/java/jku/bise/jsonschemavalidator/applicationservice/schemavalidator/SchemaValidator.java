package jku.bise.jsonschemavalidator.applicationservice.schemavalidator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.net.URISyntaxException;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.qindesign.json.schema.MalformedSchemaException;

import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft201909SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft3SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft4SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft6SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft7SchemaValidator;

public class SchemaValidator {

	private final static String SCHEMA = "$schema";

	private final static String CSV_FILE_NAME = "test.csv";
	//private final static String HASH_TAG ="#";
	private static Logger logger = LoggerFactory.getLogger(SchemaValidator.class);
	
	private  Draft4SchemaValidator draft4SchemaValidator;
	private  Draft6SchemaValidator draft6SchemaValidator;
	private  Draft7SchemaValidator draft7SchemaValidator;
	private  Draft3SchemaValidator draft3SchemaValidator;
	private  Draft201909SchemaValidator draft201909SchemaValidator;
	
	public SchemaValidator() throws IOException, URISyntaxException, MalformedSchemaException {
		this.draft4SchemaValidator= new Draft4SchemaValidator();
		this.draft6SchemaValidator= new Draft6SchemaValidator();
		this.draft7SchemaValidator= new Draft7SchemaValidator();
		this.draft3SchemaValidator= new Draft3SchemaValidator();
		this.draft201909SchemaValidator = new Draft201909SchemaValidator();

	}


	public void validateFileOrDirectory (String pathToDir) throws IOException   {

		File fileOrdir = new File(pathToDir);
		if (fileOrdir.isDirectory()) {
			for (File file : fileOrdir.listFiles()) {

				validate(file);
//				try {
//					validate(file);
//				} catch (Exception e) {
//					createCSVFile(file.toString(), new ArrayList<String>() {
//						{
//							add("Array of schemata");
//						}
//					});
//				}
			}

		}else {
			validate(fileOrdir);
		}
	}
	
	

	
	public void validate (File file )  {
		try {
		FileReader fileReader = new FileReader(file);

		
		JSONObject jsonObject=null;
		
		try {
			//TODO manage here arrays of json schema, if we decide it makes sense
			jsonObject = new JSONObject(new JSONTokener(fileReader));
		} catch (Exception e) {
			createCSVFile(file.toString(), new ArrayList<String>() {
				{
				add("Array of schemata");
				}
			});
			return;
		}
		
		List<String> errors = null;
		
		if (isDraft4Or6Or7(jsonObject)) {

			errors = validateDraft4Or6Or7(jsonObject);

		} else if (isDraft3(jsonObject)) {
			JsonNode jsonNode = JsonLoader.fromFile(file);
			errors = draft3SchemaValidator.validate(jsonNode);
		}else if (isDraft201909(jsonObject)) {
        	JsonElement jsonElement = JsonParser.parseReader(new JsonReader(new FileReader(file)));
        	//JsonObject gsonObject = jsonElement.getAsJsonObject();
        	errors = draft201909SchemaValidator.validate(jsonElement);
        }
		
		if (errors != null && errors.size() > 0)
			createCSVFile(file.toString(), errors);
		if (errors != null && errors.size() == 0)
			createCSVFile(file.toString(), new ArrayList<String>() {
				{
					add("NONE");
				}
			});
		} catch (Exception e) {
			logger.error(e.getMessage());
			/**
			 * We skip the exception to allow the itearator to keep going with other files
			 */
		}
//		logger.info("Validated {} file", file.toString());
	}

	

	public List<String> validateDraft4Or6Or7(JSONObject jsonObject) throws SchemaValidatorException {
		try {
			String schema = jsonObject.getString(SCHEMA);
			if (Draft7SchemaValidator.JSON_SCHEMA_DRAFT_O7_URL.equals(schema)) {
				return this.draft7SchemaValidator.validate(jsonObject);
			} else if (Draft6SchemaValidator.JSON_SCHEMA_DRAFT_O6_URL.equals(schema)) {
				return this.draft6SchemaValidator.validate(jsonObject);
			} else if (Draft4SchemaValidator.JSON_SCHEMA_DRAFT_O4_URL.equals(schema)) {
				return this.draft4SchemaValidator.validate(jsonObject);
			} else {
				throw new SchemaValidatorException("schema :"+schema+" must be draft 4,6 or 7");
			}
		}catch (Exception e) {
			logger.error(e.getMessage());
			throw new SchemaValidatorException();
		}

	}

	private boolean isDraft4Or6Or7(JSONObject jsonObject) {
		boolean isDraft4Or6Or7 = false;
		if (jsonObject.has(SCHEMA)) {
			String schema = jsonObject.getString(SCHEMA);
			if (Draft7SchemaValidator.JSON_SCHEMA_DRAFT_O7_URL.equals(schema)
					|| Draft6SchemaValidator.JSON_SCHEMA_DRAFT_O6_URL.equals(schema)
					|| Draft4SchemaValidator.JSON_SCHEMA_DRAFT_O4_URL.equals(schema)) {
				isDraft4Or6Or7 = true;
			}

		}
		return isDraft4Or6Or7;
	}

	private boolean isDraft3(JSONObject jsonObject) {
		boolean isDraft3 = false;
		if (jsonObject.has(SCHEMA)) {
			String schema = jsonObject.getString(SCHEMA);
			if (Draft3SchemaValidator.JSON_SCHEMA_DRAFT_O3_URL.equals(schema)) {
				isDraft3 = true;
			}

		}
		return isDraft3;
	}

	private boolean isDraft201909(JSONObject jsonObject) {
		boolean isDraft201909= false;
		if(jsonObject.has(SCHEMA)) {
			String schema = jsonObject.getString(SCHEMA);
			if(Draft201909SchemaValidator.JSON_SCHEMA_DRAFT_2019_09_URL.equals(schema)) {
				isDraft201909=true;
			}
		}
		return isDraft201909;
	}
	
	public void createCSVFile(String filename, List<String> errors) throws IOException {
		FileWriter out;
		if (Files.exists(Paths.get(CSV_FILE_NAME)))
			out = new FileWriter(CSV_FILE_NAME, true);
		else
			out = new FileWriter(CSV_FILE_NAME);
		try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT)) {
			errors.forEach(error -> {
				try {
					printer.printRecord(filename, error);
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			});
		}

	}


	
	
	

}
