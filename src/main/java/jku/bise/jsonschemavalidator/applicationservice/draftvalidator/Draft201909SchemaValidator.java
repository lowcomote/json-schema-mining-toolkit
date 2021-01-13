package jku.bise.jsonschemavalidator.applicationservice.draftvalidator;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.qindesign.json.schema.Annotation;
import com.qindesign.json.schema.Error;
import com.qindesign.json.schema.JSONPath;
import com.qindesign.json.schema.MalformedSchemaException;
import com.qindesign.json.schema.Option;
import com.qindesign.json.schema.Options;
import com.qindesign.json.schema.Specification;
import com.qindesign.json.schema.Validator;
import com.qindesign.json.schema.net.URI;

import jku.bise.jsonschemavalidator.common.Utils;


public class Draft201909SchemaValidator {

	private static Logger logger = LoggerFactory.getLogger(Draft201909SchemaValidator.class);
	public final static String JSON_SCHEMA_DRAFT_2019_09_URL = "https://json-schema.org/draft/2019-09/schema#";
	
	private static final Specification spec = Specification.DRAFT_2019_09;
	
	private  Validator validator;
	
	
	
	public Draft201909SchemaValidator () throws URISyntaxException, IOException, MalformedSchemaException {
		
		Options opts = new Options();
		opts.set(Option.FORMAT, true);
		opts.set(Option.CONTENT, true);
		opts.set(Option.DEFAULT_SPECIFICATION, spec);
		
		URI schemaID = new URI(new URL(JSON_SCHEMA_DRAFT_2019_09_URL).toURI());
		
		JsonElement schema = Utils.buildJsonElementFromURL(JSON_SCHEMA_DRAFT_2019_09_URL);
		
		this.validator = new Validator(schema, schemaID, null, null, opts);
		
		
		
	}
	
	public List<String> validate (JsonElement jsonElement) throws MalformedSchemaException {
		Map<JSONPath, Map<String, Map<JSONPath, Annotation<?>>>> annotations = new HashMap<>();
	    Map<JSONPath, Map<JSONPath, Error <?>>> errors = new HashMap<>();
	    boolean result = validator.validate(jsonElement, annotations, errors);
	    List<String> messages =createErrorList(result,errors);
		return messages;
	}
	
	private List<String> createErrorList(boolean result, Map<JSONPath, Map<JSONPath, Error <?>>> errors) {
		List<String> messages = new ArrayList<String>();
		if(!result) {
			errors.entrySet().stream()
	        	.sorted(Map.Entry.comparingByKey())
	        	.forEach(e -> {
	        		e.getValue().values().stream()
	        			.filter(err -> !err.isPruned() && !err.result)
	        			.sorted(Comparator.comparing(err -> err.loc.keyword))
	        			.forEach(err -> {
	        				JsonObject error = new JsonObject();
	        				error.addProperty("keywordLocation", err.loc.keyword.toString());
	        				error.addProperty("absoluteKeywordLocation", err.loc.absKeyword.toString());
	        				error.addProperty("instanceLocation", err.loc.instance.toString());
	        				if (err.value != null) {
	        					error.addProperty("error", err.value.toString());
	        				}
	        				messages.add(error.toString());
	        			});
	        	});
		}
		return messages;
	}
	
}