package com.philips.ai;

import com.philips.ai.controllers.*;
import com.philips.ai.http.client.HttpClient;

public class SmartSleepAnalyzerClient {

	private String clientId;
	private String clientSecret;
	private String accessToken;

	/**
	 * Singleton access to Scoring controller
	 * 
	 * @return Returns the ScoringController instance
	 */
	public ScoringController getScoring() {
		return ScoringController.getInstance();
	}

	/**
	 * Singleton access to Result controller
	 * 
	 * @return Returns the ResultController instance
	 */
	public ResultController getResult() {
		return ResultController.getInstance();
	}

	/**
	 * Singleton access to Session controller
	 * 
	 * @return Returns the SessionController instance
	 */
	public SessionController getSession() {
		return SessionController.getInstance();
	}

	/**
	 * Singleton access to Survey controller
	 * 
	 * @return Returns the SurveyController instance
	 */
	public SurveyController getSurvey() {
		return SurveyController.getInstance();
	}

	/**
	 * Get the shared http client currently being used for API calls
	 * 
	 * @return The http client instance currently being used
	 */
	public HttpClient getSharedHttpClient() {
		return BaseController.getClientInstance();
	}

	/**
	 * Set a shared http client to be used for API calls
	 * 
	 * @param httpClient The http client to use
	 */
	public void setSharedHttpClient(HttpClient httpClient) {
		BaseController.setClientInstance(httpClient);
	}

	/**
	 * Singleton access to Access Controller
	 */
	public AccessController getAccess() {
		return AccessController.getInstance();
	}

	public SmartSleepAnalyzerClient(String clientId, String clientSecret) {
		super();
		this.setClientId(clientId);
		this.setClientSecret(clientSecret);
		Configuration.clientId = clientId;
		Configuration.clientSecret = clientSecret;
		getAccess().getAccessToken(clientId, clientSecret);
		accessToken = Configuration.accessToken;

	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	
	public String geAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
