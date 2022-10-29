package com.ace.work.acework.coding.suanfa;

import java.util.ArrayList;
import java.util.List;

public class Main_字符串乘积 {


    public static void main(String[] args) {
        String a = "1111";
        String b = "33";
        System.out.println(getData(a,b));
    }

    public static String getData(String source,String b){
        List<String> result = new ArrayList<>();
        String num = "";
        for(int i=b.length()-1;i>=0;i--){
            result.add(getSubData(source,Character.toString(b.charAt(i)))+num);
            num = num+"0";
        }
        String resultTemp = "0";
        for(String strTemp:result){
            resultTemp = getAddData(resultTemp,strTemp);
        }

        return resultTemp;
    }

    /**
     * 字符串相加
     * @param a
     * @param b
     * @return
     */
    public static String getAddData(String a,String b){
        String shorterStr;
        String longerStr;
        if(a.length()>b.length()){
           shorterStr = getStr(b,a.length()-b.length());
           longerStr = a;
        }else {
           shorterStr = getStr(a,b.length()-a.length());
           longerStr = b;
        }

        int count = 0;
        int currNum = 0;
        StringBuilder tempAdd = new StringBuilder();
        for(int i=longerStr.length()-1;i>=0;i--){
           currNum = count + Integer.valueOf(Character.toString(longerStr.charAt(i)))+Integer.valueOf(Character.toString(shorterStr.charAt(i)));
           tempAdd.append(currNum%10);
           count = currNum/10;
        }
        String tempResult = tempAdd.toString();

        StringBuilder result = new StringBuilder();
        for(int i=tempResult.length()-1;i>=0;i--){
            result.append(tempResult.charAt(i));
        }
        return String.valueOf(result);
    }

    public static String getStr(String source,int length){
        StringBuilder result = new StringBuilder();
        for(int i=0;i<length;i++){
            result.append("0");
        }
        return result.append(source).toString();
    }


    /**
     * 计算单个数的乘积
     * @param a
     * @param b
     * @return
     */
    public static String getSubData(String a,String b){
        int count = 0;
        int currNum = 0;
        StringBuilder temp = new StringBuilder();

        for(int i=a.length()-1;i>=0;i--){
            currNum = count + Integer.valueOf(Character.toString(a.charAt(i)))*Integer.valueOf(b);
            temp.append(currNum%10);
            count = currNum/10;
        }

        String tempResult = temp.toString();
        StringBuilder result = new StringBuilder();

        for(int i=tempResult.length()-1;i>=0;i--){
            result.append(tempResult.charAt(i));
        }
        return String.valueOf(result);
    }
}
