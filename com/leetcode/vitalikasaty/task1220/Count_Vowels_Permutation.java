package com.leetcode.vitalikasaty.task1220;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
Difficulty: Hard

Given an integer n, your task is to count how many strings of length n can be formed under the following rules:
Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7. 

Example 1:
Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".

Example 2:
Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".

Example 3: 
Input: n = 5
Output: 68 

Constraints:
1 <= n <= 2 * 10^4
*/

public class Count_Vowels_Permutation {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.countVowelPermutation(20));
	}
}

class Solution {

	int[] result = new int[5];

	public int[] recursion(int n, Character symbol) {

		if (n == 0) {
			return result;
		}

		if (symbol.equals('a')) {
			if (n == 1) {
				result[0] += 1;
			} else {
				recursion(n - 1, 'e');
			}
		} else if (symbol.equals('e')) {
			if (n == 1) {
				result[1] += 2;
			} else {
				recursion(n - 1, 'a');
				recursion(n - 1, 'i');
			}
		} else if (symbol.equals('o')) {
			if (n == 1) {
				result[2] += 2;
			} else {
				recursion(n - 1, 'i');
				recursion(n - 1, 'u');
			}
		} else if (symbol.equals('u')) {
			if (n == 1) {
				result[3] += 1;
			} else {
				recursion(n - 1, 'a');
			}
		} else if (symbol.equals('i')) {
			if (n == 1) {
				result[4] += 4;
			} else {
				recursion(n - 1, 'e');
				recursion(n - 1, 'o');
				recursion(n - 1, 'u');
				recursion(n - 1, 'a');
			}
		}

		return result;
	}

	public int countVowelPermutation(int n) {

		if (n == 1) {
			return 5;
		} else {
			n--;
		}

		int finalCount;
		recursion(n, 'a');
		recursion(n, 'e');
		recursion(n, 'o');
		recursion(n, 'u');
		recursion(n, 'i');

		finalCount = result[0] + result[1] + result[2] + result[3] + result[4];

		return finalCount;
	}

}