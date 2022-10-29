package com.ace.work.acework.coding.suanfa;

import java.util.Scanner;

public class Main_质数问题 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            getData(num);
        }
    }

    public static void getData(int num){
        for(int i=2;i<=num;i++){
            if(num%i==0){
                System.out.println(i);
                getData(num/i);
                break;
            }
        }
    }
}
