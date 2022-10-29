package com.ace.work.acework.coding.suanfa;

import java.util.Scanner;

public class Main_高精度加法 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        if(a.length()>b.length()){
            b = getNewStr(b,a.length());
        }else if(a.length()<b.length()) {
            a = getNewStr(a,b.length());
        }
        getNewStr(a,b);
    }

    public static String getNewStr(String targetStr,int lenght){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<lenght-targetStr.length();i++){
            stringBuilder.append("0");
        }
        stringBuilder.append(targetStr);
        return stringBuilder.toString();
    }

    public static void getNewStr(String aStr,String bStr){
       if(aStr.length()!= bStr.length()){
           System.out.println("长度不同");
       }
       StringBuilder stringBuilder = new StringBuilder();
       int num = 0;
       for(int i=aStr.length()-1;i>=0;i--){
           int tempA = Integer.valueOf(Character.toString(aStr.charAt(i)));
           int tempB = Integer.valueOf(Character.toString(bStr.charAt(i)));
           int temp = tempA+tempB+num;
           stringBuilder.append(temp%10);
           num = temp/10;
       }
       if(num>0){
           stringBuilder.append(num);
       }
       StringBuilder result = new StringBuilder();
       for(int i=stringBuilder.length()-1;i>=0;i--){
           result.append(stringBuilder.charAt(i));
       }
        System.out.println(result.toString());
    }



}
