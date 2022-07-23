package com.leetcode.vitalikasaty.easy.task9;

/*
Given an integer x, return true if x is palindrome integer.
An integer is a palindrome when it reads the same backward as forward.
For example, 121 is a palindrome while 123 is not.

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Constraints:
-231 <= x <= 231 - 1
*/

public class Palindrome_Number {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isPalindrome(12321));
	}

}

class Solution {
	public boolean isPalindrome(int x) {

		if (x < 0) {
			return false;
		} else if ((Integer.toString(x).length() % 2) == 0) {
			return false;
		} else {
			String number = Integer.toString(x);
			String firstHalf = number.substring(0, number.length() / 2);
			String secondHald = number.substring(number.length() / 2 + 1, number.length());
			secondHald = new StringBuffer(secondHald).reverse().toString();
			if (firstHalf.equals(secondHald)) {
				return true;
			} else {
				return false;
			}
		}

	}
}
