package com.ace.work.acework.coding.suanfa;

import java.util.Arrays;
import java.util.Scanner;

public class Main_合唱队问题 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
           int length = scanner.nextInt();
           int[] numArray = new int[length];
           for(int i=0;i<numArray.length;i++){
               numArray[i] = scanner.nextInt();
           }
        }
        int lenght = 8;
        int[] numArray = new int[]{186,186,150,200,160,130,197,200};

        int[] dpA = new int[lenght];
        int dpAMax = 0;
        for(int i=1;i<numArray.length;i++){
            for(int j=0;j<i;j++){
                if(numArray[i]>numArray[j]){
                    dpA[i] = Math.max(dpA[i],dpA[j]+1);
                }
                dpAMax = Math.max(dpA[i],dpAMax);
            }
        }

        int[] dpB = new int[lenght];
        int dpBMax = 0;
        for(int i=numArray.length-1;i>=1;i--){
            for(int j=numArray.length-1;i<j;j--){
                if(numArray[i]>numArray[j]){
                    dpA[i] = Math.max(dpA[i],dpA[j]+1);
                }
                dpBMax = Math.max(dpA[i],dpBMax);
            }
        }

        int[] result = new int[lenght];
        for(int i=0;i<result.length;i++){
            result[i] = dpA[i]+dpB[i]+1;
        }
        Arrays.sort(result);
        System.out.println(result[result.length-1]);
    }
}
