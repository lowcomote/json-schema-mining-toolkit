package jku.bise.jsonschemavalidator.applicationservice.schemavalidator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.json.JSONException;
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
import jku.bise.jsonschemavalidator.applicationservice.schemametrics.SchemaMetric;


import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.*;
public class SchemaValidator {

	private final static String SCHEMA = "$schema";
	private final static String SCHEMA_FIELD_NOT_FOUND = "SCHEMA FIELD NOT FOUND";
	private final static String SCHEMA_VERSION_NOT_SUPPORTED = "Schema version not supported";
	
	private String CSV_FILE_NAME;
	
	

	private static Logger logger = LoggerFactory.getLogger(SchemaValidator.class);

	private Draft4SchemaValidator draft4SchemaValidator;
	private Draft6SchemaValidator draft6SchemaValidator;
	private Draft7SchemaValidator draft7SchemaValidator;
	private Draft3SchemaValidator draft3SchemaValidator;
	private Draft201909SchemaValidator draft201909SchemaValidator;

	private boolean CSV_OUTPUT;

	public SchemaValidator() throws IOException, URISyntaxException, MalformedSchemaException {
		this.draft4SchemaValidator = new Draft4SchemaValidator();
		this.draft6SchemaValidator = new Draft6SchemaValidator();
		this.draft7SchemaValidator = new Draft7SchemaValidator();
		this.draft3SchemaValidator = new Draft3SchemaValidator();
		this.draft201909SchemaValidator = new Draft201909SchemaValidator();
		CSV_OUTPUT = false;
	}

	public SchemaValidator(String csv_file_name) throws IOException, URISyntaxException, MalformedSchemaException {
		this();
		CSV_FILE_NAME = csv_file_name;
		CSV_OUTPUT = true;
	}

	public void validateFileOrDirectory(String pathToDir) throws IOException {
		File fileOrdir = new File(pathToDir);
		if (fileOrdir.isDirectory())
			for (File file : fileOrdir.listFiles())
				validate(file);
		else
			validate(fileOrdir);
	}

	public void validate(File file) {
		String schema = null;
		List<String> errors = null;
		try {
			FileReader fileReader = new FileReader(file);
			JSONObject jsonObject = new JSONObject(new JSONTokener(fileReader));
			schema = getSchemaDraft(jsonObject);
			if(schema!=null) {
				if (isDraft4Or6Or7(schema)) {
					errors = validateDraft4Or6Or7(jsonObject, schema);
				} else if (isDraft3(schema)) {
					JsonNode jsonNode = JsonLoader.fromFile(file);
					errors = validateDraft3(jsonNode);
				} else if (isDraft201909(schema)) {
					JsonElement jsonElement = JsonParser.parseReader(new JsonReader(new FileReader(file)));
					errors = validateDraft201909(jsonElement);
				}
			}
			if (CSV_OUTPUT) {
				if(schema==null)  
					createCSVFile(file.toString(),  SCHEMA_FIELD_NOT_FOUND, schema);
				else if (errors == null)
					createCSVFile(file.toString(),  SCHEMA_VERSION_NOT_SUPPORTED, schema);
				else if (errors.size() > 0)
					createCSVFile(file.toString(),  errors, schema);
				else if (errors.size() == 0)
					createCSVFile(file.toString(),  "VALID", schema);
			}
		} catch (JSONException | SchemaValidatorException | IOException e) {
			if (CSV_OUTPUT)
				createCSVFile(file.toString(),  "JSON PARSE EXCEPTION", schema);
		}
	}

	private String getSchemaDraft(JSONObject jsonObject)  {
		if (jsonObject.has(SCHEMA)) {
			String result = jsonObject.getString(SCHEMA);
			return result.endsWith("#")? result.substring(0, result.length() - 1) : result;	
		} else {
			return null;
		}
	}

	private List<String> validateDraft3(JsonNode jsonNode) throws SchemaValidatorException {
		try {
			return draft3SchemaValidator.validate(jsonNode);
		} catch (Exception e) {
			throw new SchemaValidatorException(e.getMessage());
		}
	}

