package com.sellercenter.api;

import com.sellercenter.api.endpoints.Feeds;
import com.sellercenter.api.endpoints.Orders;

public class SellerCenter {

    /**
     * The URL of the Seller Center API
     */
    public static String Url;

    /**
     * The API key of the User
     */
    public static String ApiKey;

    /**
     * The ID of the User
     */
    public static String UserId;

    /**
     * The Version of the API
     * A default version is specified in Config class 
     */
    public static String Version;

    /**
     * Access to the the feeds endpoint
     * @return empty instance of Feeds to access static method
     */
    public static Feeds Feeds() {
        return null;
    }

    /**
     * Access to the the orders endpoint
     * @return empty instance to access static method
     */
    public static Orders Orders() {
        return null;
    }

    /**
     * Get the API key from the config or from this class (priority to this class)
     * @return
     */
    protected static String getApiKey() {
        return (null == ApiKey) ? Config.API_KEY : ApiKey;
    }

    /**
     * Get the user id from the config or from this class (priority to this class)
     * @return
     */
    protected static String getUserId() {
        return (null == UserId) ? Config.USER_ID : UserId;
    }

    /**
     * Get the API version from the config or from this class (priority to this class)
     * @return
     */
    protected static String getVersion() {
        return (null == Version) ? Config.VERSION : Version;
    }

    /**
     * Get the url from the config or from this class (priority to this class)
     * @return
     */
    protected static String getUrl() {
        return (null == Url) ? Config.URL : Url;
    }
}
