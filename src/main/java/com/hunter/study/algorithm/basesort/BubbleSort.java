package com.hunter.study.algorithm.basesort;import com.hunter.study.algorithm.SortUtil;import org.junit.Test;import java.util.Arrays;/** * @Author 水木 * @Date 2021/2/19  12:47 下午 */public class BubbleSort {	/**	 * 冒泡排序  时间复杂度O(n^2)  空间复杂度O(1)  有(稳定性)	 *	 * @param arr	 * @return	 */	public static int[] bubbleSort(int[] arr) {		if (arr == null) {			return null;		}		for (int i = arr.length - 1; i >= 0; i--) {			for (int j = 0; j < i; j++) {				if (arr[j] > arr[j + 1]) {					SortUtil.swapInArray(arr, j, j + 1);				}			}		}		return arr;	}	/**	 * 20210220 练习	 *	 * @param arr	 * @return	 */	public int[] bubbleSort_0220(int[] arr) {		if (arr == null || arr.length == 1) {			return arr;		}		for (int i = arr.length - 1; i > 0; i--) {			for (int j = 0; j < i; j++) {				if (arr[j] > arr[j + 1]) {					SortUtil.swapInArray(arr, j, j + 1);				}			}		}		return arr;	}	/**	 * 20210406 练习	 *	 * @param arr	 * @return	 */	public int[] bubbleSort_0406(int[] arr) {		if (arr == null || arr.length == 1) {			return arr;		}		for (int i = arr.length - 1; i > 0; i--) {			for (int j = 0; j < i; j++) {				if(arr[j]>arr[j+1]){					SortUtil.swapInArray(arr, j, j + 1);				}			}		}		return arr;	}	@Test	public void bubbleSortTest() {		int max = 100;		for (int i = 0; i < max; i++) {			final int[] before = SortUtil.generateRandomArray(5, 10);			System.out.println("==========第" + i + 1 + "组=========");			System.out.println("before=" + Arrays.toString(before));			bubbleSort_0406(before);			System.out.println("after=" + Arrays.toString(before));		}	}}