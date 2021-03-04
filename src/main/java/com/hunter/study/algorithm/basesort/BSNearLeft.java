package com.hunter.study.algorithm.basesort;

import com.hunter.study.algorithm.SortUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author 水木
 * @Date 2021/2/19  5:49 下午
 */
public class BSNearLeft {

	/**
	 * 用二分查找
	 * 在一个有序数组中，找>=某个数最左侧的位置
	 *
	 * @param sortedArr
	 * @param num
	 * @return
	 */
	public static int bsNearLeft(int[] sortedArr, int num) {
		if (sortedArr == null) {
			return -1;
		}
		int l = 0;
		int r = sortedArr.length - 1;
		int index = -1;
		while (l <= r) {
			int m = l + ((r - l) >>> 1);
			if (sortedArr[m] >= num) {
				index = m;
				r = r - 1;
			} else {
				l = l + 1;
			}
		}
		return index;
	}


	@Test
	public void bsNearLeftTest() {
		int maxValue = 10;
		int forEachTime = 100;
		for (int i = 0; i < forEachTime; i++) {
			System.out.println("==========第" + i + "组=========");
			final int[] array = SortUtil.generateRandomArray(5, maxValue);
			InsertionSort.insertionSort(array);
			int num = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
			System.out.println("数组为：" + Arrays.toString(array) + "  要查找的值为：" + num);
			System.out.println("结果为：" + bsNearLeft(array, num));
		}

	}
}
