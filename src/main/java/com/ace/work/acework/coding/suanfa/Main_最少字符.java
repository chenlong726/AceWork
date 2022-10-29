package com.ace.work.acework.coding.suanfa;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_最少字符 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int[] strArray = new int[128];

        for(int i=0;i<str.length();i++){
            strArray[str.charAt(i)]++;
        }

        int min = strArray[str.charAt(0)];
        for(int i=0;i<str.length()-1;i++){
            min = Math.min(min,strArray[str.charAt(i+1)]);
        }

        Set<String> minStr = new HashSet<>();
        for(int i=0;i<str.length();i++){
           if(min == strArray[str.charAt(i)]){
               minStr.add(Character.toString(str.charAt(i)));
           }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<str.length();i++){
           if(!minStr.contains(Character.toString(str.charAt(i)))){
               stringBuilder.append(str.charAt(i));
           }
        }
        System.out.println(stringBuilder);

    }
}
