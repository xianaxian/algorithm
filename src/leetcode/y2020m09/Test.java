package leetcode.y2020m09;

import java.util.Calendar;
import java.util.Date;

public class Test {
    public static Date getTodayEarly(Date date){
        if(date == null){
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
    public static Date getTodayLast(Date date){
        if(date == null){
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }
    public static void main(String[] args) {
        String a="test";
        Date date=new Date();
        System.out.println(getTodayEarly(date));
        System.out.println(getTodayLast(date));
        while(1==1){
            while ("test".endsWith(a)) {
                while ("b".equals("b")){
                    for (int i = 0; i < 10; i++) {
                        System.out.println(i);
                    }
                    break;
                }
            }
        }
    }

}
