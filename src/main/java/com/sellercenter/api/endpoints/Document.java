package com.sellercenter.api.endpoints;

import com.sellercenter.api.core.response.SuccessResponse;

public class Document extends AbstractModel {

    Document(SuccessResponse res) {
        super(res);
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
