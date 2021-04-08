package com.hunter.study.algorithm.lru;import java.util.HashMap;import java.util.Map;/** * @Author 水木 * @Date 2021/3/15  4:03 下午 */public class LRUCache {	public int capacity;	public int size;	public Node tail;	public Node head;	private Map<Integer, Node> nodeMap;	class Node {		public int key;		public int value;		public Node pre;		public Node next;		public Node(int key, int value) {			this.key = key;			this.value = value;		}		public Node() {		}	}	public LRUCache(int capacity) {		this.capacity = capacity;		this.tail = new Node();		this.head = new Node();		tail.pre = head;		head.next = tail;		nodeMap = new HashMap<Integer, Node>(capacity);	}	public int get(int key) {		//如果没有，则返回-1		Node node = nodeMap.get(key);		if (node == null) {			return -1;		}		//如果存在先将则值放到head的头部，则返回		moveHead(node);		return node.value;	}	public void put(int key, int value) {		Node node = nodeMap.get(key);		if (size < capacity) {			if (node == null) {				size++;				node = new Node(key, value);				nodeMap.put(key, node);				node.next = head.next;				head.next.pre = node;				node.pre = head;				head.next = node;			} else {				nodeMap.put(key, node);				moveHead(node);			}		} else {			if (node == null) {				//删除最后一个				deleteTail(tail.pre);				size++;				node = new Node(key, value);				nodeMap.put(key, node);				node.next = head.next;				head.next.pre = node;				node.pre = head;				head.next = node;			} else {				nodeMap.put(key, node);				moveHead(node);			}		}	}	private void deleteTail(Node node) {		if (node == null) {			return;		}		nodeMap.remove(node.key);		size--;		node.pre.next = tail;		node.next.pre = node.pre;		node.pre = null;		node.next = null;	}	private void moveHead(Node node) {		if (node == null || head.next == node) {			return;		}		node.pre.next = node.next;		node.next.pre = node.pre;		node.next = head.next;		head.next.pre = node;		node.pre = head;		head.next = node;	}}