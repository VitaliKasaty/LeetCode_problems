package com.leetcode.vitalikasaty.task1220;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		System.out.println(solution.countVowelPermutation(100));
	}
}

class Solution {

	Map<String, String[]> combinationBySymbol = new HashMap<>();
	{
		combinationBySymbol.put("a", new String[] { "e" });
		combinationBySymbol.put("e", new String[] { "a", "i" });
		combinationBySymbol.put("o", new String[] { "i", "u" });
		combinationBySymbol.put("u", new String[] { "a" });
		combinationBySymbol.put("i", new String[] { "e", "o", "u", "a" });
	}

	public int countVowelPermutation(int n) {

		List<String> listResultString = new ArrayList<>();
		listResultString.add("a");
		listResultString.add("e");
		listResultString.add("o");
		listResultString.add("u");
		listResultString.add("i");

		for (int i = 1; i < n; i++) {

			int lengthListResultSizeCurrent = listResultString.size();
			for (int j = 0; j < lengthListResultSizeCurrent; j++) {

				String lastSymbol = listResultString.get(j).substring(listResultString.get(j).length() - 1);

				String[] nextValueBySymbol = combinationBySymbol.get(lastSymbol);
				for (int z = 0; z < nextValueBySymbol.length; z++) {
					listResultString.add(listResultString.get(j) + nextValueBySymbol[z]);
				}
			}

			for (int p = 0; p < lengthListResultSizeCurrent; p++) {
				if (listResultString.get(p).length() == i) {
					listResultString.remove(p);
					p = -1;
				}
			}
		}

		System.out.println(listResultString);

		return listResultString.size();

	}

}
