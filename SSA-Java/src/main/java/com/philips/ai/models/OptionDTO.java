package com.philips.ai.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class OptionDTO 
        implements java.io.Serializable {
    private static final long serialVersionUID = -2066442595058891919L;
    private String key;
    private String label;
    /** GETTER
     * The unique (within the options of the question) option id.
     */
    @JsonGetter("key")
    public String getKey ( ) { 
        return this.key;
    }
    
    /** SETTER
     * The unique (within the options of the question) option id.
     */
    @JsonSetter("key")
    public void setKey (String value) { 
        this.key = value;
    }
 
    /** GETTER
     * The displayable option label.
     */
    @JsonGetter("label")
    public String getLabel ( ) { 
        return this.label;
    }
    
    /** SETTER
     * The displayable option label.
     */
    @JsonSetter("label")
    public void setLabel (String value) { 
        this.label = value;
    }
 
}
