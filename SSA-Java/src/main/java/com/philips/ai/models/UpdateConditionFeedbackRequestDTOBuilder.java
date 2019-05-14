package com.philips.ai.models;

public class UpdateConditionFeedbackRequestDTOBuilder {
    //the instance to build
    private UpdateConditionFeedbackRequestDTO updateConditionFeedbackRequestDTO;

    /**
     * Default constructor to initialize the instance
     */
    public UpdateConditionFeedbackRequestDTOBuilder() {
        updateConditionFeedbackRequestDTO = new UpdateConditionFeedbackRequestDTO();
    }

    /**
     * The identifier of the condition.
     */
    public UpdateConditionFeedbackRequestDTOBuilder conditionIdentifier(String conditionIdentifier) {
        updateConditionFeedbackRequestDTO.setConditionIdentifier(conditionIdentifier);
        return this;
    }

    /**
     * The feedback answer.
     */
    public UpdateConditionFeedbackRequestDTOBuilder answer(Boolean answer) {
        updateConditionFeedbackRequestDTO.setAnswer(answer);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public UpdateConditionFeedbackRequestDTO build() {
        return updateConditionFeedbackRequestDTO;
    }
}
