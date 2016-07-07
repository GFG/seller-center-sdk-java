package com.sellercenter.api.samples.endpoints.order;

import com.sellercenter.api.entities.Reason;
import com.sellercenter.api.entities.ReasonCollection;
import com.sellercenter.api.entities.SellerCenter;
import com.sellercenter.api.samples.Config;

public class GetFailureReasons {
    public static void main(String[] args)
            throws Exception {

        /**
         * Runtime configuration
         */
        SellerCenter.apiKey = Config.apiKey;
        SellerCenter.userId = Config.userId;
        SellerCenter.url = Config.url;

        /**
         * Get Reasons
         */
        ReasonCollection reasons = SellerCenter.getFailureReasons();

        /**
         * Pretty print the response
         */
        System.out.println("Success !");

        System.out.println();
        System.out.println("Reasons: ");
        System.out.println();
        for (Reason reason : reasons) {
            System.out.println("    Reason:");
            System.out.println("    |   Name:  " + reason.getString("Name"));
            System.out.println("    |   Type:  " + reason.getString("Type"));
            System.out.println();
        }
    }
}
