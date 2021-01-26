package jku.bise.jsonschemavalidator.applicationservice.draftkeywords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Draft03Keywords {
	
	public final static String JSON_SCHEMA_DRAFT_O3_URL = "http://json-schema.org/draft-03/schema";
	
	public final static String PROPERTIES = "properties";
	public final static String ID = "id";
	public final static String SCHEMA = "$schema";
	public final static String REF = "$ref";
	public final static String TITLE ="title";
	public final static String DESCRIPTION = "description";
	public final static String DEFAULT= "default";
	public final static String MAXIMUM = "maximum";
	public final static String EXCLUSIVE_MAXIMUM = "exclusiveMaximum";
	public final static String MINIMUM = "minimum";
	public final static String EXCLUSIVE_MINIMUM = "exclusiveMinimum";
	public final static String MAX_LENGTH = "maxLength";
	public final static String MIN_LENGTH = "minLength";
	public final static String PATTERN = "pattern";
	public final static String ADDITIONAL_ITEMS = "additionalItems";
	public final static String ITEMS = "items";
	public final static String MAX_ITEMS = "maxItems";
	public final static String MIN_ITEMS = "minItems";
	public final static String UNIQUE_ITEMS = "uniqueItems";
	public final static String REQUIRED = "required";
	public final static String ADDITIONAL_PROPERTIES = "additionalProperties";
	public final static String PATTERN_PROPERTIES = "patternProperties";
	public final static String DEPENDENCIES = "dependencies";
	public final static String ENUM = "enum";
	public final static String TYPE = "type";
	public final static String FORMAT = "format";
	public final static String DIVISIBLE_BY ="divisibleBy";
	public final static String DISALLOW ="disallow";
	public final static String EXTENDS = "extends";
	
	
	
	public final static List<String> KEYWORDS_LIST = Collections.unmodifiableList(new ArrayList<>(List.of(
			PROPERTIES,
			ID,
			SCHEMA,
			REF,
			TITLE,
			DESCRIPTION,
			DEFAULT,
			MAXIMUM,
			EXCLUSIVE_MAXIMUM,
			MINIMUM,
			EXCLUSIVE_MINIMUM,
			MAX_LENGTH,
			MIN_LENGTH,
			PATTERN,
			ADDITIONAL_ITEMS,
			ITEMS,
			MAX_ITEMS,
			MIN_ITEMS,
			UNIQUE_ITEMS,
			REQUIRED,
			ADDITIONAL_PROPERTIES,
			PATTERN_PROPERTIES,
			DEPENDENCIES,
			ENUM,
			TYPE,
			FORMAT,
			DIVISIBLE_BY,
			DISALLOW,
			EXTENDS
		)));
	
}
