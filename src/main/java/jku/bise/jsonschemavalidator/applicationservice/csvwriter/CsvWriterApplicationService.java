package jku.bise.jsonschemavalidator.applicationservice.csvwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CsvWriterApplicationService {
	private static Logger logger = LoggerFactory.getLogger(CsvWriterApplicationService.class);
	
	private final static String SCHEMA_FIELD_NOT_FOUND = "SCHEMA FIELD NOT FOUND";
	
	public void createCSVFile(String filename,  List<String> errors, String schema, String csvFileName) {
		boolean append;
		if (Files.exists(Paths.get(csvFileName)))
			append = true;
		else
			append = false;
		try (CSVPrinter printer = new CSVPrinter(new FileWriter(csvFileName, append), CSVFormat.DEFAULT)) {
			for (String error : errors) {
				try {
					if (error.startsWith("#/allOf/"))
						printer.printRecord(filename, schema, "allOf parameter error");
					else if (error.contains("schema violation"))
						printer.printRecord(filename, schema, "Unrecognized Schema violations");
					else if (error.contains("no subschema matched out of"))
						printer.printRecord(filename, schema, "No subschema");
					else if (error.contains("is not a valid URI"))
						printer.printRecord(filename, schema, "Invalid URI reference");
					else if (error.contains("expected minimum item count"))
						printer.printRecord(filename, schema, "Expected minimum of items");
					else if (error.contains("expected type:") || error.contains("has incorrect type "))
						printer.printRecord(filename, schema, "Type error");
					else if (error.contains("is not a valid enum value"))
						printer.printRecord(filename, schema, "Invalid enum value");
					else if (error.contains("array items are not unique"))
						printer.printRecord(filename, schema, "Array items are not unique");
					else if (error.contains("the following keywords are unknown and will be ignored:"))
						printer.printRecord(filename, schema, "Unknow keywords");
					else if (error.contains("is not a valid primitive type "))
						printer.printRecord(filename, schema, "Invalid primitiva type");

					else printer.printRecord(filename, schema, error);
				} catch (NullPointerException e) {
					printer.printRecord(filename, SCHEMA_FIELD_NOT_FOUND, error);
				} 
			}

		} catch (IOException e) {
			logger.error("CREATECSV {} CSV IO Error", filename);
		}

	}
	
	public void createCSVFile(String filename,  String error, String schema, String csvFileName) {
		boolean append;
		if (Files.exists(Paths.get(csvFileName)))
			append = true;
		else
			append = false;
		try (CSVPrinter printer = new CSVPrinter(new FileWriter(csvFileName, append), CSVFormat.DEFAULT)) {			
			try {
				printer.printRecord(filename, schema, error);
			} catch (NullPointerException e) {
				printer.printRecord(filename, SCHEMA_FIELD_NOT_FOUND, error);
			}
		} catch (IOException e) {
			logger.error("CREATECSV {} CSV IO Error", filename);
		}

	}
}
