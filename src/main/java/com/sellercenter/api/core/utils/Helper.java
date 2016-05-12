package com.sellercenter.api.core.utils;

import java.util.List;

public class Helper {

    public static String toParam(List<? extends Object> list) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (Object o: list) {
            if (o instanceof Integer) builder.append(o).append(",");
            else if (o instanceof String) builder.append("\"").append(o).append("\"").append(",");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append("]");
        return builder.toString();
    }

}
