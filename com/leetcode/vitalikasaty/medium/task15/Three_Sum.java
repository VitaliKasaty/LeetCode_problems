package com.leetcode.vitalikasaty.medium.task15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
Given an integer array nums, 
return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0. 

Constraints:
3 <= nums.length <= 3000
-105 <= nums[i] <= 105
*/

public class Three_Sum {
	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}
}

class Solution {
	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		HashMap<Integer, Integer> iMap = new HashMap<>();
		HashSet<String> foundTriplets = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			iMap.put(nums[i], i);
		}

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = nums.length - 1; j > i; j--) {
				int sumIJ = (nums[i] * -1) + (nums[j] * -1);

				if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

					if (iMap.containsKey(sumIJ) && iMap.get(sumIJ) != i && iMap.get(sumIJ) != j) {
						int[] numTriplet = new int[] { nums[i], nums[j], sumIJ };
						Arrays.sort(numTriplet);
						String strTriplet = Integer.toString(numTriplet[0]) + Integer.toString(numTriplet[1])
								+ Integer.toString(numTriplet[2]);

						if (foundTriplets.add(strTriplet)) {
							result.add(
									new ArrayList<Integer>(Arrays.asList(numTriplet[0], numTriplet[1], numTriplet[2])));

						}
					}
				}
			}
		}

		return result;
	}
}