package com.brij;

import org.joda.time.DateTime;

import java.util.Date;


public class Module1 {
    public Date getCurrentDate() {
        Utility utility = new Utility();
        return utility.getCurrentDate();
    }
}
