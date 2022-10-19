package com.leetcode.vitalikasaty.medium.task1711;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/*
A good meal is a meal that contains exactly two different food items with a sum of deliciousness equal to a power of two.
You can pick any two different foods to make a good meal.
Given an array of integers deliciousness where deliciousness[i] is the deliciousness of the i​​​​​​th​​​​​​​​ item of food,
return the number of different good meals you can make from this list modulo 10^9 + 7.

Note that items with different indices are considered different even if they have the same deliciousness value.

Example 1:
Input: deliciousness = [1,3,5,7,9]
Output: 4
Explanation: The good meals are (1,3), (1,7), (3,5) and, (7,9).
Their respective sums are 4, 8, 8, and 16, all of which are powers of 2.

Example 2:
Input: deliciousness = [1,1,1,3,3,3,7]
Output: 15
Explanation: The good meals are (1,1) with 3 ways, (1,3) with 9 ways, and (1,7) with 3 ways. 

Constraints:
1 <= deliciousness.length <= 105
0 <= deliciousness[i] <= 220
*/

public class Count_Good_Meals {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.countPairs(new int[] { 1, 1, 1, 3, 3, 3, 7 }));
		System.out.println(solution.countPairs(new int[] { 1, 3, 5, 7, 9 }));
		System.out.println(solution.countPairs(
				new int[] { 149, 107, 1, 63, 0, 1, 6867, 1325, 5611, 2581, 39, 89, 46, 18, 12, 20, 22, 234 }));
	}
}

class Solution {

	public int countPairs(int[] deliciousness) {

		int result = 0;
		int mod = 1000000007;
		Map<Integer, Integer> passedValues = new HashMap<>();

		for (int i = 0; i < deliciousness.length; i++) {
			int meal = deliciousness[i];
			for (int j = 0; j <= 21; j++) {
				int shift = 1 << j;
				int requiredPair = shift - meal;

				if (passedValues.containsKey(requiredPair)) {
					result += passedValues.get(requiredPair);
					result %= mod;
				}
			}
			if (!passedValues.containsKey(meal)) {
				passedValues.put(meal, 1);
			} else {
				passedValues.put(meal, passedValues.get(meal) + 1);
			}
		}

		return result;
	}
}
