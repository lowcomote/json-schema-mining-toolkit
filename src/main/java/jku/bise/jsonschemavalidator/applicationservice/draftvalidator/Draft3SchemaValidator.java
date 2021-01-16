package jku.bise.jsonschemavalidator.applicationservice.draftvalidator;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.cfg.ValidationConfigurationBuilder;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.processors.syntax.SyntaxValidator;


public class Draft3SchemaValidator {

	private static Logger logger = LoggerFactory.getLogger(Draft3SchemaValidator.class);
	private  SyntaxValidator syntaxValidator;
	
	
	
	public Draft3SchemaValidator () {
		ValidationConfigurationBuilder validationConfigurationBuilder=ValidationConfiguration.newBuilder();
		validationConfigurationBuilder.setDefaultVersion(SchemaVersion.DRAFTV3);
		ValidationConfiguration validationConfiguration = validationConfigurationBuilder.freeze();
		this.syntaxValidator = new SyntaxValidator(validationConfiguration);
		
	}
	
	public List<String> validate (JsonNode schema) {
		List<String> messages = new ArrayList<String>();
		ProcessingReport processingReport =  this.syntaxValidator.validateSchema(schema);
		processingReport.forEach(processingMessage->{
			String message = processingMessage.getMessage();
			messages.add(message);
		});
		return messages;
	}
	
}
