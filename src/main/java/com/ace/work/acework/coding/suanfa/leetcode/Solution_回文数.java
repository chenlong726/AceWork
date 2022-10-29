package com.ace.work.acework.coding.suanfa.leetcode;

public class Solution_回文数 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(11211));
    }
    public static boolean isPalindrome(int x) {
        String temp = String.valueOf(x);
        int mid = temp.length()/2-1;
        boolean result = true;
        for(int i=0;i<=mid;i++){
           if(temp.charAt(i)!=temp.charAt(temp.length()-i-1)){
               return false;
           }
        }
        return result;
    }
}
