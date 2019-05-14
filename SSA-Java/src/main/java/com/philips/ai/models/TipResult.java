package com.philips.ai.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class TipResult 
        implements java.io.Serializable {
    private static final long serialVersionUID = -2675921969868661867L;
    private String identifier;
    private String title;
    private String detail;
    private String icon;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("identifier")
    public String getIdentifier ( ) { 
        return this.identifier;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("identifier")
    public void setIdentifier (String value) { 
        this.identifier = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("title")
    public String getTitle ( ) { 
        return this.title;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("title")
    public void setTitle (String value) { 
        this.title = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("detail")
    public String getDetail ( ) { 
        return this.detail;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("detail")
    public void setDetail (String value) { 
        this.detail = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("icon")
    public String getIcon ( ) { 
        return this.icon;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("icon")
    public void setIcon (String value) { 
        this.icon = value;
    }
 
}
