package jku.bise.jsonschemavalidator.servicefacade.schemadownloader;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import jku.bise.jsonschemavalidator.applicationservice.filedownloader.GitHubDownloader;


@Service
public class SchemaDownloaderFacade {
	
	@Autowired
	GitHubDownloader gDownloader;
	
	@Value("classpath:jsonschema_result.csv")
	Resource resourceFile;
	
	
	private static Logger logger = LoggerFactory.getLogger(SchemaDownloaderFacade.class);
	public void downloadAll(String token, String storageFolder){
		try {
			String csvFilePath = resourceFile.getFile().toString();
			gDownloader.downloadAll(csvFilePath, token, storageFolder);
		} catch (IOException e) {
			logger.error("IO exception {}", e.getMessage());
		}
	}

}
