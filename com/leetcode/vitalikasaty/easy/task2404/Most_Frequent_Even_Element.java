package com.leetcode.vitalikasaty.easy.task2404;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Given an integer array nums, return the most frequent even element.
If there is a tie, return the smallest one. If there is no such element, return -1.

Example 1:
Input: nums = [0,1,2,2,4,4,1]
Output: 2
Explanation:
The even elements are 0, 2, and 4. Of these, 2 and 4 appear the most.
We return the smallest one, which is 2.
		
Example 2:
Input: nums = [4,4,4,9,2,4]
Output: 4
Explanation: 4 is the even element appears the most.

Example 3:
Input: nums = [29,47,21,41,13,37,25,7]
Output: -1
Explanation: There is no even element. 

Constraints:
1 <= nums.length <= 2000
0 <= nums[i] <= 105
*/

public class Most_Frequent_Even_Element {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.mostFrequentEven(new int[] { 0, 1, 2, 2, 4, 4, 1 }));
	}
}

class Solution {
	public int mostFrequentEven(int[] nums) {
		Map<Integer, Integer> countEvenElements = new HashMap<>();

		for (int num : nums) {
			if (num % 2 == 0) {
				if (countEvenElements.containsKey(num)) {
					countEvenElements.put(num, countEvenElements.get(num) + 1);
				} else {
					countEvenElements.put(num, 1);
				}
			}
		}

		if (countEvenElements.size() == 0) {
			return -1;
		} else {

			int maxValue = Collections.max(countEvenElements.values());

			List<Integer> maxValuesKeys = countEvenElements.entrySet().stream()
					.filter(entry -> entry.getValue() == maxValue).map(Map.Entry::getKey).collect(Collectors.toList());

			Collections.sort(maxValuesKeys);
			return maxValuesKeys.get(0);

		}
	}
}