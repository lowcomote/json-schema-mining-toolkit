package jku.bise.jsonschemavalidator.applicationservice.draftkeywords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Draft201909Keywords {
	
	public final static String JSON_SCHEMA_DRAFT_2019_09_URL = "https://json-schema.org/draft/2019-09/schema";
	
	public final static String PROPERTIES = "properties"; //
	public final static String ID = "$id"; //
	public final static String SCHEMA = "$schema"; //
	
	public final static String ANCHOR = "$anchor"; // New
	public final static String REF = "$ref"; //
	
	public final static String RECURSIVE_REF = "$recursiveRef"; // New
	public final static String RECURSIVE_ANCHOR = "$recursiveAnchor"; // New
	public final static String VOCABULARY = "$vocabulary"; // New
	
	public final static String COMMENT = "$comment"; //
	
	
	
	public final static String TITLE ="title"; //
	public final static String DESCRIPTION = "description"; //
	public final static String DEFAULT= "default"; //
	
	public final static String DEPRECATED = "deprecated"; // New
	
	public final static String READ_ONLY= "readOnly"; //
	public final static String WRITE_ONLY= "writeOnly"; //
	public final static String EXAMPLE= "examples"; //
	public final static String MULTIPLE_OF = "multipleOf"; //
	public final static String MAXIMUM = "maximum"; //
	public final static String EXCLUSIVE_MAXIMUM = "exclusiveMaximum"; //
	public final static String MINIMUM = "minimum"; //
	public final static String EXCLUSIVE_MINIMUM = "exclusiveMinimum"; //
	public final static String MAX_LENGTH = "maxLength"; //
	public final static String MIN_LENGTH = "minLength"; //
	public final static String PATTERN = "pattern"; //
	
	public final static String ADDITIONAL_ITEMS = "additionalItems";//
	public final static String UNEVALUATED_ITEMS ="unevaluatedItems"; // New
	
	public final static String ITEMS = "items"; //
	public final static String MAX_ITEMS = "maxItems"; //
	public final static String MIN_ITEMS = "minItems"; //
	public final static String UNIQUE_ITEMS = "uniqueItems"; //
	public final static String CONTAINS ="contains"; //
	
	public final static String MAX_CONTAINS = "maxContains"; // New
	public final static String MIN_CONTAINS = "minContains"; // New
	
	public final static String MAX_PROPERTIES = "maxProperties"; //
	public final static String MIN_PROPERTIES = "minProperties"; //
	public final static String REQUIRED = "required";
	public final static String DEPENDENT_REQUIRED = "dependentRequired"; // New
	
	public final static String ADDITIONAL_PROPERTIES = "additionalProperties"; //
	public final static String UNEVALUATED_PROPERTIES = "unevaluatedProperties"; // New
	public final static String DEFINITIONS = "definitions"; //
	public final static String DEFS = "$defs"; // New
	
	public final static String PATTERN_PROPERTIES = "patternProperties"; //
	public final static String DEPENDENCIES = "dependencies"; //
	public final static String DEPENDENT_SCHEMAS = "dependentSchemas"; // New
	public final static String PROPERTY_NAMES = "propertyNames"; //
	public final static String CONST = "const"; //
	public final static String ENUM = "enum"; //
	public final static String TYPE = "type"; //
	public final static String TYPE_ARRAY = "array"; //
	public final static String TYPE_BOOLEAN = "boolean"; //
	public final static String TYPE_INTEGER = "integer"; //
	public final static String TYPE_NULL = "null"; //
	public final static String TYPE_NUMBER = "number"; //
	public final static String TYPE_OBJECT = "object"; //
	public final static String TYPE_STRING = "string"; //
	public final static String FORMAT = "format"; //
	public final static String CONTENT_MEDIA_TYPE = "contentMediaType"; //
	public final static String CONTENT_ENCODING = "contentEncoding"; //
	public final static String CONTENT_SCHEMA = "contentSchema"; // New
	public final static String IF = "if"; //
	public final static String THEN = "then"; //
	public final static String ELSE = "else"; //
	public final static String ALL_OF = "allOf"; //
	public final static String ANY_OF = "anyOf"; //
	public final static String ONE_OF = "oneOf"; //
	public final static String NOT = "not"; //
	
	public final static List<String> KEYWORDS_LIST = Collections.unmodifiableList(new ArrayList<>(List.of(
			PROPERTIES,
			ID,
			SCHEMA,
			ANCHOR,
			REF,
			RECURSIVE_REF,
			RECURSIVE_ANCHOR,
			VOCABULARY,
			COMMENT,
			TITLE,
			DESCRIPTION,
			DEFAULT,
			DEPRECATED,
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
			UNEVALUATED_ITEMS,
			ITEMS,
			MAX_ITEMS,
			MIN_ITEMS,
			UNIQUE_ITEMS,
			CONTAINS,
			MAX_CONTAINS,
			MIN_CONTAINS,
			MAX_PROPERTIES,
			MIN_PROPERTIES,
			REQUIRED,
			DEPENDENT_REQUIRED,
			ADDITIONAL_PROPERTIES,
			UNEVALUATED_PROPERTIES,
			DEFINITIONS,
			DEFS,
			PATTERN_PROPERTIES,
			DEPENDENCIES,
			DEPENDENT_SCHEMAS,
			PROPERTY_NAMES,
			CONST,
			ENUM,
			TYPE,
			FORMAT,
			CONTENT_MEDIA_TYPE,
			CONTENT_ENCODING,
			CONTENT_SCHEMA,
			IF,
			THEN,
			ELSE,
			ALL_OF,
			ANY_OF,
			ONE_OF,
			NOT
			
	)));
	
	public final static List<String> TYPE_LIST = Collections.unmodifiableList(new ArrayList<>(List.of(
			TYPE_ARRAY,
			TYPE_BOOLEAN,
			TYPE_INTEGER,
			TYPE_NULL,
			TYPE_NUMBER,
			TYPE_OBJECT,
			TYPE_STRING
	)));
	
}
