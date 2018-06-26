package com.my.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @Title: 时间操作工具类
 */
public class DateUtil {

	/* 
     * 将时间戳转换为时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    
	/* 
     * 将时间戳转换为时间，格式：yyyy-MM-dd
     */
    public static String stampToDateNoTime(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    
    /* 
     * 将日期转换为时间戳
     */    
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
    
    /* 
     * 得到给定时间戳日期前一天的最后一秒的时间戳
     */    
    public static String dateToStampLastMin(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime() - 1000;
        res = String.valueOf(ts);
        return res;
    }
    
    /* 
     * 得到今天的日期
     */    
    public static String getToday() {
    	Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String day = format.format(today);
        return day;
    }
    
    /* 
     * 得到明天的日期
     */  
    @SuppressWarnings("static-access")
	public static String getNextDay() {
    	Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE,1);
		date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		return dateString;
	}
    
    /**时间转为时间戳
     * 
     * @param s
     * @return
     * @throws ParseException
     */
    public static String timeToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
    
	/**
	 * 获得指定日期的后一天
	 * 
	 * @param specifiedDay
	 * @return
	 */
	public static String getSpecifiedDayAfter(String specifiedDay) throws ParseException {
		Calendar c = Calendar.getInstance();
		Date date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);
		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayAfter;
	}
	
	/**
	 * 获得指定日期当天23:59:59的时间戳
	 * 
	 * @param specifiedDay
	 * @return
	 */
	public static String getSpecifiedDayLastMinStamp(String specifiedDay) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(specifiedDay);
        long ts = date.getTime() + 86399000;
        res = String.valueOf(ts);
        return res;
	}
    /* 
     * 得到n天前（负）后（正）的时间戳
     */  
    @SuppressWarnings("static-access")
	public static String getBeforeTimestamp(Integer n) throws ParseException {
    	Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, n);
		date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		return dateToStamp(dateString);
	}
}
