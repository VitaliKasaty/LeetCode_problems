package com.leetcode.vitalikasaty.easy.task1160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given an array of strings words and a string chars.
A string is good if it can be formed by characters from chars (each character can only be used once).
Return the sum of lengths of all good strings in words.

Example 1:
Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

Example 2:
Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10. 

Constraints:
1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
words[i] and chars consist of lowercase English letters.
*/

public class Find_Words_That_Can_Be_Formed_by_Characters {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.countCharacters(new String[] { "hello", "world", "leetcode" }, "welldonehoneyr"));
	}
}

class Solution {
	public int countCharacters(String[] words, String chars) {

		int result = 0;
		List<Integer> sizeWords = new ArrayList<>();
		Arrays.stream(words).forEach(word -> sizeWords.add(word.length()));

		for (char ch : chars.toCharArray()) {
			words = Arrays.stream(words).map(word -> word.replaceFirst(ch + "", "")).toArray(String[]::new);
		}

		for (int i = 0; i < words.length; i++) {
			if (words[i].length() == 0) {
				result += sizeWords.get(i);
			}
		}
		return result;
	}
}