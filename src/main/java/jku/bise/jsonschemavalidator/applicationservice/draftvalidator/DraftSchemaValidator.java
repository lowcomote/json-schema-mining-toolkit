package jku.bise.jsonschemavalidator.applicationservice.draftvalidator;

import java.util.ArrayList;
import java.util.List;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class DraftSchemaValidator {

	private static Logger logger = LoggerFactory.getLogger(DraftSchemaValidator.class);
	private final static String TO_BE_DISCARDED_ERROR_MESSAGE="expected type: Boolean, found: JSONObject";
	private final static String TO_BE_DISCARDED_KEYWORD = "type";
	protected Schema schema;
	
	protected void buildSchema(SchemaLoader loader) {
		this.schema =loader.load().build();
	}
	
	public List<String> validate (JSONObject jsonObject)  {
		List<String> messages = new ArrayList<String>();
		try{
			schema.validate(jsonObject);
		}catch (ValidationException validationException) {
			
			addMessages( validationException,  messages);
			
			if(logger.isDebugEnabled()) {
				messages.stream().forEach(message->{
					logger.debug("Message from everit: addMessages {}", message);
				});
			}
			
			validationException.getAllMessages().stream().forEach(message->{
				//messages.add(message);
				if(logger.isDebugEnabled()) {//logger.isErrorEnabled()
					logger.debug("Message from everit: getAllMessages {}", message);
				}
			});
			validationException.getCausingExceptions().stream()
				.map(ValidationException::getMessage).forEach(message->{
					//messages.add(message);
					if(logger.isDebugEnabled()) {//logger.isErrorEnabled()
						logger.debug("Message from everit:::: getCausingExceptions  : {}", message);
					}
				});
			

		}
		return messages;
	}
	
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

}
