package jku.bise.jsonschemavalidator.applicationservice.draftkeywords;

import java.util.ArrayList;
import java.util.List;

public class Draf07Keywords {
	
	private final static String PROPERTIES = "properties";
	private final static String ID = "$id";
	private final static String SCHEMA = "$schema";
	private final static String REF = "$ref";
	private final static String COMMENT = "$comment";
	private final static String TITLE ="title";
	private final static String DESCRIPTION = "description";
	private final static String DEFAULT= "default";
	private final static String READ_ONLY= "readOnly";
	private final static String WRITE_ONLY= "writeOnly";
	private final static String EXAMPLE= "examples";
	private final static String MULTIPLE_OF = "multipleOf";
	private final static String MAXIMUM = "maximum";
	private final static String EXCLUSIVE_MAXIMUM = "exclusiveMaximum";
	private final static String MINIMUM = "minimum";
	private final static String EXCLUSIVE_MINIMUM = "exclusiveMinimum";
	private final static String MAX_LENGTH = "maxLength";
	private final static String MIN_LENGTH = "minLength";
	private final static String PATTERN = "pattern";
	private final static String ADDITIONAL_ITEMS = "additionalItems";
	private final static String ITEMS = "items";
	private final static String MAX_ITEMS = "maxItems";
	private final static String MIN_ITEMS = "minItems";
	private final static String UNIQUE_ITEMS = "uniqueItems";
	private final static String CONTAINS ="contains";
	private final static String MAX_PROPERTIES = "maxProperties";
	private final static String MIN_PROPERTIES = "minProperties";
	private final static String REQUIRED = "required";
	private final static String ADDITIONAL_PROPERTIES = "additionalProperties";
	private final static String DEFINITIONS = "definitions";
	private final static String PATTERN_PROPERTIES = "patternProperties";
	private final static String DEPENDENCIES = "dependencies";
	private final static String PROPERTY_NAMES = "propertyNames";
	private final static String CONST = "const";
	private final static String ENUM = "enum";
	private final static String TYPE = "type";
	private final static String TYPE_ARRAY = "array";
	private final static String TYPE_BOOLEAN = "boolean";
	private final static String TYPE_INTEGER = "integer";
	private final static String TYPE_NULL = "null";
	private final static String TYPE_NUMBER = "number";
	private final static String TYPE_OBJECT = "object";
	private final static String TYPE_STRING = "string";
	private final static String FORMAT = "format";
	private final static String CONTENT_MEDIA_TYPE = "contentMediaType";
	private final static String CONTENT_ENCODING = "contentEncoding";
	private final static String IF = "if";
	private final static String THEN = "then";
	private final static String ELSE = "else";
	private final static String ALL_OF = "allOf";
	private final static String ANY_OF = "anyOf";
	private final static String ONE_OF = "oneOf";
	private final static String NOT = "not";
	
	public final static List<String> KEYWORDS_LIST = new ArrayList<>(List.of(
			PROPERTIES,
			ID,
			SCHEMA,
			REF,
			COMMENT,
			TITLE,
			DESCRIPTION,
			DEFAULT,
			READ_ONLY,
			WRITE_ONLY,
			EXAMPLE,
			MULTIPLE_OF,
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
			CONTAINS,
			MAX_PROPERTIES,
			MIN_PROPERTIES,
			REQUIRED,
			ADDITIONAL_PROPERTIES,
			DEFINITIONS,
			PATTERN_PROPERTIES,
			DEPENDENCIES,
			PROPERTY_NAMES,
			CONST,
			ENUM,
			TYPE,
			TYPE_ARRAY,
			TYPE_BOOLEAN,
			TYPE_INTEGER,
			TYPE_NULL,
			TYPE_NUMBER,
			TYPE_OBJECT,
			TYPE_STRING,
			FORMAT,
			CONTENT_MEDIA_TYPE,
			CONTENT_ENCODING,
			IF,
			THEN,
			ELSE,
			ALL_OF,
			ANY_OF,
			ONE_OF,
			NOT
			
			));
	
}
