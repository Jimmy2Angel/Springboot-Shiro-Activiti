package indi.baojie.demo.supervision.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Lollipop on 2017/5/11.
 */
public class DateUtil {


    /**
     * 事件转字符串
     * @param date
     * @return
     */
    public static String Date2String(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String stringDate = format.format(date);
        return stringDate;
    }


    /**
     * 字符串转时间
     * @param dateTime
     * @return
     */
    public static Date String2Date(String dateTime){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date Date = null;
        try {
            Date = format.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Date;
    }

    /**
     * date2比date1多的天数
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
           // System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }
}
