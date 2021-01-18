package jku.bise.jsonschemavalidator.servicefacade.schemagrams;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jku.bise.jsonschemavalidator.applicationservice.schemagrams.SchemaGramsApplicationService;
import jku.bise.jsonschemavalidator.dto.SchemaGramsDTO;
import jku.bise.jsonschemavalidator.exception.ApplicationServiceException;
import jku.bise.jsonschemavalidator.exception.ServiceFacadeException;

@Service
public class SchemaGramsServiceFacade {

	@Autowired
	private SchemaGramsApplicationService schemaGramsApplicationService;
	
	public void findSchemaMetricsInFileOrDirectory(String pathToDir, String csvFileName) throws ServiceFacadeException{
		try {
			List<SchemaGramsDTO> schemaGramsDTOs = schemaGramsApplicationService.findSchemaMetricsInFileOrDirectory(pathToDir);
			/**
			 * TODO
			 * write in a CSV schemaGramsDTOs
			 */
		} catch (ApplicationServiceException e) {
			throw new ServiceFacadeException(e.getMessage(),e);
		}
	}
}
