package com.philips.ai.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class SenseDependencyDTO 
        implements java.io.Serializable {
    private static final long serialVersionUID = -7735810115103462301L;
    private String senseId;
    private Boolean required;
    /** GETTER
     * The id of the sense dependency.
     */
    @JsonGetter("senseId")
    public String getSenseId ( ) { 
        return this.senseId;
    }
    
    /** SETTER
     * The id of the sense dependency.
     */
    @JsonSetter("senseId")
    public void setSenseId (String value) { 
        this.senseId = value;
    }
 
    /** GETTER
     * Indicates whether the sense dependency is required.
     */
    @JsonGetter("required")
    public Boolean getRequired ( ) { 
        return this.required;
    }
    
    /** SETTER
     * Indicates whether the sense dependency is required.
     */
    @JsonSetter("required")
    public void setRequired (Boolean value) { 
        this.required = value;
    }
 
}
