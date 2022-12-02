package com.leetcode.vitalikasaty.easy.task2217;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array queries and a positive integer intLength, 
	return an array answer where answer[i] is either the queries[i]th smallest positive palindrome of length intLength or -1 if no such palindrome exists.
A palindrome is a number that reads the same backwards and forwards. Palindromes cannot have leading zeros.

Example 1:
Input: queries = [1,2,3,4,5,90], intLength = 3
Output: [101,111,121,131,141,999]
Explanation:
The first few palindromes of length 3 are:
101, 111, 121, 131, 141, 151, 161, 171, 181, 191, 202, ...
The 90th palindrome of length 3 is 999.

Example 2:
Input: queries = [2,4,6], intLength = 4
Output: [1111,1331,1551]
Explanation:
The first six palindromes of length 4 are:
1001, 1111, 1221, 1331, 1441, and 1551. 

Constraints:
1 <= queries.length <= 5 * 104
1 <= queries[i] <= 109
1 <= intLength <= 15
*/

public class Find_Palindrome_With_Fixed_Length {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution
				.kthPalindrome(new int[] { 58,29,358732919,149198876,246393513,104605183,18363825 }, 1));
	}
}

class Solution {
	public long[] kthPalindrome(int[] queries, int intLength) {

		int leftPalindromeLength = (intLength + 1) / 2;
		long[] answer = new long[queries.length];
		long start = (int) Math.pow(10, leftPalindromeLength - 1);
		long maxPossibleQueryI = (long) Math.pow(10, (intLength + 1) / 2 ) - 1 ;

		for (int i = 0; i < queries.length; i++) {

			if (queries[i] > maxPossibleQueryI) {
				answer[i] = -1;
			} else if (intLength == 1) {
				answer[i] = queries[i];
			} else {
				long value = start + queries[i] - 1;
				StringBuilder leftPalinrome = new StringBuilder(String.valueOf(value));
				StringBuilder rightPalindrome;

				if (intLength % 2 == 1) {
					rightPalindrome = new StringBuilder(String.valueOf(value / 10)).reverse();
				} else {
					rightPalindrome = new StringBuilder(String.valueOf(value)).reverse();
				}
				String fullPalindrome = leftPalinrome.append(rightPalindrome).toString();

				answer[i] = Long.valueOf(fullPalindrome);
			}
		}
		System.out.println(Arrays.toString(answer));
		return answer;

	}
}