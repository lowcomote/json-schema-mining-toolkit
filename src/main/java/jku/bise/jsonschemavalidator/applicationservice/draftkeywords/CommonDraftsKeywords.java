package jku.bise.jsonschemavalidator.applicationservice.draftkeywords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommonDraftsKeywords {
	
	public final static String PROPERTIES = "properties";
	public final static String PATTERN_PROPERTIES = "patternProperties";
	
	public final static String TYPE = "type";
	public final static String TYPE_ARRAY = "array";
	public final static String TYPE_BOOLEAN = "boolean";
	public final static String TYPE_INTEGER = "integer";
	public final static String TYPE_NULL = "null";
	public final static String TYPE_NUMBER = "number";
	public final static String TYPE_OBJECT = "object";
	public final static String TYPE_STRING = "string";
	
	public final static String ARRAY_OF_TYPES = "array_of_types";
	
	
	/**
	 * TODO add here other common keywords when needed
	 */
	
	public final static List<String> TYPE_LIST = Collections.unmodifiableList(new ArrayList<>(List.of(
			TYPE_ARRAY,
			TYPE_BOOLEAN,
			TYPE_INTEGER,
			TYPE_NULL,
			TYPE_NUMBER,
			TYPE_OBJECT,
			TYPE_STRING,
			ARRAY_OF_TYPES
	)));

}
