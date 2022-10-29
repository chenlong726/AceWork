package com.ace.work.acework.coding.suanfa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_坐标移动 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strArrays = scanner.nextLine().split(";");
        Map<String,Integer> map = new HashMap<>();
        String targetStr = "ADWS";
        for(int i=0;i<=strArrays.length-1;i++){
            try{
              int num = Integer.valueOf(strArrays[i].substring(1));//抛异常直接跳过
              String charStr = Character.toString(strArrays[i].charAt(0));
              if(!targetStr.contains(charStr)){
                   continue;
              }
              if(map.containsKey(charStr)){
                  map.put(charStr,map.get(charStr)+num);
              }else{
                  map.put(charStr,num);
              }
            }catch (Exception e){
               continue;
            }
        }

        int x = getValue(map.get("D"))-getValue(map.get("A"));
        int y = getValue(map.get("W"))-getValue(map.get("S"));

        System.out.println("("+x+","+y+")");
    }


    public static int getValue(Integer value){
        if(null==value){
            return 0;
        }
        return value;
    }
}
