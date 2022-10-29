package com.ace.work.acework.coding.suanfa;

import java.util.Scanner;

public class Main_公共子串 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        String shortStr = "";
        String longStr = "";

       if(a.length()>b.length()){
           shortStr = b;
           longStr = a;
       }else {
           shortStr =a;
           longStr =b;
       }

        String max = "";

        for(int i=1;i<=shortStr.length();i++){
            for(int j=0;j<=shortStr.length()-i;j++){
                String temp = shortStr.substring(j,j+i);
                if(longStr.contains(temp)){
                    if(temp.length()>max.length()){
                        max = temp;
                    }
                }
            }
        }
        System.out.println(max.length());
    }
}
