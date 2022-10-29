package com.ace.work.acework.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yd  惊蛰
 * @version 1.0
 * 功能描述：
 * @date 2022/6/16 9:09 下午
 */
public class WorkMain {

    public static class Node{
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static List<List<String>> RESUL_TALL = new ArrayList<>();
    public static List<String> SUB_STR_LIST = new ArrayList<>();

    public static void main(String[] args) {

        String[] array = new String[]{"a","b","c"};

        int[][] arrays = new int[][]{{1,0,0},{1,1,1},{0,0,1}};

        fullSort(array,new ArrayList<>());

        fullSubStr(array,0,"");

        List<Node> nods = new ArrayList<>();

        dfs(arrays,0,0,nods);

        System.out.println(JSON.toJSONString(RESUL_TALL));
        System.out.println(JSON.toJSONString(SUB_STR_LIST));
        System.out.println(JSON.toJSONString(nods));
    }

    /**
     * 全排列
     * @param array
     * @param result
     */
    public static void fullSort(String[] array, List<String> result){

        //全部节点排列完，得到其中一个排列结果则结束
        if(result.size()==array.length){
            RESUL_TALL.add(new ArrayList<>(result));
            return;
        }

        for(int i=0;i<array.length;i++){
            if(result.contains(array[i])){
                continue;
            }

            result.add(array[i]);

            fullSort(array,result);

            result.remove(result.size()-1);
        }
    }

    /**
     * 字符创全部子集
     * 注意：根据指针右移，可以有选和不选两种结果
     * @param array
     * @param index
     * @param subStr
     */
    public static void fullSubStr(String[] array,int index,String subStr){
        if(index>=array.length){
            SUB_STR_LIST.add(subStr);
            return;
        }
        //指针右移，不选指针对应的值
        fullSubStr(array,index+1,subStr);
        //指针右移，选中指针对应的值
        subStr = subStr+array[index];
        fullSubStr(array,index+1,subStr);
    }

    /**
     * dsf寻址，走迷宫问题
     * @param map
     * @param x
     * @param y
     * @param nods
     * @return
     */
    public static boolean dfs(int[][] map,int x,int y,List<Node> nods){
        // 添加路径信息
        nods.add(new Node(x,y));
        // 终止条件
        if(x==map.length-1 && y==map[0].length-1){
            return true;
        }

        //把当前节点设置为屏障ß
        map[x][y] = 0;

        // 右移
        if(x+1<=map.length-1 && y<=map[0].length-1 && map[x+1][y]==1){
            if(dfs(map,x+1,y,nods)){
                return true;
            }
        }

        // 左移
        if(x-1>=0 && y<=map[0].length-1 && map[x-1][y]==1){
            if(dfs(map,x-1,y,nods)){
                return true;
            }
        }

        //下移
        if(x<=map.length-1 && y+1<=map[0].length-1 && map[x][y+1]==1){
            if(dfs(map,x,y+1,nods)){
                return true;
            }
        }

        //上移
        if(x<=map.length-1 && y-1>=0 && map[x][y-1]==1){
            if(dfs(map,x,y-1,nods)){
                return true;
            }
        }

        // 还原点位信息
        map[x][y] = 1;

        // 回退点位信息
        nods.remove(nods.size()-1);

        return false;
    }
}
