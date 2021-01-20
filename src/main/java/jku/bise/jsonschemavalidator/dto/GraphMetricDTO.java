package jku.bise.jsonschemavalidator.dto;

import java.io.Serializable;

/**
 * This metrics have been taken from here https://github.com/miniHive/schemastore-analysis
 * @author alessandro.colantoni
 *
 */
public class GraphMetricDTO implements Serializable{

	
	private static final long serialVersionUID = 1073658294102415897L;
	
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
	 * Boolean flag that indicates whether the JSON Schema document (i.e. the resolved graph) is recursive.
	 */
	private boolean hasRecursion = false;
	
	/**
	 * Minimum cycle length of a recursive document. If has_recursion is false, this column will be 0.
	 */
	private int minCycleLen = 0;
	
	/**
	 * Number of leaf nodes in the schema_graph of the raw JSON Schema document.
	 */
	private int width = 0;
	
	/**
	 * Boolean flag that indicates whether the schema contains unreachable (unused) definitons.
	 */
	private boolean reachability = false;

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

	public boolean isHasRecursion() {
		return hasRecursion;
	}

	public void setHasRecursion(boolean hasRecursion) {
		this.hasRecursion = hasRecursion;
	}

	public int getMinCycleLen() {
		return minCycleLen;
	}

	public void setMinCycleLen(int minCycleLen) {
		this.minCycleLen = minCycleLen;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public boolean isReachability() {
		return reachability;
	}

	public void setReachability(boolean reachability) {
		this.reachability = reachability;
	}
	
	public void incrementDepthSchema() {
		this.depthSchema++;
	}
	
	public void incrementWidth() {
		this.width++;
	}
	
	
	

	@Override
	public GraphMetricDTO clone() {
		GraphMetricDTO clone = new GraphMetricDTO();
		clone.setDepthSchema(this.depthSchema);
		clone.setDepthResolvedTree(this.depthResolvedTree);
		clone.setFanIn(this.fanIn);
		clone.setFanOut(this.fanOut);
		clone.setHasRecursion(this.hasRecursion);
		clone.setMinCycleLen(this.minCycleLen);
		clone.setWidth(this.width);
		return clone;
	}
	

}
