package com.philips.ai.models;

public class TidbitDTOBuilder {
    //the instance to build
    private TidbitDTO tidbitDTO;

    /**
     * Default constructor to initialize the instance
     */
    public TidbitDTOBuilder() {
        tidbitDTO = new TidbitDTO();
    }

    /**
     * The identifier of the tidbit.
     */
    public TidbitDTOBuilder identifier(String identifier) {
        tidbitDTO.setIdentifier(identifier);
        return this;
    }

    /**
     * The detail content of the tidbit.
     */
    public TidbitDTOBuilder detail(String detail) {
        tidbitDTO.setDetail(detail);
        return this;
    }

    /**
     * The icon key of the tidbit.
     */
    public TidbitDTOBuilder icon(String icon) {
        tidbitDTO.setIcon(icon);
        return this;
    }

    /**
     * The video key of the tidbit.
     */
    public TidbitDTOBuilder video(String video) {
        tidbitDTO.setVideo(video);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public TidbitDTO build() {
        return tidbitDTO;
    }
}
