package com.ace.work.acework.coding.suanfa;

import java.util.Scanner;

public class Main_最长连续子串 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            int maxlength = 0;
            for(int i=0;i<str.length();i++){
                if(Character.isDigit(str.charAt(i))){
                    stringBuilder.append(str.charAt(i));
                }else if((stringBuilder.lastIndexOf(":"))!=(stringBuilder.length()-1)){
                    stringBuilder.append(":");
                }

                int temp = 0 ;
                if(stringBuilder.lastIndexOf(":")>=0){
                    temp = stringBuilder.subSequence(stringBuilder.lastIndexOf(":")+1,stringBuilder.length()).length();
                }else {
                    temp = stringBuilder.length();
                }
                if(maxlength<temp){
                    maxlength = temp;
                }
            }
            StringBuilder result = new StringBuilder();
            for(String temp : stringBuilder.toString().split(":")){
                if(temp.length()==maxlength){
                    result.append(temp);
                }
            }
            System.out.println(result.subSequence(0,result.length())+","+maxlength);
        }
    }
}
