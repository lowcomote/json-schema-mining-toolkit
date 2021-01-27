package jku.bise.jsonschemavalidator.servicefacade.modelgenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jku.bise.jsonschemavalidator.applicationservice.modelgenerator.ModelGeneratorService;
import jsonschema.Model;

@Service
public class ModelGeneratorServiceFacade {

	@Autowired
	private ModelGeneratorService modelGeneratorService;
	public Model generateModel(String inputFolder) {
		return modelGeneratorService.generateModel(inputFolder);
	}
	
	public Model generateModelAndSerialize(String inputFolder, String path) {
		Model m = generateModel(inputFolder);
		modelGeneratorService.serializeModel(m, path);
		return m;
//		return modelGeneratorService.load(path);
		
	}
	public Model loadModel(String path) {
		return modelGeneratorService.load(path);
	}
	
	
	

	
}
