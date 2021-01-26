package jku.bise.jsonschemavalidator.applicationservice.filedownloader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryContents;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.ContentsService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GitHubDownloader {

	private static Logger logger = LoggerFactory.getLogger(GitHubDownloader.class);

	
	public void downloadAll(String csvPath, String token, String storageFolder) {
		GitHubClient client = new GitHubClient();
		client.setOAuth2Token(token);
		try (
	            Reader reader = Files.newBufferedReader(Paths.get(csvPath));
	            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())){
					for (CSVRecord csvRecord : csvParser) {
						download(client, csvRecord.get(1), csvRecord.get(2), storageFolder); 
					}
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
	
	public void download(String repoFullName, String contentPath, String token, String storageFolder) {
		GitHubClient client = new GitHubClient();
		client.setOAuth2Token(token);
		download(client, repoFullName, contentPath, storageFolder);
	}
	
	private void download(GitHubClient client, String repoFullName, String contentPath, String storageFolder) {
		RepositoryService rs = new RepositoryService(client);
		try {
	        Repository repo = rs.getRepository(repoFullName.split("/")[0], repoFullName.split("/")[1]);
	        ContentsService contentService = new ContentsService(client);
	        List<RepositoryContents> contentList = contentService.getContents(repo, contentPath);
	        for(RepositoryContents content : contentList){
	            String fileConent = content.getContent();
	            
	            try(FileWriter fw = new FileWriter(new File(
	            		Paths.get(
	            				storageFolder, 
	            				repoFullName.split("/")[0] + "___" + 
		            				content.getPath().replace("/", "---") + 
		            				"___" + content.getName()).toString()))){
	            	fw.write(fileConent);
	            }
	        }

	    } catch (IOException e) {
	        logger.error(e.getMessage());
	    }
		
	}
}
