package com.sellercenter.api.core.request;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class TimestampFormatter {

    /**
     * Return timestamp of a given date,
     * of the current date if null is provided
     *
     * @param time the date
     * @return a string representing the date in the correct format.
     */
    public String getTimestamp(Date time) {
        Date now = null == time ? new Date() : time;
        final TimeZone tz = TimeZone.getTimeZone("UTC");
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmX");
        df.setTimeZone(tz);
        return df.format(now);
    }
}
