package com.ace.work.acework.coding.suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_DNA序列 {

    public static List<String> targetList = new ArrayList<String>(){};
    static {
        targetList.add("G");
        targetList.add("C");

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int lenght = Integer.valueOf(scanner.nextLine());

        String[] subStrArray = new String[str.length()-lenght+1];
        for(int i=0;i<subStrArray.length;i++){
            subStrArray[i] = str.substring(i,i+lenght);
        }

        int[] countNum = new int[subStrArray.length];

        for(int i=0;i<subStrArray.length;i++){
            countNum[i] = getCount(subStrArray[i]);
        }
        Arrays.sort(countNum);
        int max = countNum[countNum.length-1];


        for(int i=0;i<subStrArray.length;i++){
            if(getCount(subStrArray[i])==max){
                System.out.println(subStrArray[i]);
                return;
            }
        }
    }

    public static int getCount(String str){
        int count = 0;
        for(int i=0;i<str.length();i++){
            if(targetList.contains(Character.toString(str.charAt(i)))){
                count++;
            }
        }
        return count;
    }
}
