package jku.bise.jsonschemavalidator.applicationservice.csvwriter;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
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
public class FileGramsWriterApplicationService {
	private static Logger logger = LoggerFactory.getLogger(FileGramsWriterApplicationService.class);

	public void createFiles(List<SchemaGramsDTO> schemaGramsDTOs, String gramFolder) {
		for (SchemaGramsDTO schemaGramsDTO : schemaGramsDTOs) {
			try {
				createFile(schemaGramsDTO, gramFolder);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
	}

	private void createFile(SchemaGramsDTO schemaGramsDTO, String gramFolder) throws Exception {
		if (!Files.exists(Paths.get(gramFolder)))
			throw new Exception("Folder does not exsist");
		Path uniPath = Paths.get(gramFolder, "UNI");
		Path biPath = Paths.get(gramFolder, "BI");
		if (!Files.exists(uniPath))
			Files.createDirectories(uniPath);
		if (!Files.exists(biPath))
			Files.createDirectories(biPath);
		try {
			String csvFileName = Utils.digestSlashAndDot(schemaGramsDTO.getName()) + ".txt";
			Path filePath = Paths.get(uniPath.toString(), csvFileName);
			try (FileWriter printer = new FileWriter(filePath.toString())) {
				for (String unigram : schemaGramsDTO.getUnigrams()) {
					printer.write(unigram + " ");
				}
			} catch (Exception e) {
				if (logger.isErrorEnabled()) 
					logger.error("CREATEFILE for unigrams of file: {} IO Error", schemaGramsDTO.getName());
			}
			filePath = Paths.get(biPath.toString(), csvFileName);
			try (FileWriter printer = new FileWriter(filePath.toString())) {
				for (String bigram : schemaGramsDTO.getBigrams()) {
					printer.write(bigram + " ");
				}
			} catch (Exception e) {
				if (logger.isErrorEnabled()) 
					logger.error("CREATEFILE for unigrams of file: {} IO Error", schemaGramsDTO.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
