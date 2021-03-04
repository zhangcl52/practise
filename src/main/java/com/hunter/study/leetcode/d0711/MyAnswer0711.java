package com.hunter.study.leetcode.d0711;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 水木
 * @Date 2020/7/10  11:56 下午
 */
public class MyAnswer0711 {

	public static void main(String[] args) {
		String s = "abba";
		System.out.println(lengthOfLongestSubstring(s));
		System.out.println(lengthOfLongestSubstring_leetCode(s));

	}

	public static int lengthOfLongestSubstring(String s) {
//		s.length()
		if (s == null || s.isEmpty()) {
			return 0;
		}
		//key为字符串的字符串，value为某个字符的index
		Map<String, Integer> map = new HashMap();
		char[] chars = s.toCharArray();

		int max = 0;
		int index = 0;
		for (int i = 0; i < chars.length; i++) {
			Integer oneCharOfsIndex = map.get(String.valueOf(chars[i]));
			if (oneCharOfsIndex != null) {
				for (int j = index; j <= oneCharOfsIndex; j++) {
					map.remove(String.valueOf(chars[j]));
				}
				index = oneCharOfsIndex + 1;
			}
			map.put(String.valueOf(chars[i]), i);
			max = Math.max(max, map.size());
		}
		return max;
	}

	public static int lengthOfLongestSubstring_leetCode(String s) {
		if (s.length() == 0) return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		int left = 0;
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				//为了去除掉已经left 左边重重数据的干扰
				left = Math.max(left, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - left + 1);
		}
		return max;
	}
}
