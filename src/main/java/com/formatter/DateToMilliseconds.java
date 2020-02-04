package com.formatter;

import java.text.ParseException;
import java.util.Date;

public class DateToMilliseconds {

        public static int totalDay(String date1,String date2) throws ParseException {
            Date currentDate1 = StringDateFormat.parsingDate(date1);
            Date currentDate2 = StringDateFormat.parsingDate(date2);
            Long offset = currentDate2.getTime() - currentDate1.getTime();
            int totalDays = Math.round(offset / 1000 / 60 / 60 / 24);
            return totalDays;
        }
}
