package com.philips.ai.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class SectionStateDTO 
        implements java.io.Serializable {
    private static final long serialVersionUID = 134899120040832408L;
    private String identifier;
    private String name;
    private Integer stepsCompleted;
    private Integer stepsRemaining;
    /** GETTER
     * The identifier of the section.
     */
    @JsonGetter("identifier")
    public String getIdentifier ( ) { 
        return this.identifier;
    }
    
    /** SETTER
     * The identifier of the section.
     */
    @JsonSetter("identifier")
    public void setIdentifier (String value) { 
        this.identifier = value;
    }
 
    /** GETTER
     * The displayable name of the section.
     */
    @JsonGetter("name")
    public String getName ( ) { 
        return this.name;
    }
    
    /** SETTER
     * The displayable name of the section.
     */
    @JsonSetter("name")
    public void setName (String value) { 
        this.name = value;
    }
 
    /** GETTER
     * The number of steps completed within the section.
     */
    @JsonGetter("stepsCompleted")
    public Integer getStepsCompleted ( ) { 
        return this.stepsCompleted;
    }
    
    /** SETTER
     * The number of steps completed within the section.
     */
    @JsonSetter("stepsCompleted")
    public void setStepsCompleted (Integer value) { 
        this.stepsCompleted = value;
    }
 
    /** GETTER
     * A worst-case estimate of steps remaining in the section. The actual number could be less if the end-user makes choices
     * which skip steps. It could not be more.
     */
    @JsonGetter("stepsRemaining")
    public Integer getStepsRemaining ( ) { 
        return this.stepsRemaining;
    }
    
    /** SETTER
     * A worst-case estimate of steps remaining in the section. The actual number could be less if the end-user makes choices
     * which skip steps. It could not be more.
     */
    @JsonSetter("stepsRemaining")
    public void setStepsRemaining (Integer value) { 
        this.stepsRemaining = value;
    }
 
}
