package jku.bise.jsonschemavalidator.applicationservice.schemavalidator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.io.Files;

import jku.bise.jsonschemavalidator.applicationservice.csvwriter.CsvWriterApplicationService;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft201909SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft3SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft4SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft6SchemaValidator;
import jku.bise.jsonschemavalidator.applicationservice.draftvalidator.Draft7SchemaValidator;
import jku.bise.jsonschemavalidator.common.Utils;
import jku.bise.jsonschemavalidator.dto.SchemaViolationDetailDTO;
import jku.bise.jsonschemavalidator.exception.JsonParseException;
import jku.bise.jsonschemavalidator.exception.SchemaValidatorException;
import jsonschema.BaseSyntaxError;
import jsonschema.BaseSyntaxErrorType;
import jsonschema.ValidationError;
import jsonschema.jsonschemaFactory;

/**
 * 
 * @author alessandro.colantoni
 *
 */
@Service
public class SchemaValidatorApplicationService {

	private final static String SCHEMA_FIELD_NOT_FOUND = "SCHEMA FIELD NOT FOUND";
	private final static String SCHEMA_VERSION_NOT_SUPPORTED = "UNSUPPORTED SCHEMA";
	private final static String JSON_PARSE_EXCEPTION = "JSON PARSE EXCEPTION";
	private final static String VALID = "VALID";
	private static Logger logger = LoggerFactory.getLogger(SchemaValidatorApplicationService.class);
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

	public void validateFileOrDirectory(String pathToDir, String csvFileName) {
		File fileOrdir = new File(pathToDir);
		if (fileOrdir.isDirectory())
			for (File file : fileOrdir.listFiles())
				validate(file, csvFileName);
		else
			validate(fileOrdir, csvFileName);
	}

	public void validate(File file, String csvFileName) {
		String schema = null;
		List<SchemaViolationDetailDTO> schemaViolationDetailDTOs = null;
		try {
			JSONObject jsonObject = Utils.buildJsonObjectFromFile(file);
			schema = Utils.getSchemaDraftWithoutHashtag(jsonObject);
			if (schema != null)
				if (Utils.isDraft4(schema))
					schemaViolationDetailDTOs = this.draft4SchemaValidator.validate(jsonObject);
				else if (Utils.isDraft6(schema))
					schemaViolationDetailDTOs = this.draft6SchemaValidator.validate(jsonObject);
				else if (Utils.isDraft7(schema))
					schemaViolationDetailDTOs = this.draft7SchemaValidator.validate(jsonObject);
				else if (Utils.isDraft3(schema))
					schemaViolationDetailDTOs = draft3SchemaValidator.validate(file);
				else if (Utils.isDraft201909(schema))
					schemaViolationDetailDTOs = draft201909SchemaValidator.validate(file);
			if (schemaViolationDetailDTOs != null)
				for (SchemaViolationDetailDTO schemaViolationDetailDTO : schemaViolationDetailDTOs) {
					schemaViolationDetailDTO.setFileName(file.toString());
					schemaViolationDetailDTO.setSchema(schema);
				}

			if (schema == null)
				csvWriterApplicationService.createCSVFile(file.toString(), SCHEMA_FIELD_NOT_FOUND, schema, csvFileName);
			else if (schemaViolationDetailDTOs == null)
				csvWriterApplicationService.createCSVFile(file.toString(), SCHEMA_VERSION_NOT_SUPPORTED, schema,
						csvFileName);
			else if (schemaViolationDetailDTOs.size() > 0)
				csvWriterApplicationService.createCSVFile(schemaViolationDetailDTOs, csvFileName);
			else if (schemaViolationDetailDTOs.size() == 0) {
				csvWriterApplicationService.createCSVFile(file.toString(), VALID, schema, csvFileName);
				try {
					File dest = new File(Paths.get("VALID", file.getName()).toString());
					Files.copy(file, dest);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (JsonParseException e) {
			csvWriterApplicationService.createCSVFile(file.toString(), JSON_PARSE_EXCEPTION, schema, csvFileName);
		} catch (SchemaValidatorException e) {
			csvWriterApplicationService.createCSVFile(file.toString(), SCHEMA_VERSION_NOT_SUPPORTED, schema,
					csvFileName);
		}
	}

	public List<jsonschema.Error> validate(File file) {
		String schema = null;
		List<SchemaViolationDetailDTO> schemaViolationDetailDTOs = null;
		List<jsonschema.Error> result = Lists.newArrayList();
		try {
			JSONObject jsonObject = Utils.buildJsonObjectFromFile(file);
			schema = Utils.getSchemaDraftWithoutHashtag(jsonObject);
			if (schema != null)
				if (Utils.isDraft4(schema))
					schemaViolationDetailDTOs = this.draft4SchemaValidator.validate(jsonObject);
				else if (Utils.isDraft6(schema))
					schemaViolationDetailDTOs = this.draft6SchemaValidator.validate(jsonObject);
				else if (Utils.isDraft7(schema))
					schemaViolationDetailDTOs = this.draft7SchemaValidator.validate(jsonObject);
				else if (Utils.isDraft3(schema))
					schemaViolationDetailDTOs = draft3SchemaValidator.validate(file);
				else if (Utils.isDraft201909(schema))
					schemaViolationDetailDTOs = draft201909SchemaValidator.validate(file);
			if (schemaViolationDetailDTOs != null)
				for (SchemaViolationDetailDTO schemaViolationDetailDTO : schemaViolationDetailDTOs) {
					schemaViolationDetailDTO.setFileName(file.toString());
					schemaViolationDetailDTO.setSchema(schema);
				}

			if (schema == null) {
				BaseSyntaxError bse = jsonschemaFactory.eINSTANCE.createBaseSyntaxError();
				bse.setType(BaseSyntaxErrorType.SCHEMA_NOT_FOUND);
				result.add(bse);
				return (result);
			} else if (schemaViolationDetailDTOs == null) {
				BaseSyntaxError bse = jsonschemaFactory.eINSTANCE.createBaseSyntaxError();
				bse.setType(BaseSyntaxErrorType.SCHEMA_NOT_SUPPORTED);
				result.add(bse);
				return (result);
			} else if (schemaViolationDetailDTOs.size() > 0) {
				for (SchemaViolationDetailDTO error : schemaViolationDetailDTOs) {
					ValidationError ve = jsonschemaFactory.eINSTANCE.createValidationError();
					ve.setExtendedMessage(error.getExtendedMessage().replace("$", "").replace("[\b\\.\\.[/\\]]", ""));
					ve.setKeyword(error.getKeyword().replace("$", ""));
					ve.setMessage(error.getMessage().replace("$", "").replace("[\b\\.\\.[/\\]]", ""));
					ve.setPointer(error.getPointerToViolation().replace("$", ""));
					ve.setLevel(error.getLevel() + "");
//					ve.setExtendedMessage("juri");
//					ve.setMessage("juri");
					result.add(ve);
				}
				return result;
			} else if (schemaViolationDetailDTOs.size() == 0) {
				return result;
			}
			return result;
		} catch (JsonParseException e) {
			BaseSyntaxError basic = jsonschemaFactory.eINSTANCE.createBaseSyntaxError();
			basic.setType(BaseSyntaxErrorType.UNPARSABLE_JSON);
			result.add(basic);
			return result;
		} catch (SchemaValidatorException e) {
			BaseSyntaxError basic = jsonschemaFactory.eINSTANCE.createBaseSyntaxError();
			basic.setType(BaseSyntaxErrorType.UNPARSABLE_JSON);
			result.add(basic);
			return result;
		}
		
	}

}
