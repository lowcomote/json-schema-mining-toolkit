package jku.bise.jsonschemavalidator.applicationservice.draftvalidator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.cfg.ValidationConfigurationBuilder;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.processors.syntax.SyntaxValidator;

import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft03Keywords;
import jku.bise.jsonschemavalidator.common.Utils;
import jku.bise.jsonschemavalidator.dto.SchemaViolationDetailDTO;
import jku.bise.jsonschemavalidator.exception.SchemaValidatorException;

@Service
public class Draft3SchemaValidator {

	private static final String KEYWORD = "keyword";
	private static final String SCHEMA = "schema";
	private static final String LOADING_URI= "loadingURI";
	private static final String POINTER = "pointer";
	
	
	private static Logger logger = LoggerFactory.getLogger(Draft3SchemaValidator.class);
	private  SyntaxValidator syntaxValidator;
	
	public Draft3SchemaValidator () {
		ValidationConfigurationBuilder validationConfigurationBuilder=ValidationConfiguration.newBuilder();
		validationConfigurationBuilder.setDefaultVersion(SchemaVersion.DRAFTV3);
		ValidationConfiguration validationConfiguration = validationConfigurationBuilder.freeze();
		this.syntaxValidator = new SyntaxValidator(validationConfiguration);
	}
	
	//public List<String> validate (File file) throws SchemaValidatorException {
	public List<SchemaViolationDetailDTO> validate (File file) throws SchemaValidatorException {
		try {
			JsonNode jsonNode = Utils.buildJsonNodeFromFile(file);
			return  validate(jsonNode);
		} catch (Exception e) {
			throw new SchemaValidatorException(e.getMessage());
		}
	}
	
	//public List<String> validate (JsonNode schema) {
	public List<SchemaViolationDetailDTO> validate (JsonNode jsonNode) {
		//List<String> messages = new ArrayList<String>();
		List<SchemaViolationDetailDTO> schemaViolationDetailDTOs = new ArrayList<SchemaViolationDetailDTO>();
		ProcessingReport processingReport =  this.syntaxValidator.validateSchema(jsonNode);
		processingReport.forEach(processingMessage->{
			SchemaViolationDetailDTO schemaViolationDetailDTO = createSchemaViolationDetail(processingMessage);
			if(schemaViolationDetailDTO!=null) {
				schemaViolationDetailDTOs.add(schemaViolationDetailDTO);
			}
			
//			JsonNode processingMessageJson = processingMessage.asJson();
//			String message = processingMessageJson.toPrettyString();
//			messages.add(message);
//			if(logger.isDebugEnabled()) {
//				logger.debug("Json-schema-validator pretty string: {}",message);
//				
//			}
			
			
//			String message = processingMessage.getMessage(); //processingMessage.
//			messages.add(message);
//			if(logger.isDebugEnabled()) {
//				logger.debug("Json-schema-validator message: {}",message);
//				
//			}
		});
//		return messages;
		return schemaViolationDetailDTOs;
	}
	
	private SchemaViolationDetailDTO createSchemaViolationDetail(ProcessingMessage processingMessage) {
		SchemaViolationDetailDTO schemaViolationDetailDTO = null;
		if(LogLevel.ERROR.equals(processingMessage.getLogLevel()) || LogLevel.FATAL.equals(processingMessage.getLogLevel())) {
			JsonNode processingMessageJson = processingMessage.asJson();
			schemaViolationDetailDTO = new SchemaViolationDetailDTO();
			schemaViolationDetailDTO.setMessage(processingMessage.getMessage());
			schemaViolationDetailDTO.setExtendedMessage(processingMessageJson.toPrettyString());
			if(processingMessageJson.has(KEYWORD)) {
				schemaViolationDetailDTO.setKeyword(processingMessageJson.get(KEYWORD).asText());
			}
			if(processingMessageJson.has(SCHEMA)) {
				JsonNode schemaJsonNode = processingMessageJson.get(SCHEMA);
				String pointerToViolation="";
//				if(schemaJsonNode.has(LOADING_URI)) {
//					pointerToViolation += schemaJsonNode.get(LOADING_URI).asText();
//				}
				if(schemaJsonNode.has(POINTER)) {
					String pointer = schemaJsonNode.get(POINTER).asText();
					if(pointer.isBlank()) {
						pointer="/";
					}
					pointerToViolation += pointer;
					if(schemaViolationDetailDTO.getKeyword().isEmpty()) {
						String keyword= extractKeywordFromPointer(pointer);
						schemaViolationDetailDTO.setKeyword(keyword);
					}
				}
				schemaViolationDetailDTO.setPointerToViolation(pointerToViolation);
				int level = Utils.countMatchesSlash(pointerToViolation);
				schemaViolationDetailDTO.setLevel(level);
			}
		}
		if(logger.isDebugEnabled()) {
			if(schemaViolationDetailDTO == null) {
				logger.debug("Json-schema-validator schemaViolationDetailDTO is null");
			}else {
				logger.debug("Json-schema-validator chemaViolationDetailDTO: {}",schemaViolationDetailDTO.toString());
			}
		}
		return schemaViolationDetailDTO;
	}
	
	private String extractKeywordFromPointer(String pointer) {
		String keyword="";
		String[] splittedPointer = pointer.split("/");
		for(int i=splittedPointer.length-1; i>=0; i-- ) {
			if(Draft03Keywords.KEYWORDS_LIST.contains(splittedPointer[i])) {
				keyword=splittedPointer[i];
				break;
			}
		}
		return keyword;
	}
}
