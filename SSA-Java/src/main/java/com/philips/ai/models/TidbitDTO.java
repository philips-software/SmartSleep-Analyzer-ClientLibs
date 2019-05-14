package com.philips.ai.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class TidbitDTO 
        implements java.io.Serializable {
    private static final long serialVersionUID = 8488748314405331303L;
    private String identifier;
    private String detail;
    private String icon;
    private String video;
    /** GETTER
     * The identifier of the tidbit.
     */
    @JsonGetter("identifier")
    public String getIdentifier ( ) { 
        return this.identifier;
    }
    
    /** SETTER
     * The identifier of the tidbit.
     */
    @JsonSetter("identifier")
    public void setIdentifier (String value) { 
        this.identifier = value;
    }
 
    /** GETTER
     * The detail content of the tidbit.
     */
    @JsonGetter("detail")
    public String getDetail ( ) { 
        return this.detail;
    }
    
    /** SETTER
     * The detail content of the tidbit.
     */
    @JsonSetter("detail")
    public void setDetail (String value) { 
        this.detail = value;
    }
 
    /** GETTER
     * The icon key of the tidbit.
     */
    @JsonGetter("icon")
    public String getIcon ( ) { 
        return this.icon;
    }
    
    /** SETTER
     * The icon key of the tidbit.
     */
    @JsonSetter("icon")
    public void setIcon (String value) { 
        this.icon = value;
    }
 
    /** GETTER
     * The video key of the tidbit.
     */
    @JsonGetter("video")
    public String getVideo ( ) { 
        return this.video;
    }
    
    /** SETTER
     * The video key of the tidbit.
     */
    @JsonSetter("video")
    public void setVideo (String value) { 
        this.video = value;
    }
 
}
