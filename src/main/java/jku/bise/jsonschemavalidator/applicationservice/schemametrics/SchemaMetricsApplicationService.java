package jku.bise.jsonschemavalidator.applicationservice.schemametrics;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft03Keywords;
import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft04Keywords;
import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft06Keywords;
import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft07Keywords;
import jku.bise.jsonschemavalidator.applicationservice.draftkeywords.Draft201909Keywords;
import jku.bise.jsonschemavalidator.common.Utils;
import jku.bise.jsonschemavalidator.exception.ApplicationServiceException;
import jku.bise.jsonschemavalidator.exception.JsonParseException;

@Service
public class SchemaMetricsApplicationService {
	private static Logger logger = LoggerFactory.getLogger(SchemaMetricsApplicationService.class);
	
	public void findSchemaMetricsInFileOrDirectory(String pathToDir, String csvFileName) throws ApplicationServiceException  {
		File fileOrdir = new File(pathToDir);
		if (fileOrdir.isDirectory())
			for (File file : fileOrdir.listFiles())
				findSchemaMetrics(file, csvFileName);
		else
			findSchemaMetrics(fileOrdir, csvFileName);
	}

	public Map<String,Integer> findSchemaMetrics(File file, String csvFileName) throws ApplicationServiceException  {
		logger.debug("findSchemaMetrics");
		Map<String,Integer> metrics = null;
		try {
			List<String> keywordList=null;
			JSONObject jsonObject = Utils.buildJsonObjectFromFile(file);
			String schema = Utils.getSchemaDraftWithoutHashtag(jsonObject);
			if(schema!=null) {
				if(Utils.isDraft4(schema)) {
					keywordList = Draft04Keywords.KEYWORDS_LIST;
				}else if (Utils.isDraft6(schema)){
					keywordList = Draft06Keywords.KEYWORDS_LIST;
				}else if (Utils.isDraft7(schema)) {
					keywordList = Draft07Keywords.KEYWORDS_LIST;
				}else if (Utils.isDraft3(schema)) {
					keywordList = Draft03Keywords.KEYWORDS_LIST;
				} else if (Utils.isDraft201909(schema)) {
					keywordList = Draft201909Keywords.KEYWORDS_LIST;
				}
			}
			if(keywordList!=null) {
				metrics=findSchemaMetrics(jsonObject, keywordList);
			}
			return  metrics;
		} catch (JsonParseException e) {
			throw new ApplicationServiceException(e.getMessage(),e);
		}
	}
	
	
	public Map<String,Integer> findSchemaMetrics(JSONObject jsonObject, List<String> keywords){
		Map<String,Integer> metrics = new HashMap<String,Integer>();
		keywords.stream().forEach(key->{metrics.put(key, 0);});
		Set<String> keys =jsonObject.keySet();
		keys.stream().forEach(key->{
			if(keywords.contains(key)) {
				int i = metrics.get(key);
				metrics.put(key, i+1);				
			}
			//jsonObject.get(key);
		});
		
		return metrics;
		
			      
	}
}
