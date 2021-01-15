package jku.bise.jsonschemavalidator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DuplicatesDiscovery {

	private static final String path = "/Users/juri/PycharmProjects/JSON_SCHEMA/DATA";
	private static Logger logger = LoggerFactory.getLogger(DuplicatesDiscovery.class);
	private static final String CSV_FILE_NAME = "dup.csv";

	public static boolean compare(File file1, File file2) {
		try {
			JSONObject jsonObject1 = getJSONObject(file1);
			JSONObject jsonObject2 = getJSONObject(file2);
			return (jsonObject1.similar(jsonObject2));
		} catch (Exception e) {
			return false;
		}
	}

	public static JSONObject getJSONObject(File f) throws FileNotFoundException, IOException {
		try (FileReader fileReader1 = new FileReader(f)) {
			return new JSONObject(new JSONTokener(fileReader1));
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File dir = new File(path);
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length - 2; i++) {
				logger.info("{}", i);
				try {
					for (int j = i + 1; j < files.length - 1; j++)
						try {
							boolean similarity = compare(files[i], files[j]);
							if (similarity) createCSVFile(files[i].toString(), files[j].toString());
							
						} catch (Exception e) {
//							logger.error(files[i].toString(), files[j].toString());
						}
				} catch (Exception e) {
//					for (int j = i + 1; j < files.length - 1; j++)
//						createCSVFile(files[i].toString(), files[j].toString());
				}
			}
		}
	}

	private static void createCSVFile(String file1, String file2) {
		boolean append;
		if (Files.exists(Paths.get(CSV_FILE_NAME)))
			append = true;
		else
			append = false;
		try (CSVPrinter printer = new CSVPrinter(new FileWriter(CSV_FILE_NAME, append), CSVFormat.DEFAULT)) {
			printer.printRecord(file1, file2);
		} catch (IOException e) {
			logger.error("CREATECSV {} CSV IO Error", CSV_FILE_NAME);
		}

	}

}
