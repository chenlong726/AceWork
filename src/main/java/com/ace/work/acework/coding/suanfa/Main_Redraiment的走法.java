package com.ace.work.acework.coding.suanfa;

import java.util.Arrays;

public class Main_Redraiment的走法 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()){
//            int len = scanner.nextInt();
//            int[] nums = new int[len];
//            for(int i = 0;i < len;++i){
//                nums[i] = scanner.nextInt();
//            }
//            System.out.println(count(nums));
//        }
        int[] numArray = new int[]{2,5,6,5,4,5};
        System.out.println(count(numArray));

    }

    public static int count(int []nums){
        int []dp = new int[nums.length+1];
        int max = 1;
        Arrays.fill(dp,1);
        for(int i = 1;i < nums.length;++i){
            for(int j = 0;j < i;++j){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
                max = Math.max(dp[i],max);
            }
        }
        return max;
    }
}

