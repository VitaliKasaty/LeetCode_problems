package com.leetcode.vitalikasaty.easy.task290;

import java.util.HashMap;
import java.util.Map;

/*
Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true

Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Example 3:
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false 

Constraints:
1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
*/

public class Word_Pattern {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.wordPattern("abba", "cat cat cat cat"));
	}

}

class Solution {
	public boolean wordPattern(String pattern, String s) {

		String[] words = s.split(" ");

		if (pattern.length() != words.length) {
			return false;
		}

		Map<Character, String> map = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {

			char symbolPattern = pattern.charAt(i);

			if (!map.containsKey(symbolPattern)) {
				for (Map.Entry<Character, String> entry : map.entrySet()) {
					if (entry.getValue().equals(words[i])) {
						return false;
					}
				}
				map.put(symbolPattern, words[i]);
			} else {
				if (!map.get(symbolPattern).equals(words[i])) {
					return false;
				}
			}
		}

		return true;
	}
}
