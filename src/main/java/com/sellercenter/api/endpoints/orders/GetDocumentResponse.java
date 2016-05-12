package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.core.response.ConcreteResponse;
import com.sellercenter.api.core.response.SuccessResponse;

public class GetDocumentResponse extends ConcreteResponse {

    /**
     * @inheritDoc
     */
    public GetDocumentResponse(SuccessResponse successResponse) {
        super(successResponse);
    }
}
