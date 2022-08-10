package com.leetcode.vitalikasaty.hard.task2223;

/*
You are building a string s of length n one character at a time, prepending each new character to the front of the string.
The strings are labeled from 1 to n, where the string with length i is labeled si.
For example, for s = "abaca", s1 == "a", s2 == "ca", s3 == "aca", etc.
The score of si is the length of the longest common prefix between si and sn (Note that s == sn).
Given the final string s, return the sum of the score of every si.

Example 1:
Input: s = "babab"
Output: 9
Explanation:
For s1 == "b", the longest common prefix is "b" which has a score of 1.
For s2 == "ab", there is no common prefix so the score is 0.
For s3 == "bab", the longest common prefix is "bab" which has a score of 3.
For s4 == "abab", there is no common prefix so the score is 0.
For s5 == "babab", the longest common prefix is "babab" which has a score of 5.
The sum of the scores is 1 + 0 + 3 + 0 + 5 = 9, so we return 9.
		
Example 2:
Input: s = "azbazbzaz"
Output: 14
Explanation: 
For s2 == "az", the longest common prefix is "az" which has a score of 2.
For s6 == "azbzaz", the longest common prefix is "azb" which has a score of 3.
For s9 == "azbazbzaz", the longest common prefix is "azbazbzaz" which has a score of 9.
For all other si, the score is 0.
The sum of the scores is 2 + 3 + 9 = 14, so we return 14. 

Constraints:
1 <= s.length <= 105
s consists of lowercase English letters.
*/

public class Sum_of_Scores_of_Built_Strings {

	public static void main(String[] args) {

		Solution solution = new Solution();
		System.out.println(solution.sumScores("babab"));		
		
	}
}

class Solution {
	public long sumScores(String s) {

		long result = 0;
		char[] sArray = s.toCharArray();
		//int[] zArray = new int[s.length()];

		for (int i = 0; i < sArray.length; i++) {
			
			int left = 0;
			int right = sArray.length - i - 1;
			
			while(right < sArray.length) {
				if (sArray[left] == sArray[right]) {
					result++;
					left++;
					right++;
				} else {
					break;
				}
			}
			
//			char[] si = Arrays.copyOfRange(sString, s.length() - 1 - i, s.length());
//			
//			for (int j = 0; j < si.length; j++) {
//				if (si[j] == sString[j]) {
//					result++;
//				} else {
//					break;
//				}
//			}

		}
		//System.out.println(Arrays.toString(zArray));
		return result;
	}
}
