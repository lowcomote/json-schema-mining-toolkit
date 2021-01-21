package jku.bise.jsonschemavalidator.applicationservice.csvwriter;

import java.io.FileWriter;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.DraftsUnionKeywords;
import jku.bise.jsonschemavalidator.dto.GraphMetricDTO;
import jku.bise.jsonschemavalidator.dto.JsonSchemaMetricsDTO;


@Service
public class CsvMetricWriterApplicationService {
	
	private static Logger logger = LoggerFactory.getLogger(CsvMetricWriterApplicationService.class);
	
	
	
	
	public void createCSVFile(List<JsonSchemaMetricsDTO> jsonSchemaMetricsDTOs, String csvFileName) {
		initCsvFile(csvFileName);
		for(JsonSchemaMetricsDTO jsonSchemaMetricsDTO: jsonSchemaMetricsDTOs) {
			appendCSVFile( jsonSchemaMetricsDTO, csvFileName);
		}
	}
	
	private void initCsvFile(String csvFileName) {
		try (CSVPrinter printer = new CSVPrinter(new FileWriter(csvFileName, false), CSVFormat.DEFAULT)) {
			
			printer.printRecord(
					JsonSchemaMetricsDTO.FILE_NAME, 
					JsonSchemaMetricsDTO.SCHEMA, 
					
					DraftsUnionKeywords.PROPERTIES,
					DraftsUnionKeywords.ID_DRAFT_03_04,
					DraftsUnionKeywords.ID,
					DraftsUnionKeywords.SCHEMA,
					DraftsUnionKeywords.ANCHOR,
					DraftsUnionKeywords.REF,
					DraftsUnionKeywords.RECURSIVE_REF,
					DraftsUnionKeywords.RECURSIVE_ANCHOR,
					DraftsUnionKeywords.VOCABULARY,
					DraftsUnionKeywords.COMMENT,
					DraftsUnionKeywords.TITLE,
					DraftsUnionKeywords.DESCRIPTION,
					DraftsUnionKeywords.DEFAULT,
					DraftsUnionKeywords.DEPRECATED,
					DraftsUnionKeywords.READ_ONLY,
					DraftsUnionKeywords.WRITE_ONLY,
					DraftsUnionKeywords.EXAMPLE,
					DraftsUnionKeywords.MAXIMUM,
					
					DraftsUnionKeywords.EXCLUSIVE_MAXIMUM,
					DraftsUnionKeywords.MINIMUM,
					DraftsUnionKeywords.EXCLUSIVE_MINIMUM,
					DraftsUnionKeywords.MAX_LENGTH,
					DraftsUnionKeywords.MIN_LENGTH,
					DraftsUnionKeywords.PATTERN,
					DraftsUnionKeywords.ADDITIONAL_ITEMS,
					DraftsUnionKeywords.UNEVALUATED_ITEMS,
					DraftsUnionKeywords.ITEMS,
					DraftsUnionKeywords.MAX_ITEMS,
					DraftsUnionKeywords.MIN_ITEMS,
					DraftsUnionKeywords.UNIQUE_ITEMS,
					DraftsUnionKeywords.CONTAINS,
					DraftsUnionKeywords.MAX_CONTAINS,
					DraftsUnionKeywords.MIN_CONTAINS,
					DraftsUnionKeywords.MAX_PROPERTIES,
					DraftsUnionKeywords.MIN_PROPERTIES,
					DraftsUnionKeywords.REQUIRED,
					DraftsUnionKeywords.DEPENDENT_REQUIRED,
					DraftsUnionKeywords.ADDITIONAL_PROPERTIES,
					DraftsUnionKeywords.UNEVALUATED_PROPERTIES,
					DraftsUnionKeywords.DEFINITIONS,
					DraftsUnionKeywords.DEFS,
					DraftsUnionKeywords.PATTERN_PROPERTIES,
					DraftsUnionKeywords.DEPENDENCIES,
					DraftsUnionKeywords.DEPENDENT_SCHEMAS,
					DraftsUnionKeywords.PROPERTY_NAMES,
					DraftsUnionKeywords.CONST,
					DraftsUnionKeywords.ENUM,
					DraftsUnionKeywords.TYPE,
					
					DraftsUnionKeywords.FORMAT,
					DraftsUnionKeywords.CONTENT_MEDIA_TYPE,
					DraftsUnionKeywords.CONTENT_ENCODING,
					DraftsUnionKeywords.CONTENT_SCHEMA,
					DraftsUnionKeywords.IF,
					DraftsUnionKeywords.THEN,
					DraftsUnionKeywords.ELSE,
					DraftsUnionKeywords.ALL_OF,
					DraftsUnionKeywords.ANY_OF,
					DraftsUnionKeywords.ONE_OF,
					DraftsUnionKeywords.NOT,
					DraftsUnionKeywords.DIVISIBLE_BY,
					DraftsUnionKeywords.DISALLOW,
					DraftsUnionKeywords.EXTENDS,
					
					DraftsUnionKeywords.TYPE_ARRAY,
					DraftsUnionKeywords.TYPE_BOOLEAN,
					DraftsUnionKeywords.TYPE_INTEGER,
					DraftsUnionKeywords.TYPE_NULL,
					DraftsUnionKeywords.TYPE_NUMBER,
					DraftsUnionKeywords.TYPE_OBJECT,
					DraftsUnionKeywords.TYPE_STRING,
					DraftsUnionKeywords.ARRAY_OF_TYPES,
					
					GraphMetricDTO.DEPTH_SCHEMA,
					GraphMetricDTO.DEPTH_RESOLVED_TREE,
					GraphMetricDTO.FAN_IN,
					GraphMetricDTO.FAN_OUT,
					GraphMetricDTO.RECURSIONS,
					GraphMetricDTO.MIN_CYCLE_LEN,
					GraphMetricDTO.MAX_CYCLE_LEN,
					GraphMetricDTO.WIDTH,
					GraphMetricDTO.UNREACHABLES,
					GraphMetricDTO.UNSOLVED_REFS
				);
		} catch (Exception e) {
			if(logger.isErrorEnabled()) {
				logger.error("Error initiating the CSV file");
			}
			e.printStackTrace();
			
		}
	}
	
