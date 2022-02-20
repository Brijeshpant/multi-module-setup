package com.brij;

import org.joda.time.DateTime;
import org.joda.time.Period;

import java.util.Date;

public class Utility {

    public  Date getCurrentDate() {
        return new Date();
    }

    public  DateTime getJodaDateTime() {
        DateTime dt = new DateTime();
        return dt.plus(Period.days(1));
    }
}
