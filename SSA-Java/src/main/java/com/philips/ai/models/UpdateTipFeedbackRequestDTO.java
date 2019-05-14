package com.philips.ai.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class UpdateTipFeedbackRequestDTO 
        implements java.io.Serializable {
    private static final long serialVersionUID = 3149265988389704432L;
    private String tipIdentifier;
    private Boolean answer;
    /** GETTER
     * The identifier of the tip.
     */
    @JsonGetter("tipIdentifier")
    public String getTipIdentifier ( ) { 
        return this.tipIdentifier;
    }
    
    /** SETTER
     * The identifier of the tip.
     */
    @JsonSetter("tipIdentifier")
    public void setTipIdentifier (String value) { 
        this.tipIdentifier = value;
    }
 
    /** GETTER
     * The feedback answer.
     */
    @JsonGetter("answer")
    public Boolean getAnswer ( ) { 
        return this.answer;
    }
    
    /** SETTER
     * The feedback answer.
     */
    @JsonSetter("answer")
    public void setAnswer (Boolean value) { 
        this.answer = value;
    }
 
}
