package com.my.demo.utils;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

public class RandomUtils {
    /**
     * 根据模块类型产生随机数据
     * @param dataType ： 模块类型
     * @return
     */
    public static Object getRandomViewValues(String dataType){
        Random random = new Random();
        if(dataType==null){return getStringRandom(random.nextInt(5));}
        Object randomVal = "";
        switch (dataType){
            case "String" :
                int length = new Random().nextInt(10);
                randomVal = getStringRandom(length);
                break;
            case "Boolean":
                randomVal = (random.nextInt(2)==0 ? true : false);
                break;
            case "Integer":
                randomVal= random.nextInt(100);
                break;
            case "Double":
                randomVal = new java.text.DecimalFormat("#.00").format(new Random().nextDouble()*100);
                break;
            case "Long":
                randomVal = random.nextLong();
                break;
            case "BigInteger":
                randomVal = new BigInteger(random.nextInt(100000)+"");
                break;
            case "Float":
                randomVal = random.nextFloat();
            case "Date":
                randomVal = randomDate();
                break;
            case "JSONObject":
                randomVal = randomList();
                break;
            default:
                randomVal=getStringRandom(random.nextInt(5));
                break;
        }
        return randomVal;
    }
    /**
     * 获取随机日期:最近一年
     * @return date
     */
    public static String randomDate(String... formats) {
        try {
            SimpleDateFormat format = new SimpleDateFormat((formats==null||formats.length<=0) ? "yyyy-MM-dd" : Arrays.asList(formats).get(0));
            long start = System.currentTimeMillis();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(start);
            calendar.add(Calendar.YEAR, -1);
            long end = calendar.getTimeInMillis();
            long date = start + (long)(Math.random() * (end - start));
            return format.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 取最近6-12个月的时间
     * @return list
     */
    public static List<Object> randomList(){
        List<Object> objectList = new ArrayList<>();
        int size = new Random().nextInt(7)+6;//取6,12之间的随机数
        String randomDate = randomDate("yyyyMM");
        int year = Integer.valueOf(randomDate.substring(0,4));
        int month = Integer.valueOf(randomDate.substring(4));
        for(int i=0;i<size;i++){
            if(month==1){
                month=12;
                year-=1;
            }else{
                month--;
            }
            objectList.add(year+""+(month<10?"0"+month:month));
        }
        return objectList;
    }

    /**
     * 随机产生n个长度的字母，数字 ，中文组合
     * @param length
     * @return
     */
    public static String getStringRandom(int length) {
        length = (length >0 ? length : 1);
        String val = "";
        Random random = new Random();
        //参数length，表示生成几位随机数
        for(int i = 0; i < length; i++) {
            int typeIndex = random.nextInt(3)%3;
            //输出字母还是数字
            if(typeIndex==0) {//字母
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if(typeIndex==1) {//数字
                val += String.valueOf(random.nextInt(10));
            } else if(typeIndex==2){//中文
                val +=(char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1)));
            }
        }
        return val;
    }
}
