'use strict';

const _request = require('../Http/Client/RequestClient');
const _configuration = require('../configuration');
const _apiHelper = require('../APIHelper');
const _baseController = require('./BaseController');
const _survey_subPath = '/smartsleep-analyzer/Survey/';

/**
     * DEVELOPMENT ONLY: Returns all rules which were matched in the computation of the session's
     * survey state. This API is
     * only available in development environment. In all other environments it will result in a
     * 404 (not found).
     *
     * @param {string} identifier The identifier of the survey.
     *
     * @returns {Promise}
     */
    function getMatchedRules(identifier, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        let _pathUrl = '{identifier}/GetMatchedRules'

        // process template parameters
        _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
            identifier,
        });

        const _queryBuilder = `${_baseUri}${_survey_subPath}${_pathUrl}`;

        // validate and preprocess url
        const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

        // prepare headers
        const _headers = {
            'Authorization': 'Bearer ' + _configuration.AccessToken,
        };

        // construct the request
        const _options = {
            queryUrl: _queryUrl,
            method: 'GET',
            headers: _headers,
        };

        // build the response processing.
        return new Promise((_fulfill, _reject) => {
            _request(_options, (_error, _response, _context) => {
                if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                    _fulfill();
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.getMatchedRules(identifier, 1).then(moreData => {
                                _fulfill(moreData)
                            });
                        } else {
                            _fulfill(retryData.error);
                        }
                    });
                }
            });
        });
    }
    /**
     * DEVELOPMENT ONLY: Updates all answers stored for a session for a survey to the given set of
     * answers. This API is only
     * available in
     * development environment. In all other environments it will result in a 404 (not found).
     * Returns all updated
     * answers.
     *
     * @param {string} identifier The identifier of the survey.
     * @param {object} answers (optional) The answer values to apply. Answers are keyed by question
     * identifier.
     *
     * @returns {Promise}
     */
    function postSurveyAnswers(identifier, answers, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        let _pathUrl = '{identifier}/PostSurveyAnswers';

        // process template parameters
        _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
            identifier,
        });

        const _queryBuilder = `${_baseUri}${_survey_subPath}${_pathUrl}`;

        // validate and preprocess url
        const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

        // prepare headers
        const _headers = {
            'content-type': 'application/json; charset=utf-8',
            'Authorization': 'Bearer ' + _configuration.AccessToken,
        };

        // construct the request
        const _options = {
            queryUrl: _queryUrl,
            method: 'POST',
            headers: _headers,
            body: _apiHelper.jsonSerialize(answers),
        };

        // build the response processing.
        return new Promise((_fulfill, _reject) => {
            _request(_options, (_error, _response, _context) => {
                if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                    _fulfill();
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {
                            this.postSurveyAnswers(identifier, answers, 1).then(moreData => {
                                _fulfill(moreData)
                            });
                        } else {
                            _fulfill(retryData.error);
                        }
                    });
                }
            });
        });
    }
    /**
     * DEVELOPMENT ONLY: Similar to the GET /answers API, but instead returns answers mapped to
     * their corresponding sense
     * values. This API is only available in development environment. In all other environments
     * it will result in a 404
     * (not found).
     *
     * @param {string} identifier The identifier of the survey.
     *
     * @returns {Promise}
     */
    function getSenseInputValues(identifier, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        let _pathUrl = '{identifier}/GetSenseInputValues';

        // process template parameters
        _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
            identifier,
        });

        const _queryBuilder = `${_baseUri}${_survey_subPath}${_pathUrl}`;

        // validate and preprocess url
        const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

        // prepare headers
        const _headers = {
            'user-agent': 'SSA-Swagger',
            'Authorization': 'Bearer ' + _configuration.AccessToken,
        };

        // construct the request
        const _options = {
            queryUrl: _queryUrl,
            method: 'GET',
            headers: _headers,
        };

        // build the response processing.
        return new Promise((_fulfill, _reject) => {
            _request(_options, (_error, _response, _context) => {
                if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                    _fulfill();
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {
                            this.getSenseInputValues(identifier, 1).then(moreData => {
                                _fulfill(moreData)
                            });
                        } else {
                            _fulfill(retryData.error);
                        }
                    });
                }
            });
        });
    }
    /**
     * DEVELOPMENT ONLY: Gets all answers stored for a session for a given survey. This API is only
     * available in development
     * environment. In
     * all other environments it will result in a 404 (not found).
     *
     * @param {string} identifier The identifier of the survey.
     *
     * @returns {Promise}
     */
    function getSurveyAnswers(identifier, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        let _pathUrl = '{identifier}/GetSurveyAnswers';

        // process template parameters
        _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
            identifier,
        });

        const _queryBuilder = `${_baseUri}${_survey_subPath}${_pathUrl}`;

        // validate and preprocess url
        const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

        // prepare headers
        const _headers = {
            'user-agent': 'SSA-Swagger',
            'Authorization': 'Bearer ' + _configuration.AccessToken,
        };

        // construct the request
        const _options = {
            queryUrl: _queryUrl,
            method: 'GET',
            headers: _headers,
        };

        // build the response processing.
        return new Promise((_fulfill, _reject) => {
            _request(_options, (_error, _response, _context) => {
                if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                    _fulfill();
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.getSurveyAnswers(identifier, 1).then(moreData => {
                                _fulfill(moreData)
                            });
                        } else {
                            _fulfill(retryData.error);
                        }
                    });
                }
            });
        });
    }

