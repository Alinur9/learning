package com.xyz.tools;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZone {



    public ZonedDateTime getZonedDateTime(long value) {
        return Instant.ofEpochMilli(value).atZone(ZoneId.systemDefault());
    }





    public String getMatchTime(long millis) {
        ZonedDateTime date = getZonedDateTime(millis);
        ZonedDateTime time = getZonedDateTime(millis);

        return String.format("%04d-%02d-%02d", date.getYear(), date.getMonthValue(), date.getDayOfMonth()) + " " + String.format("%02d:%02d", time.getHour(), time.getMinute());
    }

}
