/*jshint node: true*/
'use strict';

const _request = require('../Http/Client/RequestClient');
const _configuration = require('../configuration');
const _apiHelper = require('../APIHelper');
const _baseController = require('./BaseController');
const _session_subPath = '/smartsleep-analyzer/Session/';

/**
 * Activates an existing session.
 *
 * @param {SessionDTO} sessionDTO (optional) Object containing the session's credentials.
 *
 * @returns {Promise}
 */
function activateSession(sessionDTO, recursive_depth = 0) {
    // prepare query string for API call
    const _baseUri = _configuration.getBaseUri();

    const _pathUrl = 'ActivateSession';
    const _queryBuilder = `${_baseUri}${_session_subPath}${_pathUrl}`;

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
        body: _apiHelper.jsonSerialize(sessionDTO),
    };

    // build the response processing.
    return new Promise((_fulfill, _reject) => {
        _request(_options, (_error, _response, _context) => {
            if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                let parsed = JSON.parse(_response.body);
                parsed = _baseController.getObjectMapper().mapObject(parsed, 'SessionDTO');
                _fulfill(parsed);
            } else {
                _baseController.validateResponse(_context).then((retryData) => {
                    if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {
                        this.activateSession(sessionDTO, 1).then(moreData => {
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
 * Retrieves the details of the activated session.
 *
 * @returns {Promise}
 */
function retrieveActivatedSession(recursive_depth = 0) {
    // prepare query string for API call
    const _baseUri = _configuration.getBaseUri();

    const _pathUrl = 'RetrieveActivatedSession';
    const _queryBuilder = `${_baseUri}${_session_subPath}${_pathUrl}`;

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
                parsed = _baseController.getObjectMapper().mapObject(parsed, 'SessionDTO');
                _fulfill(parsed);
            } else {
                _baseController.validateResponse(_context).then((retryData) => {
                    if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {
                        this.retrieveActivatedSession(1).then(moreData => {
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
 * Deactivates the current session.
 *
 * @returns {Promise}
 */
function deactivateSession(recursive_depth = 0) {
    // prepare query string for API call
    const _baseUri = _configuration.getBaseUri();

    const _pathUrl = 'DeactivateSession';
    const _queryBuilder = `${_baseUri}${_session_subPath}${_pathUrl}`;

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
                        this.deactivateSession(1).then(moreData => {
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
 * Registers a new session with the provided session information.
 *
 * @param {SessionDTO} sessionDTO (optional) The provided session information.
 *
 * @returns {Promise}
 */
function createSession(sessionDTO, recursive_depth = 0) {
    // prepare query string for API call
    const _baseUri = _configuration.getBaseUri();

    const _pathUrl = 'CreateSession';
    const _queryBuilder = `${_baseUri}${_session_subPath}${_pathUrl}`;

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
        body: _apiHelper.jsonSerialize(sessionDTO),
    };

    // build the response processing.
    return new Promise((_fulfill, _reject) => {
        _request(_options, (_error, _response, _context) => {
            if (_response.statusCode >= 200 && _response.statusCode <= 206) {
                let parsed = JSON.parse(_response.body);
                parsed = _baseController.getObjectMapper().mapObject(parsed, 'SessionDTO');
                _fulfill(parsed);
            } else {
                _baseController.validateResponse(_context).then((retryData) => {
                    if (retryData.error.errorMessage === "Access token regenarated" && recursive_depth === 0) {
                        this.createSession(sessionDTO, 1).then(moreData => {
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
class SessionController {
}
module.exports = SessionController;
