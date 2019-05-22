'use strict';

const _request = require('../Http/Client/RequestClient');
const _configuration = require('../configuration');
const _apiHelper = require('../APIHelper');
const _baseController = require('./BaseController');
const _scoring_subPath = '/smartsleep-analyzer/Scoring/';

class ScoringController {
    /**
     * Returns all question senses required to compute the target sense.
     *
     * @param {string} targetSenseId Id of sense for which required inputs are returned.
     * @param {string} locale (optional) Optional query param locale used to localize question
     * sense text.
     *
     * @returns {Promise}
     */
    static getRequiredQuestionSenses(targetSenseId, locale, recursive_depth = 0) {

        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        let _pathUrl = 'GetRequiredQuestionSenses/{targetSenseId}'
        // process template parameters
        _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
            targetSenseId,
        });

        let _queryBuilder = `${_baseUri}${_scoring_subPath}${_pathUrl}`;

        // process query parameters
        _queryBuilder = _apiHelper.appendUrlWithQueryParameters(_queryBuilder, {
            locale: (locale !== null) ? locale : 'en-US',
        });

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
                        _baseController.getObjectMapper().mapObject(model, 'SenseDTO'));
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.getRequiredQuestionSenses(targetSenseId, locale, 1).then(moreData => {
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
     * Returns all sleep problem senses which can be computed from the given input sense ids.
     *
     * @param {array} senseIds (optional) List of ids for all input senses that would be provided.
     *
     * @returns {Promise}
     */
    static getcomputableSleepProblemSenses(senseIds, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        const _pathUrl = 'GetComputableSleepProblemSenses';
        const _queryBuilder = `${_baseUri}${_scoring_subPath}${_pathUrl}`;

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
            body: _apiHelper.jsonSerialize(senseIds),
        };

        // build the response processing.
        return new Promise((_fulfill, _reject) => {
            _request(_options, (_error, _response, _context) => {
                if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                    let parsed = JSON.parse(_response.body);
                    parsed = parsed.map(model =>
                        _baseController.getObjectMapper().mapObject(model, 'SenseDTO'));
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.getcomputableSleepProblemSenses(senseIds, 1).then(moreData => {
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
     * Returns all senses which can be computed from the given input sense ids.
     *
     * @param {array} senseIds (optional) List of ids for all input senses that would be provided.
     *
     * @returns {Promise}
     */
    static getComputableSenses(senseIds, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        const _pathUrl = 'GetComputableSenses';
        const _queryBuilder = `${_baseUri}${_scoring_subPath}${_pathUrl}`;

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
            body: _apiHelper.jsonSerialize(senseIds),
        };

        // build the response processing.
        return new Promise((_fulfill, _reject) => {
            _request(_options, (_error, _response, _context) => {
                if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                    let parsed = JSON.parse(_response.body);
                    parsed = parsed.map(model =>
                        _baseController.getObjectMapper().mapObject(model, 'SenseDTO'));
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.getComputableSenses(senseIds, 1).then(moreData => {
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
     * Returns metadata information about all computed senses. Computed senses are derived from
     * other senses and should not be asked directly to an end-user.
     *
     * @returns {Promise}
     */
    static getComputedSenses(recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        const _pathUrl = 'GetComputedSenses';
        const _queryBuilder = `${_baseUri}${_scoring_subPath}${_pathUrl}`;

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
                        _baseController.getObjectMapper().mapObject(model, 'SenseDTO'));
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.getComputedSenses(1).then(moreData => {
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
     * Returns metadata information about all sleep problem senses.
     *
     * @returns {Promise}
     */
    static getSleepProblemSenses(recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        const _pathUrl = 'GetSleepProblemSenses';
        const _queryBuilder = `${_baseUri}${_scoring_subPath}${_pathUrl}`;

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
                        _baseController.getObjectMapper().mapObject(model, 'SenseDTO'));
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.getSleepProblemSenses(1).then(moreData => {
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
     * Returns metadata information about all question senses. Question senses are simple value
     * senses which can be asked to an end-user in the form of a question.
     *
     * @param {string} locale (optional) Optional query param locale used to localize question
     * sense text.
     *
     * @returns {Promise}
     */
    static getQuestionSenses(locale, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        const _pathUrl = 'GetQuestionSenses';
        let _queryBuilder = `${_baseUri}${_scoring_subPath}${_pathUrl}`;

        // process query parameters
        _queryBuilder = _apiHelper.appendUrlWithQueryParameters(_queryBuilder, {
            locale: (locale !== null) ? locale : 'en-US',
        });

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
                        _baseController.getObjectMapper().mapObject(model, 'SenseDTO'));
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.getQuestionSenses(locale, 1).then(moreData => {
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
     * Returns metadata information about all available senses.
     *
     * @param {string} locale (optional) Optional query param locale used to localize question
     * sense text.
     *
     * @returns {Promise}
     */
    static getAllSenses(locale, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        const _pathUrl = 'GetAllSenses';
        let _queryBuilder = `${_baseUri}${_scoring_subPath}${_pathUrl}`;

        // process query parameters
        _queryBuilder = _apiHelper.appendUrlWithQueryParameters(_queryBuilder, {
            locale: (locale !== null) ? locale : 'en-US',
        });

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
                        _baseController.getObjectMapper().mapObject(model, 'SenseDTO'));
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.getAllSenses(locale, 1).then(moreData => {
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
     * Returns metadata information about a single sense.
     *
     * @param {string} senseId The id of the sense.
     * @param {string} locale (optional) Optional query param locale used to localize question
     * sense text.
     *
     * @returns {Promise}
     */
    static getSense(senseId, locale, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        let _pathUrl = 'GetSense/{senseId}';
        // process template parameters
        _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
            senseId,
        });

        let _queryBuilder = `${_baseUri}${_scoring_subPath}${_pathUrl}`;

        // process query parameters
        _queryBuilder = _apiHelper.appendUrlWithQueryParameters(_queryBuilder, {
            locale: (locale !== null) ? locale : 'en-US',
        });

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
                    parsed = _baseController.getObjectMapper().mapObject(parsed, 'SenseDTO');
                    _fulfill(parsed);
                } else {
                    _baseController.validateResponse(_context).then((retryData) => {
                        if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {

                            this.getSense(senseId, locale, 1).then(moreData => {
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
     * Computes the values of all possible intermediate and sleep problem senses based on the
     * provided input values.
     *
     * @param {object} inputValues (optional) Map of sense input values, keyed by sense id.
     *
     * @returns {Promise}
     */
    static computeIntermediateAndSleepProblemSenses(inputValues, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        const _pathUrl = 'ComputeIntermediateAndSleepProblemSenses';
        const _queryBuilder = `${_baseUri}${_scoring_subPath}${_pathUrl}`;

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

                            this.computeIntermediateAndSleepProblemSenses(inputValues, 1).then(moreData => {
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
     * Computes the values of all possible sleep problem senses based on the provided input
     * values.
     *
     * @param {object} inputValues (optional) Map of sense input values, keyed by sense id.
     *
     * @returns {Promise}
     */
    static computeSleepProblemSenses(inputValues, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        const _pathUrl = 'ComputeSleepProblemSenses';
        const _queryBuilder = `${_baseUri}${_scoring_subPath}${_pathUrl}`;

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

                            this.computeSleepProblemSenses(inputValues, 1).then(moreData => {
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
     * Computes the value of a single sense based on the provided input values.
     *
     * @param {string} senseId Id of the sense to compute.
     * @param {object} inputValues (optional) Map of sense input values, keyed by sense id.
     *
     * @returns {Promise}
     */
    static computeSense(senseId, inputValues, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        let _pathUrl = 'ComputeSense/{senseId}';
        // process template parameters
        _pathUrl = _apiHelper.appendUrlWithTemplateParameters(_pathUrl, {
            senseId,
        });

        const _queryBuilder = `${_baseUri}${_scoring_subPath}${_pathUrl}`;

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
                            this.computeSense(senseId, inputValues, 1).then(moreData => {
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
     * Computes the values of all possible senses based on the provided input values.
     *
     * @param {object} inputValues (optional) Map of sense input values, keyed by sense id.
     *
     * @returns {Promise}
     */
    static computeAllSenses(inputValues, recursive_depth = 0) {
        // prepare query string for API call
        const _baseUri = _configuration.getBaseUri();

        const _pathUrl = 'ComputeAllSenses';
        const _queryBuilder = `${_baseUri}${_scoring_subPath}${_pathUrl}`;

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
                            this.computeAllSenses(inputValues, 1).then(moreData => {
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

module.exports = ScoringController;
