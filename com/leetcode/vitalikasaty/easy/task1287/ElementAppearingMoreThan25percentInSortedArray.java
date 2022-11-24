package com.leetcode.vitalikasaty.easy.task1287;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ElementAppearingMoreThan25percentInSortedArray {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.findSpecialInteger(new int[] { 1, 2, 2, 6, 6, 6, 6, 7, 10 }));
	}
}

class Solution {
	public int findSpecialInteger(int[] arr) {

		int arrLength = arr.length;
		Set<Integer> setValues = Arrays.stream(arr).boxed().collect(Collectors.toSet());

		for (int value : setValues) {
			long countValue = IntStream.of(arr).filter(x -> x == value).count();
			float percentUsage = (float) countValue / arrLength * 100;

			if (percentUsage > 25) {
				return value;
			}
		}
		return 0;
	}
}