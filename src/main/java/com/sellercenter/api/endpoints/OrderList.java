package com.sellercenter.api.endpoints;

import com.sellercenter.api.core.Client;
import com.sellercenter.api.core.request.Request;
import com.sellercenter.api.core.response.SuccessResponse;
import com.sellercenter.api.core.utils.Helper;
import com.sellercenter.api.exceptions.SdkException;

import java.util.*;

public final class OrderList extends AbstractModel implements Iterable<Order> {
    private List<Order> orders = new LinkedList<Order>();
    private List<String> ids = new LinkedList<String>();

    /**
     *
     * @param ids List of oder items to be processed
     */
    public OrderList(List<String> ids) {
        super(null);
        this.ids.addAll(ids);
        for(String id : ids) {
            orders.add(new Order(id));
        }
    }

    OrderList(SuccessResponse response) {
        super(response);
        Object orders = ((Map<String, Object>) response.getBody().get("Orders")).get("Order");
        if (orders instanceof List) {
            for(Object order : (List) orders) {
                if (order instanceof Map) {
                    this.orders.add(new Order(response, (Map<String, Object>) order));
                }
            }
        } else if (orders instanceof Map) {
            this.orders.add(new Order(response, (Map<String, Object>) orders));
        }
    }

    public OrderItemList getAllItems() throws SdkException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("OrderIdList", Helper.toParam(ids));
        SuccessResponse response = Client.call(
                new Request("GetMultipleOrderItems", SellerCenter.userId, SellerCenter.apiKey, SellerCenter.version, params)
        );

        // return new OrderItemList(response); @todo make it work in OrderItemList
        return null;
    }

    public Iterator<Order> iterator() {
        return orders.iterator();
    }
}
