package com.prehitting.solutions.leetcode;

import com.prehitting.annotation.Question;
import com.prehitting.enums.Level;
import com.prehitting.enums.Type;

@Question(title = "合并两个链表", level = Level.MEDIUM, tags = {Type.Mock})
public class Solution1669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = new ListNode(-1, list1);
        ListNode cursor = head.next;
        int index = 0;
        while (index < a - 1) {
            cursor = cursor.next;
            index++;
        }
        ListNode node1 = cursor;
        while (index <= b) {
            cursor = cursor.next;
            index++;
        }
        ListNode node2 = cursor;
        node1.next = list2;
        while (node1.next != null) {
            node1 = node1.next;
        }
        node1.next = node2;
        return head.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
