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
public class QuestionsDTO 
        implements java.io.Serializable {
    private String sessionId;
    private static final long serialVersionUID = -3630553986588012868L;
    private LinkedHashMap<String, Object> answersTemplate;
    private String heading;
    private List<QuestionDTO> questions;
    private UpdateSurveyStateRequestDTO updateAnswersTemplate;

    /** GETTER
     * Session id associated with the survey interaction.
     */
    @JsonGetter("sessionId")
    public String getSessionId ( ) {
        return this.sessionId;
    }

    /** SETTER
     * Session id associated with the survey interaction.
     */
    @JsonSetter("sessionId")
    public void setSessionId (String value) {
        this.sessionId = value;
    }

    /** GETTER
     * An answer template for populating, and submitting answers with.
     */
    @JsonGetter("answersTemplate")
    public LinkedHashMap<String, Object> getAnswersTemplate ( ) { 
        return this.answersTemplate;
    }
    
    /** SETTER
     * An answer template for populating, and submitting answers with.
     */
    @JsonSetter("answersTemplate")
    public void setAnswersTemplate (LinkedHashMap<String, Object> value) { 
        this.answersTemplate = value;
    }
 
    /** GETTER
     * The heading for a set of QuestionDTOs
     */
    @JsonGetter("heading")
    public String getHeading ( ) { 
        return this.heading;
    }
    
    /** SETTER
     * The heading for a set of QuestionDTOs
     */
    @JsonSetter("heading")
    public void setHeading (String value) { 
        this.heading = value;
    }
 
    /** GETTER
     * The QuestionDTO items requested.
     */
    @JsonGetter("questions")
    public List<QuestionDTO> getQuestions ( ) { 
        return this.questions;
    }
    
    /** SETTER
     * The QuestionDTO items requested.
     */
    @JsonSetter("questions")
    public void setQuestions (List<QuestionDTO> value) { 
        this.questions = value;
    }
 
    /** GETTER
     * Contains the information necessary to perform a survey update.
     */
    @JsonGetter("updateAnswersTemplate")
    public UpdateSurveyStateRequestDTO getUpdateAnswersTemplate ( ) { 
        return this.updateAnswersTemplate;
    }
    
    /** SETTER
     * Contains the information necessary to perform a survey update.
     */
    @JsonSetter("updateAnswersTemplate")
    public void setUpdateAnswersTemplate (UpdateSurveyStateRequestDTO value) { 
        this.updateAnswersTemplate = value;
    }
}
