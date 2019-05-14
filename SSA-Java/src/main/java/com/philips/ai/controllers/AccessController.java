package com.philips.ai.controllers;

import java.io.IOException;
import java.util.Base64;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import com.philips.ai.Configuration;
import com.philips.ai.exceptions.APIException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AccessController extends BaseController {
	private static final Object syncObject = new Object();
	private static AccessController instance = null;

	private AccessController() {

	}

	public static AccessController getInstance() {
		if (null == instance) {
			synchronized (syncObject) {
				if (null == instance) {
					instance = new AccessController();
				}
			}
		}
		return instance;
	}

	public String getAccessToken(String clientId, String clientSecret) {

		String auth = clientId + ":" + clientSecret;
		String authentication = Base64.getEncoder().encodeToString(auth.getBytes());
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials");
		Request request = new Request.Builder().url(Configuration.getAccessTokenBaseUri() + "/oauth/accessToken")
				.post(body).addHeader("Content-Type", "application/x-www-form-urlencoded")
				.addHeader("Authorization", "Basic " + authentication).addHeader("cache-control", "no-cache").build();

		try {
			Response response = client.newCall(request).execute();

			String responseBody = response.body().string();
			JSONObject responseJson = new JSONObject(responseBody);
			if (responseJson.has("access_token")) {
				Configuration.accessToken = responseJson.getString("access_token");
				return responseJson.getString("access_token");

			}
		} catch (IOException e) {
			new APIException("Something went wrong...Please try after sometime");
		}

		return StringUtils.EMPTY;

	}

	public void setAccessToken(String accessToken) {
		if (!StringUtils.isEmpty(accessToken)) {
			Configuration.accessToken = accessToken;

		}
	}

}
