package jku.bise.jsonschemavalidator.applicationservice.draftvalidator;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.cfg.ValidationConfigurationBuilder;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.processors.syntax.SyntaxValidator;


public class Draft3SchemaValidator {

	
	public final static String JSON_SCHEMA_DRAFT_O3_URL = "http://json-schema.org/draft-03/schema";
	private  SyntaxValidator syntaxValidator;
	
	
	
	public Draft3SchemaValidator () {
		ValidationConfigurationBuilder validationConfigurationBuilder=ValidationConfiguration.newBuilder();
		validationConfigurationBuilder.setDefaultVersion(SchemaVersion.DRAFTV3);
		ValidationConfiguration validationConfiguration = validationConfigurationBuilder.freeze();
		this.syntaxValidator = new SyntaxValidator(validationConfiguration);
		
	}
	
	public void validate (JsonNode schema) {
		ProcessingReport processingReport =  this.syntaxValidator.validateSchema(schema);
		processingReport.forEach(processingMessage->{
			String message = processingMessage.getMessage();
			System.out.println(message);
		});
	}
	
}
