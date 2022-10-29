package com.ace.work.acework.coding.suanfa.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_用栈操作构建数组 {

    public static List<String> buildArray(int[] target, int n) {

        Stack<Integer> currStack = new Stack<>();
        List<String> optList = new ArrayList<>();
        if(checkArray(target, currStack , optList, 1, n)){
            return optList;
        }
        return null;
    }


    public static boolean checkArray(int[] target,Stack<Integer> currStack ,List<String> optList, int index, int length) {
        if(same(currStack,target)){
            return true;
        }

        if(index>length){
            return false;
        }

        currStack.push(index);
        optList.add("Push");
        if(checkArray(target, currStack , optList, index+1,length)){
            return true;
        }
        optList.remove(optList.size()-1);

        if(currStack.isEmpty()){
            return false;
        }

        currStack.pop();
        optList.add("Pop");
        if(checkArray(target, currStack , optList, index,length)){
            return true;
        }
        optList.remove(optList.size()-1);

        return false;
    }

    /**
     * 判断是否是目标集合
     * @param stack
     * @param target
     * @return
     */
    public static boolean same(Stack<Integer> stack,int[] target ){

        Integer[] sourceArray = new Integer[stack.size()];
        stack.toArray(sourceArray);

        if(stack.size()!=target.length){
            return false;
        }
        for(int i=target.length-1; i>=0;i--){
            if(target[i]!=sourceArray[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] target = new int[]{1,3};
        System.out.println(buildArray(target,3));
    }
}
