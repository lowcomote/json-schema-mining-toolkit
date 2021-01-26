package jku.bise.jsonschemavalidator.applicationservice.modelgenerator;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import jku.bise.jsonschemavalidator.DuplicateService;
import jku.bise.jsonschemavalidator.applicationservice.schemametrics.SchemaMetricsApplicationService;
import jku.bise.jsonschemavalidator.applicationservice.schemavalidator.SchemaValidatorApplicationService;
import jku.bise.jsonschemavalidator.common.Utils;
import jku.bise.jsonschemavalidator.dto.JsonSchemaMetricsDTO;
import jku.bise.jsonschemavalidator.exception.JsonParseException;
import jsonschema.BaseSyntaxError;
import jsonschema.BaseSyntaxErrorType;
import jsonschema.Error;
import jsonschema.JSONSchemaFile;
import jsonschema.JSONSchemaVersion;
import jsonschema.Measure;
import jsonschema.Metric;
import jsonschema.MetricType;
import jsonschema.Model;
import jsonschema.jsonschemaFactory;

@Service
public class ModelGeneratorService {

	@Autowired
	private DuplicateService duplicateService;

	@Autowired
	private SchemaValidatorApplicationService schemaValidatorApplicationService;

	@Autowired
	private SchemaMetricsApplicationService schemaMetricsApplicationService;

	private static Logger logger = LoggerFactory.getLogger(ModelGeneratorService.class);

