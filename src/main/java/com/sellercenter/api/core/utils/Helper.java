package com.sellercenter.api.core.utils;

import java.util.List;

public class Helper {

    public static String toParam(List<String> list) {
        return "[" + String.join(",", list)+ "]";
    }

}
