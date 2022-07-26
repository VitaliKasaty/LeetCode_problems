package com.leetcode.vitalikasaty.easy.task389;

/*
You are given two strings s and t.
String t is generated by random shuffling string s and then add one more letter at a random position.
Return the letter that was added to t. 

Example 1:
Input: s = "abcd", t = "abcde"
Output: "e"
Explanation: 'e' is the letter that was added.

Example 2:
Input: s = "", t = "y"
Output: "y" 

Constraints:
0 <= s.length <= 1000
t.length == s.length + 1
s and t consist of lowercase English letters.
*/

public class Find_the_Difference {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.findTheDifference("abcd", "abcde"));
	}
}

class Solution {
	public char findTheDifference(String s, String t) {

		int sumS = 0;
		int sumT = 0;
		for (int i = 0; i < s.length(); i++) {
			sumS += (int) s.charAt(i);
			sumT += (int) t.charAt(i);
		}
		sumT += t.charAt(t.length() - 1);

		return (char) (sumT - sumS);
	}
}