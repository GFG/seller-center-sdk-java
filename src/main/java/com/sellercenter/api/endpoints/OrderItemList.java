package com.sellercenter.api.endpoints;

import com.sellercenter.api.core.Client;
import com.sellercenter.api.core.request.Request;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.core.utils.Helper;
import com.sellercenter.api.exceptions.SdkException;

import java.util.*;

public final class OrderItemList extends AbstractModel implements Iterable<OrderItem>{
    private List<OrderItem> items = new ArrayList<OrderItem>();
    private List<String> ids = new LinkedList<String>();

    /**
     *
     * @param ids List of oder items to be processed
     */
    public OrderItemList(List<String> ids) {
        super(null);
        this.ids.addAll(ids);
        for(String id : ids) {
            items.add(new OrderItem(id));
        }
    }

    OrderItemList(SuccessResponse response) {
        super(response);

        Object items = ((Map<String, Object>) response.getBody().get("OrderItems")).get("OrderItem");
        if (items instanceof List) {
            for(Object item : (List) items) {
                if (item instanceof Map) {
                    this.items.add(new OrderItem(response, (Map<String, Object>) item));
                }
            }
        } else if (items instanceof Map) {
            this.items.add(new OrderItem(response, (Map<String, Object>) items));
        }
    }

    /**
     * @throws SdkException
     */
    public void setStatusToPackedByMarketplace() throws SdkException {
        throw new SdkException("Not Implemented yet ...");
    }

    /**
     * @throws SdkException
     */
    public void setStatusToReadyToShip() throws SdkException {
        throw new SdkException("Not Implemented yet ...");
    }

    public Document getDocument(String documentType) throws SdkException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("OrderItemIds", Helper.toParam(ids));
        params.put("DocumentType", documentType);

        SuccessResponse response = Client.call(
                new Request("GetDocument", SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version, params)
        );

        return new Document(response);


    }


        /*
    Not sure if those methods should be ever implemented

    They do no exists in the API so we would have to multiply them on every order of the collection
    without the user being aware of the complexity/load
     */
//    public void setStatusToFailedDelivery() throws SdkException {
//        throw new SdkException("Not Implemented yet ...");
//    }

//    public void setStatusToCanceled(String reason, String reasonDetail) throws SdkException {
//        throw new SdkException("Not Implemented yet ...");
//    }

//    public void setStatusToDelivered() throws SdkException {
//        throw new SdkException("Not Implemented yet ...");
//    }

//        public void setStatusToShipped() throws SdkException {
//        throw new SdkException("Not Implemented yet ...");
//    }

    public Iterator<OrderItem> iterator() {
        return items.iterator();
    }
}
