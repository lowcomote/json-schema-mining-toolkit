package jku.bise.jsonschemavalidator.servicefacade.schemavalidator;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jku.bise.jsonschemavalidator.applicationservice.schemavalidator.SchemaValidator;

@Service
public class SchemaValidatorServiceFacade {
	
	@Autowired
	private SchemaValidator schemaValidator;
	
	public void validateFileOrDirectory(String pathToDir, String csvFileName)  {
		schemaValidator.validateFileOrDirectory(pathToDir, csvFileName);
	}

	public void validate(File file, String csvFileName)  {
		schemaValidator.validate(file, csvFileName);
	}
}
