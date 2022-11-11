package com.leetcode.vitalikasaty.medium.task686;

/*
Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it.
If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.
Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".

Example 1:
Input: a = "abcd", b = "cdabcdab"
Output: 3
Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.

Example 2:
Input: a = "a", b = "aa"
Output: 2 

Constraints:
1 <= a.length, b.length <= 104
a and b consist of lowercase English letters.
*/

public class Repeated_String_Match {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.repeatedStringMatch("abcd", "cdabcdab"));
	}
}

class Solution {
	public int repeatedStringMatch(String a, String b) {

		int count = 0;
		String nextA = "";
		while (nextA.length() < b.length() + a.length()) {
			nextA += a;
			if (nextA.indexOf(b) == -1) {
				count++;
			} else {
				return count += 1;
			}
		}

		return -1;
	}
}