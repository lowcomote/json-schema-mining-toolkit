package jku.bise.jsonschemavalidator.applicationservice.schemavalidator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

	private String CSV_FILE_NAME = "";
	private final static String HASH_TAG = "#";
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

	}
	public SchemaValidator(String csv_file_name) throws IOException, URISyntaxException, MalformedSchemaException {
		this();
		CSV_FILE_NAME = csv_file_name;
		CSV_OUTPUT = true;
	}

	public void validateDirectory(String pathToDir) throws IOException, MalformedSchemaException {

		File dir = new File(pathToDir);
		if (dir.isDirectory()) {
			for (File file : dir.listFiles()) {

				try {
					validate(file);
				} catch (Exception e) {
					if (CSV_OUTPUT) createCSVFile(file.toString(), null, new ArrayList<String>() {{add(e.getMessage());}});
					logger.error("{} - {}", file.toString(), e.getMessage());
				}
			}

		}
	}

	public void validate(File file) throws IOException, MalformedSchemaException {

		FileReader fileReader = new FileReader(file);

		
		try {
			JSONObject jsonObject = new JSONObject(new JSONTokener(fileReader));
			List<String> errors = null;
			if (isDraft4Or6Or7(jsonObject)) {
				errors = validateDraft4Or6Or7(jsonObject);
			} else if (isDraft3(jsonObject)) {
				JsonNode jsonNode = JsonLoader.fromFile(file);
				errors = validateDraft3(jsonNode);
			} else if (isDraft201909(jsonObject)) {
				JsonElement jsonElement = JsonParser.parseReader(new JsonReader(new FileReader(file)));
				// JsonObject gsonObject = jsonElement.getAsJsonObject();
				errors = draft201909SchemaValidator.validate(jsonElement);
			}
			if (errors != null && errors.size() > 0)
				if (CSV_OUTPUT)createCSVFile(file.toString(), jsonObject, errors);
			if (errors != null && errors.size() == 0)
				if (CSV_OUTPUT) createCSVFile(file.toString(), jsonObject, new ArrayList<String>() {{add("NONE");}});
		} catch (SchemaValidatorException e) {
			if (CSV_OUTPUT) createCSVFile(file.toString(), null, new ArrayList<String>() {{add("JSON PARSE EXCEPTION");}});
//			logger.error("ROOT2 {}", e.getMessage());
		}
		
	}

	private String getSchemaDraft(JSONObject jsonObject) throws JSONOBjectSchemaNotFoundException {
		if (jsonObject.has(SCHEMA)) {
			return jsonObject.getString(SCHEMA);
		} else
			throw new JSONOBjectSchemaNotFoundException();
	}

	public List<String> validateDraft3(JsonNode jsonNode) throws SchemaValidatorException {
		try {
			return draft3SchemaValidator.validate(jsonNode);
		} catch (Exception e) {
			throw new SchemaValidatorException(e.getMessage());
		}
	}

	public List<String> validateDraft4Or6Or7(JSONObject jsonObject) throws SchemaValidatorException {
		if (jsonObject.has(SCHEMA)) {
			String schema = jsonObject.getString(SCHEMA);
			if (schema.equals(Draft7SchemaValidator.JSON_SCHEMA_DRAFT_O7_URL + HASH_TAG)) {
				return this.draft7SchemaValidator.validate(jsonObject);
			} else if (schema.equals(Draft6SchemaValidator.JSON_SCHEMA_DRAFT_O6_URL + HASH_TAG)) {
				return this.draft6SchemaValidator.validate(jsonObject);
			} else if (schema.equals(Draft4SchemaValidator.JSON_SCHEMA_DRAFT_O4_URL + HASH_TAG)) {
				return this.draft4SchemaValidator.validate(jsonObject);
			} else
				new SchemaValidatorException();
		}
		throw new SchemaValidatorException("SCHEMA FIELD NOT FOUND");

	}

	private boolean isDraft4Or6Or7(JSONObject jsonObject) {
		boolean isDraft4Or6Or7 = false;
		if (jsonObject.has(SCHEMA)) {
			String schema = jsonObject.getString(SCHEMA);
			if ((Draft7SchemaValidator.JSON_SCHEMA_DRAFT_O7_URL + HASH_TAG).equals(schema)
					|| (Draft6SchemaValidator.JSON_SCHEMA_DRAFT_O6_URL + HASH_TAG).equals(schema)
					|| (Draft4SchemaValidator.JSON_SCHEMA_DRAFT_O4_URL + HASH_TAG).equals(schema)) {
				isDraft4Or6Or7 = true;
			}

		}
		return isDraft4Or6Or7;
	}

	private boolean isDraft3(JSONObject jsonObject) {
		boolean isDraft3 = false;
		if (jsonObject.has(SCHEMA)) {
			String schema = jsonObject.getString(SCHEMA);
			if ((Draft3SchemaValidator.JSON_SCHEMA_DRAFT_O3_URL + HASH_TAG).equals(schema)) {
				isDraft3 = true;
			}

		}
		return isDraft3;
	}

	private boolean isDraft201909(JSONObject jsonObject) {
		boolean isDraft201909 = false;
		if (jsonObject.has(SCHEMA)) {
			String schema = jsonObject.getString(SCHEMA);
			if ((Draft201909SchemaValidator.JSON_SCHEMA_DRAFT_2019_09_URL + HASH_TAG).equals(schema)) {
				isDraft201909 = true;
			}
		}
		return isDraft201909;
	}

	public void createCSVFile(String filename, JSONObject jsonObject, List<String> errors) throws IOException {
		FileWriter out;
		if (Files.exists(Paths.get(CSV_FILE_NAME)))
			out = new FileWriter(CSV_FILE_NAME, true);
		else
			out = new FileWriter(CSV_FILE_NAME);
		try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT)) {
			errors.forEach(error -> {
				try {
					try {
						
						printer.printRecord(filename, getSchemaDraft(jsonObject), error);
					} catch (JSONOBjectSchemaNotFoundException e) {
						printer.printRecord(filename, "SCHEMA FIELD NOT FOUND",error);
					} catch (NullPointerException e) {
						printer.printRecord(filename, "SCHEMA FIELD NOT FOUND",error);
					}
				} catch (IOException e) {
					logger.error("CREATECSV {} CSV IO Error",filename);
				}
			});
		}

	}

}
