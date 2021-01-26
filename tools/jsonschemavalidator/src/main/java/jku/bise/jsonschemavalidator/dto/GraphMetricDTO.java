package jku.bise.jsonschemavalidator.dto;

import java.io.Serializable;

/**
 * This metrics have been taken from here https://github.com/miniHive/schemastore-analysis
 * @author alessandro.colantoni
 *
 */
public class GraphMetricDTO implements Serializable{

	
	private static final long serialVersionUID = 1073658294102415897L;
	
	public static final String DEPTH_SCHEMA ="Depth Schema"; 
	public static final String DEPTH_RESOLVED_TREE ="Depth Resolved Tree"; 
	public static final String FAN_IN ="Fan In"; 
	public static final String FAN_OUT ="Fan Out";
	public static final String RECURSIONS ="Recursions";
	public static final String MIN_CYCLE_LEN ="Min Cycle Len";
	public static final String MAX_CYCLE_LEN = "Max Cycle Len";
	public static final String WIDTH ="Width";
	public static final String UNREACHABLES ="Unreachables";
	public static final String UNSOLVED_REFS ="Unsolved Refs";
	
	
	/**
	 * keep track of the location element in the json that created it
	 */
	private String pointer="#";
	
	/**
	 * Depth of the tree that emerges from loading the raw JSON Schema into an schema_graph .
	 */
	private int depthSchema = 0;
	
	/**
	 * Depth of the tree after resolving the references. If has_recursion is true, this is the maximum cycle length in the recursive document.
	 */
	private int depthResolvedTree=0;
	
	/**
	 * Maximum Fan-In over all nodes included in the schema_graph.
	 */
	private int fanIn = 0;
	
	/**
	 * Maximum Fan-Out over all nodes included in the schema_graph.
	 */
	private int fanOut = 0;
	
	/**
	 * Number of recursions.
	 */
	private int recursions = 0;
	
	/**
	 * Minimum cycle length of a recursive document. If has_recursion is false, this column will be 0.
	 */
	private int minCycleLen = 0;
	
	/**
	 * MAximum cycle length of a recursive document. If has_recursion is false, this column will be 0.
	 */
	private int maxCycleLen = 0;
	
	/**
	 * Number of leaf nodes in the schema_graph of the raw JSON Schema document.
	 */
	private int width = 0;
	
	/**
	 * Number of  unreachable (unused) definitons.
	 */
	private int unreachables = 0;
	
	/**
	 * Number of references not matching a definition
	 */
	private int unsolvedRefs =0;
	

	public int getDepthSchema() {
		return depthSchema;
	}

	public void setDepthSchema(int depthSchema) {
		this.depthSchema = depthSchema;
	}

	public int getDepthResolvedTree() {
		return depthResolvedTree;
	}

	public void setDepthResolvedTree(int depthResolvedTree) {
		this.depthResolvedTree = depthResolvedTree;
	}

	public int getFanIn() {
		return fanIn;
	}

	public void setFanIn(int fanIn) {
		this.fanIn = fanIn;
	}

	public int getFanOut() {
		return fanOut;
	}

	public void setFanOut(int fanOut) {
		this.fanOut = fanOut;
	}

	public int getRecursions() {
		return recursions;
	}

	public void setRecursions(int recursions) {
		this.recursions = recursions;
	}

	public int getMinCycleLen() {
		return minCycleLen;
	}

	public void setMinCycleLen(int minCycleLen) {
		this.minCycleLen = minCycleLen;
	}
	
	

	public int getMaxCycleLen() {
		return maxCycleLen;
	}

	public void setMaxCycleLen(int maxCycleLen) {
		this.maxCycleLen = maxCycleLen;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getUnreachables() {
		return unreachables;
	}

	public void setUnreachables(int unreachables) {
		this.unreachables = unreachables;
	}
	
	
	
	public String getPointer() {
		return pointer;
	}

	public void setPointer(String pointer) {
		this.pointer = pointer;
	}
	
	
	
	
	public int getUnsolvedRefs() {
		return unsolvedRefs;
	}

	public void setUnsolvedRefs(int unsolvedRefs) {
		this.unsolvedRefs = unsolvedRefs;
	}

	public void appendToPointer(String key) {
		this.pointer += "/"+ key;
	}

	public void incrementDepthSchema() {
		this.depthSchema++;
	}
	
	public void incrementWidth() {
		this.width++;
	}
	
	public void incrementFanIn() {
		this.fanIn++;
	}
	
	public void incrementRecursions() {
		this.recursions++;
	}
	
	
	

	@Override
	public GraphMetricDTO clone() {
		GraphMetricDTO clone = new GraphMetricDTO();
		clone.setPointer(this.pointer);
		clone.setDepthSchema(this.depthSchema);
		//clone.setDepthResolvedTree(this.depthResolvedTree);
		//clone.setFanIn(this.fanIn);
		//clone.setFanOut(this.fanOut);
		//clone.setRecursions(this.recursions);
//		clone.setMinCycleLen(this.minCycleLen);
//		clone.setMaxCycleLen(this.maxCycleLen);
		clone.setWidth(this.width);
		return clone;
	}
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		//stringBuffer.append("pointer :" +this.pointer+"\n");
		stringBuffer.append("depthSchema :" +this.depthSchema+"\n");
		stringBuffer.append("depthResolvedTree :" +this.depthResolvedTree+"\n");
		stringBuffer.append("fanIn :" +this.fanIn+"\n");
		stringBuffer.append("fanOut :" +this.fanOut+"\n");
		stringBuffer.append("recursions :" +this.recursions+"\n");
		stringBuffer.append("minCycleLen :" +this.minCycleLen+"\n");
		stringBuffer.append("maxCycleLen :" +this.maxCycleLen+"\n");
		stringBuffer.append("width :" +this.width+"\n");
		stringBuffer.append("unreachables :" +this.unreachables+"\n");
		stringBuffer.append("unsolvedRefs :" +this.unsolvedRefs+"\n");
		return stringBuffer.toString();
	}

}
