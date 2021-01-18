package jku.bise.jsonschemavalidator.servicefacade.schemametrics;

import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jku.bise.jsonschemavalidator.applicationservice.schemametrics.SchemaMetricsApplicationService;
import jku.bise.jsonschemavalidator.exception.ApplicationServiceException;
import jku.bise.jsonschemavalidator.exception.ServiceFacadeException;

@Service
public class SchemaMetricsServiceFacade {
	
	@Autowired
	private SchemaMetricsApplicationService schemaMetricsApplicationService;
	
	public void findSchemaMetricsInFileOrDirectory(String pathToDir, String csvFileName) throws ServiceFacadeException  {
		try {
			schemaMetricsApplicationService.findSchemaMetricsInFileOrDirectory(pathToDir,  csvFileName);
		} catch (ApplicationServiceException e) {
			throw new ServiceFacadeException(e.getMessage(),e);
		}
	}

	public Map<String,Integer> findSchemaMetrics(File file, String csvFileName) throws  ServiceFacadeException  {
		try {
			return schemaMetricsApplicationService.findSchemaMetrics(file, csvFileName);
		} catch (ApplicationServiceException e) {
			throw new ServiceFacadeException(e.getMessage(),e);
		}
	}

}
