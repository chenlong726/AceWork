package com.ace.work.acework.coding.suanfa.二分法;

public class Main_找峰值 {

    public static void main(String[] args) {
        int[] numArray = new int[]{2,4,1,2,7,8,4};
        System.out.println(findPeakElement(numArray));
    }

    public static int findPeakElement (int[] nums) {
        // write code here
        //关键思想：下坡的时候可能找到波峰，但是可能找不到，一直向下走的
        //上坡的时候一定能找到波峰，因为题目给出的是nums[-1] = nums[n] = -∞
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            //证明右边的路是下坡路，不一定有坡峰
            if(nums[mid]>nums[mid+1]){
                right = mid;
            }else{
                //这里是右边的路是上坡路
                left=mid+1;
            }
        }
        return right;
    }

}
