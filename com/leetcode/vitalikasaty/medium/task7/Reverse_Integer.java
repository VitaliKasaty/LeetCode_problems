package com.leetcode.vitalikasaty.medium.task7;

/*
Given a signed 32-bit integer x, return x with its digits reversed. 
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21 

Constraints:
-231 <= x <= 231 - 1
*/

public class Reverse_Integer {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reverse(-123));
	}

}

class Solution {
	public int reverse(int x) {

		int result = 0;

		while (x != 0) {
			int lastDigit = x % 10;
			x /= 10;
			if (result > Integer.MAX_VALUE / 10)
				return 0;
			if (result < Integer.MIN_VALUE / 10)
				return 0;
			result = result * 10 + lastDigit;
		}

		return result;
	}
}
