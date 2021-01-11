package jku.bise.jsonschemavalidator.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.json.JSONObject;
import org.json.JSONTokener;

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
}
