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
	
	
//	@Deprecated
//	public boolean validate (String filePath) throws IOException {
//		JSONObject jsonObject = Utils.buildJsonObjectFromFile(filePath);
//		return validate (jsonObject);
//	}
//	
//	@Deprecated
//	public void validateDirectory (String pathToDir) throws IOException {
//		File dir = new File(pathToDir);
//		if(dir.isDirectory()) {
//			for (File file : dir.listFiles()) {
//	            FileReader fileReader = new FileReader(file);
//	            JSONObject jsonObject = new JSONObject(new JSONTokener(fileReader));
//	            validate ( jsonObject) ;
//	        }
//		}
//	}
	
	public List<String> validate (JSONObject jsonObject)  {
		List<String> messages = new ArrayList<String>();
		try{
			schema.validate(jsonObject);
		}catch (ValidationException validationException) {
			if(logger.isDebugEnabled()) {
				logger.debug(validationException.getMessage());
			}
			validationException.getCausingExceptions().stream()
				.map(ValidationException::getMessage).forEach(message->{
					messages.add(message);
					if(logger.isDebugEnabled()) {
						logger.debug(message);
					}
				});
//			System.out.println(validationException.getMessage());
//			validationException.getCausingExceptions().stream()
//				.map(ValidationException::getMessage)
//				.forEach(System.out::println);
		}
		return messages;
	}
	
}
