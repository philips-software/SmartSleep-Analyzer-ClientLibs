package com.philips.ai.models;

public class SectionStateDTOBuilder {
    //the instance to build
    private SectionStateDTO sectionStateDTO;

    /**
     * Default constructor to initialize the instance
     */
    public SectionStateDTOBuilder() {
        sectionStateDTO = new SectionStateDTO();
    }

    /**
     * The identifier of the section.
     */
    public SectionStateDTOBuilder identifier(String identifier) {
        sectionStateDTO.setIdentifier(identifier);
        return this;
    }

    /**
     * The displayable name of the section.
     */
    public SectionStateDTOBuilder name(String name) {
        sectionStateDTO.setName(name);
        return this;
    }

    /**
     * The number of steps completed within the section.
     */
    public SectionStateDTOBuilder stepsCompleted(Integer stepsCompleted) {
        sectionStateDTO.setStepsCompleted(stepsCompleted);
        return this;
    }

    /**
     * A worst-case estimate of steps remaining in the section. The actual number could be less if the end-user makes choices
     * which skip steps. It could not be more.
     */
    public SectionStateDTOBuilder stepsRemaining(Integer stepsRemaining) {
        sectionStateDTO.setStepsRemaining(stepsRemaining);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public SectionStateDTO build() {
        return sectionStateDTO;
    }
}
