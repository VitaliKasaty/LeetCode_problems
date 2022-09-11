package com.leetcode.vitalikasaty.medium.task16;

import java.util.Arrays;

/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution. 

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:
Input: nums = [0,0,0], target = 1
Output: 0

Constraints:
3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104
*/

public class Three_Sum_Closest {
	public static void main(String[] args) {

		Solution solution = new Solution();
		System.out.println(solution.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));

	}
}

class Solution {
	public int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);
		int sumThree = nums[0] + nums[1] + nums[2];
		Arrays.toString(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				int tempSumThree = nums[i] + nums[j] + nums[k];

				if (tempSumThree == target) {
					return tempSumThree;
				}

				if (Math.abs(target - tempSumThree) < Math.abs(target - sumThree)) {
					sumThree = tempSumThree;
				}
				if (tempSumThree < target) {
					j++;
				} else {
					k--;
				}
			}

		}
		return sumThree;

	}
}