class SurveyController {
    
    /**
     * Resets the state of the survey for the current session. In other words, all the session's
     * answers are removed and the
     * survey should start back at the beginning.
     *
     * @param {string} identifier The identifier of the survey.
     *
     * @returns {Promise}
     */
    static resetSurveyState(identifier, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        let _pathUrl = '{identifier}/ResetSurveyState';

        // process template parameters
        _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
            identifier,
        });

        const _queryBuilder = `${_baseUri}${_survey_subPath}${_pathUrl}`;

        // validate and preprocess url
        const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

        // prepare headers
        const _headers = {
            'content-type': 'application/json; charset=utf-8',
            'Authorization': 'Bearer ' + _configuration.AccessToken,
        };

        // construct the request
        const _options = {
            queryUrl: _queryUrl,
            method: 'POST',
            headers: _headers,
        };

        // build the response processing.
        return new Promise((_fulfill, _reject) => {
            _request(_options, (_error, _response, _context) => {
                if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                    _fulfill();
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.resetSurveyState(identifier, 1).then(moreData => {
                                _fulfill(moreData)
                            });
                        } else {
                            _fulfill(retryData.error);
                        }
                    });
                }
            });
        });
    }
    
    /**
     * Retrieves the state of a survey for the current session.
     *
     * @param {string} identifier The identifier of the survey.
     * @param {string} sessionId An auth token provided by the backend, for persisting state between calls.
     *
     * @returns {Promise}
     */
    static getSurveyState(identifier, sessionId, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        let _pathUrl = '{identifier}/GetSurveyState';

        // process template parameters
        _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
            identifier,
        });

        const _queryBuilder = `${_baseUri}${_survey_subPath}${_pathUrl}`;

        // validate and preprocess url
        const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

        // prepare headers
        const _headers = {
            accept: 'application/json',
            'user-agent': 'SSA-Swagger',
            'Authorization': 'Bearer ' + _configuration.AccessToken,
        };

        if (sessionId != null && sessionId != undefined) {
            _headers["auth_token"] = sessionId;
        }

        // construct the request
        const _options = {
            queryUrl: _queryUrl,
            method: 'GET',
            headers: _headers,
        };

        // build the response processing.
        return new Promise((_fulfill, _reject) => {
            _request(_options, (_error, _response, _context) => {
                if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                    let parsed = JSON.parse(_response.body);
                    parsed = _baseController.getObjectMapper().mapObject(parsed, 'SurveyStateDTO');
                    parsed.sessionId = _response.headers['auth_token'];
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {
                            this.getSurveyState(identifier, sessionId, 1).then(moreData => {
                                _fulfill(moreData)
                            });
                        } else {
                            _fulfill(retryData.error);
                        }
                    });
                }
            });
        });
    }

    /**
     * Updates the state of a survey for the current session, and returns the portion of the survey
     * state necessary for the
     * client to render the survey based on the update.
     *
     * @param {string} identifier The identifier of the survey.
     * @param {UpdateSurveyStateRequestDTO} requestDTO (optional) The update request object.
     * @param {string} sessionId An auth token provided by the backend, for persisting state between calls.
     *
     * @returns {Promise}
     */
    static updateSurveyState(identifier, requestDTO, sessionId, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        let _pathUrl = '{identifier}/UpdateSurveyState';

        // process template parameters
        _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
            identifier,
        });

        const _queryBuilder = `${_baseUri}${_survey_subPath}${_pathUrl}`;

        // validate and preprocess url
        const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

        // prepare headers
        const _headers = {
            accept: 'application/json',
            'content-type': 'application/json; charset=utf-8',
            'Authorization': 'Bearer ' + _configuration.AccessToken,
        };

        if (sessionId != null && sessionId != undefined) {
            _headers["auth_token"] = sessionId;
        }

        // construct the request
        const _options = {
            queryUrl: _queryUrl,
            method: 'PUT',
            headers: _headers,
            body: _apiHelper.jsonSerialize(requestDTO),
        };

        // build the response processing.
        return new Promise((_fulfill, _reject) => {
            _request(_options, (_error, _response, _context) => {
                if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                    let parsed = JSON.parse(_response.body);
                    parsed = _baseController.getObjectMapper().mapObject(parsed, 'SurveyStateDTO');
                    parsed.sessionId = _response.headers['auth_token'];
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.updateSurveyState(identifier, requestDTO, sessionId, 1).then(moreData => {
                                _fulfill(moreData)
                            });
                        } else {
                            _fulfill(retryData.error);
                        }
                    });
                }
            });
        });
    }

    /**
     * Get the QuestionDTO for a given sense, and for the given survey.
     *
     * @param {string} identifier The identifier of the survey.
     * @param {string} senseId The id of the sense we want a QuestionDTO for.
     *
     * @returns {Promise}
     */
    static getSenseQuestion(identifier, senseId, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        let _pathUrl = '{identifier}/GetSenseQuestion/{senseId}';

        // process template parameters
        _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
            identifier,
            senseId,
        });

        const _queryBuilder = `${_baseUri}${_survey_subPath}${_pathUrl}`;

        // validate and preprocess url
        const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

        // prepare headers
        const _headers = {
            accept: 'application/json',
            'user-agent': 'SSA-Swagger',
            'Authorization': 'Bearer ' + _configuration.AccessToken,
        };

        // construct the request
        const _options = {
            queryUrl: _queryUrl,
            method: 'GET',
            headers: _headers,
        };

        // build the response processing.
        return new Promise((_fulfill, _reject) => {
            _request(_options, (_error, _response, _context) => {
                if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                    let parsed = JSON.parse(_response.body);
                    parsed = _baseController.getObjectMapper().mapObject(parsed, 'QuestionDTO');
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.getSenseQuestion(identifier, senseId, 1).then(moreData => {
                                _fulfill(moreData)
                            });
                        } else {
                            _fulfill(retryData.error);
                        }
                    });
                }
            });
        });
    }
    /**
     * Get a list of required QuestionDTO items for a given sense, and for the given survey.
     *
     * @param {string} identifier The identifier of the survey.
     * @param {string} senseId The id of the sense we want a list of required QuestionDTO for.
     *
     * @returns {Promise}
     */
    static getSenseRequiredQuestions(identifier, senseId, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        let _pathUrl = '{identifier}/GetSenseRequiredQuestions/{senseId}';

        // process template parameters
        _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
            identifier,
            senseId,
        });

        const _queryBuilder = `${_baseUri}${_survey_subPath}${_pathUrl}`;

        // validate and preprocess url
        const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

        // prepare headers
        const _headers = {
            accept: 'application/json',
            'user-agent': 'SSA-Swagger',
            'Authorization': 'Bearer ' + _configuration.AccessToken,
        };

        // construct the request
        const _options = {
            queryUrl: _queryUrl,
            method: 'GET',
            headers: _headers,
        };

        // build the response processing.
        return new Promise((_fulfill, _reject) => {
            _request(_options, (_error, _response, _context) => {
                if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                    let parsed = JSON.parse(_response.body);
                    parsed = parsed.map(model =>
                        _baseController.getObjectMapper().mapObject(model, 'QuestionDTO'));
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.getSenseRequiredQuestions(identifier, senseId, 1).then(moreData => {
                                _fulfill(moreData)
                            });
                        } else {
                            _fulfill(retryData.error);
                        }
                    });
                }
            });
        });
    }
    /**
     * Retrieves the current question set, per the current survey state, or per the given Step Id reference.
     * Templates are also provided for immediately submitting via PostAnswers, or later submission via UpdateAnswers.
     *
     * @param {string} identifier The identifier of the survey.
     * @param {string} stepRef (optional) Optional Step Id we wish to query QuestionDTOs for. Defaults to the latest step, if unspecified.
     * @param {string} sessionId An auth token provided by the backend, for persisting state between calls.
     *
     * @returns {Promise}
     */
    static getQuestions(identifier, stepRef, sessionId, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        let _pathUrl = '{identifier}/GetQuestions';

        // process template parameters
        _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
            identifier,
        });

        let _queryBuilder = `${_baseUri}${_survey_subPath}${_pathUrl}`;

        // process query parameters
        _queryBuilder = _apiHelper.appendUrlWithQueryParameters(_queryBuilder, {
            stepRef,
        });

        // validate and preprocess url
        const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

        // prepare headers
        const _headers = {
            accept: 'application/json',
            'user-agent': 'SSA-Swagger',
            'Authorization': 'Bearer ' + _configuration.AccessToken,
        };

        if (sessionId != null && sessionId != undefined) {
            _headers["auth_token"] = sessionId;
        }

        // construct the request
        const _options = {
            queryUrl: _queryUrl,
            method: 'GET',
            headers: _headers,
        };

        // build the response processing.
        return new Promise((_fulfill, _reject) => {
            _request(_options, (_error, _response, _context) => {
                if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                    let parsed = JSON.parse(_response.body);
                    parsed = _baseController.getObjectMapper().mapObject(parsed, 'QuestionsDTO');
                    parsed.sessionId = _response.headers['auth_token'];
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.getQuestions(identifier, stepRef, sessionId, 1).then(moreData => {
                                _fulfill(moreData)
                            });
                        } else {
                            _fulfill(retryData.error);
                        }
                    });
                }
            });
        });
    }
    /**
     * Submits answers to the most recent, unanswered questions for the current survey session,
     * and returns the next batch of unanswered survey questions if successful.
     *
     * @param {string} identifier The identifier of the survey.
     * @param {dictionary} answers (optional) The answers for the most recent, unanswered questions available in the survey.
     * @param {string} sessionId An auth token provided by the backend, for persisting state between calls.
     *
     * @returns {Promise}
     */
    static postAnswers(identifier, answers, sessionId, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        let _pathUrl = '{identifier}/PostAnswers';

        // process template parameters
        _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
            identifier,
        });

        const _queryBuilder = `${_baseUri}${_survey_subPath}${_pathUrl}`;

        // validate and preprocess url
        const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

        // prepare headers
        const _headers = {
            accept: 'application/json',
            'content-type': 'application/json; charset=utf-8',
            'Authorization': 'Bearer ' + _configuration.AccessToken,
        };

        if (sessionId != null && sessionId != undefined) {
            _headers["auth_token"] = sessionId;
        }

        // construct the request
        const _options = {
            queryUrl: _queryUrl,
            method: 'PUT',
            headers: _headers,
            body: _apiHelper.jsonSerialize(answers),
        };

        // build the response processing.
        return new Promise((_fulfill, _reject) => {
            _request(_options, (_error, _response, _context) => {
                if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                    let parsed = JSON.parse(_response.body);
                    parsed = _baseController.getObjectMapper().mapObject(parsed, 'QuestionsDTO');
                    parsed.sessionId = _response.headers['auth_token'];
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.postAnswers(identifier, answers, sessionId, 1).then(moreData => {
                                _fulfill(moreData)
                            });
                        } else {
                            _fulfill(retryData.error);
                        }
                    });
                }
            });
        });
    }
    /**
     * Re-submits answers to a potentially existing set of questions, from a previous step, and returns the next batch of unanswered survey questions if successful.
     * This endpoint gracefully handles first-time submissions as well, similar to the simpler PostAnswers endpoint.
     *
     * @param {string} identifier The identifier of the survey.
     * @param {UpdateSurveyStateRequestDTO} updateSurveyStateRequestDTO (required) A DTO with the step ref, and answers to re-submit.
     * @param {string} sessionId An auth token provided by the backend, for persisting state between calls.
     *
     * @returns {Promise}
     */
    static updateAnswers(identifier, updateSurveyStateRequestDTO, sessionId, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        let _pathUrl = '{identifier}/UpdateAnswers';

        // process template parameters
        _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
            identifier,
        });

        const _queryBuilder = `${_baseUri}${_survey_subPath}${_pathUrl}`;

        // validate and preprocess url
        const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

        // prepare headers
        const _headers = {
            accept: 'application/json',
            'content-type': 'application/json; charset=utf-8',
            'Authorization': 'Bearer ' + _configuration.AccessToken,
        };

        if (sessionId != null && sessionId != undefined) {
            _headers["auth_token"] = sessionId;
        }

        // construct the request
        const _options = {
            queryUrl: _queryUrl,
            method: 'PUT',
            headers: _headers,
            body: _apiHelper.jsonSerialize(updateSurveyStateRequestDTO),
        };

        // build the response processing.
        return new Promise((_fulfill, _reject) => {
            _request(_options, (_error, _response, _context) => {
                if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                    let parsed = JSON.parse(_response.body);
                    parsed = _baseController.getObjectMapper().mapObject(parsed, 'QuestionsDTO');
                    parsed.sessionId = _response.headers['auth_token'];
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.updateAnswers(identifier, updateSurveyStateRequestDTO, sessionId, 1).then(moreData => {
                                _fulfill(moreData)
                            });
                        } else {
                            _fulfill(retryData.error);
                        }
                    });
                }
            });
        });
    }

    /**
     * Retrieves the state of a survey for the current session.
     *
     * @param {string} identifier The identifier of the survey.
     * @param {string} sessionId An auth token provided by the backend, for persisting state between calls.
     *
     * @returns {Promise}
     */
    static getSurveyStateSummary(identifier, sessionId, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        let _pathUrl = '{identifier}/GetSurveyStateSummary';

        // process template parameters
        _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
            identifier,
        });

        const _queryBuilder = `${_baseUri}${_survey_subPath}${_pathUrl}`;

        // validate and preprocess url
        const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

        // prepare headers
        const _headers = {
            accept: 'application/json',
            'user-agent': 'SSA-Swagger',
            'Authorization': 'Bearer ' + _configuration.AccessToken,
        };

        if (sessionId != null && sessionId != undefined) {
            _headers["auth_token"] = sessionId;
        }

        // construct the request
        const _options = {
            queryUrl: _queryUrl,
            method: 'GET',
            headers: _headers,
        };

        // build the response processing.
        return new Promise((_fulfill, _reject) => {
            _request(_options, (_error, _response, _context) => {
                if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                    let parsed = JSON.parse(_response.body);
                    parsed = _baseController.getObjectMapper().mapObject(parsed, 'SurveyStateSummaryDTO');
                    parsed.sessionId = _response.headers['auth_token'];
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.getSurveyStateSummary(identifier, sessionId, 1).then(moreData => {
                                _fulfill(moreData)
                            });
                        } else {
                            _fulfill(retryData.error);
                        }
                    });
                }
            });
        });
    }
}
module.exports = SurveyController;
