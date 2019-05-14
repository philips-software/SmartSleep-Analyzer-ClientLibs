'use strict';

const servers = require('./Servers');
const environments = require('./Environments');
const apiHelper = require('./APIHelper');

const environmentsMap = [];

environmentsMap[environments.PRODUCTION] = [];

environmentsMap[environments.PRODUCTION][servers.MDEFAULT] = environments.defaultHost;

const Configuration = {
    /**
     * defaultHost
     * @type {string}
     */
    defaultHost: environments.defaultHost,

    /**
     * Current API environment
     * @type {string}
     */
    currentEnvironment: environments.PRODUCTION,
    /**
         * Access Token to get 
         * @type {string}
         */

    AccessToken: '',

    /**
      * Access Token URL to get 
      * @type {string}
      */

    secretkey: '',

    clientid: '',

    /**
     * Get base URI for a server in the current API environment
     * @param  {string|null} server Server name
     * @return {string}             Base URI for server
     */
    getBaseUri(server) {
        
        const url = environmentsMap[this.currentEnvironment][server || servers.MDEFAULT];
        const urlParams = {
            defaultHost: this.defaultHost,
        };
        return apiHelper.appendUrlWithTemplateParameters(url, urlParams);
    },
};

module.exports = Configuration;
