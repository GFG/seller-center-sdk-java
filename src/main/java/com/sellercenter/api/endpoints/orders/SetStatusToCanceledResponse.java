package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.core.response.ConcreteResponse;
import com.sellercenter.api.core.response.SuccessResponse;

public class SetStatusToCanceledResponse extends ConcreteResponse {

    /**
     * @inheritDoc
     */
    public SetStatusToCanceledResponse(SuccessResponse successResponse) {
        super(successResponse);
    }
}
