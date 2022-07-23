package com.leetcode.vitalikasaty.easy.task2148;

/*Given an integer array nums, return the number of elements that have both a strictly smaller and a strictly greater element appear in nums.

Example 1:
Input: nums = [11,7,2,15]
Output: 2
Explanation: The element 7 has the element 2 strictly smaller than it and the element 11 strictly greater than it.
Element 11 has element 7 strictly smaller than it and element 15 strictly greater than it.
In total there are 2 elements having both a strictly smaller and a strictly greater element appear in nums.

Constraints:
1 <= nums.length <= 100
-105 <= nums[i] <= 105
*/

public class Count_Elements_With_Strictly_Smaller_and_Greater_Elements {

	public static void main(String[] args) {

		Solution solution = new Solution();
		int[] array = new int[] { 11, 7, 2, 15 };
		System.out.println(solution.countElements(array));

	}
}

class Solution {

	public int countElements(int[] nums) {

		int result = 0;
		int length = nums.length;
		boolean isSmaller = false;
		boolean isBigger = false;

		for (int i = 0; i < length; i++) {

			int smaller = nums[i];
			int bigger = nums[i];

			for (int j = 0; j < length; j++) {

				if (nums[j] < smaller) {
					isSmaller = true;
				} else if (nums[j] > bigger) {
					isBigger = true;
				}

				if (isSmaller & isBigger) {
					result++;
					isSmaller = false;
					isBigger = false;
					break;
				} else if (j == (length - 1)) {
					isSmaller = false;
					isBigger = false;
				}

			}
		}
		return result;
	}

}
