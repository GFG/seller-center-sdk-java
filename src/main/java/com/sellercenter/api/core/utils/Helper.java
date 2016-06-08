package com.sellercenter.api.core.utils;

import java.util.List;

public class Helper {

    /**
     * Convert a list of parameters into a suitable parameter
     *
     * @param param list of the items of the parameter
     * @return API compliant string
     */
    public static String toParam(List<String> param) {
        return "[" + String.join(",", param) + "]";
    }

}
