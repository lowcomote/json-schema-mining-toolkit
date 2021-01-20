package jku.bise.jsonschemavalidator.servicefacade.schemametrics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jku.bise.jsonschemavalidator.applicationservice.csvwriter.CsvMetricWriterApplicationService;
import jku.bise.jsonschemavalidator.applicationservice.schemametrics.SchemaMetricsApplicationService;
import jku.bise.jsonschemavalidator.dto.JsonSchemaMetricsDTO;
import jku.bise.jsonschemavalidator.exception.ApplicationServiceException;
import jku.bise.jsonschemavalidator.exception.ServiceFacadeException;

@Service
public class SchemaMetricsServiceFacade {
	
	@Autowired
	private SchemaMetricsApplicationService schemaMetricsApplicationService;
	
	@Autowired
	private CsvMetricWriterApplicationService csvMetricWriterApplicationService;
	
	public void findSchemaMetricsInFileOrDirectory(String pathToDir, String csvFileName) throws ServiceFacadeException  {
		try {
			List<JsonSchemaMetricsDTO>  jsonSchemaMetricsDTOs = schemaMetricsApplicationService.findSchemaMetricsInFileOrDirectory(pathToDir,  csvFileName);
			csvMetricWriterApplicationService.createCSVFile(jsonSchemaMetricsDTOs, csvFileName);
		} catch (ApplicationServiceException e) {
			throw new ServiceFacadeException(e.getMessage(),e);
		}
	}

	

}
