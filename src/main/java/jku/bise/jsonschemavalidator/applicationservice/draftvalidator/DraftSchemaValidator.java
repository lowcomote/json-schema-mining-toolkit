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
	protected Schema schema;
	
	
	
	protected void buildSchema(SchemaLoader loader) {
		this.schema =loader.load().build();
	}
	
	

	
	public List<String> validate (JSONObject jsonObject)  {
		List<String> messages = new ArrayList<String>();
		try{
			schema.validate(jsonObject);
		}catch (ValidationException validationException) {
			validationException.getCausingExceptions().stream()
				.map(ValidationException::getMessage).forEach(message->{
					messages.add(message);
					if(logger.isDebugEnabled()) {
						logger.debug(message);
					}
				});
			

		}
		return messages;
	}

}
