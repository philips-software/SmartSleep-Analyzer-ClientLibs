'use strict';

const _request = require('../Http/Client/RequestClient');
const _configuration = require('../configuration');
const _apiHelper = require('../APIHelper');
const _baseController = require('./BaseController');
const _result_subPath = '/smartsleep-analyzer/Result/';

/**
    * Computes and returns all tips that would be associated with the given condition, based on
    * the given input values.
    *
    * @param {string} conditionId (optional) The id of the sleep problem.
    * @param {object} inputValues (optional) The sense input values.
    *
    * @returns {Promise}
    */
function getTipsByConditionAndInputValues(conditionId, inputValues, recursive_depth = 0) {

    // prepare query string for API call
    const _baseUri = _configuration.getBaseUri();

    const _pathUrl = 'GetTipsByConditionAndInputValues';
    let _queryBuilder = `${_baseUri}${_result_subPath}${_pathUrl}`;

    // process query parameters
    _queryBuilder = _apiHelper.appendUrlWithQueryParameters(_queryBuilder, {
        conditionId,
    });

    // validate and preprocess url
    const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

    // prepare headers
    const _headers = {
        accept: 'application/json',
        'content-type': 'application/json; charset=utf-8',
        'Authorization': 'Bearer ' + _configuration.AccessToken,
    };

    // construct the request
    const _options = {
        queryUrl: _queryUrl,
        method: 'POST',
        headers: _headers,
        body: _apiHelper.jsonSerialize(inputValues),
    };

    // build the response processing.
    return new Promise((_fulfill, _reject) => {
        _request(_options, (_error, _response, _context) => {
            if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                let parsed = JSON.parse(_response.body);
                parsed = parsed.map(model =>
                    _baseController.getObjectMapper().mapObject(model, 'TipResult'));
                _fulfill(parsed);
            } else {
                _baseController.validateResponse(_context).then((retryData) => {
                    if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                        this.getTipsByConditionAndInputValues(conditionId, inputValues, 1).then(moreData => {
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
 * Computes and returns the ids of all tips that would be associated with the given condition,
 * based on the given
 * input values.
 *
 * @param {string} conditionId The id of the sleep problem.
 * @param {object} inputValues (optional) The sense input values.
 *
 * @returns {Promise}
 */
function getTipIdsByConditionAndInputValues(conditionId, inputValues, recursive_depth = 0) {

    // prepare query string for API call
    const _baseUri = _configuration.getBaseUri();

    let _pathUrl = 'GetTipIdsByConditionAndInputValues/{conditionId}';
    // process template parameters
    _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
        conditionId,
    });

    const _queryBuilder = `${_baseUri}${_result_subPath}${_pathUrl}`;

    // validate and preprocess url
    const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

    // prepare headers
    const _headers = {
        accept: 'application/json',
        'content-type': 'application/json; charset=utf-8',
        'Authorization': 'Bearer ' + _configuration.AccessToken,
    };

    // construct the request
    const _options = {
        queryUrl: _queryUrl,
        method: 'POST',
        headers: _headers,
        body: _apiHelper.jsonSerialize(inputValues),
    };

    // build the response processing.
    return new Promise((_fulfill, _reject) => {
        _request(_options, (_error, _response, _context) => {
            if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                const parsed = JSON.parse(_response.body);
                _fulfill(parsed);
            } else {
                _baseController.validateResponse(_context).then((retryData) => {
                    if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                        this.getTipIdsByConditionAndInputValues(conditionId, inputValues, 1).then(moreData => {
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
 * Returns the ids of all tidbits that could be associated with the given condition.
 *
 * @param {string} conditionId The id of the condition.
 *
 * @returns {Promise}
 */
function getTidbitIdsByCondition(conditionId, recursive_depth = 0) {
    // prepare query string for API call
    const _baseUri = _configuration.getBaseUri();

    let _pathUrl = 'GetTidbitIdsByCondition/{conditionId}';
    // process template parameters
    _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
        conditionId,
    });

    const _queryBuilder = `${_baseUri}${_result_subPath}${_pathUrl}`;

    // validate and preprocess url
    const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

    // prepare headers
    const _headers = {
        accept: 'application/json',
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
                const parsed = JSON.parse(_response.body);
                _fulfill(parsed);
            } else {
                _baseController.validateResponse(_context).then((retryData) => {
                    if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                        this.getTidbitIdsByCondition(conditionId, 1).then(moreData => {
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
 * Returns the ids of all tips that could be associated with the given condition.
 *
 * @param {string} conditionId The id of the condition.
 *
 * @returns {Promise}
 */
function getTipIdsByCondition(conditionId, recursive_depth = 0) {
    // prepare query string for API call
    const _baseUri = _configuration.getBaseUri();

    let _pathUrl = 'GetTipIdsByCondtion/{conditionId}';
    // process template parameters
    _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
        conditionId,
    });

    const _queryBuilder = `${_baseUri}${_result_subPath}${_pathUrl}`;

    // validate and preprocess url
    const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

    // prepare headers
    const _headers = {
        accept: 'application/json',
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
                const parsed = JSON.parse(_response.body);
                _fulfill(parsed);
            } else {
                _baseController.validateResponse(_context).then((retryData) => {
                    if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                        this.getTipIdsByCondition(conditionId, 1).then(moreData => {
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
 * Submits feedback for the session on the indicated tip.
 *
 * @param {UpdateTipFeedbackRequestDTO} requestDTO (optional) The request object.
 *
 * @returns {Promise}
 */
function submitTipFeedback(requestDTO, recursive_depth = 0) {
    // prepare query string for API call
    const _baseUri = _configuration.getBaseUri();

    const _pathUrl = 'Feedback/SubmitTipFeedback';
    const _queryBuilder = `${_baseUri}${_result_subPath}${_pathUrl}`;

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
        body: _apiHelper.jsonSerialize(requestDTO),
    };

    // build the response processing.
    return new Promise((_fulfill, _reject) => {
        _request(_options, (_error, _response, _context) => {
            if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                _fulfill();
            } else {
                _baseController.validateResponse(_context).then((retryData) => {
                    if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {
                        this.submitTipFeedback(requestDTO, 1).then(moreData => {
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
 * Submits feedback for the session on the indicated condition.
 *
 * @param {UpdateConditionFeedbackRequestDTO} requestDTO (optional) The request object.
 *
 * @returns {Promise}
 */
function submitConditionFeedback(requestDTO, recursive_depth = 0) {

    // prepare query string for API call
    const _baseUri = _configuration.getBaseUri();

    const _pathUrl = 'Feedback/SubmitConditionFeedback';
    const _queryBuilder = `${_baseUri}${_result_subPath}${_pathUrl}`;

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
        body: _apiHelper.jsonSerialize(requestDTO),
    };

    // build the response processing.
    return new Promise((_fulfill, _reject) => {
        _request(_options, (_error, _response, _context) => {
            if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                _fulfill();
            } else {
                _baseController.validateResponse(_context).then((retryData) => {
                    if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {
                        this.submitConditionFeedback(requestDTO, 1).then(moreData => {
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

class ResultController {
    /**
    * Returns metadata information about an single condition.
    *
    * @param {string} conditionId The id of the condition.
    *
    * @returns {Promise}
    */
    static getCondition(conditionId, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        let _pathUrl = 'GetCondition/{conditionId}';
        // process template parameters
        _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
            conditionId,
        });

        const _queryBuilder = `${_baseUri}${_result_subPath}${_pathUrl}`;

        // validate and preprocess url
        const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

        // prepare headers
        const _headers = {
            accept: 'application/json',
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
                    let parsed = JSON.parse(_response.body);
                    parsed = _baseController.getObjectMapper().mapObject(parsed, 'ConditionResult');
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.getCondition(conditionId, 1).then(moreData => {
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
     * Returns metadata information about all available conditions.
     *
     * @returns {Promise}
     */
    static getAllConditions(recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        const _pathUrl = 'GetAllConditions';
        const _queryBuilder = `${_baseUri}${_result_subPath}${_pathUrl}`;

        // validate and preprocess url
        const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

        // prepare headers
        const _headers = {
            accept: 'application/json',
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
                        _baseController.getObjectMapper().mapObject(model, 'ConditionResult'));
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.getAllConditions(1).then(moreData => {
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
     * Computes Results output for the given survey.
     *
     * @param {string} surveyIdentifier The identifier of the survey.
     * @param {string} sessionId An auth token provided by the backend, for persisting state between calls.
     *
     * @returns {Promise}
     */
    static computeResult(surveyIdentifier, sessionId, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        let _pathUrl = '{surveyIdentifier}/ComputeResult';
        // process template parameters
        _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
            surveyIdentifier,
        });

        const _queryBuilder = `${_baseUri}${_result_subPath}${_pathUrl}`;

        // validate and preprocess url
        const _queryUrl = _apiHelper.cleanUrl(_queryBuilder);

        // prepare headers
        const _headers = {
            accept: 'application/json',
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
                    parsed = _baseController.getObjectMapper().mapObject(parsed, 'ResultDTO');
                    parsed.sessionId = _response.headers['auth_token'];
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {
                            this.computeResult(surveyIdentifier, sessionId, 1).then(moreData => {
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
module.exports = ResultController;
