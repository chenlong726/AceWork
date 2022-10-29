package com.ace.work.acework.coding.suanfa.leetcode;

public class Solution_1640_能否链接形成数组 {

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        int arrIndex=0; // arr的指针
        int allCount=1;
        int currentIndex=0;
        while(allCount<=pieces.length && arrIndex<arr.length){

            for(int index=0;index<=pieces.length-1;index++){
                if(arrIndex>=arr.length){
                    break;
                }
                int[] currentArr = pieces[index];
                boolean same = true;
                currentIndex = arrIndex;
                for(int i=0;i<currentArr.length;i++){
                    if(currentArr[i]!=arr[arrIndex]){
                        same = false;
                        break;
                    }
                    arrIndex++;
                }
                if(!same){
                    arrIndex = currentIndex;
                }
            }
            allCount++;
        }
        return (arrIndex==arr.length);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{15,88};
        int[][] pieces = new int[][]{{88},{15}};
        System.out.println(Solution_1640_能否链接形成数组.canFormArray(arr,pieces));
    }

}
