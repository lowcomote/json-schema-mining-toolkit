package jku.bise.jsonschemavalidator;

import java.io.File;
import java.util.Scanner;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jku.bise.jsonschemavalidator.applicationservice.schemavalidator.SchemaValidator;
import jku.bise.jsonschemavalidator.servicefacade.schemavalidator.SchemaValidatorServiceFacade;
/**
 * https://stackoverflow.com/questions/56358562/receive-input-from-command-line-with-spring-boot/58215035
 * @author alessandro.colantoni
 *
 */
@Component
public class JsonSchemaAnalyzerRunner implements CommandLineRunner{

	@Autowired
	private SchemaValidatorServiceFacade schemaValidatorServiceFacade;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		String outputCSV = "";
		String inputFolderPath = "";
		
		
		//System.out.println("Enter word!");
		System.out.println("Hello! Welcome to Json Schema Analyzer. Ready to analyze? We are.");
		System.out.println("Do you want to use the default input and output? [Y\\N]");
		Scanner console = new Scanner(System.in);
        String defaultIOOption = console.nextLine();
		if ("Y".equalsIgnoreCase(defaultIOOption)){
			PropertiesConfiguration config = loadConfiguration();
			inputFolderPath = config.getString("input.json.schema.path");
			outputCSV = config.getString("output.csv.file");			
		}else {
			System.out.println("Please introcuce the path to the folder or file you want to analyze (e.g., json/)");
			inputFolderPath = console.nextLine();
			
			
			System.out.println("Please introcuce the name  of the csv file you want to create or update (e.g., test.csv)");
			outputCSV=console.nextLine();
		}
		System.out.println("Input Folder Path: "+inputFolderPath);
		System.out.println("Output CSV: "+outputCSV);
		
		System.out.println("Press A to abort, any other key to continue");
		String abort =console.nextLine();
		if(!"A".equalsIgnoreCase(abort)) {
			System.out.println("Ok... we go on");
			schemaValidatorServiceFacade.validateFileOrDirectory(inputFolderPath);
		}
		console.close();
		
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
