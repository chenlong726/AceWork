package com.ace.work.acework.coding.suanfa;

import java.util.Scanner;

public class Main_回文串长度 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println(getCount(str));
        }
        //System.out.println(getCount("cdabbacc"));

    }

    public static int getCount(String str){
        int max = 0;
        for(int i=0;i<str.length();i++){
           int countA =  getCount(str,i,i+1);
           int countB =  getCount(str,i-1,i+1);
           int maxTemp = Math.max(countA,countB);
           max = Math.max(max,maxTemp);
        }
        return max;
    }

    public static int getCount(String str,int left,int right){
        while((right<str.length()) && (left>=0)){
            if(str.charAt(left)==str.charAt(right)){
                left--;
                right++;
            }else {
                return right-left-1;
            }
        }
        return right-left-1;
    }
}
