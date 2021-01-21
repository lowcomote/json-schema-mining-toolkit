package jku.bise.jsonschemavalidator;

import java.io.File;
import java.util.Scanner;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jku.bise.jsonschemavalidator.servicefacade.schemagrams.SchemaGramsServiceFacade;
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
	private static final String GRAMS_CHOICE = "G";
	private static final String USE_CONFIG_PROPERTIES = "Y";
	private static final String NOT_USE_CONFIG_PROPERTIES = "N";
	private static final String DELETE_DUPLICATES = "Y";
	private static final String ABORT ="A";
	
	@Autowired
	private SchemaValidatorServiceFacade schemaValidatorServiceFacade;
	
	@Autowired
	private SchemaMetricsServiceFacade schemaMetricsServiceFacade;
	
	@Autowired
	private DuplicateService duplicateService;

	@Autowired
	private SchemaGramsServiceFacade  schemaGramsServiceFacade;

	
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
		String gramFolder = "";
		boolean duplicates = false;
		
		Scanner console = new Scanner(System.in);
		
		System.out.println("*********************************");
		System.out.println("*********************************");
		System.out.println("*********************************");
		System.out.println();
		System.out.println("Hello! Welcome to Json Schema Analyzer. Ready to analyze? We are!");
		while (!VALIDATION_CHOICE.equalsIgnoreCase(choice) 
				&& !METRICS_CHOICE.equalsIgnoreCase(choice)
				&& !GRAMS_CHOICE.equalsIgnoreCase(choice)) {
			System.out.println("Please choose an option");
			System.out.println("["+VALIDATION_CHOICE+"] Validate a json file or a directory of json files");
			System.out.println("["+METRICS_CHOICE+"] Calculate the metrics of a json file or a directory of json files");
			System.out.println("["+GRAMS_CHOICE+"] Calculate unigrams and bigrams");
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
			gramFolder = config.getString("gram.output.folder");
			duplicates = config.getBoolean("remove.dupicates");		

		} else {
			System.out.println("Please introcuce the path to the folder or file you want to analyze (e.g., json/)");
			inputFolderPath = console.nextLine().trim();
			System.out.println("Please introcuce the name  of the csv file you want to create or update (e.g., test.csv)");
			outputCSV=console.nextLine().trim();
			System.out.println("Please introcuce if duplicates should be removed: (Y remove duplicates, N maintain duplicates");
			duplicates = console.nextLine().trim().equals(DELETE_DUPLICATES);
			if (choice.equals(GRAMS_CHOICE)) {
				System.out.println("Please introcuce the gram output folder");
				gramFolder=console.nextLine().trim();
			}
		}
		
		System.out.println("Choice: "+choice);
		System.out.println("Input Folder Path: "+inputFolderPath);
		System.out.println("Output CSV: "+outputCSV);
		System.out.println("Remove duplicates: " + duplicates);
		
		System.out.println("Press A to abort, any other key to continue");
		String abort =console.nextLine().trim();
		if(duplicates)
			duplicateService.removeDuplicates(inputFolderPath);
		if(!ABORT.equalsIgnoreCase(abort)) {
			System.out.println("Ok... we go on");
			if(VALIDATION_CHOICE.equalsIgnoreCase(choice)) {
				schemaValidatorServiceFacade.validateFileOrDirectory(inputFolderPath, outputCSV);
			}else if(GRAMS_CHOICE.equalsIgnoreCase(choice)) {
				schemaGramsServiceFacade.findSchemaMetricsInFileOrDirectory(inputFolderPath, gramFolder);
			}else if(METRICS_CHOICE.equalsIgnoreCase(choice)) {
				schemaMetricsServiceFacade.findSchemaMetricsInFileOrDirectory(inputFolderPath, outputCSV);
			}
		}
		console.close();
		System.out.println("The task is done");
		
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
