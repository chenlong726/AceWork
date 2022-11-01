package com.ace.work.acework.coding.suanfa.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class Solution_784_字母大小写全排列 {

    public List<String> letterCasePermutation(String s) {
        List<Integer> indexList = new ArrayList<>();
        char[] charArray = s.toCharArray();
        for(int i=0 ;i< charArray.length; i++){
            if(Character.isLetter(charArray[i])){
                indexList.add(i);
            }
        }
        List<String> result = new ArrayList<>();
        allSort(s, result, 0, indexList);
        return result;
    }

    /**
     * 依次变更indexList中，相应位置的字符串大小写
     * @param targetStr
     * @param result
     * @param index
     * @param indexList
     */
    public void allSort(String targetStr,List<String> result,int index,List<Integer> indexList){
        if(index>=indexList.size()){
            result.add(targetStr);
            return;
        }
        allSort(targetStr, result, index+1, indexList);
        allSort(changeStr(targetStr,indexList.get(index)), result, index+1, indexList);
    }

    /**
     * 相应位置转变大小写
     * @return
     */
    public String changeStr(String str,int index){
        StringBuilder stringBuilder = new StringBuilder();

        char[] charArray = str.toCharArray();
        for(int i=0 ;i< charArray.length; i++){
            if(i==index){
                if(Character.isUpperCase(charArray[i])){
                    stringBuilder.append(Character.toLowerCase(charArray[i]));
                }else {
                    stringBuilder.append(Character.toUpperCase(charArray[i]));
                }
                continue;
            }
            stringBuilder.append(charArray[i]);
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        Solution_784_字母大小写全排列 solution_784_字母大小写全排列 = new Solution_784_字母大小写全排列();
        List<String> resultList = solution_784_字母大小写全排列.letterCasePermutation("a1b2");
        System.out.println(JSON.toJSONString(resultList));
    }

}
