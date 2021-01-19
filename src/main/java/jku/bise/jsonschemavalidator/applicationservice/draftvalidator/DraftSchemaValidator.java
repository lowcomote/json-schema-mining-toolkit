package jku.bise.jsonschemavalidator.applicationservice.draftvalidator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jku.bise.jsonschemavalidator.common.Utils;
import jku.bise.jsonschemavalidator.dto.SchemaViolationDetailDTO;


public abstract class DraftSchemaValidator {

	private static Logger logger = LoggerFactory.getLogger(DraftSchemaValidator.class);
	private final static String TO_BE_DISCARDED_ERROR_MESSAGE="expected type: Boolean, found: JSONObject";
	private final static String TO_BE_DISCARDED_KEYWORD = "type";
	protected Schema schema;
	
	protected void buildSchema(SchemaLoader loader) {
		this.schema =loader.load().build();
	}
	
	//public List<String> validate (JSONObject jsonObject)  {
	public List<SchemaViolationDetailDTO> validate (JSONObject jsonObject)  {
		//List<String> messages = new ArrayList<String>();
		List<SchemaViolationDetailDTO> schemaViolationDetailDTOs = new ArrayList<SchemaViolationDetailDTO>();
		try{
			schema.validate(jsonObject);
		}catch (ValidationException validationException) {
			
			//addMessages( validationException,  messages);
			addSchemaViolationDetail(validationException, schemaViolationDetailDTOs);
			
			/******************START DEBUGGER*********************/
			if(logger.isDebugEnabled()) {
//				messages.stream().forEach(message->{
//					logger.debug("Message from everit: addMessages {}", message);
//				});

				schemaViolationDetailDTOs.stream().forEach(schemaViolationDetailDTO->{
					logger.debug("Message from everit: addMessages {}", schemaViolationDetailDTO.toString());
				});
				
				validationException.getAllMessages().stream().forEach(message->{
					//messages.add(message);
					logger.debug("Message from everit: getAllMessages {}", message);
					
				});
				
				validationException.getCausingExceptions().stream()
				.map(ValidationException::getMessage).forEach(message->{
					//messages.add(message);
					logger.debug("Message from everit:::: getCausingExceptions  : {}", message);
				});
			}
			/******************END DEBUGGER*********************/
		}
//		return messages;
		return schemaViolationDetailDTOs;
	}
	
	@Deprecated
	private void addMessages(ValidationException validationException, List<String> messages) {
		if(validationException.getCausingExceptions().isEmpty()) {
			messages.add(validationException.getMessage());
			//messages.addAll(validationException.getAllMessages());
		}else {
			validationException.getCausingExceptions().stream().forEach(childValidationException->{
				if(validationException.getCausingExceptions().size()==1  
					|| !TO_BE_DISCARDED_KEYWORD.equals(childValidationException.getKeyword()) 
							|| !TO_BE_DISCARDED_ERROR_MESSAGE.equals(childValidationException.getErrorMessage()) ){
					addMessages(childValidationException, messages);
					}
			});
		}
	}
	
	
	private void addSchemaViolationDetail(ValidationException validationException, List<SchemaViolationDetailDTO> schemaViolationDetailDTOs) {
		if(validationException.getCausingExceptions().isEmpty()) {
			SchemaViolationDetailDTO schemaViolationDetailDTO = createSchemaViolationDetail(validationException);
			schemaViolationDetailDTOs.add(schemaViolationDetailDTO);
		}else {
			validationException.getCausingExceptions().stream().forEach(childValidationException->{
				if(validationException.getCausingExceptions().size()==1  
					|| !TO_BE_DISCARDED_KEYWORD.equals(childValidationException.getKeyword()) 
							|| !TO_BE_DISCARDED_ERROR_MESSAGE.equals(childValidationException.getErrorMessage()) ){
					addSchemaViolationDetail(childValidationException, schemaViolationDetailDTOs);
					}
			});
		}
	}
	
	private SchemaViolationDetailDTO createSchemaViolationDetail(ValidationException validationException) {
		SchemaViolationDetailDTO schemaViolationDetailDTO = new SchemaViolationDetailDTO();
		schemaViolationDetailDTO.setKeyword(validationException.getKeyword());
		String pointerToViolation = validationException.getPointerToViolation(); 
		schemaViolationDetailDTO.setPointerToViolation(pointerToViolation);
		int level = Utils.countMatchesSlash(pointerToViolation);
		schemaViolationDetailDTO.setLevel(level);
		schemaViolationDetailDTO.setMessage(validationException.getErrorMessage());
		schemaViolationDetailDTO.setExtendedMessage(validationException.getMessage());
		return schemaViolationDetailDTO;

		
	}
	
	
}
