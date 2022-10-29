package com.ace.work.acework.coding.suanfa;

public class Main_质数 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()){
//            int num = scanner.nextInt();
//            getNum(num);
//        }
        getNum(3);
    }

    public static void getNum(int num){
        for(int i=2;i<=num;i++){
            if(num%i==0){
                System.out.print(i+" ");
                getNum(num/i);
                break;
            }
            if(i==num){
                System.out.println(i+"");
            }
        }
    }
}
