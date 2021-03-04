package com.hunter.study.algorithm.class03;/** * @Author 水木 * @Date 2021/2/24  10:50 上午 */public class DoubleNodesToStackAndQueue {	//自己的双端链表node	public static class Node<T> {		public T value;		public Node<T> head;		public Node<T> tail;		public Node(T t) {			value = t;		}	}	//自己的基础结构	public static class MyDoubleNodesToStackAndQueue<T> {		private Node<T> head;		private Node<T> tail;		/**		 * 从头部增加节点		 *		 * @param t		 * @return		 */		public void addFromHead(T t) {			if (t == null) {				return;			}			Node node = new Node(t);			if (head == null) {				head = node;				tail = node;				return;			}			head.head = node;			node.tail = head;			head = node;		}		/**		 * 从头部尾节点增加		 *		 * @param t		 * @return		 */		public void addFromTail(T t) {			if (t == null) {				return;			}			Node<T> node = new Node(t);			if (tail == null) {				head = node;				tail = node;				return;			}			tail.tail = node;			node.head = tail;			tail = node;		}		/**		 * 从头部节点弹出		 *		 * @return		 */		public T popFromHead() {			if (head == null) {				return null;			}			Node<T> cru = head;			if (head == tail) {				head = null;				tail = null;			} else {				head = head.tail;				cru.tail = null;				cru.head = null;			}			return cru.value;		}		/**		 * 从尾部节点弹出		 *		 * @return		 */		public T popFromTail() {			if (tail == null) {				return null;			}			Node<T> cur = tail;			if (head == tail) {				head = null;				tail = null;			} else {				tail = tail.head;				cur.head = null;				cur.tail = null;			}			return cur.value;		}	}	public static class MyStack<T> {		private MyDoubleNodesToStackAndQueue<T> myDoubleNodesToStackAndQueue = new MyDoubleNodesToStackAndQueue<T>();		//增加数据		public void add(T t) {			myDoubleNodesToStackAndQueue.addFromHead(t);		}		//取出数据		public T pop() {			return myDoubleNodesToStackAndQueue.popFromHead();		}	}	public static class MyQueue<T> {		private MyDoubleNodesToStackAndQueue<T> myDoubleNodesToStackAndQueue = new MyDoubleNodesToStackAndQueue<T>();		//增加数据		public void add(T t) {			myDoubleNodesToStackAndQueue.addFromHead(t);		}		//取出数据		public T pop() {			return myDoubleNodesToStackAndQueue.popFromTail();		}	}	public static void main(String[] args) {//		MyStack<Integer> myStack = new MyStack<>();//		myStack.add(12);//		myStack.add(14);////		System.out.println(myStack.pop());//		System.out.println(myStack.pop());		MyQueue<Integer> myQueue = new MyQueue<>();		myQueue.add(12);		myQueue.add(1);		System.out.println(myQueue.pop());		System.out.println(myQueue.pop());		myQueue.add(4);		System.out.println(myQueue.pop());	}}