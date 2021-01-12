package jku.bise.jsonschemavalidator.applicationservice.schemavalidator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft3SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft4SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft6SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft7SchemaValidator;

public class SchemaValidator {

	private final static String SCHEMA = "$schema";
	private final static String CSV_FILE_NAME = "test.csv";
	private final static String HASH_TAG = "#";
	private static Logger logger = LoggerFactory.getLogger(SchemaValidator.class);

	private Draft4SchemaValidator draft4SchemaValidator;
	private Draft6SchemaValidator draft6SchemaValidator;
	private Draft7SchemaValidator draft7SchemaValidator;
	private Draft3SchemaValidator draft3SchemaValidator;

	public SchemaValidator() throws IOException {
		this.draft4SchemaValidator = new Draft4SchemaValidator();
		this.draft6SchemaValidator = new Draft6SchemaValidator();
		this.draft7SchemaValidator = new Draft7SchemaValidator();
		this.draft3SchemaValidator = new Draft3SchemaValidator();
	}

	public void validateDirectory(String pathToDir) throws IOException {
		File dir = new File(pathToDir);
		if (dir.isDirectory()) {
			for (File file : dir.listFiles()) {
//	            FileReader fileReader = new FileReader(file);
//	            JSONObject jsonObject = new JSONObject(new JSONTokener(fileReader));
//	            validateDraft4Or6Or7 ( jsonObject) ;
				try {
					validate(file);
				} catch (Exception e) {
					createCSVFile(file.toString(), new ArrayList<String>() {
						{
							add("Array of schemata");
						}
					});
				}
			}
		}
	}

	public void validate(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		JSONObject jsonObject = new JSONObject(new JSONTokener(fileReader));
		List<String> errors = null;
		try {
			if (isDraft4Or6Or7(jsonObject)) {

				errors = validateDraft4Or6Or7(jsonObject);

			} else {
				if (isDraft3(jsonObject)) {
					JsonNode jsonNode = JsonLoader.fromFile(file);
					errors = validateDraft3(jsonNode);
				}
			}
		} catch (SchemaValidatorException e) {
			logger.error(e.getMessage());
		}
		if (errors != null && errors.size() > 0)
			createCSVFile(file.toString(), errors);
		if (errors != null && errors.size() == 0)
			createCSVFile(file.toString(), new ArrayList<String>() {
				{
					add("NONE");
				}
			});
//		logger.info("Validated {} file", file.toString());
	}

	public List<String> validateDraft3(JsonNode jsonNode) throws SchemaValidatorException {
		try {
			return draft3SchemaValidator.validate(jsonNode);
		} catch (Exception e) {
			throw new SchemaValidatorException();
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
		throw new SchemaValidatorException();

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
