package com.leetcode.vitalikasaty.easy.task20;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
	Open brackets must be closed by the same type of brackets.
	Open brackets must be closed in the correct order.
	Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false 

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

public class Valid_Parentheses {
	public static void main(String[] args) {
		Solution solution = new Solution();

		System.out.println(solution.isValid("()[]{}"));
	}
}

class Solution {
	public boolean isValid(String s) {

		StringBuilder sb = new StringBuilder(s);

		while (sb.length() > 0) {
			int indexPairClosed = -2;

			if (sb.indexOf("()") > -1) {
				indexPairClosed = sb.indexOf("()");
			} else if (sb.indexOf("{}") > -1) {
				indexPairClosed = sb.indexOf("{}");
			} else if (sb.indexOf("[]") > -1) {
				indexPairClosed = sb.indexOf("[]");
			}

			if (indexPairClosed != -2) {
				sb.delete(indexPairClosed, indexPairClosed + 2);
			} else if (sb.length() > 0) {
				return false;
			}
		}

		return true;
	}
}
