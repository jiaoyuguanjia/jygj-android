package com.wuya.app.core.net;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 请求JAVA WEB端AJAX服务工具，请求和返回都是JSON
 * 
 * @author xiaocilin
 * 
 * @since 2014-12-13
 * 
 */
public class HttpClientUtils {

	public static JSONObject post(String url, Map<String, String> params)
			throws Exception {
		return post(url, toJson(params));
	}

	public static JSONObject post(String jsonUrlApi, JSONObject jsonParams)
			throws Exception {
		HttpPost post = new HttpPost(jsonUrlApi);
		post.addHeader("Content-Type", "application/json");
		//TODO:这里将公共参数放入到Header里面

		// 绑定到请求 Entry
		post.setEntity(new StringEntity(jsonParams.toString()));
		// 发送请求
		HttpResponse httpResponse = new DefaultHttpClient().execute(post);

		if (httpResponse.getStatusLine().getStatusCode() == 200) {
			// 生成 JSON 对象
			return new JSONObject(
					EntityUtils.toString(httpResponse.getEntity()));
		}
		throw new Exception();
	}

	public static JSONObject get(String url, Map<String, String> paramMap)
			throws Exception {
		return get(url, toList(paramMap));
	}

	public static JSONObject get(String url, List<BasicNameValuePair> params)
			throws Exception {
		url = join(url, URLEncodedUtils.format(params, HTTP.UTF_8));
		HttpGet get = new HttpGet(url);
		get.addHeader("Content-Type", "application/json");
		get.addHeader("charset", HTTP.UTF_8);

		HttpResponse response = new DefaultHttpClient().execute(get);
		if (response.getStatusLine().getStatusCode() == 200) {
			// 生成 JSON 对象
			return new JSONObject(EntityUtils.toString(response.getEntity(),
					HTTP.UTF_8));
		}
		throw new Exception();
	}

	private static List<BasicNameValuePair> toList(Map<String, String> paramMap) {
		// 先将参数放入List，再对参数进行URL编码
		List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
		for (Map.Entry<String, String> param : paramMap.entrySet()) {
			params.add(new BasicNameValuePair(param.getKey(), param.getValue()));
		}
		return params;
	}

	private static JSONObject toJson(Map<String, String> params)
			throws JSONException {
		JSONObject jsonParams = new JSONObject();
		for (Map.Entry<String, String> param : params.entrySet()) {
			jsonParams.put(param.getKey(), param.getValue());
		}
		return jsonParams;
	}

	private static String join(String url, String encodeParams) {
		return url + "?" + encodeParams;
	}
	
}
