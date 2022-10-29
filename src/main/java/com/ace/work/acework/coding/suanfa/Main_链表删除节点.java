package com.ace.work.acework.coding.suanfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_链表删除节点 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strArrays = scanner.nextLine().split(" ");

        int linkeLength = Integer.valueOf(strArrays[0]);
        String head = strArrays[1];

        List<String> nodeList = new ArrayList<>();
        List<String> resultList = new ArrayList<>();
        resultList.add(head);

        for(int i=2;i<=strArrays.length-2;i=i+2){
            nodeList.add(strArrays[i]+":"+strArrays[i+1]);
        }

        while(resultList.size()<linkeLength){
            List<String> tempList = new ArrayList<>(nodeList);
            for(String temp:tempList){
                String[] tempNode = temp.split(":");
                int tempIndex = resultList.indexOf(tempNode[1]);
                if(tempIndex>=0){
                    resultList.add(tempIndex+1,tempNode[0]);
                    nodeList.remove(temp);
                }
            }
        }
        resultList.remove(resultList.indexOf(strArrays[strArrays.length-1]));
        for(String temp:resultList){
            System.out.print(temp+" ");
        }
    }
}
