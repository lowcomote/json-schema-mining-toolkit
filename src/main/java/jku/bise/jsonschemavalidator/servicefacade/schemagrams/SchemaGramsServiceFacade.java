package jku.bise.jsonschemavalidator.servicefacade.schemagrams;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jku.bise.jsonschemavalidator.applicationservice.csvwriter.FileGramsWriterApplicationService;
import jku.bise.jsonschemavalidator.applicationservice.schemagrams.SchemaGramsApplicationService;
import jku.bise.jsonschemavalidator.dto.SchemaGramsDTO;

@Service
public class SchemaGramsServiceFacade {

	@Autowired
	private SchemaGramsApplicationService schemaGramsApplicationService;
	
	@Autowired
	private FileGramsWriterApplicationService fileGramsWriterApplicationService;
	
	public void findSchemaMetricsInFileOrDirectory(String pathToDir, String gramFolder){
		List<SchemaGramsDTO> schemaGramsDTOs = schemaGramsApplicationService.buildGramsInFileOrDirectory(pathToDir);
		fileGramsWriterApplicationService.createFiles(schemaGramsDTOs, gramFolder);
	}
}
