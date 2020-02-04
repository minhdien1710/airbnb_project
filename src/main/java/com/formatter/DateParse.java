package com.formatter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParse {
    public static String dateParser(Date dt, String format) {

        String formatDate = "null";

        if (format.equals("yyyy/MM/dd")) {
            formatDate = DateFormat.getDateInstance().format(dt);
            return formatDate;
        }
        if (format.equals("yyyy/MM/dd HH:mm:ss")) {
            DateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            formatDate = dFormat.format(dt);
            return formatDate;
        }



        return formatDate;

    }
}
