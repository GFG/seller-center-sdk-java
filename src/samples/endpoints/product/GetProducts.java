package endpoints.product;

import com.sellercenter.api.SellerCenter;
import com.sellercenter.api.endpoints.Products;
import com.sellercenter.api.endpoints.products.GetProductsOptions;
import com.sellercenter.api.endpoints.products.GetProductsResponse;
import com.sellercenter.api.models.Product.Product;

import java.util.LinkedList;

public class GetProducts {

    public static void main(String[] args)
            throws Exception {

        /**
         * Runtime configuration
         */
        SellerCenter.ApiKey = "11bbf504d7bb6a5e9c30baa9f0908e3b9ee5f514";
        SellerCenter.UserId = "remy.rey@rocket-internet.com";
        SellerCenter.Url = "https://rocket:rock4me@sellercenter-api-lazada-th.sellercenter.net/";

        /**
         * Call the API
         */
        GetProductsOptions opt = new GetProductsOptions();
        opt.setLimit(2).addSku("7878");
        GetProductsResponse res = Products.getProducts(opt);

        /**
         * Pretty print the response
         */
        System.out.println("Success :");
        System.out.println(">   " + res.getResponseType());
        System.out.println(">   " + res.getTimestamp());
        System.out.println();
        System.out.println("Products :");
        for (Product p : res.getProducts()) {
            System.out.println("    " + p.getName());
            System.out.println("        sku :" + p.getSellerSku());
            System.out.println("        id :" + p.getMainImage());
            System.out.println("        price :" + p.getPrice());
        }
    }
}
