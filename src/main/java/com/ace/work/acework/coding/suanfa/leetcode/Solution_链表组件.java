package com.ace.work.acework.coding.suanfa.leetcode;

/**
 * 找链表的组件
 */
public class Solution_链表组件{
    public static int numComponents(ListNode head, int[] nums) {
        int[] index = new int[10001];
        for (int num: nums) {
            index[num] = 1;
        }
        int result = 0;
        int pre = 0;
        while (head != null) {
            if (pre == 0 && index[head.val] == 1) {
                result++;
            }
            pre = index[head.val];
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0,new ListNode(1,new ListNode(2,new ListNode(3))));
        int[] nums = new int[]{0,1,3};
        System.out.println("组件数："+Solution_链表组件.numComponents(head,nums));
    }
}