package jku.bise.jsonschemavalidator.applicationservice.draftvalidator;

import java.io.IOException;

import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft07Keywords;
import jku.bise.jsonschemavalidator.common.Utils;

/**
 * This class validate if given json-schemas conform to Drfat 7 Metaschema
 * @author alessandro.colantoni
 *
 */
public class Draft7SchemaValidator extends DraftSchemaValidator{

	
	
	
	
	public Draft7SchemaValidator () throws IOException {
		
		JSONObject jsonObject = Utils.buildJsonObjectFromURL(Draft07Keywords.JSON_SCHEMA_DRAFT_O7_URL);
		
		SchemaLoader loader = SchemaLoader.builder()
                .schemaJson(jsonObject)
                .draftV7Support() 
                .build();
		buildSchema(loader);
	}
	
	
	
}
