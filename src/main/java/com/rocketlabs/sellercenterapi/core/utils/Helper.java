package com.rocketlabs.sellercenterapi.core.utils;

public class Helper {

    /**
     * Convert a list of parameters into a suitable parameter
     *
     * @param param list of the items of the parameter
     * @return API compliant string
     */
    public static String toParam(Iterable<String> param) {
        return "[" + String.join(",", param) + "]";
    }

}
