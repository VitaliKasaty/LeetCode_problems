package com.leetcode.vitalikasaty.easy.task1995;

/*
Given a 0-indexed integer array nums, return the number of distinct quadruplets (a, b, c, d) such that:
	nums[a] + nums[b] + nums[c] == nums[d]
	and a < b < c < d 

Example 1:
Input: nums = [1,2,3,6]
Output: 1
Explanation: The only quadruplet that satisfies the requirement is (0, 1, 2, 3) because 1 + 2 + 3 == 6.

Example 2:
Input: nums = [3,3,6,4,5]
Output: 0
Explanation: There are no such quadruplets in [3,3,6,4,5].

Example 3:
Input: nums = [1,1,1,3,5]
Output: 4
Explanation: The 4 quadruplets that satisfy the requirement are:
- (0, 1, 2, 3): 1 + 1 + 1 == 3
- (0, 1, 3, 4): 1 + 1 + 3 == 5
- (0, 2, 3, 4): 1 + 1 + 3 == 5
- (1, 2, 3, 4): 1 + 1 + 3 == 5
 

Constraints:
4 <= nums.length <= 50
1 <= nums[i] <= 100
*/

public class Count_Special_Quadruplets {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.countQuadruplets(new int[] { 1, 1, 1, 3, 5 }));
	}
}

class Solution {
	public int countQuadruplets(int[] nums) {
		int result = 0;
		int length = nums.length;

		for (int i = 0; i < length - 3; i++) {
			int a = nums[i];

			for (int k = 1; k < length - 2; k++) {
				int b = nums[k];

				for (int l = 2; l < length - 1; l++) {
					int c = nums[l];

					for (int m = 3; m < length; m++) {

						if (i < k && k < l && l < m) {
							if ((a + b + c) == nums[m]) {
								result++;
							}
						}
					}
				}
			}
		}

		return result;
	}
}
