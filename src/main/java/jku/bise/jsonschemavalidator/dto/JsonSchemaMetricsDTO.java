package jku.bise.jsonschemavalidator.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class JsonSchemaMetricsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7556533730002406407L;
	
	private String name;
	
	private String schema;
	
	private Map<String,Integer> keywordsCount = new HashMap<String,Integer>();
	
	private Map<String,Integer> typesCount = new HashMap<String,Integer>();
	
	private GraphMetricDTO graphMetricDTO = new GraphMetricDTO();
	
	
	public void putKeywordsCount(String keyword, Integer count) {
		this.keywordsCount.put(keyword, count) ;
	}

	public Integer getKeywordsCount(String keyword) {
		return this.keywordsCount.get(keyword);
	}
	
	public Map<String, Integer> getKeywordsCount() {
		return keywordsCount;
	}
	
	
	public void putTypesCount(String keyword, Integer count) {
		this.typesCount.put(keyword, count) ;
	}

	public Integer getTypesCount(String keyword) {
		return this.typesCount.get(keyword);
	}
	
	public Map<String, Integer> getTypesCount() {
		return typesCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public GraphMetricDTO getGraphMetricDTO() {
		return graphMetricDTO;
	}

	
	
	

	
	
	
	
}
