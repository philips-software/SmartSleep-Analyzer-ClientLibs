/*
 * SmartSleepAnalyzer
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.philips.ai.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class UpdateSurveyStateRequestDTO 
        implements java.io.Serializable {
    private static final long serialVersionUID = -824016429199524313L;
    private String stepRef;
    private LinkedHashMap<String, Object> answers;
    /** GETTER
     * The identifier of the step on which the update was performed. Provided answers must correspond to the question on
     * this step.
     */
    @JsonGetter("stepRef")
    public String getStepRef ( ) { 
        return this.stepRef;
    }
    
    /** SETTER
     * The identifier of the step on which the update was performed. Provided answers must correspond to the question on
     * this step.
     */
    @JsonSetter("stepRef")
    public void setStepRef (String value) { 
        this.stepRef = value;
    }
 
    /** GETTER
     * Map of answers for the question on the referenced step. Answers are keyed by question identifier.
     */
    @JsonGetter("answers")
    public LinkedHashMap<String, Object> getAnswers ( ) { 
        return this.answers;
    }
    
    /** SETTER
     * Map of answers for the question on the referenced step. Answers are keyed by question identifier.
     */
    @JsonSetter("answers")
    public void setAnswers (LinkedHashMap<String, Object> value) { 
        this.answers = value;
    }
 
}
