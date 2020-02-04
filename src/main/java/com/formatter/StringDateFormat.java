package com.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDateFormat {
    public static Date parsingDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date result = formatter.parse(date);
        return result;
}
}
