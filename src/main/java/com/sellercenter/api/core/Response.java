package com.sellercenter.api.core;

import java.util.Map;

public interface Response {

    /**
     * Specify if error occured from API side
     *
     * @return True if the response is an API error reponse
     */
    boolean isError();

    /**
     * Simple getter for request action
     * @return the request action
     */
    String getRequestAction();

    /**
     * Get the body of the response, in a JSON like representation,
     * including List<Object> and primitive value Object.
     *
     * @return A map representing the content of the body
     */
    Map<String, Object> getBody();
}
