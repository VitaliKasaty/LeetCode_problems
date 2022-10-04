package com.leetcode.vitalikasaty.easy.task747;

import java.util.Arrays;

/*
You are given an integer array nums where the largest integer is unique.
Determine whether the largest element in the array is at least twice as much as every other number in the array.
If it is, return the index of the largest element, or return -1 otherwise.

Example 1:
Input: nums = [3,6,1,0]
Output: 1
Explanation: 6 is the largest integer.
For every other number in the array x, 6 is at least twice as big as x.
The index of value 6 is 1, so we return 1.
		
Example 2:
Input: nums = [1,2,3,4]
Output: -1
Explanation: 4 is less than twice the value of 3, so we return -1.

Constraints:
2 <= nums.length <= 50
0 <= nums[i] <= 100
The largest element in nums is unique.
*/

public class Largest_Number_At_Least_Twice_of_Others {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.dominantIndex(new int[] { 3, 6, 1, 0 }));
	}
}

class Solution {
	public int dominantIndex(int[] nums) {
		int resultIndex = 0;
		int maxNum = Integer.MIN_VALUE;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > maxNum) {
				maxNum = nums[i];
				resultIndex = i;
			}
		}
		
		Arrays.sort(nums);
		maxNum = nums[nums.length - 1];		
		for (int i = nums.length - 2; i >= 0; i--) {
			if (maxNum < (nums[i] * 2)) {
				return -1;
			}
		}
		return resultIndex ;
	}
}
