package com.philips.ai.models;

public class SenseDependencyDTOBuilder {
    //the instance to build
    private SenseDependencyDTO senseDependencyDTO;

    /**
     * Default constructor to initialize the instance
     */
    public SenseDependencyDTOBuilder() {
        senseDependencyDTO = new SenseDependencyDTO();
    }

    /**
     * The id of the sense dependency.
     */
    public SenseDependencyDTOBuilder senseId(String senseId) {
        senseDependencyDTO.setSenseId(senseId);
        return this;
    }

    /**
     * Indicates whether the sense dependency is required.
     */
    public SenseDependencyDTOBuilder required(Boolean required) {
        senseDependencyDTO.setRequired(required);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public SenseDependencyDTO build() {
        return senseDependencyDTO;
    }
}
