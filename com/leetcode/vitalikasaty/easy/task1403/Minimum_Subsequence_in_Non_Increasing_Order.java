package com.leetcode.vitalikasaty.easy.task1403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
Given the array nums, obtain a subsequence of the array whose sum of elements is strictly greater than the sum of the non included elements in such subsequence. 
If there are multiple solutions, return the subsequence with minimum size and if there still exist multiple solutions, 
return the subsequence with the maximum total sum of all its elements. A subsequence of an array can be obtained by erasing some (possibly zero) elements from the array. 
Note that the solution with the given constraints is guaranteed to be unique. 
Also return the answer sorted in non-increasing order.

Example 1:
Input: nums = [4,3,10,9,8]
Output: [10,9] 
Explanation: The subsequences [10,9] and [10,8] are minimal such that the sum of their elements is strictly greater than the sum of elements not included, however, the subsequence [10,9] has the maximum total sum of its elements. 

Example 2:
Input: nums = [4,4,7,6,7]
Output: [7,7,6] 
Explanation: The subsequence [7,7] has the sum of its elements equal to 14 which is not strictly greater than the sum of elements not included (14 = 4 + 4 + 6). Therefore, the subsequence [7,6,7] is the minimal satisfying the conditions. Note the subsequence has to returned in non-decreasing order.  

Example 3:
Input: nums = [6]
Output: [6]
*/

public class Minimum_Subsequence_in_Non_Increasing_Order {

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 4, 7, 6, 7 };
		Solution solution = new Solution();
		System.out.println(solution.minSubsequence(nums));
	}
}

class Solution {
	public List<Integer> minSubsequence(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int sumResult = 0;
		Arrays.sort(nums);
		
		for (int i = nums.length - 1; i >= 0; i--) {
			int sumNums = IntStream.of(nums).sum();
			if (sumResult <= sumNums) {
				sumResult += nums[i];
				result.add(nums[i]);
				nums[i] = 0;
			} else {
				break;
			}
		}

		return result;
	}
}