package com.ace.work.acework.coding.suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_TEST {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while(scanner.hasNextLine()){
            int startIndex = Integer.parseInt(scanner.nextLine());
            int wordsize = Integer.parseInt(scanner.nextLine());
            List<String> wordList = new ArrayList<>();
            for(int i=0;i<=wordsize-1;i++){
                wordList.add(scanner.nextLine());
            }
            String startWord = wordList.get(startIndex);
            wordList.remove(startWord);
            StringBuffer stringBuffer = new StringBuffer(startWord);

            while(null!=startWord){
                startWord = getNextWord(wordList,startWord);
                if(null==startWord){
                    System.out.println(stringBuffer.toString());
                    break;
                }else {
                    stringBuffer.append(startWord);
                }
            }
        }
    }


    public static String getNextWord(List<String> wordList,String startWord){
        List<String> targetList = new ArrayList<>();
        List<String> resultList = new ArrayList<>();
        String nextWord = null;
        for(String word : wordList){
            if(word.substring(0,1).equals(startWord.substring(startWord.length()-1))){
                targetList.add(word);
            }
            //剩余的单词
            resultList.add(word);
        }

        if(targetList.size()==0){
            return null;
        }

        if(targetList.size()==1){
            nextWord = targetList.get(0);
        }
        nextWord =getWord(targetList);

        if(null!=nextWord){
            wordList.remove(nextWord);
        }
        return nextWord;
    }


    public static String getWord(List<String> targetList){
        int maxlength = 0;
        List<String> maxLengthList = new ArrayList<>();
        for(String word:targetList){
            if(word.length()>=maxlength){
                maxlength = word.length();
            }
        }

        for(String word:targetList){
            if(word.length()==maxlength){
                maxLengthList.add(word);
            }
        }

        if(maxLengthList.size()==1){
            return maxLengthList.get(0);
        }

        String[] wordArray = new String[maxLengthList.size()];
        for(int i=0;i<maxLengthList.size();i++){
            wordArray[i] = maxLengthList.get(i);
        }

        Arrays.sort(wordArray);
        return wordArray[0];
    }

}
