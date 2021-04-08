package com.hunter.study.algorithm.basesort;import com.hunter.study.algorithm.SortUtil;import org.junit.Test;import java.util.Arrays;/** * @Author 水木 * @Date 2021/2/19  12:46 下午 */public class InsertionSort {	/**	 * 插入排序 时间复杂度O(n^2)  空间复杂度O(1)  有(稳定性)	 * 和冒泡排序有点类似	 * 插入排序是给一个数据，这个数据和他前面的比较，如果小，则交换位置（值小，则往下沉）	 * 冒泡排序是给一个list,从list的第一个开始比较，如果大，则交换位置（值大，则往上冒）	 *	 * @param arr	 * @return	 */	public static int[] insertionSort(int[] arr) {		if (arr == null) {			return null;		}		//从第一个开始		for (int i = 1; i < arr.length; i++) {			//前一个与自己比较，如果自己小，则与前一个交换位置			for (int j = i; j > 0; j--) {				if (arr[j] < arr[j - 1]) {					SortUtil.swapInArray(arr, j, j - 1);				}			}		}		return null;	}	/**	 * 20210220 练习	 *	 * @param arr	 * @return	 */	public int[] insertionSort_20210220(int[] arr) {		if (arr == null || arr.length == 1) {			return arr;		}		for (int i = 0; i < arr.length; i++) {			for (int j = i; j > 0; j--) {				if (arr[j] < arr[j - 1]) {					SortUtil.swapInArray(arr, j, j - 1);				}			}		}		return arr;	}	/**	 * 20210406 练习	 *	 * @param arr	 * @return	 */	public int[] insertionSort_20210406(int[] arr) {		if (arr == null || arr.length == 1) {			return arr;		}		for (int i = 1; i < arr.length; i++) {			for (int j = i; j > 0; j--) {				if (arr[j] < arr[j - 1]) {					SortUtil.swapInArray(arr, j, j - 1);				}			}		}		return arr;	}	@Test	public void insertionSortTest() {		int max = 100;		for (int i = 0; i < max; i++) {			final int[] before = SortUtil.generateRandomArray(5, 10);			System.out.println("==========第" + i + 1 + "组=========");			System.out.println("before=" + Arrays.toString(before));			//			insertionSort(before);			insertionSort_20210406(before);			System.out.println("after=" + Arrays.toString(before));		}	}}