	private List<String> validateDraft4Or6Or7(JSONObject jsonObject, String schema) throws SchemaValidatorException {
		try {
			if (Draft7SchemaValidator.JSON_SCHEMA_DRAFT_O7_URL.equals(schema)) {
				List<String> result = this.draft7SchemaValidator.validate(jsonObject);
				SchemaMetric m = new SchemaMetric();
				Map<String,Integer> metric = m.findSchemaMetrics(jsonObject, Draf07Keywords.KEYWORDS_LIST);
				
				return result;
			} else if (Draft6SchemaValidator.JSON_SCHEMA_DRAFT_O6_URL.equals(schema)) {
				return this.draft6SchemaValidator.validate(jsonObject);
			} else if (Draft4SchemaValidator.JSON_SCHEMA_DRAFT_O4_URL.equals(schema)) {
				return this.draft4SchemaValidator.validate(jsonObject);
			} else {
				throw new SchemaValidatorException("schema :" + schema + " must be draft 4,6 or 7");
			}
		} catch (Exception e) {
			throw new SchemaValidatorException(SCHEMA_FIELD_NOT_FOUND);
		}
	}

	private List<String> validateDraft201909(JsonElement jsonElement) throws SchemaValidatorException {
		try {
			return draft201909SchemaValidator.validate(jsonElement);
		} catch (Exception e) {
			throw new SchemaValidatorException(e.getMessage());
		}
	}
	
	private boolean isDraft4Or6Or7(String schema) {
		boolean isDraft4Or6Or7 = 
				Draft7SchemaValidator.JSON_SCHEMA_DRAFT_O7_URL.equals(schema) ||
				Draft6SchemaValidator.JSON_SCHEMA_DRAFT_O6_URL.equals(schema) ||
				Draft4SchemaValidator.JSON_SCHEMA_DRAFT_O4_URL.equals(schema);
		return isDraft4Or6Or7;
	}
	
	

	private boolean isDraft3(String schema) {
		return Draft3SchemaValidator.JSON_SCHEMA_DRAFT_O3_URL.equals(schema);
	}
	
	

	private boolean isDraft201909(String schema) {
			return Draft201909SchemaValidator.JSON_SCHEMA_DRAFT_2019_09_URL.equals(schema);
	}
	
	
	private void createCSVFile(String filename,  List<String> errors, String schema) {
		boolean append;
		if (Files.exists(Paths.get(CSV_FILE_NAME)))
			append = true;
		else
			append = false;
		try (CSVPrinter printer = new CSVPrinter(new FileWriter(CSV_FILE_NAME, append), CSVFormat.DEFAULT)) {
			for (String error : errors) {
				try {
					if (error.startsWith("#/allOf/"))
						printer.printRecord(filename, schema, "allOf parameter error");
					else if (error.contains("schema violation"))
						printer.printRecord(filename, schema, "Unrecognized Schema violations");
					else if (error.contains("no subschema matched out of"))
						printer.printRecord(filename, schema, "No subschema");
					else if (error.contains("is not a valid URI"))
						printer.printRecord(filename, schema, "Invalid URI reference");
					else if (error.contains("expected minimum item count"))
						printer.printRecord(filename, schema, "Expected minimum of items");
					else if (error.contains("expected type:") || error.contains("has incorrect type "))
						printer.printRecord(filename, schema, "Type error");
					else if (error.contains("is not a valid enum value"))
						printer.printRecord(filename, schema, "Invalid enum value");
					else if (error.contains("array items are not unique"))
						printer.printRecord(filename, schema, "Array items are not unique");
					else if (error.contains("the following keywords are unknown and will be ignored:"))
						printer.printRecord(filename, schema, "Unknow keywords");
					else if (error.contains("is not a valid primitive type "))
						printer.printRecord(filename, schema, "Invalid primitiva type");

					else printer.printRecord(filename, schema, error);
				} catch (NullPointerException e) {
					printer.printRecord(filename, SCHEMA_FIELD_NOT_FOUND, error);
				} 
			}

		} catch (IOException e) {
			logger.error("CREATECSV {} CSV IO Error", filename);
		}

	}
	
	private void createCSVFile(String filename,  String error, String schema) {
		boolean append;
		if (Files.exists(Paths.get(CSV_FILE_NAME)))
			append = true;
		else
			append = false;
		try (CSVPrinter printer = new CSVPrinter(new FileWriter(CSV_FILE_NAME, append), CSVFormat.DEFAULT)) {			
			try {
				printer.printRecord(filename, schema, error);
			} catch (NullPointerException e) {
				printer.printRecord(filename, SCHEMA_FIELD_NOT_FOUND, error);
			}
		} catch (IOException e) {
			logger.error("CREATECSV {} CSV IO Error", filename);
		}

	}

}
