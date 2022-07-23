package com.leetcode.vitalikasaty.hard.task1220;

import java.util.Arrays;

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
		System.out.println(solution.countVowelPermutation(123456));
	}
}

class Solution {

	public int countVowelPermutation(int n) {
		
		int mod = 1000000007;
		
		int[][] countByLastSymbol = new int[n][5];
		
		Arrays.fill(countByLastSymbol[0], 1);
		
		for (int i = 1; i < n; i++) {			
//			[i][0] = a;
//			[i][1] = e;
//			[i][2] = i;
//			[i][3] = o;
//			[i][4] = u;	
			
			countByLastSymbol[i][0] += (((countByLastSymbol[i - 1][1] 
					+ countByLastSymbol[i - 1][2]) % mod) + countByLastSymbol[i - 1][4]) % mod;
			
			countByLastSymbol[i][1] += (countByLastSymbol[i - 1][0] 
					+ countByLastSymbol[i - 1][2]) % mod; 
			
			countByLastSymbol[i][2] += (countByLastSymbol[i - 1][1] 
					+ countByLastSymbol[i - 1][3]) % mod;
			
			countByLastSymbol[i][3] += countByLastSymbol[i - 1][2] % mod;
			
			countByLastSymbol[i][4]	+= (countByLastSymbol[i - 1][2]
					+ countByLastSymbol[i - 1][3]) % mod;
			
			
		}
		
		int totalCount = 0;
		
		for(int i = 0; i < 5; i++) {
			totalCount += countByLastSymbol[n-1][i];
			totalCount %= mod;
		}
		
		return totalCount;
	}

}