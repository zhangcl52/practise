package com.hunter.study.algorithm.class03;import org.junit.Test;import java.util.Objects;/** * @Author 水木 * @Date 2021/2/23  7:36 下午 */public class DeleteGivenValue {	/**	 * 删除指定的值	 *	 * @param head	 * @param num	 * @return	 */	public static Node deleteNum(Node<Integer> head, int num) {		//处理第一个数是num的情况		while (head != null && Objects.equals(head.value, num)) {			head = head.next;		}		if (head == null) {			return null;		}		Node pre = head;		Node cur = head.next;		while (cur != null) {			if (Objects.equals(cur.value, num)) {				pre.next = cur.next;			} else {				pre = cur;			}			cur = cur.next;		}		return head;	}	@Test	public void deleteNumTest() {		int max = 100;		for (int i = 0; i < max; i++) {			Node head = NodeUtils.generateRandomLinkedList(10, 5);			System.out.println("==========测试" + i + "=========");			int num = (int) (Math.random() * (5 + 1));			System.out.println(NodeUtils.nodeToString(head) + "，要删除的数据为：" + num);			System.out.println(NodeUtils.nodeToString(deleteNum(head, num)));		}	}}