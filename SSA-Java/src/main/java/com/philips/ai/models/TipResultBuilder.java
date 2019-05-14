package com.philips.ai.models;

public class TipResultBuilder {
    //the instance to build
    private TipResult tipResult;

    /**
     * Default constructor to initialize the instance
     */
    public TipResultBuilder() {
        tipResult = new TipResult();
    }

    public TipResultBuilder identifier(String identifier) {
        tipResult.setIdentifier(identifier);
        return this;
    }

    public TipResultBuilder title(String title) {
        tipResult.setTitle(title);
        return this;
    }

    public TipResultBuilder detail(String detail) {
        tipResult.setDetail(detail);
        return this;
    }

    public TipResultBuilder icon(String icon) {
        tipResult.setIcon(icon);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public TipResult build() {
        return tipResult;
    }
}
