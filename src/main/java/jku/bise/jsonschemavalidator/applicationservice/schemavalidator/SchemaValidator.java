package jku.bise.jsonschemavalidator.applicationservice.schemavalidator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonElement;

import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft201909SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft3SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft4SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft6SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft7SchemaValidator;
import jku.bise.jsonschemavalidator.common.Utils;
import jku.bise.jsonschemavalidator.exception.JsonParseException;
import jku.bise.jsonschemavalidator.exception.SchemaValidatorException;

/**
 * TODO change name to SchemaValidatorApplicationService
 * @author alessandro.colantoni
 *
 */
@Service
public class SchemaValidator {

	private final static String SCHEMA_FIELD_NOT_FOUND = "SCHEMA FIELD NOT FOUND";
	private final static String SCHEMA_VERSION_NOT_SUPPORTED = "Schema version not supported";

	private static Logger logger = LoggerFactory.getLogger(SchemaValidator.class);
	
	//private String csvFileName;

	@Autowired
	private Draft4SchemaValidator draft4SchemaValidator;
	@Autowired
	private Draft6SchemaValidator draft6SchemaValidator;
	@Autowired
	private Draft7SchemaValidator draft7SchemaValidator;
	@Autowired
	private Draft3SchemaValidator draft3SchemaValidator;
	@Autowired
	private Draft201909SchemaValidator draft201909SchemaValidator;

	//private boolean CSV_OUTPUT;

//	public SchemaValidator() throws IOException, URISyntaxException, MalformedSchemaException {
//		this.draft4SchemaValidator = new Draft4SchemaValidator();
//		this.draft6SchemaValidator = new Draft6SchemaValidator();
//		this.draft7SchemaValidator = new Draft7SchemaValidator();
//		this.draft3SchemaValidator = new Draft3SchemaValidator();
//		this.draft201909SchemaValidator = new Draft201909SchemaValidator();
//		//CSV_OUTPUT = false;
//	}

//	public SchemaValidator(String csv_file_name) throws IOException, URISyntaxException, MalformedSchemaException {
//		this();
//		csvFileName = csv_file_name;
//		//CSV_OUTPUT = true;
//	}

	public void validateFileOrDirectory(String pathToDir, String csvFileName)  {
		File fileOrdir = new File(pathToDir);
		if (fileOrdir.isDirectory())
			for (File file : fileOrdir.listFiles())
				validate(file, csvFileName);
		else
			validate(fileOrdir, csvFileName);
	}

	public void validate(File file, String csvFileName) {
		String schema = null;
		List<String> errors = null;
		try {
			JSONObject jsonObject = Utils.buildJsonObjectFromFile(file);
			schema = Utils.getSchemaDraftWithoutHashtag(jsonObject);
			if(schema!=null) {
				if(Utils.isDraft4(schema)) {
					errors = this.draft4SchemaValidator.validate(jsonObject);
				}else if (Utils.isDraft6(schema)){
					errors = this.draft6SchemaValidator.validate(jsonObject);
				}else if (Utils.isDraft7(schema)) {
					errors = this.draft7SchemaValidator.validate(jsonObject);
				}
				/*if (Utils.isDraft4Or6Or7(schema)) {
					errors = validateDraft4Or6Or7(jsonObject, schema);
				}*/ else if (Utils.isDraft3(schema)) {
					//JsonNode jsonNode = JsonLoader.fromFile(file);
//					JsonNode jsonNode = Utils.buildJsonNodeFromFile(file);
//					errors = validateDraft3(jsonNode);
					errors= draft3SchemaValidator.validate(file);
				} else if (Utils.isDraft201909(schema)) {
//					JsonElement jsonElement = Utils.buildJsonElementFromFile(file);
//					errors = validateDraft201909(jsonElement);
					errors = draft201909SchemaValidator.validate(file);
					
				}
			}
			//if (CSV_OUTPUT) {
			if(schema==null)  
				createCSVFile(file.toString(),  SCHEMA_FIELD_NOT_FOUND, schema, csvFileName);
			else if (errors == null)
				createCSVFile(file.toString(),  SCHEMA_VERSION_NOT_SUPPORTED, schema, csvFileName);
			else if (errors.size() > 0)
				createCSVFile(file.toString(),  errors, schema, csvFileName);
			else if (errors.size() == 0)
				createCSVFile(file.toString(),  "VALID", schema, csvFileName);
			//}
		} catch ( JsonParseException | SchemaValidatorException e) {
			//if (CSV_OUTPUT)
			createCSVFile(file.toString(),  "JSON PARSE EXCEPTION", schema, csvFileName);
		}
	}

//	private String getSchemaDraftWithoutHashtag(JSONObject jsonObject)  {
//		if (jsonObject.has(SCHEMA)) {
//			String result = jsonObject.getString(SCHEMA);
//			return result.endsWith("#")? result.substring(0, result.length() - 1) : result;	
//		} else {
//			return null;
//		}
//	}

