package com.example.designpattern.mvvm.utils;

import android.annotation.SuppressLint;

import androidx.databinding.BindingConversion;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * 该方法会将Date类型的日期转换成String类型的日期并返回
     *
     * @param date
     * @return
     */
    @BindingConversion//用于自动从表达式类型转换为 setter 中使用的值的注释方法
    public static String convertDate(Date date) {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
