package com.ace.work.acework.coding.suanfa.leetcode;

public class Solution_最长回文子串 {

    public static void main(String[] args) {
        String str = "cbbd";
        String maxStr = "";

        String lengthA = "";
        String lengthB = "";
        String tempStr = "";
        for(int i=1;i<str.length();i++){
            lengthA = getData(str,i,i+1);
            lengthB = getData(str,i-1,i+1);
            tempStr = getMaxStr(lengthA,lengthB);
            maxStr = getMaxStr(maxStr,tempStr);
        }
        System.out.println(maxStr);
    }


    public static String getMaxStr(String str1,String str2){
        if(str1.length()>str2.length()){
            return str1;
        }else{
            return str2;
        }
    }

    public static String getData(String str,int left1,int right1){
        int left = left1;
        int right = right1;
        if(left<0 || right>=str.length()){
            return str.substring(left+1,right);
        }
        if(str.charAt(left)==str.charAt(right)){
            left--;
            right++;
            return getData(str,left,right);
        }else {
            return str.substring(left+1,right);
        }
    }

}
