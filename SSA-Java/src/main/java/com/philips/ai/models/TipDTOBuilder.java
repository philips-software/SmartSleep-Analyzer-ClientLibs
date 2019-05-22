package com.philips.ai.models;

public class TipDTOBuilder {
    //the instance to build
    private TipDTO tipDTO;

    /**
     * Default constructor to initialize the instance
     */
    public TipDTOBuilder() {
        tipDTO = new TipDTO();
    }

    /**
     * The identifier of the tip.
     */
    public TipDTOBuilder identifier(String identifier) {
        tipDTO.setIdentifier(identifier);
        return this;
    }

    /**
     * The title of the tip.
     */
    public TipDTOBuilder title(String title) {
        tipDTO.setTitle(title);
        return this;
    }

    /**
     * The detail content of the tip.
     */
    public TipDTOBuilder detail(String detail) {
        tipDTO.setDetail(detail);
        return this;
    }

    /**
     * The icon key of the tip.
     */
    public TipDTOBuilder icon(String icon) {
        tipDTO.setIcon(icon);
        return this;
    }

    /**
     * Indicates whether an end-user is likely or unlikely to follow the tip, or null if no feedback was provided.
     */
    public TipDTOBuilder tipFeedback(Boolean tipFeedback) {
        tipDTO.setTipFeedback(tipFeedback);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public TipDTO build() {
        return tipDTO;
    }
}
