package jku.bise.jsonschemavalidator;

import java.io.File;
import java.util.Scanner;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jku.bise.jsonschemavalidator.servicefacade.schemametrics.SchemaMetricsServiceFacade;
import jku.bise.jsonschemavalidator.servicefacade.schemavalidator.SchemaValidatorServiceFacade;
/**
 * https://stackoverflow.com/questions/56358562/receive-input-from-command-line-with-spring-boot/58215035
 * @author alessandro.colantoni
 *
 */
@Component
public class JsonSchemaAnalyzerRunner implements CommandLineRunner{

	private static final String VALIDATION_CHOICE = "V";
	private static final String METRICS_CHOICE = "M";
	private static final String USE_CONFIG_PROPERTIES = "Y";
	private static final String NOT_USE_CONFIG_PROPERTIES = "N";
	private static final String ABORT ="A";
	
	@Autowired
	private SchemaValidatorServiceFacade schemaValidatorServiceFacade;
	
	@Autowired
	private SchemaMetricsServiceFacade schemaMetricsServiceFacade;
	
	@Override
	public void run(String... args) throws Exception {
		/**
		 * Choose among [V]alidation, [M]etrics,....
		 */
		String choice ="";
		
		/**
		 * use Config.properties [Y/N]
		 */
		String useConfig = "";
		String outputCSV = "";
		String inputFolderPath = "";
		
		Scanner console = new Scanner(System.in);
		 
		System.out.println("Hello! Welcome to Json Schema Analyzer. Ready to analyze? We are!");
		while (!VALIDATION_CHOICE.equalsIgnoreCase(choice)&& !METRICS_CHOICE.equalsIgnoreCase(choice)) {
			System.out.println("Please choose an option");
			System.out.println("["+VALIDATION_CHOICE+"] Validate a json file or a directory of json files");
			System.out.println("["+METRICS_CHOICE+"] Calculate the metrics of a json file or a directory of json files");
			choice = console.nextLine().trim();
		}
		while(!USE_CONFIG_PROPERTIES.equalsIgnoreCase(useConfig) && ! NOT_USE_CONFIG_PROPERTIES.equalsIgnoreCase(useConfig)) {
			System.out.println("Do you want to use the default input and output? ["+USE_CONFIG_PROPERTIES+"\\"+NOT_USE_CONFIG_PROPERTIES+"]");
	        useConfig = console.nextLine().trim();
		}
		if (USE_CONFIG_PROPERTIES.equalsIgnoreCase(useConfig)){
			PropertiesConfiguration config = loadConfiguration();
			inputFolderPath = config.getString("input.json.schema.path");
			outputCSV = config.getString("output.csv.file");			
		}else {
			System.out.println("Please introcuce the path to the folder or file you want to analyze (e.g., json/)");
			inputFolderPath = console.nextLine().trim();
			System.out.println("Please introcuce the name  of the csv file you want to create or update (e.g., test.csv)");
			outputCSV=console.nextLine().trim();
		}
		System.out.println("Choice: "+choice);
		System.out.println("Input Folder Path: "+inputFolderPath);
		System.out.println("Output CSV: "+outputCSV);
		
		System.out.println("Press A to abort, any other key to continue");
		String abort =console.nextLine().trim();
		if(!ABORT.equalsIgnoreCase(abort)) {
			System.out.println("Ok... we go on");
			if(VALIDATION_CHOICE.equalsIgnoreCase(choice)) {
				schemaValidatorServiceFacade.validateFileOrDirectory(inputFolderPath, outputCSV);
			}else if(METRICS_CHOICE.equalsIgnoreCase(choice)) {
				schemaMetricsServiceFacade.findSchemaMetricsInFileOrDirectory(inputFolderPath, outputCSV);
			}
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
