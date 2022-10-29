package com.ace.work.acework.coding.suanfa;

import java.util.Scanner;

public class Main_挑7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            if(num<7){
                System.out.println(0);
            }
            countNum(num);
        }
    }

    public static void countNum(int num){
        int count = 0;
        for(int i=7;i<=num;i++){
            if(i%7==0 || String.valueOf(i).contains("7")){
                count++;
            }
        }
        System.out.println(count);
    }
}
