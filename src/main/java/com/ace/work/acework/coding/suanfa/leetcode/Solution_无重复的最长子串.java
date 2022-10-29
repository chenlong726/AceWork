package com.ace.work.acework.coding.suanfa.leetcode;

public class Solution_无重复的最长子串 {

    public static void main(String[] args) {
        String str = "b";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(null==s||s.length()==0){
           return 0;
        }

        if(s.equals(" ")){
            return 1;
        }
        int max = 0;
        String tempStr = "";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(!tempStr.contains(Character.toString(s.charAt(j)))){
                    tempStr = tempStr+s.charAt(j);
                }else {
                    break;
                }
            }
            max = Math.max(max,tempStr.length());
            tempStr = "";
        }

        return max;
    }

}
