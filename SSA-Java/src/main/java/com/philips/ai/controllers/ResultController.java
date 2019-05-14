package com.philips.ai.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.philips.ai.APIHelper;
import com.philips.ai.Configuration;
import com.philips.ai.controllers.syncwrapper.APICallBackCatcher;
import com.philips.ai.http.client.APICallBack;
import com.philips.ai.http.client.HttpContext;
import com.philips.ai.http.request.HttpRequest;
import com.philips.ai.http.response.HttpResponse;
import com.philips.ai.http.response.HttpStringResponse;
import com.philips.ai.models.ConditionResult;
import com.philips.ai.models.ResultDTO;
import com.philips.ai.models.TipResult;
import com.philips.ai.models.UpdateConditionFeedbackRequestDTO;
import com.philips.ai.models.UpdateTipFeedbackRequestDTO;

public class ResultController extends BaseController {
	// private static variables for the singleton pattern
	private static final Object syncObject = new Object();
	private static ResultController instance = null;
	private static final String RESULT_URI = "/Result";

	/**
	 * Singleton pattern implementation
	 * 
	 * @return The singleton instance of the ResultController class
	 */
	public static ResultController getInstance() {
		if (null == instance) {
			synchronized (syncObject) {
				if (null == instance) {
					instance = new ResultController();
				}
			}
		}
		return instance;
	}

