package com.markbdsouza.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * URL: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Level: MEDIUM
 * Tags: Linked List, Two Pointers
 * <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class Problem019RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode firstPointer = start;
        ListNode secondPointer = firstPointer;
        int i =1;
        while(i<=n+1 ){
            secondPointer = secondPointer.next;
            i++;
        }
        while(secondPointer!=null){
            secondPointer = secondPointer.next;
            firstPointer = firstPointer.next;
        }
        firstPointer.next = firstPointer.next.next;
        return start.next;
    }
}

class ListNode {
   int val;
   ListNode next;
   ListNode() {}
   ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}