package com.leetcode.vitalikasaty.easy.task14;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "". 

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
	
Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings. 

Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
*/

public class Longest_Common_Prefix {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
	}
}

class Solution {
	public String longestCommonPrefix(String[] strs) {

		StringBuilder result = new StringBuilder("");
		boolean finished = false;

		Comparator<String> comprator = (o1, o2) -> o1.length() - o2.length();
		Arrays.sort(strs, comprator);

		for (int i = 0; i < strs[0].length() && !finished; i++) {
			char symbol = strs[0].charAt(i);

			for (int j = 1; j < strs.length; j++) {
				if (strs[j].charAt(i) != symbol) {
					finished = true;
					break;
				}
			}
			if (!finished) {
				result.append(symbol);
			}
		}

		return result.toString();
	}
}
