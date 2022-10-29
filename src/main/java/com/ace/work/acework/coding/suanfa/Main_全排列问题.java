package com.ace.work.acework.coding.suanfa;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main_全排列问题 {

    // 存所有排列的集合
    public static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        // 存一种排列
        LinkedList<Integer> list = new LinkedList<>();
        // 递归进行
        backTrack(num,list);
        return res;
    }

    public static void backTrack(int[] num, LinkedList<Integer> list){
        // 当list中的长度等于数组的长度，则证明此时已经找到一种排列了
        if(list.size() == 3){
            // add进返回结果集中
            res.add(new ArrayList<>(list));
            return;
        }
        // 遍历num数组
        for(int i = 0; i < num.length; i++){
            // 若当前位置中的数已经添加过了则跳过
            if(list.contains(num[i]))
                continue;
            // 选择该数
            list.add(num[i]);
            // 继续寻找
            backTrack(num,list);
            // 撤销最后一个
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] numArray = new int[] {1,2,3};
        permute(numArray);
        System.out.println(JSON.toJSONString(res));
    }
}
