package com.leetcode.vitalikasaty.medium.task5;

/*
Given a string s, return the longest palindromic substring in s.		 

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.
*/

public class Longest_Palindromic_Substring {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.longestPalindrome("abacab"));
	}
}

class Solution {
	public String longestPalindrome(String s) {
		String result = "";
		String resultSubString;

		for (int i = 0; i < s.length(); i++) {
			for (int j = s.length(); j > i; j--) {
				resultSubString = s.substring(i, j);
				if (resultSubString.charAt(0) == resultSubString.charAt(resultSubString.length() - 1)) {
					if (isPalindrome(resultSubString) && result.length() < resultSubString.length()) {
						result = resultSubString;
						if (result.length() > s.length() - result.length()) {
							return result;
						}
					}
				}
			}
		}

		return result;
	}

	public boolean isPalindrome(String inputString) {

		String firstHalfString;
		String secondHalfString;

		if (inputString.length() % 2 == 0) {
			firstHalfString = inputString.substring(0, inputString.length() / 2);
			secondHalfString = new StringBuilder(inputString.substring(inputString.length() / 2)).reverse().toString();
		} else {
			firstHalfString = inputString.substring(0, inputString.length() / 2);
			secondHalfString = new StringBuilder(inputString.substring(inputString.length() / 2 + 1)).reverse()
					.toString();
		}

		if (firstHalfString.equals(secondHalfString)) {
			return true;
		} else {
			return false;
		}

	}
}
