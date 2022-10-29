package com.ace.work.acework.coding.suanfa;

import java.util.Scanner;

public class Main_密码截取 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "ABBA";
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            // ABA型
            int len1 = longest(s, i, i);
            // ABBA型
            int len2 = longest(s, i, i + 1);
            res = Math.max(res, len1 > len2 ? len1 : len2);
        }
        return res;
    }

    private static int longest(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
