package com.philips.ai.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class SurveyStateDTO 
        implements java.io.Serializable {
    private static final long serialVersionUID = 6024451561844274529L;
    private String sessionId;
    private List<SectionStateDTO> sectionStates;
    private List<StepStateDTO> steps;
    private String currentStepRef;
    private Integer stepsRemaining;
    private Boolean finished;
    private List<QuestionDTO> questions;
    private LinkedHashMap<String, Object> answers;
    
    /** GETTER
     * Session id associate with the user survey interaction.
     */
    @JsonGetter("sessionId")
    public String getSessionId ( ) { 
        return this.sessionId;
    }
    
    /** SETTER
     * Session id associate with the user survey interaction.
     */
    @JsonSetter("sessionId")
    public void setSessionId (String value) { 
        this.sessionId = value;
    }

    /** GETTER
     * List of all sections relevant to the survey based on its state.
     */
    @JsonGetter("sectionStates")
    public List<SectionStateDTO> getSectionStates ( ) { 
        return this.sectionStates;
    }
    
    /** SETTER
     * List of all sections relevant to the survey based on its state.
     */
    @JsonSetter("sectionStates")
    public void setSectionStates (List<SectionStateDTO> value) { 
        this.sectionStates = value;
    }
 
    /** GETTER
     * List of all steps through which the session has navigated, up to the current step. When returned for an update, this
     * will contain only steps following the step for which the update was performed.
     */
    @JsonGetter("steps")
    public List<StepStateDTO> getSteps ( ) { 
        return this.steps;
    }
    
    /** SETTER
     * List of all steps through which the session has navigated, up to the current step. When returned for an update, this
     * will contain only steps following the step for which the update was performed.
     */
    @JsonSetter("steps")
    public void setSteps (List<StepStateDTO> value) { 
        this.steps = value;
    }
 
    /** GETTER
     * The identifier of the current step (the step the session must complete to proceed).
     */
    @JsonGetter("currentStepRef")
    public String getCurrentStepRef ( ) { 
        return this.currentStepRef;
    }
    
    /** SETTER
     * The identifier of the current step (the step the session must complete to proceed).
     */
    @JsonSetter("currentStepRef")
    public void setCurrentStepRef (String value) { 
        this.currentStepRef = value;
    }
 
    /** GETTER
     * An estimate of how many steps are remaining in the survey. This is a worst-case estimate, and will generally
     * shorten as the end-user makes choices which skip subsequent parts of the survey.
     */
    @JsonGetter("stepsRemaining")
    public Integer getStepsRemaining ( ) { 
        return this.stepsRemaining;
    }
    
    /** SETTER
     * An estimate of how many steps are remaining in the survey. This is a worst-case estimate, and will generally
     * shorten as the end-user makes choices which skip subsequent parts of the survey.
     */
    @JsonSetter("stepsRemaining")
    public void setStepsRemaining (Integer value) { 
        this.stepsRemaining = value;
    }
 
    /** GETTER
     * Indicates whether the session has finished the survey.
     */
    @JsonGetter("finished")
    public Boolean getFinished ( ) { 
        return this.finished;
    }
    
    /** SETTER
     * Indicates whether the session has finished the survey.
     */
    @JsonSetter("finished")
    public void setFinished (Boolean value) { 
        this.finished = value;
    }
 
    /** GETTER
     * List of all questions used by the survey. Only populated on survey state calls. Empty for update calls.
     */
    @JsonGetter("questions")
    public List<QuestionDTO> getQuestions ( ) { 
        return this.questions;
    }
    
    /** SETTER
     * List of all questions used by the survey. Only populated on survey state calls. Empty for update calls.
     */
    @JsonSetter("questions")
    public void setQuestions (List<QuestionDTO> value) { 
        this.questions = value;
    }
 
    /** GETTER
     * Map of all the session's answers, up to the end of the path for which the session can navigate to without performing
     * updates.
     */
    @JsonGetter("answers")
    public LinkedHashMap<String, Object> getAnswers ( ) { 
        return this.answers;
    }
    
    /** SETTER
     * Map of all the session's answers, up to the end of the path for which the session can navigate to without performing
     * updates.
     */
    @JsonSetter("answers")
    public void setAnswers (LinkedHashMap<String, Object> value) { 
        this.answers = value;
    }
}
