package jku.bise.jsonschemavalidator.applicationservice.draftvalidator;

import java.io.IOException;

import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

import jku.bise.jsonschemavalidator.common.Utils;

/**
 * This class validate if given json-schemas conform to Drfat 6 Metaschema
 * @author alessandro.colantoni
 *
 */
public class Draft6SchemaValidator extends DraftSchemaValidator{

	public final static String JSON_SCHEMA_DRAFT_O6_URL = "http://json-schema.org/draft-06/schema";
	
	
	
	public Draft6SchemaValidator () throws IOException {
		
		JSONObject jsonObject = Utils.buildJsonObjectFromURL(JSON_SCHEMA_DRAFT_O6_URL);
		
		SchemaLoader loader = SchemaLoader.builder()
                .schemaJson(jsonObject)
                .draftV6Support() 
                .build();
		buildSchema(loader);
	}
	
	
	
}
