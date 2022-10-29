package com.ace.work.acework.coding.suanfa;

import java.util.Scanner;

public class Main_冒泡排序 {

    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        char[] strArrayAll = str.toCharArray();

        StringBuilder stringBuilder = new StringBuilder("");

        for(int i=0;i<=strArrayAll.length-1;i++){
            if(Character.isLetter(strArrayAll[i])){
                stringBuilder.append(strArrayAll[i]);
            }
        }

        char[] strArray = stringBuilder.toString().toCharArray();
        for(int i=0;i<=strArray.length-1;i++){
            for(int j=0; j<strArray.length-1; j++){
                if(Character.toLowerCase(strArray[j])>Character.toLowerCase(strArray[j+1])
                        && !Character.toString(strArray[j]).toLowerCase().equals(Character.toString(strArray[j+1]).toLowerCase())){
                    char temp = strArray[j+1];
                    strArray[j+1] = strArray[j];
                    strArray[j] = temp;
                }
            }
        }

        int j = 0;
        for(int i=0;i<strArrayAll.length;i++){
            if(Character.isLetter(strArrayAll[i])){
                if(j>strArray.length){
                    return;
                }
                strArrayAll[i] = strArray[j];
                j++;
            }
        }

        for(int i=0;i<strArrayAll.length;i++){
            System.out.print(strArrayAll[i]);
        }
    }
}
