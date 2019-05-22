package com.philips.ai.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class ResultDTO 
        implements java.io.Serializable {
    private static final long serialVersionUID = 6086191347139997276L;
    private String sessionId;
    private List<ConditionDTO> conditions;
    private List<TipDTO> tips;
    private List<TidbitDTO> tidbits;
    private LinkedHashMap<String, Object> calculations;
    private LinkedHashMap<String, Object> senseValues;
    
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
     * The conditions identified for the session.
     */
    @JsonGetter("conditions")
    public List<ConditionDTO> getConditions ( ) { 
        return this.conditions;
    }
    
    /** SETTER
     * The conditions identified for the session.
     */
    @JsonSetter("conditions")
    public void setConditions (List<ConditionDTO> value) { 
        this.conditions = value;
    }
 
    /** GETTER
     * The tips identified for the session.
     */
    @JsonGetter("tips")
    public List<TipDTO> getTips ( ) { 
        return this.tips;
    }
    
    /** SETTER
     * The tips identified for the session.
     */
    @JsonSetter("tips")
    public void setTips (List<TipDTO> value) { 
        this.tips = value;
    }
 
    /** GETTER
     * The tidbits identified for the session.
     */
    @JsonGetter("tidbits")
    public List<TidbitDTO> getTidbits ( ) { 
        return this.tidbits;
    }
    
    /** SETTER
     * The tidbits identified for the session.
     */
    @JsonSetter("tidbits")
    public void setTidbits (List<TidbitDTO> value) { 
        this.tidbits = value;
    }
 
    /** GETTER
     * Custom calculations that can be used by the client.
     */
    @JsonGetter("calculations")
    public LinkedHashMap<String, Object> getCalculations ( ) { 
        return this.calculations;
    }
    
    /** SETTER
     * Custom calculations that can be used by the client.
     */
    @JsonSetter("calculations")
    public void setCalculations (LinkedHashMap<String, Object> value) { 
        this.calculations = value;
    }
 
    /** GETTER
     * The sense values used to generate the result. This is only returned in Development environments.
     */
    @JsonGetter("senseValues")
    public LinkedHashMap<String, Object> getSenseValues ( ) { 
        return this.senseValues;
    }
    
    /** SETTER
     * The sense values used to generate the result. This is only returned in Development environments.
     */
    @JsonSetter("senseValues")
    public void setSenseValues (LinkedHashMap<String, Object> value) { 
        this.senseValues = value;
    }
 
}
