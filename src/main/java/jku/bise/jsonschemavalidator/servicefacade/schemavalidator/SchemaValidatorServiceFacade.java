package jku.bise.jsonschemavalidator.servicefacade.schemavalidator;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import jku.bise.jsonschemavalidator.exception.ServiceFacadeException;

@Service
public class SchemaValidatorServiceFacade {
	
	
	
	public void validateFileOrDirectory(String pathToDir) throws ServiceFacadeException {
		System.out.println("pathToDir: "+pathToDir);
	}

	public void validate(File file) throws ServiceFacadeException {
		
	}
}
