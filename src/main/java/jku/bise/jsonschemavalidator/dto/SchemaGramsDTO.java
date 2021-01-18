package jku.bise.jsonschemavalidator.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SchemaGramsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5471697194709624686L;
	
	private String name;
	private String schema;
	
	private Set<String> unigrams = new HashSet<>();
	private Set<String> bigrams = new HashSet<>();
	
	public void addUnigram (String unigram) {
		this.unigrams.add(unigram);
	}
	
	public void addBigram (String bigram) {
		this.bigrams.add(bigram);
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
	public Set<String> getUnigrams() {
		return unigrams;
	}
	
	public Set<String> getBigrams() {
		return bigrams;
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("name :" +this.name+"\n");
		stringBuffer.append("schema :" +this.schema+"\n");
		stringBuffer.append("unigrams : " +this.unigrams.toString()+"\n");
		stringBuffer.append("bigrams  : "+this.bigrams.toString()+"\n");
		return stringBuffer.toString();
		
	}
	
	
	
	

}
