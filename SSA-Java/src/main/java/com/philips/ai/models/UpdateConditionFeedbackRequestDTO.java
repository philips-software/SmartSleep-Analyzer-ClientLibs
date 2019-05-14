package com.philips.ai.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class UpdateConditionFeedbackRequestDTO 
        implements java.io.Serializable {
    private static final long serialVersionUID = 3728695046914839036L;
    private String conditionIdentifier;
    private Boolean answer;
    /** GETTER
     * The identifier of the condition.
     */
    @JsonGetter("conditionIdentifier")
    public String getConditionIdentifier ( ) { 
        return this.conditionIdentifier;
    }
    
    /** SETTER
     * The identifier of the condition.
     */
    @JsonSetter("conditionIdentifier")
    public void setConditionIdentifier (String value) { 
        this.conditionIdentifier = value;
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
