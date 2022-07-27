package com.leetcode.vitalikasaty.easy.task557;

/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
	
Example 2:
Input: s = "God Ding"
Output: "doG gniD" 

Constraints:
1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
*/

public class Reverse_Words_in_a_String_III {

	public static void main(String[] args) {

		Solution solution = new Solution();
		System.out.println(solution.reverseWords("Let's take LeetCode contest"));
	}

}

class Solution {
	public String reverseWords(String s) {

		String result = "";
		String[] sSplit = s.split(" ");		
		
		for (int i = 0; i < sSplit.length; i++) {
			result += new StringBuffer(sSplit[i]).reverse();
			result += " ";
		}		
				
		return result.trim();
	}
}