	private void appendCSVFile(JsonSchemaMetricsDTO jsonSchemaMetricsDTO , String csvFileName) {
		try {
			
			
			try (CSVPrinter printer = new CSVPrinter(new FileWriter(csvFileName, true), CSVFormat.DEFAULT)) {
				printer.printRecord(
						jsonSchemaMetricsDTO.getName(), 
						jsonSchemaMetricsDTO.getSchema(),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.PROPERTIES),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.ID_DRAFT_03_04),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.ID),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.SCHEMA),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.ANCHOR),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.REF),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.RECURSIVE_REF),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.RECURSIVE_ANCHOR),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.VOCABULARY),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.COMMENT),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.TITLE),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.DESCRIPTION),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.DEFAULT),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.DEPRECATED),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.READ_ONLY),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.WRITE_ONLY),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.EXAMPLE),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.MAXIMUM),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.EXCLUSIVE_MAXIMUM),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.MINIMUM),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.EXCLUSIVE_MINIMUM),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.MAX_LENGTH),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.MIN_LENGTH),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.PATTERN),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.ADDITIONAL_ITEMS),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.UNEVALUATED_ITEMS),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.ITEMS),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.MAX_ITEMS),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.MIN_ITEMS),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.UNIQUE_ITEMS),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.CONTAINS),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.MAX_CONTAINS),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.MIN_CONTAINS),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.MAX_PROPERTIES),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.MIN_PROPERTIES),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.REQUIRED),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.DEPENDENT_REQUIRED),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.ADDITIONAL_PROPERTIES),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.UNEVALUATED_PROPERTIES),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.DEFINITIONS),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.DEFS),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.PATTERN_PROPERTIES),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.DEPENDENCIES),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.DEPENDENT_SCHEMAS),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.PROPERTY_NAMES),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.CONST),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.ENUM),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.TYPE),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.FORMAT),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.CONTENT_MEDIA_TYPE),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.CONTENT_ENCODING),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.CONTENT_SCHEMA),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.IF),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.THEN),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.ELSE),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.ALL_OF),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.ANY_OF),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.ONE_OF),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.NOT),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.DIVISIBLE_BY),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.DISALLOW),
						jsonSchemaMetricsDTO.getKeywordsCount(DraftsUnionKeywords.EXTENDS),
						
						jsonSchemaMetricsDTO.getTypesCount(DraftsUnionKeywords.TYPE_ARRAY),
						jsonSchemaMetricsDTO.getTypesCount(DraftsUnionKeywords.TYPE_BOOLEAN),
						jsonSchemaMetricsDTO.getTypesCount(DraftsUnionKeywords.TYPE_INTEGER),
						jsonSchemaMetricsDTO.getTypesCount(DraftsUnionKeywords.TYPE_NULL),
						jsonSchemaMetricsDTO.getTypesCount(DraftsUnionKeywords.TYPE_NUMBER),
						jsonSchemaMetricsDTO.getTypesCount(DraftsUnionKeywords.TYPE_OBJECT),
						jsonSchemaMetricsDTO.getTypesCount(DraftsUnionKeywords.TYPE_STRING),
						jsonSchemaMetricsDTO.getTypesCount(DraftsUnionKeywords.ARRAY_OF_TYPES),
						
						jsonSchemaMetricsDTO.getGraphMetricDTO().getDepthSchema(),
						jsonSchemaMetricsDTO.getGraphMetricDTO().getDepthResolvedTree(),
						jsonSchemaMetricsDTO.getGraphMetricDTO().getFanIn(),
						jsonSchemaMetricsDTO.getGraphMetricDTO().getFanOut(),
						jsonSchemaMetricsDTO.getGraphMetricDTO().getRecursions(),
						jsonSchemaMetricsDTO.getGraphMetricDTO().getMinCycleLen(),
						jsonSchemaMetricsDTO.getGraphMetricDTO().getMaxCycleLen(),
						jsonSchemaMetricsDTO.getGraphMetricDTO().getWidth(),
						jsonSchemaMetricsDTO.getGraphMetricDTO().getUnreachables(),
						jsonSchemaMetricsDTO.getGraphMetricDTO().getUnsolvedRefs()
					
				);
				
				
			} catch (Exception e) {
				e.printStackTrace();
				if(logger.isErrorEnabled()) {
					logger.error("CREATECSV for grams of file: {} CSV IO Error", jsonSchemaMetricsDTO.getName());
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
