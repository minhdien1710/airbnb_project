package com.formatter;

import java.text.ParseException;
import java.util.Date;

public class BooleanDate {
    public static boolean afterBefore(String d1,String d2) throws ParseException {
        Date date1 = StringDateFormat.parsingDate(d1);
        Date date2 = StringDateFormat.parsingDate(d2);
        boolean before = date1.before(date2);
        boolean after = date2.after(date1);
        if (before && after) {
            return true;
        }
        return false;
    }
}
