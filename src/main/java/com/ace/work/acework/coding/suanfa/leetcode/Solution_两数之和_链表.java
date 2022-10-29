package com.ace.work.acework.coding.suanfa.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


public class Solution_两数之和_链表 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int count = 0;
        ListNode resultListNode = null;
        ListNode node1 = l1;
        ListNode node2 = l2;
        while(null!=node1 || null!=node2){
            sum = (addCount(node1,node2) + count) ;
            count = sum/10;
            resultListNode = new ListNode(sum%10,null==resultListNode? null:resultListNode);
            if(null!=node1){
                node1 = node1.next;
            }
            if(null!=node2){
                node2 = node2.next;
            }
        }
        if(count>0){
            resultListNode = new ListNode(count,null==resultListNode? null:resultListNode);
        }
        return nodeRevesal(resultListNode);
    }

    public static int addCount(ListNode l1, ListNode l2) {
        if(null==l1){
            return l2.val;
        }
        if(null==l2){
            return l1.val;
        }
        return l1.val+l2.val;
    }

    /**
     * 链表反转
     * @param node
     * @return
     */
    public static ListNode nodeRevesal(ListNode node) {
        ListNode currentNode = node;
        ListNode resultNode = null;
        while(null!=currentNode){
            resultNode = new ListNode(currentNode.val,resultNode);
            currentNode = currentNode.next;
        }
        return resultNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));

        ListNode result = addTwoNumbers(l1,l2);
        System.out.println(result);
    }
}