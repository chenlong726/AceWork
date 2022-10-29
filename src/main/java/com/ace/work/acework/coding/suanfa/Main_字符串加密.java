package com.ace.work.acework.coding.suanfa;

import java.util.*;

public class Main_字符串加密 {

    public static String[] KEY_ARRAY   = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public static String VALUES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String key = "bvsrduec";
        String result = "bmrkgqybpcpmmntmckxak";
        String fixKey = fixData(key);
        String valuesNew = fixData(fixKey.toUpperCase()+VALUES);
        Map<String,String> mapValues = new HashMap<>();

        for(int i=0;i<=KEY_ARRAY.length-1;i++){
            mapValues.put(KEY_ARRAY[i],Character.toString(valuesNew.charAt(i)));
        }

        StringBuilder resultFinall = new StringBuilder();
        for(int i=0;i<result.length();i++){
           String temp = Character.toString(result.charAt(i));
           if(Character.isLowerCase(result.charAt(i))){
               resultFinall.append(mapValues.get(temp.toUpperCase()).toLowerCase());
           }else{
               resultFinall.append(mapValues.get(temp.toUpperCase()));
           }
        }
        System.out.println(resultFinall.toString());
    }

    /**
     * 去除重复字符
     * @param str
     * @return
     */
    public static String fixData(String str){
        StringBuilder stringBuilder = new StringBuilder();
        List<String> stringList = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            if(!stringList.contains(Character.toString(str.charAt(i)).toLowerCase())){
                stringBuilder.append(str.charAt(i));//不重复拼接上
                stringList.add(Character.toString(str.charAt(i)).toLowerCase());
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 去除重复字符
     * @param str
     * @return
     */
    public static String get(String str){
        StringBuilder stringBuilder = new StringBuilder();
        List<String> stringList = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            if(!stringList.contains(Character.toString(str.charAt(i)).toLowerCase())){
                stringBuilder.append(str.charAt(i));//不重复拼接上
                stringList.add(Character.toString(str.charAt(i)).toLowerCase());
            }
        }
        return stringBuilder.toString();
    }

}
