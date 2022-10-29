package com.ace.work.acework.coding.suanfa;

import java.util.Arrays;
import java.util.Scanner;

public class Main_兄弟单词 {

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        //String str = "183 bacad ad cda a dcccd aab bb cb cbd bacd dcbb dda b adcb dca ab adbd ab caa bbaba adad dc cbd ccddb cdc ab ad cb ddb bc bcdb cdcc bcbb dd abdd bda bad cdbb d dcb bc badcb cacc bbacb da dbadd cada bcbdc ddbca db ca ca d ad d ddcb bb ba bab adaca aba cbca aaddd cbccc c c bcdbb cdd dcabd d dd db dabad d acddc a ddcb daba daca b bba adb db c a accb aa dcab bdccc adbb a bacb cbdba aa ad cab cada bcba ccadc cba bd dad cc bcda dcaac acaad abada a cb c d ddac acb a ba acaa bdb cdb cada bc cccac d dcaa bd bcada dab ad dacb aaada dc dcccd acac dbdb cd acdac bbdbc caad cbc bdab dd abaa bc ada ba cbda a dbaa dabd cd aacdc bdcb bbcc ccca cac ddba cdcd dc aab b bbad bbdd bc adc cdab bba acad ca cbc a c c addbd caadb cbaa ab d bbbd c dcc ab c ba ccbb adad 1";

        String[] strArrays = str.split(" ");
        int wordSize = Integer.valueOf(strArrays[0]);
        String sourceWord = strArrays[strArrays.length-2];
        int index = Integer.valueOf(strArrays[strArrays.length-1]);

        StringBuilder stringBuilder = new StringBuilder();

        for(int i=1;i<=strArrays.length-3;i++){
            if(checkWord(strArrays[i],sourceWord)){
                stringBuilder.append(strArrays[i]).append(";");
            }
        }

        if(stringBuilder.toString().length()==0){
            System.out.println(0);
            return;
        }
        String[] finallArrays = stringBuilder.toString().split(";");
        Arrays.sort(finallArrays);
        System.out.println(finallArrays.length);
        if(finallArrays.length>=index){
            System.out.println(finallArrays[index-1]);
        }
    }

    public static boolean checkWord(String target,String source){

        if(null==target){
           return false;
        }

        if(target.length()!=source.length()){
            return false;
        }

        if(target.equals(source)){
           return false;
        }

        char[] targetArray = target.toCharArray();
        Arrays.sort(targetArray);

        char[] sourceArray = source.toCharArray();
        Arrays.sort(sourceArray);

        if(Arrays.toString(targetArray).equals(Arrays.toString(sourceArray))){
            return true;
        }
        return false;
    }

}
