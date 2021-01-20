package jku.bise.jsonschemavalidator.applicationservice.csvwriter;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jku.bise.jsonschemavalidator.common.Utils;
import jku.bise.jsonschemavalidator.dto.JsonSchemaMetricsDTO;
import jku.bise.jsonschemavalidator.dto.SchemaGramsDTO;


@Service
public class CsvMetricWriterApplicationService {
	private static Logger logger = LoggerFactory.getLogger(CsvMetricWriterApplicationService.class);
	
	
	public void createCSVFile(List<JsonSchemaMetricsDTO> jsonSchemaMetricsDTOs, String csvFileName) {
		for(JsonSchemaMetricsDTO jsonSchemaMetricsDTO: jsonSchemaMetricsDTOs) {
			createCSVFile( jsonSchemaMetricsDTO, csvFileName);
		}
	}
	
	private void createCSVFile(JsonSchemaMetricsDTO jsonSchemaMetricsDTO , String csvFileName) {
		try {
			boolean append;
			if (Files.exists(Paths.get(csvFileName)))
				append = true;
			else
				append = false;
			String jsonFileame = jsonSchemaMetricsDTO.getName();
			String schema = jsonSchemaMetricsDTO.getSchema();
				
			try (CSVPrinter printer = new CSVPrinter(new FileWriter(csvFileName, append), CSVFormat.DEFAULT)) {
				//CSVPrinter printer = new CSVPrinter(new FileWriter(csvFileName, append), CSVFormat.DEFAULT);
				for (Entry<String,Integer> keywordsCountEntry : jsonSchemaMetricsDTO.getKeywordsCount().entrySet()) {
					printer.printRecord(jsonFileame, schema, keywordsCountEntry.getKey(), keywordsCountEntry.getValue());
				}
				for (Entry<String,Integer> typesCountEntry : jsonSchemaMetricsDTO.getTypesCount().entrySet()) {
					printer.printRecord(jsonFileame, schema, typesCountEntry.getKey(), typesCountEntry.getValue());
				}
			} catch (Exception e) {
				if(logger.isErrorEnabled()) {
					logger.error("CREATECSV for grams of file: {} CSV IO Error", jsonSchemaMetricsDTO.getName());
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
