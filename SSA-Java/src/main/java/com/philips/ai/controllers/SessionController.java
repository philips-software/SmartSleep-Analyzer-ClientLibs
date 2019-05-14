package com.philips.ai.controllers;

import java.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.philips.ai.*;
import com.philips.ai.controllers.syncwrapper.APICallBackCatcher;
import com.philips.ai.http.client.APICallBack;
import com.philips.ai.http.client.HttpContext;
import com.philips.ai.http.request.HttpRequest;
import com.philips.ai.http.response.HttpResponse;
import com.philips.ai.http.response.HttpStringResponse;
import com.philips.ai.models.*;

/*package com.philips.ai.controllers;

import java.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.philips.ai.*;
import com.philips.ai.controllers.syncwrapper.APICallBackCatcher;
import com.philips.ai.http.client.APICallBack;
import com.philips.ai.http.client.HttpContext;
import com.philips.ai.http.request.HttpRequest;
import com.philips.ai.http.response.HttpResponse;
import com.philips.ai.http.response.HttpStringResponse;
import com.philips.ai.models.*;*/

public class SessionController extends BaseController {
	// private static variables for the singleton pattern
	private static final Object syncObject = new Object();
	private static SessionController instance = null;
	private static final String USER_URI = "/User";

	/**
	 * Singleton pattern implementation
	 * 
	 * @return The singleton instance of the SessionController class
	 */
	public static SessionController getInstance() {
		if (null == instance) {
			synchronized (syncObject) {
				if (null == instance) {
					instance = new SessionController();
				}
			}
		}
		return instance;
	}

	/**
	 * Activates a session.
	 * 
	 * @param sessionDTO Optional parameter: Object containing the session's credentials.
	 * @return Returns the SessionDTO response from the API call
	 */
	private SessionDTO loginUser(final SessionDTO sessionDTO) throws Throwable {
		APICallBackCatcher<SessionDTO> callback = new APICallBackCatcher<SessionDTO>();
		loginAsync(sessionDTO, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return loginUserRetry(sessionDTO);
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private SessionDTO loginUserRetry(final SessionDTO sessionDTO) throws Throwable {
		APICallBackCatcher<SessionDTO> callback = new APICallBackCatcher<SessionDTO>();
		loginAsync(sessionDTO, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Activates a session.
	 * 
	 * @param sessionDTO Optional parameter: Object containing the session's credentials.
	 * @return Returns the void response from the API call
	 */
	private void loginAsync(final SessionDTO sessionDTO, final APICallBack<SessionDTO> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(USER_URI + "/LoginUser");

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("accept", "application/json");
					_headers.put("content-type", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(sessionDTO));

					// invoke the callback before request if its not null
					if (getHttpCallBack() != null) {
						getHttpCallBack().OnBeforeRequest(_request);
					}

				} catch (Throwable e) {
					callBack.onFailure(null, e);
					return;
				}

				// invoke request and get response
				getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
					public void onSuccess(HttpContext _context, HttpResponse _response) {

						try {

							// invoke the callback after response if its not null
							if (getHttpCallBack() != null) {
								getHttpCallBack().OnAfterResponse(_context);
							}

							// handle errors defined at the API level
							validateResponse(_response, _context);

							// extract result from the http response
							String _responseBody = ((HttpStringResponse) _response).getBody();
							SessionDTO _result = APIHelper.deserialize(_responseBody, new TypeReference<SessionDTO>() {
							});

							// let the caller know of the success
							callBack.onSuccess(_context, _result);
						} catch (Exception exception) {
							// let the caller know of the caught Exception
							callBack.onFailure(_context, exception);
						}
					}

					public void onFailure(HttpContext _context, Throwable _error) {
						// invoke the callback after response if its not null
						if (getHttpCallBack() != null) {
							getHttpCallBack().OnAfterResponse(_context);
						}

						// let the caller know of the failure
						callBack.onFailure(_context, _error);
					}
				});
			}
		};

