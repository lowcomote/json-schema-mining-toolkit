package jku.bise.jsonschemavalidator.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonSchemaMetricsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7556533730002406407L;
	
	public static final String FILE_NAME ="File Name"; 
	public static final String SCHEMA ="schema"; 
	
	private String name;
	
	private String schema;
	
	private Map<String,Integer> keywordsCount = new HashMap<String,Integer>();
	
	private Map<String,Integer> typesCount = new HashMap<String,Integer>();
	
	private GraphMetricDTO graphMetricDTO = new GraphMetricDTO();
	
	
	//private Map<String,GraphMetricDTO> referencer = new HashMap<String,GraphMetricDTO>();
	private Map<String,List<GraphMetricDTO>> referencer = new HashMap<String,List<GraphMetricDTO>>();
	private Map<String,GraphMetricDTO> referable = new HashMap<String,GraphMetricDTO>();
	
	public void putKeywordsCount(String keyword, Integer count) {
		this.keywordsCount.put(keyword, count) ;
	}

	public Integer getKeywordsCount(String keyword) {
		if(this.keywordsCount.containsKey(keyword)) {
			return this.keywordsCount.get(keyword);
		}else {
			return 0;
		}
	}
	
	public Map<String, Integer> getKeywordsCount() {
		return keywordsCount;
	}
	
	
	public void putTypesCount(String keyword, Integer count) {
		this.typesCount.put(keyword, count) ;
	}

	public Integer getTypesCount(String keyword) {
		if(this.typesCount.containsKey(keyword)) {
			return this.typesCount.get(keyword);
		}else {
			return 0;
		}
		
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

	public Map<String, List<GraphMetricDTO>> getReferencer() {
		return referencer;
	}

	public Map<String, GraphMetricDTO> getReferable() {
		return referable;
	}
	
	public void putReferencer(String key,  GraphMetricDTO graphMetricDTO) {
		if(!this.referencer.containsKey(key)) {
			this.referencer.put(key, new ArrayList<GraphMetricDTO>());
		}
		referencer.get(key).add(graphMetricDTO);
	}

	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("name :" +this.name+"\n");
		stringBuffer.append("schema :" +this.schema+"\n");
		stringBuffer.append("keywordsCount :" +this.keywordsCount.toString()+"\n");
		stringBuffer.append("typesCount :" +this.typesCount.toString()+"\n");
		stringBuffer.append("graphMetricDTO :" +this.graphMetricDTO.toString()+"\n");
		return stringBuffer.toString();
	}

}
