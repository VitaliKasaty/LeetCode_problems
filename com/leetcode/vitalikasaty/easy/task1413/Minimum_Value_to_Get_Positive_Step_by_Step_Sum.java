package com.leetcode.vitalikasaty.easy.task1413;

import java.util.Arrays;

/*
Given an array of integers nums, you start with an initial positive value startValue.
In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
Return the minimum positive value of startValue such that the step by step sum is never less than 1. 

Example 1:
Input: nums = [-3,2,-3,4,2]
Output: 5
Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
step by step sum
startValue = 4 | startValue = 5 | nums
  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
  
Example 2:
Input: nums = [1,2]
Output: 1
Explanation: Minimum start value should be positive. 

Example 3:
Input: nums = [1,-2,-3]
Output: 5 

Constraints:
1 <= nums.length <= 100
-100 <= nums[i] <= 100
*/

public class Minimum_Value_to_Get_Positive_Step_by_Step_Sum {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.minStartValue(new int[] { 2, 3, 5, -5, -1 }));
	}
}

class Solution {
	public int minStartValue(int[] nums) {

		int min = Arrays.stream(nums).min().getAsInt();
		int result = 0;
		if (min > 0) {
			return 1;
		} else {
			for (int i = 1; i < Integer.MAX_VALUE; i++) {
				int[] newNums = new int[nums.length];
				newNums[0] = nums[0] + i;

				for (int j = 1; j < nums.length; j++) {
					newNums[j] = nums[j] + newNums[j - 1];
				}
				if (Arrays.stream(newNums).min().getAsInt() > 0) {
					result = i;
					break;
				}
			}
		}
		return result;
	}
}