	/**
	 * Computes and returns all tips that would be associated with the given
	 * condition, based on the given input values.
	 * 
	 * @param conditionId Optional parameter: The id of the sleep problem.
	 * @param inputValues Optional parameter: The sense input values.
	 * @return Returns the List<TipResult> response from the API call
	 */
	private List<TipResult> getTipsByConditionAndInputValues(final String conditionId, final Object inputValues)
			throws Throwable {
		APICallBackCatcher<List<TipResult>> callback = new APICallBackCatcher<List<TipResult>>();
		getTipsByConditionAndInputValuesAsync(conditionId, inputValues, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getTipsByConditionAndInputValuesRetry(conditionId, inputValues);
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private List<TipResult> getTipsByConditionAndInputValuesRetry(final String conditionId, final Object inputValues)
			throws Throwable {
		APICallBackCatcher<List<TipResult>> callback = new APICallBackCatcher<List<TipResult>>();
		getTipsByConditionAndInputValuesAsync(conditionId, inputValues, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Computes and returns all tips that would be associated with the given
	 * condition, based on the given input values.
	 * 
	 * @param conditionId Optional parameter: The id of the sleep problem.
	 * @param inputValues Optional parameter: The sense input values.
	 * @return Returns the void response from the API call
	 */
	private void getTipsByConditionAndInputValuesAsync(final String conditionId, final Object inputValues,
			final APICallBack<List<TipResult>> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(RESULT_URI + "/GetTipsByConditionAndInputValues");

					/// process query parameters
					Map<String, Object> _queryParameters = new HashMap<String, Object>();
					if (conditionId != null) {
						_queryParameters.put("conditionId", conditionId);
					}
					APIHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);

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
							String _responseBody = ((HttpStringResponse) _response).getBody();
							List<TipResult> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<TipResult>>() {
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
	 * Computes and returns the ids of all tips that would be associated with the
	 * given condition, based on the given input values.
	 * 
	 * @param conditionId Required parameter: The id of the sleep problem.
	 * @param inputValues Optional parameter: The sense input values.
	 * @return Returns the List<String> response from the API call
	 */
	private List<String> getTipIdsByConditionAndInputValues(final String conditionId, final Object inputValues)
			throws Throwable {
		APICallBackCatcher<List<String>> callback = new APICallBackCatcher<List<String>>();
		getTipIdsByConditionAndInputValuesAsync(conditionId, inputValues, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated"))	 {
				return getTipIdsByConditionAndInputValuesRetry(conditionId, inputValues);
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private List<String> getTipIdsByConditionAndInputValuesRetry(final String conditionId, final Object inputValues)
			throws Throwable {
		APICallBackCatcher<List<String>> callback = new APICallBackCatcher<List<String>>();
		getTipIdsByConditionAndInputValuesAsync(conditionId, inputValues, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Computes and returns the ids of all tips that would be associated with the
	 * given condition, based on the given input values.
	 * 
	 * @param conditionId Required parameter: The id of the sleep problem.
	 * @param inputValues Optional parameter: The sense input values.
	 * @return Returns the void response from the API call
	 */
	private void getTipIdsByConditionAndInputValuesAsync(final String conditionId, final Object inputValues,
			final APICallBack<List<String>> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(
							RESULT_URI + "/GetTipIdsByConditionAndInputValues/{conditionId}");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<String, Object>();
					_templateParameters.put("conditionId", conditionId);
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

						try {

							// invoke the callback after response if its not null
							if (getHttpCallBack() != null) {
								getHttpCallBack().OnAfterResponse(_context);
							}

							// handle errors defined at the API level
							validateResponse(_response, _context);

							// extract result from the http response
							String _responseBody = ((HttpStringResponse) _response).getBody();
							List<String> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<String>>() {
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
	 * Returns the ids of all tidbits that could be associated with the given
	 * condition.
	 * 
	 * @param conditionId Required parameter: The id of the condition.
	 * @return Returns the List<String> response from the API call
	 */
	private List<String> getTidbitIdsByCondition(final String conditionId) throws Throwable {
		APICallBackCatcher<List<String>> callback = new APICallBackCatcher<List<String>>();
		getTidbitIdsByConditionAsync(conditionId, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getTidbitIdsByConditionRetry(conditionId);
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private List<String> getTidbitIdsByConditionRetry(final String conditionId) throws Throwable {
		APICallBackCatcher<List<String>> callback = new APICallBackCatcher<List<String>>();
		getTidbitIdsByConditionAsync(conditionId, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Returns the ids of all tidbits that could be associated with the given
	 * condition.
	 * 
	 * @param conditionId Required parameter: The id of the condition.
	 * @return Returns the void response from the API call
	 */
	private void getTidbitIdsByConditionAsync(final String conditionId, final APICallBack<List<String>> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(
							RESULT_URI + "/GetTidbitIdsByCondition/{conditionId}");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<String, Object>();
					_templateParameters.put("conditionId", conditionId);
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("accept", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().post(_queryUrl, _headers, null);

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
							List<String> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<String>>() {
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
	 * Returns the ids of all tips that could be associated with the given
	 * condition.
	 * 
	 * @param conditionId Required parameter: The id of the condition.
	 * @return Returns the List<String> response from the API call
	 */
	private List<String> getTipIdsByCondition(final String conditionId) throws Throwable {
		APICallBackCatcher<List<String>> callback = new APICallBackCatcher<List<String>>();
		getTipIdsByConditionAsync(conditionId, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getTipIdsByConditionRetry(conditionId);
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private List<String> getTipIdsByConditionRetry(final String conditionId) throws Throwable {
		APICallBackCatcher<List<String>> callback = new APICallBackCatcher<List<String>>();
		getTipIdsByConditionAsync(conditionId, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Returns the ids of all tips that could be associated with the given
	 * condition.
	 * 
	 * @param conditionId Required parameter: The id of the condition.
	 * @return Returns the void response from the API call
	 */
	private void getTipIdsByConditionAsync(final String conditionId, final APICallBack<List<String>> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(RESULT_URI + "/GetTipIdsByCondition/{conditionId}");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<String, Object>();
					_templateParameters.put("conditionId", conditionId);
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("accept", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().post(_queryUrl, _headers, null);

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
							List<String> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<String>>() {
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
	 * Returns metadata information about an single condition.
	 * 
	 * @param conditionId Required parameter: The id of the condition.
	 * @return Returns the ConditionResult response from the API call
	 */
	public ConditionResult getCondition(final String conditionId) throws Throwable {
		APICallBackCatcher<ConditionResult> callback = new APICallBackCatcher<ConditionResult>();
		getConditionAsync(conditionId, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getConditionRetry(conditionId);
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private ConditionResult getConditionRetry(final String conditionId) throws Throwable {
		APICallBackCatcher<ConditionResult> callback = new APICallBackCatcher<ConditionResult>();
		getConditionAsync(conditionId, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Returns metadata information about an single condition.
	 * 
	 * @param conditionId Required parameter: The id of the condition.
	 * @return Returns the void response from the API call
	 */
	private void getConditionAsync(final String conditionId, final APICallBack<ConditionResult> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(RESULT_URI + "/GetCondition/{conditionId}");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<String, Object>();
					_templateParameters.put("conditionId", conditionId);
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("accept", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().post(_queryUrl, _headers, null);

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
							ConditionResult _result = APIHelper.deserialize(_responseBody,
									new TypeReference<ConditionResult>() {
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
	 * Submits feedback for the session on the indicated tip.
	 * 
	 * @param requestDTO Optional parameter: The request object.
	 * @return Returns the void response from the API call
	 */
	private void submitTipFeedback(final UpdateTipFeedbackRequestDTO requestDTO) throws Throwable {
		APICallBackCatcher<Object> callback = new APICallBackCatcher<Object>();
		submitTipFeedbackAsync(requestDTO, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				submitTipFeedbackRetry(requestDTO);
			} else
				throw callback.getError();
		}
		callback.getResult();
	}

	private void submitTipFeedbackRetry(final UpdateTipFeedbackRequestDTO requestDTO) throws Throwable {
		APICallBackCatcher<Object> callback = new APICallBackCatcher<Object>();
		submitTipFeedbackAsync(requestDTO, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		callback.getResult();
	}

	/**
	 * Submits feedback for the session on the indicated tip.
	 * 
	 * @param requestDTO Optional parameter: The request object.
	 * @return Returns the void response from the API call
	 */
	private void submitTipFeedbackAsync(final UpdateTipFeedbackRequestDTO requestDTO,
			final APICallBack<Object> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(RESULT_URI + "/Feedback/SubmitTipFeedback");

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("content-type", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(requestDTO));

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
	 * Returns metadata information about all available conditions.
	 * 
	 * @return Returns the List<ConditionResult> response from the API call
	 */
	public List<ConditionResult> getAllConditions() throws Throwable {
		APICallBackCatcher<List<ConditionResult>> callback = new APICallBackCatcher<List<ConditionResult>>();
		getAllConditionsAsync(callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getAllConditionsRetry();
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private List<ConditionResult> getAllConditionsRetry() throws Throwable {
		APICallBackCatcher<List<ConditionResult>> callback = new APICallBackCatcher<List<ConditionResult>>();
		getAllConditionsAsync(callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		return callback.getResult();
	}

	/**
	 * Returns metadata information about all available conditions.
	 * 
	 * @return Returns the void response from the API call
	 */
	private void getAllConditionsAsync(final APICallBack<List<ConditionResult>> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(RESULT_URI + "/GetAllConditions");

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
							List<ConditionResult> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<ConditionResult>>() {
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
	 * Submits feedback for the session on the indicated condition.
	 * 
	 * @param requestDTO Optional parameter: The request object.
	 * @return Returns the void response from the API call
	 */
	private void submitConditionFeedback(final UpdateConditionFeedbackRequestDTO requestDTO) throws Throwable {
		APICallBackCatcher<Object> callback = new APICallBackCatcher<Object>();
		submitConditionFeedbackAsync(requestDTO, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				submitConditionFeedbackRetry(requestDTO);
			} else
				throw callback.getError();
		}
		callback.getResult();
	}

	private void submitConditionFeedbackRetry(final UpdateConditionFeedbackRequestDTO requestDTO) throws Throwable {
		APICallBackCatcher<Object> callback = new APICallBackCatcher<Object>();
		submitConditionFeedbackAsync(requestDTO, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		callback.getResult();
	}

	/**
	 * Submits feedback for the session on the indicated condition.
	 * 
	 * @param requestDTO Optional parameter: The request object.
	 * @return Returns the void response from the API call
	 */
	private void submitConditionFeedbackAsync(final UpdateConditionFeedbackRequestDTO requestDTO,
			final APICallBack<Object> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(RESULT_URI + "/Feedback/SubmitConditionFeedback");

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("content-type", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(requestDTO));

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
	 * Computes Results output for the given survey.
	 * 
	 * @param surveyIdentifier Required parameter: The identifier of the survey.
	 * @return Returns the ResultDTO response from the API call
	 */

	public ResultDTO getComputeResult(final String surveyIdentifier, final String sessionId) throws Throwable {
		APICallBackCatcher<ResultDTO> callback = new APICallBackCatcher<ResultDTO>();
		getComputeResultAsync(surveyIdentifier, sessionId, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getComputeResultRetry(surveyIdentifier, sessionId);
			} else
			throw callback.getError();
		}
		ResultDTO result = callback.getResult();
		result.setSessionId((String) callback.getExtraData().get("auth_token"));
		return result;
	}

	private ResultDTO getComputeResultRetry(final String surveyIdentifier, final String sessionId) throws Throwable {
		APICallBackCatcher<ResultDTO> callback = new APICallBackCatcher<ResultDTO>();
		getComputeResultAsync(surveyIdentifier, sessionId, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		ResultDTO result = callback.getResult();
		result.setSessionId((String) callback.getExtraData().get("auth_token"));
		return result;
	}

	/**
	 * Computes Results output for the given survey.
	 * 
	 * @param surveyIdentifier Required parameter: The identifier of the survey.
	 * @return Returns the void response from the API call
	 */
	private void getComputeResultAsync(final String surveyIdentifier, final String sessionId, final APICallBack<ResultDTO> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(RESULT_URI + "/{surveyIdentifier}/ComputeResult");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<String, Object>();
					_templateParameters.put("surveyIdentifier", surveyIdentifier);
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("accept", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);
					
					if (sessionId != null) {
						_headers.put("auth_token", sessionId);
					}

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
							
							// Extract the auth token response header and store it in the callback
							((APICallBackCatcher<?>) callBack).getExtraData().put("auth_token", _response.getHeaders().get("auth_token"));

							// extract result from the http response
							String _responseBody = ((HttpStringResponse) _response).getBody();
							ResultDTO _result = APIHelper.deserialize(_responseBody, new TypeReference<ResultDTO>() {
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
