package com.ace.work.acework.coding.suanfa;

import java.util.Arrays;
import java.util.Scanner;

public class Main_二分法查询 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        //String str = "[-1,0,3,4,6,10,13,14],13";

        int target = Integer.valueOf(str.substring(str.lastIndexOf("]")+2));
        String[] srtArray = str.substring(1,str.lastIndexOf("]")).split(",");
        if(srtArray.length==1 && srtArray[0].length()==0){
            System.out.println(-1);
            return;
        }
        int[] numArray = Arrays.stream(srtArray).mapToInt(n->Integer.valueOf(n)).toArray();


        int left = 0;
        int right = numArray.length-1;

        int mid;
        boolean flage = false;
        while(left<=right){
            mid =left+(right-left)/2;
            if(numArray[mid]>target){
                right = mid-1;
            }else if(numArray[mid]<target){
                left = mid+1;
            }else {
                System.out.println(mid);
                flage = true;
                break;
            }
        }
        if(!flage){
            System.out.println(-1);
        }
    }
}
