package jku.bise.jsonschemavalidator.applicationservice.draftvalidator;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;


public abstract class DraftSchemaValidator {

	
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
	
	public boolean validate (JSONObject jsonObject)  {
		boolean validate;
		try{
			schema.validate(jsonObject);
			validate=true;
		}catch (ValidationException e) {
			  System.out.println(e.getMessage());
			  e.getCausingExceptions().stream()
			      .map(ValidationException::getMessage)
			      .forEach(System.out::println);
			  validate=false;
		}
		return validate;
	}
	
}
