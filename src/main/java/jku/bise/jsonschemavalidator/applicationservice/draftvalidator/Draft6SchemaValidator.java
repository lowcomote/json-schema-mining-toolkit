package jku.bise.jsonschemavalidator.applicationservice.draftvalidator;

import java.io.IOException;

import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft06Keywords;
import jku.bise.jsonschemavalidator.common.Utils;

/**
 * This class validate if given json-schemas conform to Drfat 6 Metaschema
 * @author alessandro.colantoni
 *
 */
@Service
public class Draft6SchemaValidator extends DraftSchemaValidator{

	 
	
	
	
	public Draft6SchemaValidator () throws IOException {
		
		JSONObject jsonObject = Utils.buildJsonObjectFromURL(Draft06Keywords.JSON_SCHEMA_DRAFT_O6_URL);
		
		SchemaLoader loader = SchemaLoader.builder()
                .schemaJson(jsonObject)
                .draftV6Support() 
                .build();
		buildSchema(loader);
	}
	
	
	
}