	public Model generateModel(String inputFolder) {
		Model model = jsonschemaFactory.eINSTANCE.createModel();
		try {
			Multimap<String, String> v = duplicateService.getDuplicates(inputFolder);
			for (String key : v.keySet()) {
				List<JSONSchemaFile> list = Lists.newArrayList();
				for (String artifact : v.get(key)) {
					JSONSchemaFile file = jsonschemaFactory.eINSTANCE.createJSONSchemaFile();
					file.setFileName(artifact);
					model.getJsonFiles().add(file);
					list.add(file);
				}
				for (JSONSchemaFile file : list) {
					List<JSONSchemaFile> temp = Lists.newArrayList();
					list.stream().filter(z -> z != file).forEach(z -> temp.add(z));
					file.getDuplicates().addAll(temp);
				}
			}

		} catch (NoSuchAlgorithmException | IOException e) {
			logger.error(e.getMessage());
		}

		for (JSONSchemaFile file : model.getJsonFiles()) {
			try {
				File fileIO = new File(file.getFileName());
				List<Error> errors = schemaValidatorApplicationService.validate(fileIO);
			
				if (errors.size() == 0) {
					JSONObject jsonObject = Utils.buildJsonObjectFromFile(fileIO);
					String schema = Utils.getSchemaDraftWithoutHashtag(jsonObject);
					if(schema!=null)
						try {
							JSONSchemaVersion jsv = jsonschemaFactory.eINSTANCE.createJSONSchemaVersion();
							jsv.setDraftName(schema);
							jsv.setDraftURL(schema);
							file.setVersion(jsv);
						} catch (Exception e) {
							logger.error("First - {} {}", file.getFileName(), e.getMessage());
						}
					try {
						JsonSchemaMetricsDTO metrics = schemaMetricsApplicationService.findSchemaMetrics(fileIO);
						if (metrics != null) {
							for (String key : metrics.getKeywordsCount().keySet()) {
								Metric m = getMetric(model, key, MetricType.KEYWORD_USAGE);
								Measure measure = jsonschemaFactory.eINSTANCE.createMeasure();
								measure.setMetric(m);
								measure.setValue(metrics.getKeywordsCount().get(key));
							}
							for (String key : metrics.getTypesCount().keySet()) {
								Metric m = getMetric(model, key, MetricType.TYPE_USAGE);
								Measure measure = jsonschemaFactory.eINSTANCE.createMeasure();
								measure.setMetric(m);
								measure.setValue(metrics.getTypesCount().get(key));
							}
							Metric m = getMetric(model, "DepthResolvedTree", MetricType.GRAPH_BASED);
							Measure measure = jsonschemaFactory.eINSTANCE.createMeasure();
							measure.setMetric(m);
							metrics.getGraphMetricDTO().getDepthResolvedTree();
							file.getMeasures().add(measure);

							m = getMetric(model, "DepthSchema", MetricType.GRAPH_BASED);
							measure = jsonschemaFactory.eINSTANCE.createMeasure();
							measure.setMetric(m);
							measure.setValue(metrics.getGraphMetricDTO().getDepthSchema());
							file.getMeasures().add(measure);

							m = getMetric(model, "FanIn", MetricType.GRAPH_BASED);
							measure = jsonschemaFactory.eINSTANCE.createMeasure();
							measure.setMetric(m);
							measure.setValue(metrics.getGraphMetricDTO().getFanIn());
							file.getMeasures().add(measure);

							m = getMetric(model, "FanOut", MetricType.GRAPH_BASED);
							measure = jsonschemaFactory.eINSTANCE.createMeasure();
							measure.setMetric(m);
							measure.setValue(metrics.getGraphMetricDTO().getFanOut());
							file.getMeasures().add(measure);

							m = getMetric(model, "Recursions", MetricType.GRAPH_BASED);
							measure = jsonschemaFactory.eINSTANCE.createMeasure();
							measure.setMetric(m);
							measure.setValue(metrics.getGraphMetricDTO().getRecursions());
							file.getMeasures().add(measure);

							m = getMetric(model, "MaxCycleLen", MetricType.GRAPH_BASED);
							measure = jsonschemaFactory.eINSTANCE.createMeasure();
							measure.setMetric(m);
							measure.setValue(metrics.getGraphMetricDTO().getMaxCycleLen());
							file.getMeasures().add(measure);

							m = getMetric(model, "MinCycleLen", MetricType.GRAPH_BASED);
							measure = jsonschemaFactory.eINSTANCE.createMeasure();
							measure.setMetric(m);
							measure.setValue(metrics.getGraphMetricDTO().getMinCycleLen());
							file.getMeasures().add(measure);

							m = getMetric(model, "Width", MetricType.GRAPH_BASED);
							measure = jsonschemaFactory.eINSTANCE.createMeasure();
							measure.setMetric(m);
							measure.setValue(metrics.getGraphMetricDTO().getWidth());
							file.getMeasures().add(measure);

							m = getMetric(model, "Unreachables", MetricType.GRAPH_BASED);
							measure = jsonschemaFactory.eINSTANCE.createMeasure();
							measure.setMetric(m);
							measure.setValue(metrics.getGraphMetricDTO().getUnreachables());
							file.getMeasures().add(measure);

							m = getMetric(model, "UnsolvedRefs", MetricType.GRAPH_BASED);
							measure = jsonschemaFactory.eINSTANCE.createMeasure();
							measure.setMetric(m);
							measure.setValue(metrics.getGraphMetricDTO().getUnsolvedRefs());
							file.getMeasures().add(measure);
						}
					} catch (Exception e) {
						logger.error("{} {}", file.getFileName(), e.getMessage());
					}
				}
				file.getErrors().addAll(errors);
			} catch (Exception e) {
				BaseSyntaxError basic = jsonschemaFactory.eINSTANCE.createBaseSyntaxError();
				basic.setType(BaseSyntaxErrorType.UNPARSABLE_JSON);
				file.getErrors().add(basic);
			}
		}
		model.getMetrics().forEach(z -> logger.info(z.getName()));
		logger.info("Model has been instanciated");
		return model;
	}


	

	private Metric getMetric(Model model, String metricName, MetricType mt) throws Exception {
		if(metricName == null)
			throw new Exception();
		String newMN = metricName.replace("$", "");
		Optional<Metric> value = model.getMetrics().stream()
				.filter(z -> z.getType().equals(mt) && z.getName().equals(newMN)).findFirst();
		if (value.isPresent())
			return value.get();
		else {
			Metric metric = jsonschemaFactory.eINSTANCE.createMetric();
			metric.setType(mt);
			metric.setName(newMN);
			model.getMetrics().add(metric);
			return metric;
		}

	}

	private JSONSchemaFile getJSONSchemaFileFromFilename(String filename, Model model) {
		Optional<JSONSchemaFile> result = model.getJsonFiles().stream().filter(z -> z.getFileName().equals(filename))
				.findFirst();
		if (result.isPresent())
			return result.get();
		else
			return null;
	}

	public void serializeModel(Model wm, String fileName) {
		logger.info("Serializing model");
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.createResource(URI.createURI(fileName));
		resource.getContents().add(wm);
		try {
			resource.save(Collections.EMPTY_MAP);
			logger.info("Model has been serialized");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
