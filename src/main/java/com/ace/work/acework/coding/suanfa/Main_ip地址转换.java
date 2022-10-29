package com.ace.work.acework.coding.suanfa;

import java.util.Arrays;
import java.util.Scanner;

public class Main_ip地址转换 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = "39.66.68.72";
        String str2 = "3868643487";

        getIpNum(str1);
        getIpStr(str2);

    }

    public static void getIpNum(String ip){
        String[] ipArray = ip.replace(".",";").split(";");
        StringBuilder stringBuilder = new StringBuilder("");
        Arrays.stream(ipArray).forEach(n->stringBuilder.append(fixData(Long.toBinaryString(Long.valueOf(n)),8)));
        System.out.println(Long.valueOf(stringBuilder.toString(),2));
    }

    public static void getIpStr(String num){
        String strNum = fixData(Long.toBinaryString(Long.valueOf(num)),32);
        StringBuilder stringBuilder = new StringBuilder("");
        for(int i=1;i<=4;i++){
            String temp = strNum.substring(8*(i-1),8*i);
            stringBuilder.append(Long.valueOf(temp,2)).append(".");
        }
        System.out.println(stringBuilder.toString().substring(0,stringBuilder.length()-1));
    }

    public static String fixData(String source,Integer length){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<length-source.length();i++){
            stringBuilder.append("0");
        }
        return stringBuilder.append(source).toString();
    }

}
