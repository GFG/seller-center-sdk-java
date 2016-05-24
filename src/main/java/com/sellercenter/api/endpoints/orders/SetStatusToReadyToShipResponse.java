package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.core.response.ConcreteResponse;
import com.sellercenter.api.core.response.SuccessResponse;

public class SetStatusToReadyToShipResponse extends ConcreteResponse {

    /**
     * @inheritDoc
     */
    public SetStatusToReadyToShipResponse(SuccessResponse successResponse) {
        super(successResponse);
    }
}
