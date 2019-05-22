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

public class ScoringController extends BaseController {
	// private static variables for the singleton pattern
	private static final Object syncObject = new Object();
	private static ScoringController instance = null;

	/**
	 * Singleton pattern implementation
	 * 
	 * @return The singleton instance of the ScoringController class
	 */
	public static ScoringController getInstance() {
		if (null == instance) {
			synchronized (syncObject) {
				if (null == instance) {
					instance = new ScoringController();
				}
			}
		}
		return instance;
	}

	private ScoringController() {

	}

	/**
	 * Returns all question senses required to compute the target sense.
	 * 
	 * @param targetSenseId Required parameter: Id of sense for which required
	 *                      inputs are returned.
	 * @param locale        Optional parameter: Optional query param locale used to
	 *                      localize question sense text.
	 * @return Returns the List<SenseDTO> response from the API call
	 */
	public List<SenseDTO> getRequiredQuestionSenses(final String targetSenseId, final String locale) throws Throwable {
		APICallBackCatcher<List<SenseDTO>> callback = new APICallBackCatcher<List<SenseDTO>>();

		getRequiredQuestionSensesAsync(targetSenseId, locale, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getRequiredQuestionSensesRetry(targetSenseId, locale);
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private List<SenseDTO> getRequiredQuestionSensesRetry(final String targetSenseId, final String locale)
			throws Throwable {
		APICallBackCatcher<List<SenseDTO>> callback = new APICallBackCatcher<List<SenseDTO>>();
		getRequiredQuestionSensesAsync(targetSenseId, locale, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Returns all question senses required to compute the target sense.
	 * 
	 * @param targetSenseId Required parameter: Id of sense for which required
	 *                      inputs are returned.
	 * @param locale        Optional parameter: Optional query param locale used to
	 *                      localize question sense text.
	 * @return Returns the void response from the API call
	 */
	private void getRequiredQuestionSensesAsync(final String targetSenseId, final String locale,
			final APICallBack<List<SenseDTO>> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder("/Scoring/GetRequiredQuestionSenses/{targetSenseId}");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<String, Object>();
					_templateParameters.put("targetSenseId", targetSenseId);
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

					/// process query parameters
					Map<String, Object> _queryParameters = new HashMap<String, Object>();
					if (locale != null) {
						_queryParameters.put("locale", (locale != null) ? locale : "en-US");
					}
					APIHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);

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
							List<SenseDTO> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<SenseDTO>>() {
									});

							// let the caller know of the success
							callBack.onSuccess(_context, _result);
						} catch (Exception exception) {
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
	 * Returns all sleep problem senses which can be computed from the given input
	 * sense ids.
	 * 
	 * @param senseIds Optional parameter: List of ids for all input senses that
	 *                 would be provided.
	 * @return Returns the List<SenseDTO> response from the API call
	 */
	public List<SenseDTO> getComputableSleepProblemSenses(final List<String> senseIds) throws Throwable {
		APICallBackCatcher<List<SenseDTO>> callback = new APICallBackCatcher<List<SenseDTO>>();
		getComputableSleepProblemSensesAsync(senseIds, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getComputableSleepProblemSensesRetry(senseIds);
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private List<SenseDTO> getComputableSleepProblemSensesRetry(final List<String> senseIds) throws Throwable {
		APICallBackCatcher<List<SenseDTO>> callback = new APICallBackCatcher<List<SenseDTO>>();
		getComputableSleepProblemSensesAsync(senseIds, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Returns all sleep problem senses which can be computed from the given input
	 * sense ids.
	 * 
	 * @param senseIds Optional parameter: List of ids for all input senses that
	 *                 would be provided.
	 * @return Returns the void response from the API call
	 */
	private void getComputableSleepProblemSensesAsync(final List<String> senseIds,
			final APICallBack<List<SenseDTO>> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					// StringBuilder _queryBuilder = new
					// StringBuilder("/api/Scoring/GetComputableSleepProblemSenses");
					StringBuilder _queryBuilder = new StringBuilder("/Scoring/GetComputableSleepProblemSenses");

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("accept", "application/json");
					_headers.put("content-type", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(senseIds));

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
							List<SenseDTO> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<SenseDTO>>() {
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
	 * Returns all senses which can be computed from the given input sense ids.
	 * 
	 * @param senseIds Optional parameter: List of ids for all input senses that
	 *                 would be provided.
	 * @return Returns the List<SenseDTO> response from the API call
	 */
	public List<SenseDTO> getComputableSenses(final List<String> senseIds) throws Throwable {
		APICallBackCatcher<List<SenseDTO>> callback = new APICallBackCatcher<List<SenseDTO>>();
		getComputableSensesAsync(senseIds, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getComputableSensesRetry(senseIds);
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private List<SenseDTO> getComputableSensesRetry(final List<String> senseIds) throws Throwable {
		APICallBackCatcher<List<SenseDTO>> callback = new APICallBackCatcher<List<SenseDTO>>();
		getComputableSensesAsync(senseIds, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Returns all senses which can be computed from the given input sense ids.
	 * 
	 * @param senseIds Optional parameter: List of ids for all input senses that
	 *                 would be provided.
	 * @return Returns the void response from the API call
	 */
	private void getComputableSensesAsync(final List<String> senseIds, final APICallBack<List<SenseDTO>> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder("/Scoring/GetComputableSenses");

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("accept", "application/json");
					_headers.put("content-type", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(senseIds));

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
							List<SenseDTO> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<SenseDTO>>() {
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
	 * Returns metadata information about all computed senses. Computed senses are
	 * derived from other senses and should not be asked directly to an end-user.
	 * 
	 * @return Returns the List<SenseDTO> response from the API call
	 */
	public List<SenseDTO> getComputedSenses() throws Throwable {
		APICallBackCatcher<List<SenseDTO>> callback = new APICallBackCatcher<List<SenseDTO>>();
		getComputedSensesAsync(callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getComputedSensesRetry();
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private List<SenseDTO> getComputedSensesRetry() throws Throwable {
		APICallBackCatcher<List<SenseDTO>> callback = new APICallBackCatcher<List<SenseDTO>>();
		getComputedSensesAsync(callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Returns metadata information about all computed senses. Computed senses are
	 * derived from other senses and should not be asked directly to an end-user.
	 * 
	 * @return Returns the void response from the API call
	 */
	private void getComputedSensesAsync(final APICallBack<List<SenseDTO>> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder("/Scoring/GetComputedSenses");

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
							List<SenseDTO> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<SenseDTO>>() {
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
	 * Returns metadata information about all sleep problem senses.
	 * 
	 * @return Returns the List<SenseDTO> response from the API call
	 */
	public List<SenseDTO> getSleepProblemSenses() throws Throwable {
		APICallBackCatcher<List<SenseDTO>> callback = new APICallBackCatcher<List<SenseDTO>>();
		getSleepProblemSensesAsync(callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getSleepProblemSensesRetry();
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private List<SenseDTO> getSleepProblemSensesRetry() throws Throwable {
		APICallBackCatcher<List<SenseDTO>> callback = new APICallBackCatcher<List<SenseDTO>>();
		getSleepProblemSensesAsync(callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Returns metadata information about all sleep problem senses.
	 * 
	 * @return Returns the void response from the API call
	 */
	private void getSleepProblemSensesAsync(final APICallBack<List<SenseDTO>> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder("/Scoring/GetSleepProblemSenses");

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
							List<SenseDTO> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<SenseDTO>>() {
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
	 * Returns metadata information about all question senses. Question senses are
	 * simple value senses which can be asked to an end-user in the form of a question.
	 * 
	 * @param locale Optional parameter: Optional query param locale used to
	 *               localize question sense text.
	 * @return Returns the List<SenseDTO> response from the API call
	 */
	public List<SenseDTO> getQuestionSenses(final String locale) throws Throwable {
		APICallBackCatcher<List<SenseDTO>> callback = new APICallBackCatcher<List<SenseDTO>>();
		getQuestionSensesAsync(locale, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getQuestionSensesRetry(locale);
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private List<SenseDTO> getQuestionSensesRetry(final String locale) throws Throwable {
		APICallBackCatcher<List<SenseDTO>> callback = new APICallBackCatcher<List<SenseDTO>>();
		getQuestionSensesAsync(locale, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Returns metadata information about all question senses. Question senses are
	 * simple value senses which can be asked to an end-user in the form of a question.
	 * 
	 * @param locale Optional parameter: Optional query param locale used to
	 *               localize question sense text.
	 * @return Returns the void response from the API call
	 */
	private void getQuestionSensesAsync(final String locale, final APICallBack<List<SenseDTO>> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder("/Scoring/GetQuestionSenses");

					/// process query parameters
					Map<String, Object> _queryParameters = new HashMap<String, Object>();
					if (locale != null) {
						_queryParameters.put("locale", (locale != null) ? locale : "en-US");
					}
					APIHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);

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
							List<SenseDTO> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<SenseDTO>>() {
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
	 * Returns metadata information about all available senses.
	 * 
	 * @param locale Optional parameter: Optional query param locale used to
	 *               localize question sense text.
	 * @return Returns the List<SenseDTO> response from the API call
	 */
	public List<SenseDTO> getAllSenses(final String locale) throws Throwable {
		APICallBackCatcher<List<SenseDTO>> callback = new APICallBackCatcher<List<SenseDTO>>();
		getAllSensesAsync(locale, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getAllSensesRetry(locale);
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private List<SenseDTO> getAllSensesRetry(final String locale) throws Throwable {
		APICallBackCatcher<List<SenseDTO>> callback = new APICallBackCatcher<List<SenseDTO>>();
		getAllSensesAsync(locale, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Returns metadata information about all available senses.
	 * 
	 * @param locale      Optional parameter: Optional query param locale used to
	 *                    localize question sense text.
	 * @return Returns the void response from the API call
	 */
	private void getAllSensesAsync(final String locale, final APICallBack<List<SenseDTO>> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder("/Scoring/GetAllSenses");

					/// process query parameters
					Map<String, Object> _queryParameters = new HashMap<String, Object>();
					if (locale != null) {
						_queryParameters.put("locale", (locale != null) ? locale : "en-US");
					}
					APIHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);

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
							List<SenseDTO> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<SenseDTO>>() {
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
	 * Returns metadata information about a single sense.
	 * 
	 * @param senseId Required parameter: The id of the sense.
	 * @param locale  Optional parameter: Optional query param locale used to
	 *                localize question sense text.
	 * @return Returns the SenseDTO response from the API call
	 */
	public SenseDTO getSense(final String senseId, final String locale) throws Throwable {
		APICallBackCatcher<SenseDTO> callback = new APICallBackCatcher<SenseDTO>();
		getSenseAsync(senseId, locale, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getSenseRetry(senseId, locale);
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private SenseDTO getSenseRetry(final String senseId, final String locale) throws Throwable {
		APICallBackCatcher<SenseDTO> callback = new APICallBackCatcher<SenseDTO>();
		getSenseAsync(senseId, locale, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Returns metadata information about a single sense.
	 * 
	 * @param senseId Required parameter: The id of the sense.
	 * @param locale  Optional parameter: Optional query param locale used to
	 *                localize question sense text.
	 * @return Returns the void response from the API call
	 */
	private void getSenseAsync(final String senseId, final String locale, final APICallBack<SenseDTO> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder("/Scoring/GetSense/{senseId}");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<String, Object>();
					_templateParameters.put("senseId", senseId);
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

					/// process query parameters
					Map<String, Object> _queryParameters = new HashMap<String, Object>();
					if (locale != null) {
						_queryParameters.put("locale", (locale != null) ? locale : "en-US");
					}
					APIHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);

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
							SenseDTO _result = APIHelper.deserialize(_responseBody, new TypeReference<SenseDTO>() {
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
	 * Computes the values of all possible intermediate and sleep problem senses
	 * based on the provided input values.
	 * 
	 * @param inputValues Optional parameter: Map of sense input values, keyed by
	 *                    sense id.
	 * @return Returns the LinkedHashMap<String, Object> response from the API call
	 */
	public LinkedHashMap<String, Object> computeIntermediateAndSleepProblemSenses(final Object inputValues)
			throws Throwable {
		APICallBackCatcher<LinkedHashMap<String, Object>> callback = new APICallBackCatcher<LinkedHashMap<String, Object>>();
		computeIntermediateAndSleepProblemSensesAsync(inputValues, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return computeIntermediateAndSleepProblemSensesRetry(inputValues);
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private LinkedHashMap<String, Object> computeIntermediateAndSleepProblemSensesRetry(final Object inputValues)
			throws Throwable {
		APICallBackCatcher<LinkedHashMap<String, Object>> callback = new APICallBackCatcher<LinkedHashMap<String, Object>>();
		computeIntermediateAndSleepProblemSensesAsync(inputValues, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Computes the values of all possible intermediate and sleep problem senses
	 * based on the provided input values.
	 * 
	 * @param inputValues Optional parameter: Map of sense input values, keyed by
	 *                    sense id.
	 * @return Returns the void response from the API call
	 */
	private void computeIntermediateAndSleepProblemSensesAsync(final Object inputValues,
			final APICallBack<LinkedHashMap<String, Object>> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(
							"/Scoring/ComputeIntermediateAndSleepProblemSenses");

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("accept", "application/json");
					_headers.put("content-type", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(inputValues));

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
							DynamicResponse _result = new DynamicResponse(_response);

							callBack.onSuccess(_context, (LinkedHashMap<String, Object>) _result.parseAsDictionary());
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
	 * Computes the values of all possible sleep problem senses based on the
	 * provided input values.
	 * 
	 * @param inputValues Optional parameter: Map of sense input values, keyed by
	 *                    sense id.
	 * @return Returns the LinkedHashMap<String, Object> response from the API call
	 */
	public LinkedHashMap<String, Object> computeSleepProblemSenses(final Object inputValues) throws Throwable {
		APICallBackCatcher<LinkedHashMap<String, Object>> callback = new APICallBackCatcher<LinkedHashMap<String, Object>>();
		computeSleepProblemSensesAsync(inputValues, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return computeSleepProblemSensesRetry(inputValues);
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private LinkedHashMap<String, Object> computeSleepProblemSensesRetry(final Object inputValues) throws Throwable {
		APICallBackCatcher<LinkedHashMap<String, Object>> callback = new APICallBackCatcher<LinkedHashMap<String, Object>>();
		computeSleepProblemSensesAsync(inputValues, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Computes the values of all possible sleep problem senses based on the
	 * provided input values.
	 * 
	 * @param inputValues Optional parameter: Map of sense input values, keyed by
	 *                    sense id.
	 * @return Returns the void response from the API call
	 */
	private void computeSleepProblemSensesAsync(final Object inputValues,
			final APICallBack<LinkedHashMap<String, Object>> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder("/Scoring/ComputeSleepProblemSenses");

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("accept", "application/json");
					_headers.put("content-type", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(inputValues));

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
							DynamicResponse _result = new DynamicResponse(_response);

							callBack.onSuccess(_context, (LinkedHashMap<String, Object>) _result.parseAsDictionary());
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
	 * Computes the value of a single sense based on the provided input values.
	 * 
	 * @param senseId     Required parameter: Id of the sense to compute.
	 * @param inputValues Optional parameter: Map of sense input values, keyed by
	 *                    sense id.
	 * @return Returns the LinkedHashMap<String, Object> response from the API call
	 */
	public LinkedHashMap<String, Object> computeSense(final String senseId, final Object inputValues) throws Throwable {
		APICallBackCatcher<LinkedHashMap<String, Object>> callback = new APICallBackCatcher<LinkedHashMap<String, Object>>();
		computeSenseAsync(senseId, inputValues, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return computeSenseRetry(senseId, inputValues);
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private LinkedHashMap<String, Object> computeSenseRetry(final String senseId, final Object inputValues)
			throws Throwable {
		APICallBackCatcher<LinkedHashMap<String, Object>> callback = new APICallBackCatcher<LinkedHashMap<String, Object>>();
		computeSenseAsync(senseId, inputValues, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Computes the value of a single sense based on the provided input values.
	 * 
	 * @param senseId     Required parameter: Id of the sense to compute.
	 * @param inputValues Optional parameter: Map of sense input values, keyed by
	 *                    sense id.
	 * @return Returns the void response from the API call
	 */
	private void computeSenseAsync(final String senseId, final Object inputValues,
			final APICallBack<LinkedHashMap<String, Object>> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder("/Scoring/ComputeSense/{senseId}");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<String, Object>();
					_templateParameters.put("senseId", senseId);
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("accept", "application/json");
					_headers.put("content-type", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(inputValues));

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
						DynamicResponse _result = null;

						try {

							// invoke the callback after response if its not null
							if (getHttpCallBack() != null) {
								getHttpCallBack().OnAfterResponse(_context);
							}

							// handle errors defined at the API level
							validateResponse(_response, _context);

							// extract result from the http response
							_result = new DynamicResponse(_response);

							callBack.onSuccess(_context, (LinkedHashMap<String, Object>) _result.parseAsDictionary());
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
	 * Computes the values of all possible senses based on the provided input
	 * values.
	 * 
	 * @param inputValues Optional parameter: Map of sense input values, keyed by
	 *                    sense id.
	 * @return Returns the LinkedHashMap<String, Object> response from the API call
	 */
	public LinkedHashMap<String, Object> computeAllSenses(final Object inputValues) throws Throwable {
		APICallBackCatcher<LinkedHashMap<String, Object>> callback = new APICallBackCatcher<LinkedHashMap<String, Object>>();
		computeAllSensesAsync(inputValues, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return computeAllSensesRetry(inputValues);
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private LinkedHashMap<String, Object> computeAllSensesRetry(final Object inputValues) throws Throwable {
		APICallBackCatcher<LinkedHashMap<String, Object>> callback = new APICallBackCatcher<LinkedHashMap<String, Object>>();
		computeAllSensesAsync(inputValues, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Computes the values of all possible senses based on the provided input
	 * values.
	 * 
	 * @param inputValues Optional parameter: Map of sense input values, keyed by
	 *                    sense id.
	 * @return Returns the void response from the API call
	 */
	private void computeAllSensesAsync(final Object inputValues,
			final APICallBack<LinkedHashMap<String, Object>> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder("/Scoring/ComputeAllSenses");

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("accept", "application/json");
					_headers.put("content-type", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(inputValues));

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
							DynamicResponse _result = new DynamicResponse(_response);

							callBack.onSuccess(_context, (LinkedHashMap<String, Object>) _result.parseAsDictionary());
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
