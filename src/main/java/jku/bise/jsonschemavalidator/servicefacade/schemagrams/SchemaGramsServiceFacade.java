package jku.bise.jsonschemavalidator.servicefacade.schemagrams;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jku.bise.jsonschemavalidator.applicationservice.csvwriter.CsvGramsWriterApplicationService;
import jku.bise.jsonschemavalidator.applicationservice.schemagrams.SchemaGramsApplicationService;
import jku.bise.jsonschemavalidator.dto.SchemaGramsDTO;

@Service
public class SchemaGramsServiceFacade {

	@Autowired
	private SchemaGramsApplicationService schemaGramsApplicationService;
	
	@Autowired
	private CsvGramsWriterApplicationService csvGramsWriterApplicationService;
	
	public void findSchemaMetricsInFileOrDirectory(String pathToDir, String csvFileName){
		List<SchemaGramsDTO> schemaGramsDTOs = schemaGramsApplicationService.findSchemaMetricsInFileOrDirectory(pathToDir);
		csvGramsWriterApplicationService.createCSVFile(schemaGramsDTOs, csvFileName);
	}
}