	@Deprecated
	private List<String> validateDraft3(JsonNode jsonNode) throws SchemaValidatorException {
		try {
			return draft3SchemaValidator.validate(jsonNode);
		} catch (Exception e) {
			throw new SchemaValidatorException(e.getMessage());
		}
	}

	@Deprecated
	private List<String> validateDraft4Or6Or7(JSONObject jsonObject, String schema) throws SchemaValidatorException {
		try {
			//if (Draft07Keywords.JSON_SCHEMA_DRAFT_O7_URL.equals(schema)) {
			if (Utils.isDraft7(schema)) {
				return this.draft7SchemaValidator.validate(jsonObject);
//				List<String> result = this.draft7SchemaValidator.validate(jsonObject);
//				SchemaMetric m = new SchemaMetric();
//				Map<String,Integer> metric = m.findSchemaMetrics(jsonObject, Draft07Keywords.KEYWORDS_LIST);
//				return result;
			//} else if (Draft06Keywords.JSON_SCHEMA_DRAFT_O6_URL.equals(schema)) {
			} else if (Utils.isDraft6(schema)) {
				return this.draft6SchemaValidator.validate(jsonObject);
			//} else if (Draft04Keywords.JSON_SCHEMA_DRAFT_O4_URL.equals(schema)) {
			} else if (Utils.isDraft4(schema)) {
				return this.draft4SchemaValidator.validate(jsonObject);
			} else {
				throw new SchemaValidatorException("schema :" + schema + " must be draft 4,6 or 7");
			}
		} catch (Exception e) {
			throw new SchemaValidatorException(SCHEMA_FIELD_NOT_FOUND);
		}
	}

	@Deprecated
	private List<String> validateDraft201909(JsonElement jsonElement) throws SchemaValidatorException {
		try {
			return draft201909SchemaValidator.validate(jsonElement);
		} catch (Exception e) {
			throw new SchemaValidatorException(e.getMessage());
		}
	}
	
//	private boolean isDraft4Or6Or7(String schema) {
//		boolean isDraft4Or6Or7 = 
//				Draft07Keywords.JSON_SCHEMA_DRAFT_O7_URL.equals(schema) ||
//				Draft06Keywords.JSON_SCHEMA_DRAFT_O6_URL.equals(schema) ||
//				Draft04Keywords.JSON_SCHEMA_DRAFT_O4_URL.equals(schema);
//		return isDraft4Or6Or7;
//	}
//	
//	
//
//	private boolean isDraft3(String schema) {
//		return Draft03Keywords.JSON_SCHEMA_DRAFT_O3_URL.equals(schema);
//	}
//	
//	
//
//	private boolean isDraft201909(String schema) {
//			return Draft201909Keywords.JSON_SCHEMA_DRAFT_2019_09_URL.equals(schema);
//	}
	
	
	private void createCSVFile(String filename,  List<String> errors, String schema, String csvFileName) {
		boolean append;
		if (Files.exists(Paths.get(csvFileName)))
			append = true;
		else
			append = false;
		try (CSVPrinter printer = new CSVPrinter(new FileWriter(csvFileName, append), CSVFormat.DEFAULT)) {
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
	
	private void createCSVFile(String filename,  String error, String schema, String csvFileName) {
		boolean append;
		if (Files.exists(Paths.get(csvFileName)))
			append = true;
		else
			append = false;
		try (CSVPrinter printer = new CSVPrinter(new FileWriter(csvFileName, append), CSVFormat.DEFAULT)) {			
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
