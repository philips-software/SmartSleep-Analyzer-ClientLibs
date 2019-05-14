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

@SuppressWarnings("Duplicates")
public class SurveyController extends BaseController {
	private static final Object syncObject = new Object();
	private static SurveyController instance = null;
	private static final String SURVEY_URI = "/Survey";

	/**
	 * Singleton pattern implementation
	 * 
	 * @return The singleton instance of the SurveyController class
	 */
	public static SurveyController getInstance() {
		if (null == instance) {
			synchronized (syncObject) {
				if (null == instance) {
					instance = new SurveyController();
				}
			}
		}
		return instance;
	}

	/**
	 * DEVELOPMENT ONLY: Returns all rules which were matched in the computation of
	 * the survey state. This API is only available in development
	 * environment. In all other environments it will result in a 404 (not found).
	 * 
	 * @param identifier Required parameter: The identifier of the survey.
	 * @return Returns the void response from the API call
	 */
	private void getMatchedRules(final String identifier) throws Throwable {
		APICallBackCatcher<Object> callback = new APICallBackCatcher<>();

		getMatchedRulesAsync(identifier, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				getMatchedRulesRetry(identifier);
			} else
				throw callback.getError();
		}
		callback.getResult();
	}

	private void getMatchedRulesRetry(final String identifier) throws Throwable {
		APICallBackCatcher<Object> callback = new APICallBackCatcher<Object>();
		getMatchedRulesAsync(identifier, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		callback.getResult();
	}

	/**
	 * DEVELOPMENT ONLY: Returns all rules which were matched in the computation of
	 * the survey state. This API is only available in development
	 * environment. In all other environments it will result in a 404 (not found).
	 * 
	 * @param identifier Required parameter: The identifier of the survey.
	 * @return Returns the void response from the API call
	 */
	private void getMatchedRulesAsync(final String identifier, final APICallBack<Object> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(SURVEY_URI + "/{identifier}/GetMatchedRules");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<String, Object>();
					_templateParameters.put("identifier", identifier);
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

					// validate and pre-process url
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
	 * Get the QuestionDTO for a given sense, and for the given survey.
	 * @param    identifier    Required parameter: The identifier of the survey.
	 * @param    senseId    Required parameter: The id of the sense we want a QuestionDTO for.
	 * @return    Returns the QuestionDTO response from the API call
	 */
	public QuestionDTO getSenseQuestion(
			final String identifier,
			final String senseId
	) throws Throwable {
		APICallBackCatcher<QuestionDTO> callback = new APICallBackCatcher<>();

		getSenseQuestionAsync(identifier, senseId, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getSenseQuestionRetry(identifier, senseId);
			} else
				throw callback.getError();
		}
		QuestionDTO result = callback.getResult();
		return result;
	}

	private QuestionDTO getSenseQuestionRetry(final String identifier, final String senseId) throws Throwable {
		APICallBackCatcher<QuestionDTO> callback = new APICallBackCatcher<>();

		getSenseQuestionAsync(identifier, senseId, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}

		return callback.getResult();
	}

	/**
	 * Get the QuestionDTO for a given sense, and for the given survey.
	 * @param    identifier    Required parameter: The identifier of the survey.
	 * @param    senseId    Required parameter: The id of the sense we want a QuestionDTO for.
	 * @return    Returns the QuestionDTO response from the API call
	 */
	private void getSenseQuestionAsync(final String identifier, final String senseId,
									 final APICallBack<QuestionDTO> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(SURVEY_URI + "/{identifier}/GetSenseQuestion/{senseId}");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<>();
					_templateParameters.put("identifier", identifier);
					_templateParameters.put("senseId", senseId);
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<>();
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
							QuestionDTO _result = APIHelper.deserialize(_responseBody,
									new TypeReference<QuestionDTO>() {
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
	 * Get a list of required QuestionDTO items for a given sense, and for the given survey.
	 * @param    identifier    Required parameter: The identifier of the survey.
	 * @param    senseId    Required parameter: The id of the sense we want a list of required QuestionDTO for.
	 * @return    Returns the List<QuestionDTO> response from the API call
	 */
	public List<QuestionDTO> getSenseRequiredQuestions(
			final String identifier,
			final String senseId
	) throws Throwable {
		APICallBackCatcher<List<QuestionDTO>> callback = new APICallBackCatcher<>();

		getSenseRequiredQuestionsAsync(identifier, senseId, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getSenseRequiredQuestionsRetry(identifier, senseId);
			} else
				throw callback.getError();
		}
		return callback.getResult();
	}

	private List<QuestionDTO> getSenseRequiredQuestionsRetry(final String identifier, final String senseId) throws Throwable {
		APICallBackCatcher<List<QuestionDTO>> callback = new APICallBackCatcher<>();

		getSenseRequiredQuestionsAsync(identifier, senseId, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}

		return callback.getResult();
	}

	/**
	 * Get a list of required QuestionDTO items for a given sense, and for the given survey.
	 * @param    identifier    Required parameter: The identifier of the survey.
	 * @param    senseId    Required parameter: The id of the sense we want a list of required QuestionDTO for.
	 * @return    Returns the List<QuestionDTO> response from the API call
	 */
	private void getSenseRequiredQuestionsAsync(final String identifier, final String senseId,
									   final APICallBack<List<QuestionDTO>> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(SURVEY_URI + "/{identifier}/GetSenseRequiredQuestions/{senseId}");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<>();
					_templateParameters.put("identifier", identifier);
					_templateParameters.put("senseId", senseId);
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<>();
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
							List<QuestionDTO> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<QuestionDTO>>() {
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
	 * Retrieves the current question set, per the current survey state, or per the given Step Id reference.
	 * Templates are also provided for immediately submitting via PostAnswers, or later submission via UpdateAnswers.
	 * @param    identifier    Required parameter: The identifier of the survey.
	 * @param    stepRef    Optional parameter: Optional Step Id we wish to query QuestionDTOs for. Defaults to the latest step, if unspecified.
	 * @param    sessionId  The session id for the survey (pass null to generate a new session id).
	 * @return    Returns the QuestionsDTO response from the API call
	 */
	public QuestionsDTO getQuestions(
			final String identifier,
			final String stepRef,
			final String sessionId
	) throws Throwable {
		APICallBackCatcher<QuestionsDTO> callback = new APICallBackCatcher<>();
		getQuestionsAsync(identifier, stepRef, sessionId, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getQuestionsRetry(identifier, stepRef, sessionId);
			} else
				throw callback.getError();
		}
		QuestionsDTO result = callback.getResult();
		result.setSessionId((String) callback.getExtraData().get("auth_token"));
		return result;
	}

	private QuestionsDTO getQuestionsRetry(final String identifier, final String stepRef, final String sessionId) throws Throwable {
		APICallBackCatcher<QuestionsDTO> callback = new APICallBackCatcher<>();
		getQuestionsAsync(identifier, stepRef, sessionId, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		QuestionsDTO result = callback.getResult();
		result.setSessionId((String) callback.getExtraData().get("auth_token"));
		return result;
	}

	/**
	 * Retrieves the current question set, per the current survey state, or per the given Step Id reference.
	 * Templates are also provided for immediately submitting via PostAnswers, or later submission via UpdateAnswers.
	 * @param    identifier    Required parameter: The identifier of the survey.
	 * @param    stepRef    Optional parameter: Optional Step Id we wish to query QuestionDTOs for. Defaults to the latest step, if unspecified.
	 * @param    sessionId  The session id for the survey (pass null to generate a new session id).
	 * @return    Returns the QuestionsDTO response from the API call
	 */
	private void getQuestionsAsync(final String identifier, final String stepRef, final String sessionId,
									 final APICallBack<QuestionsDTO> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(SURVEY_URI + "/{identifier}/GetQuestions");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<>();
					_templateParameters.put("identifier", identifier);
					if (stepRef != null) {
						_templateParameters.put("stepRef", stepRef);
					}
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<>();
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
							((APICallBackCatcher<?>) callBack).getExtraData().put("auth_token",
									_response.getHeaders().get("auth_token"));

							// extract result from the http response
							String _responseBody = ((HttpStringResponse) _response).getBody();
							QuestionsDTO _result = APIHelper.deserialize(_responseBody,
									new TypeReference<QuestionsDTO>() {
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
	 * Submits answers to the most recent, unanswered questions for the current survey session,
	 * and returns the next batch of unanswered survey questions if successful.
	 * @param    identifier    Required parameter: The identifier of the survey.
	 * @param    answers    Required parameter: The answers for the most recent, unanswered questions available in the survey.
	 * @param    sessionId    The session id for the survey (pass null to generate a new session id).
	 * @return    Returns the QuestionsDTO response from the API call
	 */
	public QuestionsDTO postAnswers(
			final String identifier,
			final LinkedHashMap<String, Object> answers,
			final String sessionId
	) throws Throwable {
		APICallBackCatcher<QuestionsDTO> callback = new APICallBackCatcher<>();

		postAnswersAsync(identifier, answers, sessionId, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return postAnswersRetry(identifier, answers, sessionId);
			} else
				throw callback.getError();
		}
		QuestionsDTO result = callback.getResult();
		result.setSessionId((String) callback.getExtraData().get("auth_token"));
		return result;
	}

	private QuestionsDTO postAnswersRetry(final String identifier, final LinkedHashMap<String, Object> answers,
										  final String sessionId) throws Throwable {
		APICallBackCatcher<QuestionsDTO> callback = new APICallBackCatcher<>();

		postAnswersAsync(identifier, answers, sessionId, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		QuestionsDTO result = callback.getResult();
		result.setSessionId((String) callback.getExtraData().get("auth_token"));
		return result;
	}

	/**
	 * Submits answers to the most recent, unanswered questions for the current survey session,
	 * and returns the next batch of unanswered survey questions if successful.
	 * @param    identifier    Required parameter: The identifier of the survey.
	 * @param    answers    Required parameter: The answers for the most recent, unanswered questions available in the survey.
	 * @param    sessionId    The session id for the survey (pass null to generate a new session id).
	 * @return    Returns the QuestionsDTO response from the API call
	 */
	private void postAnswersAsync(final String identifier, final LinkedHashMap<String, Object> answers,
								  final String sessionId, final APICallBack<QuestionsDTO> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(SURVEY_URI + "/{identifier}/PostAnswers");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<>();
					_templateParameters.put("identifier", identifier);
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<>();
					_headers.put("accept", "application/json");
					_headers.put("content-type", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					if (sessionId != null) {
						_headers.put("auth_token", sessionId);
					}

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().putBody(_queryUrl, _headers, APIHelper.serialize(answers));

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
							((APICallBackCatcher<?>) callBack).getExtraData().put("auth_token",
									_response.getHeaders().get("auth_token"));

							// extract result from the http response
							String _responseBody = ((HttpStringResponse) _response).getBody();
							QuestionsDTO _result = APIHelper.deserialize(_responseBody,
									new TypeReference<QuestionsDTO>() {
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
	 * Re-submits answers to a potentially existing set of questions, from a previous step, and returns the next batch
	 * of unanswered survey questions if successful. This endpoint gracefully handles first-time submissions as well,
	 * similar to the simpler PostAnswers endpoint.
	 * @param    identifier    Required parameter: The identifier of the survey.
	 * @param    updateSurveyStateRequestDTO    Required parameter: A DTO with the step ref, and answers to re-submit.
	 * @param    sessionId    The session id for the survey (pass null to generate a new session id).
	 * @return    Returns the QuestionsDTO response from the API call
	 */
	public QuestionsDTO updateAnswers(
			final String identifier,
			final UpdateSurveyStateRequestDTO updateSurveyStateRequestDTO,
			final String sessionId
	) throws Throwable {
		APICallBackCatcher<QuestionsDTO> callback = new APICallBackCatcher<>();

		updateAnswersAsync(identifier, updateSurveyStateRequestDTO, sessionId, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return updateAnswersRetry(identifier, updateSurveyStateRequestDTO, sessionId);
			} else
				throw callback.getError();
		}
		QuestionsDTO result = callback.getResult();
		result.setSessionId((String) callback.getExtraData().get("auth_token"));
		return result;
	}

	private QuestionsDTO updateAnswersRetry(final String identifier,
											final UpdateSurveyStateRequestDTO updateSurveyStateRequestDTO,
											final String sessionId) throws Throwable {
		APICallBackCatcher<QuestionsDTO> callback = new APICallBackCatcher<>();

		updateAnswersAsync(identifier, updateSurveyStateRequestDTO, sessionId, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		QuestionsDTO result = callback.getResult();
		result.setSessionId((String) callback.getExtraData().get("auth_token"));
		return result;
	}

	/**
	 * Re-submits answers to a potentially existing set of questions, from a previous step, and returns the next batch
	 * of unanswered survey questions if successful. This endpoint gracefully handles first-time submissions as well,
	 * similar to the simpler PostAnswers endpoint.
	 * @param    identifier    Required parameter: The identifier of the survey.
	 * @param    updateSurveyStateRequestDTO    Required parameter: A DTO with the step ref, and answers to re-submit.
	 * @param    sessionId    The session id for the survey (pass null to generate a new session id).
	 * @return    Returns the QuestionsDTO response from the API call
	 */
	private void updateAnswersAsync(final String identifier,
									final UpdateSurveyStateRequestDTO updateSurveyStateRequestDTO,
									final String sessionId, final APICallBack<QuestionsDTO> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(SURVEY_URI + "/{identifier}/UpdateAnswers");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<String, Object>();
					_templateParameters.put("identifier", identifier);
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("accept", "application/json");
					_headers.put("content-type", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					if (sessionId != null) {
						_headers.put("auth_token", sessionId);
					}

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().putBody(_queryUrl, _headers, APIHelper.serialize(updateSurveyStateRequestDTO));

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
							((APICallBackCatcher<?>) callBack).getExtraData().put("auth_token",
									_response.getHeaders().get("auth_token"));

							// extract result from the http response
							String _responseBody = ((HttpStringResponse) _response).getBody();
							QuestionsDTO _result = APIHelper.deserialize(_responseBody,
									new TypeReference<QuestionsDTO>() {
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
	 * Retrieves the summarized state of a survey for the current session.
	 * @param    identifier    Required parameter: The identifier of the survey.
	 * @param    sessionId    The session id for the survey (pass null to generate a new session id).
	 * @return    Returns the SurveyStateSummaryDTO response from the API call
	 */
	public SurveyStateSummaryDTO getSurveyStateSummary(
			final String identifier,
			final String sessionId
	) throws Throwable {
		APICallBackCatcher<SurveyStateSummaryDTO> callback = new APICallBackCatcher<>();
		getSurveyStateSummaryAsync(identifier, sessionId, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getSurveyStateSummaryRetry(identifier, sessionId);
			} else
				throw callback.getError();
		}
		SurveyStateSummaryDTO result = callback.getResult();
		result.setSessionId((String) callback.getExtraData().get("auth_token"));
		return result;
	}

	private SurveyStateSummaryDTO getSurveyStateSummaryRetry(final String identifier, final String sessionId) throws Throwable {
		APICallBackCatcher<SurveyStateSummaryDTO> callback = new APICallBackCatcher<>();
		getSurveyStateSummaryAsync(identifier, sessionId, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		SurveyStateSummaryDTO result = callback.getResult();
		result.setSessionId((String) callback.getExtraData().get("auth_token"));
		return result;
	}

	/**
	 * Retrieves the summarized state of a survey for the current session.
	 * @param    identifier    Required parameter: The identifier of the survey.
	 * @param    sessionId    The session id for the survey (pass null to generate a new session id).
	 * @return    Returns the SurveyStateSummaryDTO response from the API call
	 */
	private void getSurveyStateSummaryAsync(final String identifier, final String sessionId,
									 final APICallBack<SurveyStateSummaryDTO> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(SURVEY_URI + "/{identifier}/GetSurveyStateSummary");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<>();
					_templateParameters.put("identifier", identifier);
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<>();
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
							((APICallBackCatcher<?>) callBack).getExtraData().put("auth_token",
									_response.getHeaders().get("auth_token"));

							// extract result from the http response
							String _responseBody = ((HttpStringResponse) _response).getBody();
							SurveyStateSummaryDTO _result = APIHelper.deserialize(_responseBody,
									new TypeReference<SurveyStateSummaryDTO>() {
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
	 * DEVELOPMENT ONLY: Updates all answers stored for an end-user for a survey to the
	 * given set of answers. This API is only available in development environment.
	 * In all other environments it will result in a 404 (not found). Returns all
	 * updated answers.
	 * 
	 * @param identifier Required parameter: The identifier of the survey.
	 * @param answers    Optional parameter: The answer values to apply. Answers are
	 *                   keyed by question identifier.
	 * @return Returns the void response from the API call
	 */
	private void postSurveyAnswers(final String identifier, final Object answers) throws Throwable {
		APICallBackCatcher<Object> callback = new APICallBackCatcher<Object>();
		postSurveyAnswersAsync(identifier, answers, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				postSurveyAnswersRetry(identifier, answers);
			} else
				throw callback.getError();
		}
		callback.getResult();
	}

	private void postSurveyAnswersRetry(final String identifier, final Object answers) throws Throwable {
		APICallBackCatcher<Object> callback = new APICallBackCatcher<Object>();
		postSurveyAnswersAsync(identifier, answers, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		callback.getResult();
	}

	/**
	 * DEVELOPMENT ONLY: Updates all answers stored for a session for a survey to the
	 * given set of answers. This API is only available in development environment.
	 * In all other environments it will result in a 404 (not found). Returns all
	 * updated answers.
	 * 
	 * @param identifier Required parameter: The identifier of the survey.
	 * @param answers    Optional parameter: The answer values to apply. Answers are
	 *                   keyed by question identifier.
	 * @return Returns the void response from the API call
	 */
	private void postSurveyAnswersAsync(final String identifier, final Object answers,
			final APICallBack<Object> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(SURVEY_URI + "/{identifier}/PostSurveyAnswers");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<String, Object>();
					_templateParameters.put("identifier", identifier);
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("content-type", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(answers));

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
	 * DEVELOPMENT ONLY: Similar to the GET /answers API, but instead returns
	 * answers mapped to their corresponding sense values. This API is only
	 * available in development environment. In all other environments it will
	 * result in a 404 (not found).
	 * 
	 * @param identifier Required parameter: The identifier of the survey.
	 * @return Returns the void response from the API call
	 */
	private void getSenseInputValues(final String identifier) throws Throwable {
		APICallBackCatcher<Object> callback = new APICallBackCatcher<Object>();
		getSenseInputValuesAsync(identifier, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				getSenseInputValuesRetry(identifier);
			} else
				throw callback.getError();
		}
		callback.getResult();
	}

	private void getSenseInputValuesRetry(final String identifier) throws Throwable {
		APICallBackCatcher<Object> callback = new APICallBackCatcher<Object>();
		getSenseInputValuesAsync(identifier, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		callback.getResult();
	}

	/**
	 * DEVELOPMENT ONLY: Similar to the GET /answers API, but instead returns
	 * answers mapped to their corresponding sense values. This API is only
	 * available in development environment. In all other environments it will
	 * result in a 404 (not found).
	 * 
	 * @param identifier Required parameter: The identifier of the survey.
	 * @return Returns the void response from the API call
	 */
	private void getSenseInputValuesAsync(final String identifier, final APICallBack<Object> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(SURVEY_URI + "/{identifier}/GetSenseInputValues");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<String, Object>();
					_templateParameters.put("identifier", identifier);
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

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
	 * Resets the state of the survey for the current session. In other words, all the
	 * session's answers are removed and the survey should start back at the beginning.
	 * 
	 * @param identifier Required parameter: The identifier of the survey.
	 * @return Returns the void response from the API call
	 */
	public void createResetSurveyState(final String identifier) throws Throwable {
		APICallBackCatcher<Object> callback = new APICallBackCatcher<Object>();
		createResetSurveyStateAsync(identifier, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				createResetSurveyStateRetry(identifier);
			} else
				throw callback.getError();
		}
		callback.getResult();
	}

	private void createResetSurveyStateRetry(final String identifier) throws Throwable {
		APICallBackCatcher<Object> callback = new APICallBackCatcher<Object>();
		createResetSurveyStateAsync(identifier, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		callback.getResult();
	}

	/**
	 * Resets the state of the survey for the current session. In other words, all the
	 * session's answers are removed and the survey should start back at the beginning.
	 * 
	 * @param identifier Required parameter: The identifier of the survey.
	 * @return Returns the void response from the API call
	 */
	private void createResetSurveyStateAsync(final String identifier, final APICallBack<Object> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(SURVEY_URI + "/{identifier}/ResetSurveyState");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<String, Object>();
					_templateParameters.put("identifier", identifier);
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
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
	 * DEVELOPMENT ONLY: Gets all answers stored for a session for a given survey. This
	 * API is only available in development environment. In all other environments
	 * it will result in a 404 (not found).
	 * 
	 * @param identifier Required parameter: The identifier of the survey.
	 * @return Returns the void response from the API call
	 */
	private void getSurveyAnswers(final String identifier) throws Throwable {
		APICallBackCatcher<Object> callback = new APICallBackCatcher<Object>();
		getSurveyAnswersAsync(identifier, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				getSurveyAnswersRetry(identifier);
			} else
				throw callback.getError();
		}
		callback.getResult();
	}

	private void getSurveyAnswersRetry(final String identifier) throws Throwable {
		APICallBackCatcher<Object> callback = new APICallBackCatcher<Object>();
		getSurveyAnswersAsync(identifier, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		callback.getResult();
	}

	/**
	 * DEVELOPMENT ONLY: Gets all answers stored for a session for a given survey. This
	 * API is only available in development environment. In all other environments
	 * it will result in a 404 (not found).
	 * 
	 * @param identifier Required parameter: The identifier of the survey.
	 * @return Returns the void response from the API call
	 */
	private void getSurveyAnswersAsync(final String identifier, final APICallBack<Object> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(SURVEY_URI + "/{identifier}/GetSurveyAnswers");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<String, Object>();
					_templateParameters.put("identifier", identifier);
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

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
	 * Retrieves the state of a survey for the current session.
	 * 
	 * @param identifier Required parameter: The identifier of the survey.
	 * @param sessionId  The session id for the survey (pass null to generate a new
	 *                   session id).
	 * @return Returns the SurveyStateDTO response from the API call
	 */
	public SurveyStateDTO getSurveyState(final String identifier, final String sessionId) throws Throwable {
		APICallBackCatcher<SurveyStateDTO> callback = new APICallBackCatcher<SurveyStateDTO>();
		getSurveyStateAsync(identifier, sessionId, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return getSurveyStateRetry(identifier, sessionId);
			} else
				throw callback.getError();
		}
		SurveyStateDTO result = callback.getResult();
		result.setSessionId((String) callback.getExtraData().get("auth_token"));
		return result;
	}

	private SurveyStateDTO getSurveyStateRetry(final String identifier, final String sessionId) throws Throwable {
		APICallBackCatcher<SurveyStateDTO> callback = new APICallBackCatcher<SurveyStateDTO>();
		getSurveyStateAsync(identifier, sessionId, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		SurveyStateDTO result = callback.getResult();
		result.setSessionId((String) callback.getExtraData().get("auth_token"));
		return result;
	}

	/**
	 * Retrieves the state of a survey for the current session.
	 * 
	 * @param identifier Required parameter: The identifier of the survey.
	 * @param sessionId  The session id for the survey (pass null to generate a new
	 *                   session id).
	 * @return Returns the void response from the API call
	 */
	private void getSurveyStateAsync(final String identifier, final String sessionId,
			final APICallBack<SurveyStateDTO> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(SURVEY_URI + "/{identifier}/GetSurveyState");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<String, Object>();
					_templateParameters.put("identifier", identifier);
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
							((APICallBackCatcher<?>) callBack).getExtraData().put("auth_token",
									_response.getHeaders().get("auth_token"));

							// extract result from the http response
							String _responseBody = ((HttpStringResponse) _response).getBody();
							SurveyStateDTO _result = APIHelper.deserialize(_responseBody,
									new TypeReference<SurveyStateDTO>() {
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
	 * Updates the state of a survey for the current session, and returns the portion
	 * of the survey state necessary for the client to render the survey based on
	 * the update.
	 * 
	 * @param identifier Required parameter: The identifier of the survey.
	 * @param requestDTO Optional parameter: The update request object.
	 * @return Returns the SurveyStateDTO response from the API call
	 */
	public SurveyStateDTO updateSurveyState(final String identifier, final String sessionId,
			final UpdateSurveyStateRequestDTO requestDTO) throws Throwable {
		APICallBackCatcher<SurveyStateDTO> callback = new APICallBackCatcher<SurveyStateDTO>();
		updateSurveyStateAsync(identifier, sessionId, requestDTO, callback);
		if (!callback.isSuccess()) {
			if (callback.getError().getMessage().equals("Access token regenarated")) {
				return updateSurveyStateRetry(identifier, sessionId, requestDTO);
			} else
				throw callback.getError();
		}
		SurveyStateDTO result = callback.getResult();
		result.setSessionId((String) callback.getExtraData().get("auth_token"));
		return result;
	}

	private SurveyStateDTO updateSurveyStateRetry(final String identifier, final String sessionId,
			final UpdateSurveyStateRequestDTO requestDTO) throws Throwable {
		APICallBackCatcher<SurveyStateDTO> callback = new APICallBackCatcher<SurveyStateDTO>();
		updateSurveyStateAsync(identifier, sessionId, requestDTO, callback);
		if (!callback.isSuccess()) {
			throw callback.getError();
		}
		SurveyStateDTO result = callback.getResult();
		result.setSessionId((String) callback.getExtraData().get("auth_token"));
		return result;
	}

	/**
	 * Updates the state of a survey for the current session, and returns the portion
	 * of the survey state necessary for the client to render the survey based on
	 * the update.
	 * 
	 * @param identifier Required parameter: The identifier of the survey.
	 * @param requestDTO Optional parameter: The update request object.
	 * @return Returns the void response from the API call
	 */
	private void updateSurveyStateAsync(final String identifier, final String sessionId,
			final UpdateSurveyStateRequestDTO requestDTO, final APICallBack<SurveyStateDTO> callBack) {
		Runnable _responseTask = new Runnable() {
			public void run() {

				final HttpRequest _request;

				try {
					// the base uri for api requests
					String _baseUri = Configuration.getBaseUri();

					// prepare query string for API call
					StringBuilder _queryBuilder = new StringBuilder(SURVEY_URI + "/{identifier}/UpdateSurveyState");

					// process template parameters
					Map<String, Object> _templateParameters = new HashMap<String, Object>();
					_templateParameters.put("identifier", identifier);
					APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

					// validate and preprocess url
					String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

					// load all headers for the outgoing API request
					Map<String, String> _headers = new HashMap<String, String>();
					_headers.put("accept", "application/json");
					_headers.put("content-type", "application/json");
					_headers.put("Authorization", "Bearer " + Configuration.accessToken);

					if (sessionId != null) {
						_headers.put("auth_token", sessionId);
					}

					// prepare and invoke the API call request to fetch the response
					_request = getClientInstance().putBody(_queryUrl, _headers, APIHelper.serialize(requestDTO));

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
							((APICallBackCatcher<?>) callBack).getExtraData().put("auth_token",
									_response.getHeaders().get("auth_token"));

							// extract result from the http response
							String _responseBody = ((HttpStringResponse) _response).getBody();
							SurveyStateDTO _result = APIHelper.deserialize(_responseBody,
									new TypeReference<SurveyStateDTO>() {
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
