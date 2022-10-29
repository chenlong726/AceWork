package com.ace.work.acework.coding.suanfa;

import java.util.Scanner;

public class Main_TEST_1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //数组个数
        int wordsize = Integer.parseInt(scanner.nextLine());
        //空格分隔
        String[] sizeArray = scanner.nextLine().split(" ");

        int[] resultArray = new int[wordsize];
        int index = 0;
        for(int i=0;i<wordsize;i++){
            
            if(i==wordsize-1){
                resultArray[index]=0;
                break;
            }
            boolean findBigger = false;
            int size = Integer.parseInt(sizeArray[i]);
            for(int j=i+1;j<wordsize;j++){
                if(size<Integer.parseInt(sizeArray[j])){
                    resultArray[index]=j;
                    findBigger = true;
                    break;
                }
            }
            if(!findBigger){
                resultArray[index]=0;
            }
            index++;
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<wordsize;i++){
            sb.append(resultArray[i]).append(",");
        }
        String result = sb.toString();
        System.out.println(result.substring(0,result.length()-1));
    }

}
