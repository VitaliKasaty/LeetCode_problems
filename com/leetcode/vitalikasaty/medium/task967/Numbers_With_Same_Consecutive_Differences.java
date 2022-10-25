package com.leetcode.vitalikasaty.medium.task967;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given two integers n and k, return an array of all the integers of length n where the difference between every two consecutive digits is k.
You may return the answer in any order.
Note that the integers should not have leading zeros. Integers as 02 and 043 are not allowed.

Example 1:
Input: n = 3, k = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.

Example 2:
Input: n = 2, k = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98] 

Constraints:
2 <= n <= 9
0 <= k <= 9
*/

public class Numbers_With_Same_Consecutive_Differences {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.numsSameConsecDiff(3, 0)));
	}
}

class Solution {
	public int[] numsSameConsecDiff(int n, int k) {

		List<Integer> nums = new ArrayList<>();

		for (int i = 0; i < 10 - k; i++) {
			int goodDigits = i * 10 + i + k;

			if (k == 0) {
				if (i != 0) {
					nums.add(i * 10 + i);
				}
			} else if (goodDigits >= 10) {
				nums.add(goodDigits);
				int reverse = (goodDigits % 10) * 10 + goodDigits / 10;
				nums.add(reverse);
			} else {
				nums.add(goodDigits * 10);
			}
		}

		int iter = 2;
		while (iter != n) {
			List<Integer> nextIterationNums = new ArrayList<>(nums);

			for (int num : nextIterationNums) {
				int rightDigit = num % 10;

				if (k == 0) {
					nums.add(num * 10 + rightDigit);
				} else {
					if (rightDigit - k >= 0) {
						nums.add(num * 10 + (rightDigit - k));
					}
					if (rightDigit + k < 10) {
						nums.add(num * 10 + (rightDigit + k));
					}
				}
			}
			int power = iter;
			nums.removeIf(x -> x < ((int) Math.pow(10, power)));
			iter++;
		}

		return nums.stream().mapToInt(i -> i).toArray();
	}
}
