package jku.bise.jsonschemavalidator.applicationservice.schemametrics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;

public class SchemaMetric {

	public Map<String,Integer> findSchemaMetrics(JSONObject jsonObject, List<String> keywords){
		Map<String,Integer> metrics = new HashMap<String,Integer>();
		keywords.stream().forEach(key->{metrics.put(key, 0);});
		Set<String> keys =jsonObject.keySet();
		keys.stream().forEach(key->{
			
		});
		
		return metrics;
		
			      
	}
}
