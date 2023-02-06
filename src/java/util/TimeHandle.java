/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Admin
 */
public class TimeHandle {

    public static int timeDiff(Date d) {
        java.util.Date date = Calendar.getInstance().getTime();
//        Date startTime = new java.sql.Date(date.getTime());
        Date current = new java.sql.Date(date.getTime());
        long difference = current.getTime() - d.getTime();
        long differenceDays = difference / (24 * 60 * 60 * 1000);
        return (int) differenceDays;
    }
}
