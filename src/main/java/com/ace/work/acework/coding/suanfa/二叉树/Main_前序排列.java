package com.ace.work.acework.coding.suanfa.二叉树;

import java.util.ArrayList;
import java.util.List;

public class Main_前序排列 {

    public static void main(String[] args) {
        int[] treeNodeArray = new int[]{1,2,3};
    }

    public int[] preorderTraversal (TreeNode root) {
        List<Integer> list=new ArrayList<>();
        dfs(list,root);
        int[] res=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }

    public void dfs(List<Integer> list,TreeNode root){
        if(root!=null){
            list.add(root.value);
            dfs(list,root.left);
            dfs(list,root.right);
        }
    }

    public static class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int value;
        public TreeNode(int value) {
            this.value = value;
        }
    }

}
