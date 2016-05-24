package com.sellercenter.api.endpoints.orders;

import com.sellercenter.api.core.request.Get;
import com.sellercenter.api.core.utils.Helper;

import java.util.List;

public class GetDocumentRequest extends Get {

    /**
     * Constructor
     *
     * @param userId The ID of the user making the call.
     * @param apiKey The API key of the user specified in the UserID parameter.
     * @param version The API version against which this call is to be executed, in major-dot-minor format.
     * @param docType One of 'invoice', 'shippingLabel' or 'shippingParcel' or 'carrierManifest'
     * @param orderItemIds List of the order items for which the caller is wanting to get a document
     */
    public GetDocumentRequest(String userId, String apiKey, String version, String docType,  List<Integer> orderItemIds) {
        super(userId, apiKey, version);
        addParam("Action", "GetDocument");
        addParam("DocumentType", docType);
        addParam("OrderItemIds", Helper.toParam(orderItemIds));
    }
}
