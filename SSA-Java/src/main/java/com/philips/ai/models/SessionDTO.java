package com.philips.ai.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)		
public class SessionDTO
        implements java.io.Serializable {
    private static final long serialVersionUID = -2676831697227881610L;
    private String sessionKey;
    private String dataKey;

    /** GETTER
     * The session identifier.
     */
    @JsonGetter("sessionKey")
    public String getSessionKey( ) {
        return this.sessionKey;
    }
    
    /** SETTER
     * The session identifier.
     */
    @JsonSetter("sessionKey")
    public void setSessionKey(String value) {
        this.sessionKey = value;
    }

    /** GETTER
     * The session's dataKey. This is only used for passing data to APIs. A dataKey is never returned from APIs.
     */
    @JsonGetter("dataKey")
    public String getDataKey( ) {
        return this.dataKey;
    }
    
    /** SETTER
     * The session's dataKey. This is only used for passing data to APIs. A dataKey is never returned from APIs.
     */
    @JsonSetter("dataKey")
    public void setDataKey(String value) {
        this.dataKey = value;
    }
}