		// execute async using thread pool
		APIHelper.getScheduler().execute(_responseTask);
	}

	/**
	 * Retrieves the details of the activated session.
	 * 
	 * @return Returns the SessionDTO response from the API call
	 */
	private SessionDTO retrieveLoggedInUser() throws Throwable {
		APICallBackCatcher<SessionDTO> callback = new APICallBackCatcher<SessionDTO>();
		retrieveAsync(callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return retrieveLoggedInUserRetry();
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private SessionDTO retrieveLoggedInUserRetry() throws Throwable {
		APICallBackCatcher<SessionDTO> callback = new APICallBackCatcher<SessionDTO>();
		retrieveAsync(callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Retrieves the details of the activated session.
	 * 
	 * @return Returns the void response from the API call
	 */
	private void retrieveAsync(final APICallBack<SessionDTO> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(USER_URI + "/RetrieveLoggedInUser");

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("accept", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().get(_queryUrl, _headers, null);

					// invoke the callback before request if its not null
					if (getHttpCallBack() != null) {
						getHttpCallBack().OnBeforeRequest(_request);
					}

				} catch (Throwable e) {
					callBack.onFailure(null, e);
					return;
				}

				// invoke request and get response
				getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
					public void onSuccess(HttpContext _context, HttpResponse _response) {

						try {

							// invoke the callback after response if its not null
							if (getHttpCallBack() != null) {
								getHttpCallBack().OnAfterResponse(_context);
							}

							// handle errors defined at the API level
							validateResponse(_response, _context);

							// extract result from the http response
							String _responseBody = ((HttpStringResponse) _response).getBody();
							SessionDTO _result = APIHelper.deserialize(_responseBody, new TypeReference<SessionDTO>() {
							});

							// let the caller know of the success
							callBack.onSuccess(_context, _result);
						} catch (Exception exception) {
							// let the caller know of the caught Exception
							callBack.onFailure(_context, exception);
						}
					}

					public void onFailure(HttpContext _context, Throwable _error) {
						// invoke the callback after response if its not null
						if (getHttpCallBack() != null) {
							getHttpCallBack().OnAfterResponse(_context);
						}

						// let the caller know of the failure
						callBack.onFailure(_context, _error);
					}
				});
			}
		};

		// execute async using thread pool
		APIHelper.getScheduler().execute(_responseTask);
	}

	/**
	 * Deactivates the current session.
	 * 
	 * @return Returns the void response from the API call
	 */
	private void logoutUser() throws Throwable {
		APICallBackCatcher<Object> callback = new APICallBackCatcher<Object>();
		getLogoutAsync(callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				logoutUserRetry();
			} else
				throw callback.getError();
		}
		callback.getResult();
	}

	private void logoutUserRetry() throws Throwable {
		APICallBackCatcher<Object> callback = new APICallBackCatcher<Object>();
		getLogoutAsync(callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		callback.getResult();
	}

	/**
	 * Deactivates the current session.
	 * 
	 * @return Returns the void response from the API call
	 */
	private void getLogoutAsync(final APICallBack<Object> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(USER_URI + "/LogoutUser");

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().get(_queryUrl, _headers, null);

					// invoke the callback before request if its not null
					if (getHttpCallBack() != null) {
						getHttpCallBack().OnBeforeRequest(_request);
					}

				} catch (Throwable e) {
					callBack.onFailure(null, e);
					return;
				}

				// invoke request and get response
				getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
					public void onSuccess(HttpContext _context, HttpResponse _response) {

						try {

							// invoke the callback after response if its not null
							if (getHttpCallBack() != null) {
								getHttpCallBack().OnAfterResponse(_context);
							}

							// handle errors defined at the API level
							validateResponse(_response, _context);

							// let the caller know of the success
							callBack.onSuccess(_context, _context);
						} catch (Exception exception) {
							// let the caller know of the caught Exception
							callBack.onFailure(_context, exception);
						}
					}

					public void onFailure(HttpContext _context, Throwable _error) {
						// invoke the callback after response if its not null
						if (getHttpCallBack() != null) {
							getHttpCallBack().OnAfterResponse(_context);
						}

						// let the caller know of the failure
						callBack.onFailure(_context, _error);
					}
				});
			}
		};

		// execute async using thread pool
		APIHelper.getScheduler().execute(_responseTask);
	}

	/**
	 * Creates a new session with the provided information.
	 * 
	 * @param sessionDTO Optional parameter: The provided information.
	 * @return Returns the SessionDTO response from the API call
	 */
	private SessionDTO registerUser(final SessionDTO sessionDTO) throws Throwable {
		APICallBackCatcher<SessionDTO> callback = new APICallBackCatcher<SessionDTO>();
		registerUserAsync(sessionDTO, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return registerUserRetry(sessionDTO);
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private SessionDTO registerUserRetry(final SessionDTO sessionDTO) throws Throwable {
		APICallBackCatcher<SessionDTO> callback = new APICallBackCatcher<SessionDTO>();
		registerUserAsync(sessionDTO, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Creates a new session with the provided information.
	 * 
	 * @param sessionDTO Optional parameter: The provided information.
	 * @return Returns the void response from the API call
	 */
	private void registerUserAsync(final SessionDTO sessionDTO, final APICallBack<SessionDTO> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(USER_URI + "/RegisterUser");

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("accept", "application/json");
					_headers.put("content-type", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(sessionDTO));

					// invoke the callback before request if its not null
					if (getHttpCallBack() != null) {
						getHttpCallBack().OnBeforeRequest(_request);
					}

				} catch (Throwable e) {
					callBack.onFailure(null, e);
					return;
				}

				// invoke request and get response
				getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
					public void onSuccess(HttpContext _context, HttpResponse _response) {

						try {

							// invoke the callback after response if its not null
							if (getHttpCallBack() != null) {
								getHttpCallBack().OnAfterResponse(_context);
							}

							// handle errors defined at the API level
							validateResponse(_response, _context);

							// extract result from the http response
							String _responseBody = ((HttpStringResponse) _response).getBody();
							SessionDTO _result = APIHelper.deserialize(_responseBody, new TypeReference<SessionDTO>() {
							});

							// let the caller know of the success
							callBack.onSuccess(_context, _result);
						} catch (Exception exception) {
							// let the caller know of the caught Exception
							callBack.onFailure(_context, exception);
						}
					}

					public void onFailure(HttpContext _context, Throwable _error) {
						// invoke the callback after response if its not null
						if (getHttpCallBack() != null) {
							getHttpCallBack().OnAfterResponse(_context);
						}

						// let the caller know of the failure
						callBack.onFailure(_context, _error);
					}
				});
			}
		};

		// execute async using thread pool
		APIHelper.getScheduler().execute(_responseTask);
	}

}
