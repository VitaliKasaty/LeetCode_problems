package com.leetcode.vitalikasaty.medium.task18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order. 

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
		
Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]] 

Constraints:
1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
*/

public class Four_Sum {
	public static void main(String[] args) {
		Solution solution = new Solution();
		List<List<Integer>> result = solution.fourSum(new int[] { 1000000000, 1000000000, 1000000000, 1000000000 },
				-294967296);
		System.out.println(result.toString());
	}
}

class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		HashSet<Integer> originalNumbers = new HashSet<Integer>(
				Arrays.stream(nums).boxed().collect(Collectors.toList()));
		for (int num : originalNumbers) {
			int countCurrentNumber = (int) IntStream.of(nums).filter(elem -> elem == num).count();
			if (countCurrentNumber > 4) {
				countCurrentNumber = 4;
			}
			for (int i = 0; i < countCurrentNumber; i++) {
				tempList.add(num);
			}
		}
		nums = tempList.stream().mapToInt(i -> i).toArray();

		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				for (int k = j + 1; k < nums.length - 1; k++) {
					for (int m = k + 1; m < nums.length; m++) {

						long sum = (long) nums[i] + nums[j] + nums[k] + nums[m];
						if (sum == target) {
							List<Integer> matchCombination = new ArrayList<>();
							matchCombination.add(nums[i]);
							matchCombination.add(nums[j]);
							matchCombination.add(nums[k]);
							matchCombination.add(nums[m]);
							Collections.sort(matchCombination);
							if (!result.contains(matchCombination)) {
								result.add(matchCombination);
							}
						}

					}
				}
			}
		}
		return result;
	}
}