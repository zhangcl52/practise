package com.hunter.study.leetcode;/** * @Author 水木 * @Date 2021/2/25  5:18 下午 */public class LongestPalindrome {	/**	 * 最长回文子串	 * https://leetcode-cn.com/problems/longest-palindromic-substring/	 * 给你一个字符串 s，找到 s 中最长的回文子串。	 *	 * @param s	 * @return	 */	public String longestPalindromeBaoli(String s, int left, int right) {		if (left == 0 || right == s.length() - 1) {			return s.substring(left, right + 1);		}		if (left == right) {			return s.substring(left, right + 1);		}		String s1 = longestPalindromeBaoli(s, left - 1, right + 1);		return s1;	}	public String longestPalindromedp(String s) {		int n = s.length();		boolean[][] dp = new boolean[n][n];		String ans = "";		for (int l = 0; l < n; ++l) {			for (int i = 0; i + l < n; ++i) {				int j = i + l;				if (l == 0) {					dp[i][j] = true;				} else if (l == 1) {					dp[i][j] = (s.charAt(i) == s.charAt(j));				} else {					dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);				}				if (dp[i][j] && l + 1 > ans.length()) {					ans = s.substring(i, i + l + 1);				}			}		}		return ans;	}}