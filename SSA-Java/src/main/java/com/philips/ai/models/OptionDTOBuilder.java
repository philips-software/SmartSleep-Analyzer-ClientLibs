package com.philips.ai.models;

public class OptionDTOBuilder {
    //the instance to build
    private OptionDTO optionDTO;

    /**
     * Default constructor to initialize the instance
     */
    public OptionDTOBuilder() {
        optionDTO = new OptionDTO();
    }

    /**
     * The unique (within the options of the question) option id.
     */
    public OptionDTOBuilder key(String key) {
        optionDTO.setKey(key);
        return this;
    }

    /**
     * The displayable option label.
     */
    public OptionDTOBuilder label(String label) {
        optionDTO.setLabel(label);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public OptionDTO build() {
        return optionDTO;
    }
}
