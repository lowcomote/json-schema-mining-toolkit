package jku.bise.jsonschemavalidator;

import java.io.IOException;

import jku.bise.jsonschemavalidator.applicationservice.schemavalidator.SchemaValidator;

public class Validate {
	public static void main(String[] args) throws IOException {
        if (args.length > 0) {
        	String pathToDir = args[0];
            SchemaValidator schemaValidator = new SchemaValidator();
            schemaValidator.validateDirectory(pathToDir);
        }
    }
	
}
