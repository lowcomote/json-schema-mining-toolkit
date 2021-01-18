package jku.bise.jsonschemavalidator.applicationservice.schemavalidator;

import java.io.File;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jku.bise.jsonschemavalidator.applicationservice.csvwriter.CsvWriterApplicationService;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft201909SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft3SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft4SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft6SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft7SchemaValidator;
import jku.bise.jsonschemavalidator.common.Utils;
import jku.bise.jsonschemavalidator.exception.JsonParseException;
import jku.bise.jsonschemavalidator.exception.SchemaValidatorException;

/**
 * 
 * @author alessandro.colantoni
 *
 */
@Service
public class SchemaValidatorApplicationService {

	private final static String SCHEMA_FIELD_NOT_FOUND = "SCHEMA FIELD NOT FOUND";
	private final static String SCHEMA_VERSION_NOT_SUPPORTED = "Schema version not supported";
	
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
	@Autowired
	private CsvWriterApplicationService csvWriterApplicationService;

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
				}else if (Utils.isDraft3(schema)) {
					errors= draft3SchemaValidator.validate(file);
				} else if (Utils.isDraft201909(schema)) {
					errors = draft201909SchemaValidator.validate(file);
				}
			}
			if(schema==null)  
				csvWriterApplicationService.createCSVFile(file.toString(),  SCHEMA_FIELD_NOT_FOUND, schema, csvFileName);
			else if (errors == null)
				csvWriterApplicationService.createCSVFile(file.toString(),  SCHEMA_VERSION_NOT_SUPPORTED, schema, csvFileName);
			else if (errors.size() > 0)
				csvWriterApplicationService.createCSVFile(file.toString(),  errors, schema, csvFileName);
			else if (errors.size() == 0)
				csvWriterApplicationService.createCSVFile(file.toString(),  "VALID", schema, csvFileName);
		} catch ( JsonParseException | SchemaValidatorException e) {
			csvWriterApplicationService.createCSVFile(file.toString(),  "JSON PARSE EXCEPTION", schema, csvFileName);
		}
	}
}
