package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.core.response.ConcreteResponse;
import com.sellercenter.api.core.response.SuccessResponse;

public class SetStatusToPackedByMarketplaceResponse extends ConcreteResponse {

    /**
     * @inheritDoc
     */
    public SetStatusToPackedByMarketplaceResponse(SuccessResponse successResponse) {
        super(successResponse);
    }
}
