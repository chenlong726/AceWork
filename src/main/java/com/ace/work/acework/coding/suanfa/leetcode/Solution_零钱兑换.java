package com.ace.work.acework.coding.suanfa.leetcode;

import java.util.Arrays;

public class Solution_零钱兑换 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5};
        int targetSum = 11;
        System.out.println(coinChange(nums,targetSum));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dpSum = new int[amount+1];
        int max = amount+1;
        Arrays.fill(dpSum, max);//所有初始化最大值
        dpSum[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]){
                    dpSum[i] = Math.min(dpSum[i], dpSum[i - coins[j]] + 1);
                }
            }
        }
        if(dpSum[amount]==max){
           return -1;
        }
        return dpSum[amount];
    }
}
