package com.philips.ai.models;

public class SessionDTOBuilder {
    //the instance to build
    private SessionDTO sessionDTO;

    /**
     * Default constructor to initialize the instance
     */
    public SessionDTOBuilder() {
        sessionDTO = new SessionDTO();
    }

    /**
     * The session's identifier.
     */
    public SessionDTOBuilder sessionKey(String sessionKey) {
        sessionDTO.setSessionKey(sessionKey);
        return this;
    }

    /**
     * The session's dataKey. This is only used for passing data to APIs. A dataKey is never returned from APIs.
     */
    public SessionDTOBuilder dataKey(String datakey) {
        sessionDTO.setDataKey(datakey);
        return this;
    }

    /**
     * Build the instance with the given values
     */
    public SessionDTO build() {
        return sessionDTO;
    }
}
