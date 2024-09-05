package edu.hain;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;

import java.util.Calendar;
import java.util.Date;

public class TimeTest {

    public static void main(String[] args) {
        Date currentTime = Calendar.getInstance().getTime();

        System.out.println(DateUtil.format(currentTime,"yyyy-MM"));
    }
}
