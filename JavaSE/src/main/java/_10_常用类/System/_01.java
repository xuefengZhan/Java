package _10_常用类.System;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class _01 {
    @Test
    public void test(){
        System.out.println(System.currentTimeMillis());

        System.out.println(new Date());
    }

    @Test
    public void test2(){
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss 是本年的第D天");
        System.out.println(sf.format(date)); //2021-08-24 14:57:46 是本年的第236天

        String s = "2016-12-01 14:12:23";
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d = sf2.parse(s);
            System.out.println(d); //Thu Dec 01 14:12:23 CST 2016
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
