package jku.bise.jsonschemavalidator.applicationservice.draftvalidator;

import java.io.IOException;

import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft04Keywords;
import jku.bise.jsonschemavalidator.common.Utils;

/**
 * This class validate if given json-schemas conform to DRAFT 4 Metaschema
 * @author alessandro.colantoni
 *
 */
public class Draft4SchemaValidator extends DraftSchemaValidator{

	
	
	
	public Draft4SchemaValidator () throws IOException {
		
		JSONObject jsonObject = Utils.buildJsonObjectFromURL(Draft04Keywords.JSON_SCHEMA_DRAFT_O4_URL);
		this.schema = SchemaLoader.load(jsonObject);
		
	}
	
	
	
}
