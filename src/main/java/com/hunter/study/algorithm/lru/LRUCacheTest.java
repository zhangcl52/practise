package com.hunter.study.algorithm.lru;/** * @Author 水木 * @Date 2021/3/15  4:04 下午 */public class LRUCacheTest {	public static void main(String[] args) {		LRUCache lruCache=new LRUCache(2);		lruCache.put(1,1);		lruCache.put(2,2);		lruCache.get(1);		lruCache.put(3,3);		System.out.println(lruCache.get(1));	}}