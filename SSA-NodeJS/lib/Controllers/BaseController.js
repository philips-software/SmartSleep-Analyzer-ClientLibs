'use strict';

const _objectMapper = require('../ObjectMapper');
const _configuration = require('../configuration');
const _accessController = require('./AccessController');

const _objectMapperInstance = new _objectMapper();

class BaseController {
    /**
     * Get ObjectMapper instance
     * @return {ObjectMapper} Shared instance
     */
    static getObjectMapper() {
        return _objectMapperInstance;
    }

    /**
     * Global error handling
     * @param   {HttpContext}   _context   HttpContext containing request and response objects
     */
    static validateResponse(_context) {
        return new Promise((resolve, reject) => {
            const errorObj = {
                errorMessage: '',
                errorCode: '',
                errorResponse: _context.response.body,
            };
            const returnObj = {
                error: errorObj,
                response: null,
                context: _context,
            };

            if (_context.response.body === undefined || _context.response.body === "") {
                returnObj.error.errorMessage = '00000:Please verify the provided information is correct.';
                returnObj.error.errorCode = '00000';
                resolve(returnObj);
            }
            else if (_context.response.body.search("Access token expired") != -1) {
                _accessController.getAccessToken().then(function (success) {
                    _configuration.AccessToken = success;
                    returnObj.error.errorMessage = "Access token regenarated"
                    returnObj.error.errorCode = _context.response.statusCode;
                    resolve(returnObj);
                });

            }
            else {
                returnObj.error.errorMessage = _context.response.body;
                returnObj.error.errorCode = _context.response.statusCode;
                resolve(returnObj);
            }
        });
    }
}
module.exports = BaseController;
