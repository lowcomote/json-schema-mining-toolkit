package jku.bise.jsonschemavalidator.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;

import jku.bise.jsonschemavalidator.exception.JsonParseException;

public final class Utils {
	
	private final static String SCHEMA = "$schema";
	
	public static JSONObject buildJsonObjectFromFilePath(String filePath) throws IOException {
		InputStream inputStream = new FileInputStream(filePath);
		JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));
		return jsonObject;
		
	}
	public static JSONObject buildJsonObjectFromURL(String url) throws IOException {
		InputStream inputStream = new URL(url).openStream();
		JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));
		return jsonObject;
		
	}
	
	public static JsonElement buildJsonElementFromURL(String url) throws IOException {
		InputStream inputStream = new URL(url).openStream();
		InputStreamReader reader = new InputStreamReader(inputStream);
		JsonElement jsonElement = JsonParser.parseReader(reader);
		return jsonElement;
	}
	
	public static JSONObject buildJsonObjectFromFile(File file) throws JsonParseException   {
		try {
			FileReader fileReader = new FileReader(file);
			JSONObject jsonObject = new JSONObject(new JSONTokener(fileReader));
			return jsonObject;
		} catch (FileNotFoundException | JSONException e) {
			throw new JsonParseException("It has not been poosible to create the JSONObject from the file",e);
		} 
	}
	
	public static JsonElement buildJsonElementFromFile(File file) throws JsonParseException   {
		try {
			FileReader fileReader = new FileReader(file);
			JsonReader jsonReader = new JsonReader(fileReader);
			JsonElement jsonElement = JsonParser.parseReader(jsonReader);
			return jsonElement;
		} catch (JsonIOException  | JsonSyntaxException | FileNotFoundException e) {
			throw new JsonParseException("It has not been poosible to create the JsonElement from the file",e);
		}
	}
	
	public static JsonNode buildJsonNodeFromFile(File file) throws JsonParseException   {
		try {
			JsonNode jsonNode = JsonLoader.fromFile(file);
			return jsonNode;
		} catch (IOException e) {
			throw new JsonParseException("It has not been poosible to create the JsonNode from the file",e);
		}
	}
	
	public static String getSchemaDraftWithoutHashtag(JSONObject jsonObject)  {
		if (jsonObject.has(SCHEMA)) {
			String result = jsonObject.getString(SCHEMA);
			return result.endsWith("#")? result.substring(0, result.length() - 1) : result;	
		} else {
			return null;
		}
	}
}
