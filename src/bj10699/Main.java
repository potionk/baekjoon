package bj10699;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Calendar cal=Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        String monthStr;
        if(month<10)
            monthStr="0"+month;
        else
            monthStr=month+"";
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String dayStr;
        if(day<10)
            dayStr="0"+day;
        else
            dayStr=day+"";

        System.out.println(year + "-"+ monthStr+"-"+dayStr);
    }
}