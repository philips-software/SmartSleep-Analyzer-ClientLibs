package com.philips.ai.models;

public class UpdateTipFeedbackRequestDTOBuilder {
    //the instance to build
    private UpdateTipFeedbackRequestDTO updateTipFeedbackRequestDTO;

    /**
     * Default constructor to initialize the instance
     */
    public UpdateTipFeedbackRequestDTOBuilder() {
        updateTipFeedbackRequestDTO = new UpdateTipFeedbackRequestDTO();
    }

    /**
     * The identifier of the tip.
     */
    public UpdateTipFeedbackRequestDTOBuilder tipIdentifier(String tipIdentifier) {
        updateTipFeedbackRequestDTO.setTipIdentifier(tipIdentifier);
        return this;
    }

    /**
     * The feedback answer.
     */
    public UpdateTipFeedbackRequestDTOBuilder answer(Boolean answer) {
        updateTipFeedbackRequestDTO.setAnswer(answer);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public UpdateTipFeedbackRequestDTO build() {
        return updateTipFeedbackRequestDTO;
    }
}
