package com.ace.work.acework.coding.suanfa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_第一个只出现一次的字符 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] strArray = str.toCharArray();
        Map<String,Integer> strMap = new HashMap<>();
        for(int i=0;i<strArray.length;i++){
            String tempKey = Character.toString(strArray[i]);
            if(strMap.containsKey(tempKey)){
                strMap.put(tempKey,strMap.get(tempKey)+1);
            }else{
                strMap.put(tempKey,1);
            }
        }

        int flag = 0;
        for(int i=0;i<strArray.length;i++){
            String tempKey = Character.toString(strArray[i]);
            if(strMap.get(tempKey)==1){
                flag++;
                System.out.println(tempKey);
                return;
            }
        }
        if(flag==0){
            System.out.println(-1);
        }
    }
}
