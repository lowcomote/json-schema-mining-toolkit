package jku.bise.jsonschemavalidator.servicefacade.schemavalidator;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jku.bise.jsonschemavalidator.applicationservice.schemavalidator.SchemaValidatorApplicationService;

@Service
public class SchemaValidatorServiceFacade {
	
	@Autowired
	private SchemaValidatorApplicationService schemaValidatorApplicationService;
	
	public void validateFileOrDirectory(String pathToDir, String csvFileName)  {
		schemaValidatorApplicationService.validateFileOrDirectory(pathToDir, csvFileName);
	}

	public void validate(File file, String csvFileName)  {
		schemaValidatorApplicationService.validate(file, csvFileName);
	}
}
