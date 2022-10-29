package com.ace.work.acework.coding.suanfa.leetcode;


import java.util.Stack;

public class Solution_括号校验 {

    public static void main(String[] args) {
        String str = "(){}";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(')');
            }else if(c== '{'){
                stack.push('}');
            }else if(c=='['){
                stack.push(']');
            }else if(stack.isEmpty() || c!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}