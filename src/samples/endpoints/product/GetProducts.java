package endpoints.product;

import com.sellercenter.api.endpoints.ProductList;
import com.sellercenter.api.endpoints.SellerCenter;
import com.sellercenter.api.endpoints.GetProductsOptions;
import com.sellercenter.api.endpoints.Product;

public class GetProducts {

    public static void main(String[] args)
            throws Exception {

        /**
         * Runtime configuration
         */
        SellerCenter.apiKey = "11bbf504d7bb6a5e9c30baa9f0908e3b9ee5f514";
        SellerCenter.userId = "remy.rey@rocket-internet.com";
        SellerCenter.url = "https://rocket:rock4me@sellercenter-api-lazada-th.sellercenter.net/";

        /**
         * Call the API
         */
        GetProductsOptions opt = new GetProductsOptions();
        opt.setLimit(2).addSku("7878");
        ProductList products = SellerCenter.getProducts(opt);

        /**
         * Pretty print the response
         */
        System.out.println("Success !");
        System.out.println();
        System.out.println("Products :");
        for (Product p : products) {
            System.out.println("    " + p.getName());
            System.out.println("        sku :" + p.getSellerSku());
            System.out.println("        id :" + p.getMainImage());
            System.out.println("        price :" + p.getPrice());
        }
    }
}
