package jku.bise.jsonschemavalidator.common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public final class Utils {
	public static JSONObject buildJsonObjectFromFile(String filePath) throws IOException {
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
}
