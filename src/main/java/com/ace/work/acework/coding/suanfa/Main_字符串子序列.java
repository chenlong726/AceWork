package com.ace.work.acework.coding.suanfa;


public class Main_字符串子序列 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()){
//            String[] str = scanner.nextLine().split(",");
//            Arrays.sort(str);
//            StringBuffer stringBuffer = new StringBuffer("");
//            Arrays.stream(str).forEach(n->stringBuffer.append(n).append(","));
//            System.out.println(stringBuffer.substring(0,stringBuffer.length()-2));
//        }
        String str = "abc";
        PrintAllSub(str.toCharArray(),0,"");
    }

    public static void PrintAllSub(char[] cha,int i, String res){
        if(i == cha.length){
            System.out.println(res);
            return;
        }
        PrintAllSub(cha,i+1,res);
        PrintAllSub(cha,i+1,res+String.valueOf(cha[i]));
    }
}