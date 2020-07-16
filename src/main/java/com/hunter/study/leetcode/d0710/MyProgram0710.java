package com.hunter.study.leetcode.d0710;

/**
 * @Author 水木
 * @Date 2020/7/10  11:21 下午
 */
public class MyProgram0710 {
    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNode = null;
        ListNode nexNode = null;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int mo = (l1.val + l2.val + sum) % 10;
                ListNode tempNode = new ListNode(mo);
                if (headNode == null) {
                    headNode = tempNode;
                } else {
                    nexNode.next = tempNode;
                }
                nexNode = tempNode;
                sum = (l1.val + l2.val + sum) / 10;
                l1 = l1.next;
                l2 = l2.next;
                continue;
            }

            if (l1 != null && l2 == null) {
                if (headNode == null) {
                    headNode = l1;
                } else {
                    int mo = (l1.val + sum) % 10;
                    ListNode tempNode = new ListNode(mo);
                    sum = (l1.val + sum) / 10;
                    nexNode.next = tempNode;
                    nexNode = tempNode;
                }
                l1 = l1.next;
                continue;
            }

            if (l2 != null && l1 == null) {
                if (headNode == null) {
                    headNode = l2;
                } else {
                    int mo = (l2.val + sum) % 10;
                    ListNode tempNode = new ListNode(mo);
                    sum = (l2.val + sum) / 10;
                    nexNode.next = tempNode;
                    nexNode = tempNode;

                }
                l2 = l2.next;
                continue;
            }
        }
        if (sum > 0) {
            ListNode tempNode = new ListNode(sum);
            nexNode.next = tempNode;
        }

        return headNode;
    }
}
