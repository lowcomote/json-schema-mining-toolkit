package jku.bise.jsonschemavalidator;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import com.qindesign.json.schema.MalformedSchemaException;

import jku.bise.jsonschemavalidator.applicationservice.schemavalidator.SchemaValidatorApplicationService;
@Deprecated
public class Validate {
	public static void main(String[] args) throws IOException, MalformedSchemaException, URISyntaxException {

		String outputCSV = "";
		String inputFolderPath = "";
		if (args.length == 2) {
			inputFolderPath = args[0];
			outputCSV = args[1];
		} else {
			PropertiesConfiguration config = loadConfiguration();
			inputFolderPath = config.getString("input.json.schema.path");
			outputCSV = config.getString("output.csv.file");			
		}
//		SchemaValidator schemaValidator = new SchemaValidator(outputCSV);
//		schemaValidator.validateFileOrDirectory(inputFolderPath);
		
		SchemaValidatorApplicationService schemaValidator = new SchemaValidatorApplicationService();
		schemaValidator.validateFileOrDirectory(inputFolderPath, outputCSV);
	}

	private static PropertiesConfiguration loadConfiguration() {
		Configurations configs = new Configurations();
		try {
			return configs.properties(new File("config.properties"));
		} catch (ConfigurationException cex) {

		}
		return null;
	}
}
