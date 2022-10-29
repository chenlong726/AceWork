package com.ace.work.acework.coding.suanfa;

import java.util.Scanner;

public class Main_分数拆成埃及数 {

    public static void main(String[] args) {

//        String str = "8/11";
//        int a = Integer.valueOf(str.split("/")[0]);//分子
//        int b = Integer.valueOf(str.split("/")[1]);//分母

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            int a = Integer.valueOf(str.split("/")[0]);//分子
            int b = Integer.valueOf(str.split("/")[1]);//分母

            StringBuilder resultStr = new StringBuilder();
            getStr(a,b,resultStr);
            System.out.println(resultStr.toString().substring(0,resultStr.length()-1));
        }
    }

    public static void getStr(int a,int b,StringBuilder resultStr){
        int tempX = b/a;
        //检验埃及数
        if(a==1||b%a==0){
            resultStr.append(1).append("/").append(tempX).append("+");
            return;
        }
        //计算数值
        resultStr.append(1).append("/").append(tempX+1).append("+");

        int nextA = (tempX+1)*a-b;
        int nextB = (tempX+1)*b;
        getStr(nextA,nextB,resultStr);
    }
}
