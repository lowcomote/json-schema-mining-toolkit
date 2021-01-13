package jku.bise.jsonschemavalidator;

import java.io.IOException;
import java.net.URISyntaxException;

import com.qindesign.json.schema.MalformedSchemaException;

import jku.bise.jsonschemavalidator.applicationservice.schemavalidator.SchemaValidator;

public class Validate {
	public static void main(String[] args) throws IOException, MalformedSchemaException, URISyntaxException {
        if (args.length > 0) {
        	String pathToDir = args[0];
            SchemaValidator schemaValidator = new SchemaValidator();
            //schemaValidator.validateDirectory(pathToDir);
            schemaValidator.validateFileOrDirectory(pathToDir);
        }
    }
	
}
