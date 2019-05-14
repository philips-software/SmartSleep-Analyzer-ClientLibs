package com.philips.ai.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class TipDTO 
        implements java.io.Serializable {
    private static final long serialVersionUID = 2300299629487746412L;
    private String identifier;
    private String title;
    private String detail;
    private String icon;
    private Boolean tipFeedback;
    /** GETTER
     * The identifier of the tip.
     */
    @JsonGetter("identifier")
    public String getIdentifier ( ) { 
        return this.identifier;
    }
    
    /** SETTER
     * The identifier of the tip.
     */
    @JsonSetter("identifier")
    public void setIdentifier (String value) { 
        this.identifier = value;
    }
 
    /** GETTER
     * The title of the tip.
     */
    @JsonGetter("title")
    public String getTitle ( ) { 
        return this.title;
    }
    
    /** SETTER
     * The title of the tip.
     */
    @JsonSetter("title")
    public void setTitle (String value) { 
        this.title = value;
    }
 
    /** GETTER
     * The detail content of the tip.
     */
    @JsonGetter("detail")
    public String getDetail ( ) { 
        return this.detail;
    }
    
    /** SETTER
     * The detail content of the tip.
     */
    @JsonSetter("detail")
    public void setDetail (String value) { 
        this.detail = value;
    }
 
    /** GETTER
     * The icon key of the tip.
     */
    @JsonGetter("icon")
    public String getIcon ( ) { 
        return this.icon;
    }
    
    /** SETTER
     * The icon key of the tip.
     */
    @JsonSetter("icon")
    public void setIcon (String value) { 
        this.icon = value;
    }
 
    /** GETTER
     * Indicates whether an end-user is likely or unlikely to follow the tip, or null if no feedback was provided.
     */
    @JsonGetter("tipFeedback")
    public Boolean getSessionFeedback ( ) {
        return this.tipFeedback;
    }
    
    /** SETTER
     * Indicates whether an end-user is likely or unlikely to follow the tip, or null if no feedback was provided.
     */
    @JsonSetter("tipFeedback")
    public void setUserFeedback (Boolean value) { 
        this.tipFeedback = value;
    }
 
}
