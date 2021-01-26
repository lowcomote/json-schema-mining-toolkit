package jku.bise.jsonschemavalidator.dto;

import java.io.Serializable;

public class SchemaViolationDetailDTO implements Serializable {

	
	private static final long serialVersionUID = -5758312640606195581L;
	
	private String fileName ="";
	private String schema = "";
	private String keyword ="";
	private String pointerToViolation ="";
	private int level = 0;
	private String message ="";
	private String extendedMessage ="";
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getPointerToViolation() {
		return pointerToViolation;
	}
	public void setPointerToViolation(String pointerToViolation) {
		this.pointerToViolation = pointerToViolation;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getExtendedMessage() {
		return extendedMessage;
	}
	public void setExtendedMessage(String extendedMessage) {
		this.extendedMessage = extendedMessage;
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("fileName :" +this.fileName+"\n");
		stringBuffer.append("schema :" +this.schema+"\n");
		stringBuffer.append("keyword :" +this.keyword+"\n");
		stringBuffer.append("pointerToViolation :" +this.pointerToViolation+"\n");
		stringBuffer.append("message :" +this.message+"\n");
		stringBuffer.append("extendedMessage :" +this.extendedMessage+"\n");
		return stringBuffer.toString();
		
	}
	
	
	
	
	
	
	

}
