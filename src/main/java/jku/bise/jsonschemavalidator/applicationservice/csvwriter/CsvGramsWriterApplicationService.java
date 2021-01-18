package jku.bise.jsonschemavalidator.applicationservice.csvwriter;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jku.bise.jsonschemavalidator.common.Utils;
import jku.bise.jsonschemavalidator.dto.SchemaGramsDTO;


@Service
public class CsvGramsWriterApplicationService {
	private static Logger logger = LoggerFactory.getLogger(CsvGramsWriterApplicationService.class);
	
	
	public void createCSVFile(List<SchemaGramsDTO> schemaGramsDTOs, String csvFileName) {
		for(SchemaGramsDTO schemaGramsDTO: schemaGramsDTOs) {
			createCSVFile( schemaGramsDTO);
		}
	}
	
	private void createCSVFile(SchemaGramsDTO schemaGramsDTO) {
		//String csvFileName = Utils.stripDot(schemaGramsDTO.getName())+".csv";
		//try {
		try {
			String csvFileName = Utils.digestSlashAndDot(schemaGramsDTO.getName())+".csv";
			boolean append;
			if (Files.exists(Paths.get(csvFileName)))
				append = true;
			else
				append = false;
			String jsonFileame = schemaGramsDTO.getName();
			String schema = schemaGramsDTO.getSchema();
				
			try (CSVPrinter printer = new CSVPrinter(new FileWriter(csvFileName, append), CSVFormat.DEFAULT)) {
				//CSVPrinter printer = new CSVPrinter(new FileWriter(csvFileName, append), CSVFormat.DEFAULT);
				for (String unigram : schemaGramsDTO.getUnigrams()) {
					printer.printRecord(jsonFileame, schema, "UNIGRAM", unigram);
				}
				for (String bigram : schemaGramsDTO.getBigrams()) {
					printer.printRecord(jsonFileame, schema, "BIGRAM", bigram);
				}
			} catch (Exception e) {
				if(logger.isErrorEnabled()) {
					logger.error("CREATECSV for grams of file: {} CSV IO Error", schemaGramsDTO.getName());
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
