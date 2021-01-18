package jku.bise.jsonschemavalidator;

import static java.util.stream.Collectors.toMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
@Service
public class DuplicateService {

	private static Logger logger = LoggerFactory.getLogger(DuplicateService.class);
	private static final String CSV_FILE_NAME = "duplicates.csv";
	private String getFileChecksum(MessageDigest digest, File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);

		byte[] byteArray = new byte[1024];
		int bytesCount = 0;

		while ((bytesCount = fis.read(byteArray)) != -1)
			digest.update(byteArray, 0, bytesCount);
		fis.close();
		byte[] bytes = digest.digest();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++)
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		return sb.toString();
	}


	public void removeDuplicates(String inputFolder) {
		try {
			List<File> duplicates = getDuplicates(inputFolder, CSV_FILE_NAME);
			if(logger.isInfoEnabled()) logger.info("Removing duplicates");
			duplicates.forEach(duplicate -> duplicate.delete());
			if(logger.isInfoEnabled()) logger.info("Duplicates have been removed");
		} catch (NoSuchAlgorithmException | IOException e) {
			logger.error(e.getMessage());
		} 
		
	}
	
	

	public List<File> getDuplicates(String inputFoler, String CSV_FILE_NAME) throws FileNotFoundException, IOException, NoSuchAlgorithmException {
		MessageDigest shaDigest = MessageDigest.getInstance("SHA-256");
		if(logger.isInfoEnabled()) logger.info("IDENTIFIYNG DUPICATES");
		List<File> duplicates = Lists.newArrayList();
		Map<String, File> checksum_fileMap = Maps.newHashMap();
		Map<String, Integer> checksum_countMap = Maps.newHashMap();
		File dir = new File(inputFoler);
		boolean append;
		if (Files.exists(Paths.get(CSV_FILE_NAME)))
			append = true;
		else
			append = false;

		try (CSVPrinter printer = new CSVPrinter(new FileWriter(CSV_FILE_NAME, append), CSVFormat.DEFAULT)) {
			if (dir.isDirectory()) {
				File[] files = dir.listFiles();
				int i = 0;
				for (File file : files) {
					String shaChecksum1 = getFileChecksum(shaDigest, file);
					if (checksum_fileMap.containsKey(shaChecksum1)) {
						duplicates.add(file);
						checksum_countMap.put(shaChecksum1, checksum_countMap.get(shaChecksum1) + 1);
						printer.printRecord(checksum_fileMap.get(shaChecksum1).toString(), file.toString());
					} else {
						checksum_fileMap.put(shaChecksum1, file);
						checksum_countMap.put(shaChecksum1, 1);
					}
					if (i % 100 == 0)
						logger.info("{}", i);
					i++;
				}
			}
		} catch (IOException e) {
			if(logger.isInfoEnabled()) logger.error("CREATECSV {} CSV IO Error", CSV_FILE_NAME);
		}
		Map<String, Integer> sorted = checksum_countMap.entrySet().stream().filter(z -> z.getValue() > 1)
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		sorted.entrySet().stream().limit(40)
				.forEach(z -> {if(logger.isInfoEnabled()) logger.info("{} - {}", checksum_fileMap.get(z.getKey()), z.getValue());});
		if(logger.isInfoEnabled()) logger.info("{} duplicates have been recognized", duplicates.size());
		return duplicates;
	}

}
