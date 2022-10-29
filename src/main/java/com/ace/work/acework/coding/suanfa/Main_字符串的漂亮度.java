package com.ace.work.acework.coding.suanfa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_字符串的漂亮度 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
           int num = Integer.valueOf(scanner.nextLine());
           String[] strings = new String[num];
           for(int i=0;i<num;i++){
               strings[i] = scanner.nextLine();
           }
           for(int i=0;i<num;i++){
               getMaxCount(strings[i]);
           }
        }
    }

    public static void getMaxCount(String str){
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            String temp = Character.toString(str.charAt(i));
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp)+1);
            }else{
                map.put(temp,1);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            stringBuilder.append(entry.getValue()).append(":");
        }

        String[] strArray = stringBuilder.toString().substring(0,stringBuilder.length()-1).split(":");
        int[] numArray = new int[strArray.length];
        for(int i=0;i<strArray.length;i++){
            numArray[i] = Integer.valueOf(strArray[i]);
        }
        Arrays.sort(numArray);
        int count = 0;
        int n = 0;
        for(int i=numArray.length-1;i>=0;i--){
            count = count + Integer.valueOf(numArray[i])*(26-n);
            n++;
        }
        System.out.println(count);
    }
}
