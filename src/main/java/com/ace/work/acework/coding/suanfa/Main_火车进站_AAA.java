package com.ace.work.acework.coding.suanfa;


import java.util.*;

public class Main_火车进站_AAA{

    static List<String> RESULT = new ArrayList<>(); //储存结果

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            RESULT.clear(); //静态变量，每次先清空
            int nums = in.nextInt();
            int[] id = new int[nums];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < nums; i++) {
                id[i] = in.nextInt();
            }
            trainOut(id, 0, stack, "", 0);
            //对结果集排序
            Collections.sort(RESULT);
            for (String str : RESULT) {
                System.out.println(str);
            }
        }
        in.close();
    }

    public static void trainOut(int[] id, int i, Stack<Integer> s, String str, int n) {
        if (n == id.length) {
            RESULT.add(str); //如果所有火车均出栈则将当前结果保存
        }

        if (!s.empty()) { //栈非空时出栈
            int temp = s.pop();
            trainOut(id, i, s, str + temp + " ", n + 1);
            s.push(temp); //恢复现场
        }

        if (i < id.length) {
            s.push(id[i]);
            trainOut(id, i + 1, s, str, n);
            s.pop(); //恢复现场

        }
    }
}