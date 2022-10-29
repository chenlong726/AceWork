package com.ace.work.acework.coding.suanfa;

public class Main_最长公共子串 {
    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        String a = scanner.nextLine();
//        String b  = scanner.nextLine();
//
//        String strShort = "";
//        String strLong = "";
//
//
//        if(a.length()>b.length()){
//            strShort = b;
//            strLong = a;
//        }else{
//            strShort = a;
//            strLong = b;
//        }

        String strShort = "abcdefghijklmnop";
        String strLong = "abcsafjklmnopqrstuvw";
        String max = "";

        for(int i=1;i<=strShort.length();i++){
            for(int j=0;j<=strShort.length()-i;j++){
                String temp = strShort.substring(j,j+i);
                if(strLong.contains(temp)){
                    if(temp.length()>max.length()){
                        max = temp;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
