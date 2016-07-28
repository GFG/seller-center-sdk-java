package com.rocketlabs.sellercenterapi.entities;

import com.rocketlabs.sellercenterapi.core.response.SuccessResponse;

public final class Document extends AbstractModel {

    /**
     * Constructor
     *
     * @param response response from API
     */
    Document(SuccessResponse response) {
        super(response.getBody().getJsonObject("Document"));
    }

    public String getFile() {
        return getString("File");
    }

    public String getDocumentType() {
        return getString("DocumentType");
    }

    public String getMimeType() {
        return getString("MimeType");
    }
}
