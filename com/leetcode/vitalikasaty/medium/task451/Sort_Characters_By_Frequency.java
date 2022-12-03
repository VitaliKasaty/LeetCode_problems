package com.leetcode.vitalikasaty.medium.task451;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
Given a string s, sort it in decreasing order based on the frequency of the characters.
The frequency of a character is the number of times it appears in the string.
Return the sorted string. If there are multiple answers, return any of them.

Example 1:
Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:
Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 

Constraints:
1 <= s.length <= 5 * 105
s consists of uppercase and lowercase English letters and digits.
*/

public class Sort_Characters_By_Frequency {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.frequencySort("Aabb"));
	}
}

class Solution {
	public String frequencySort(String s) {

		String result = "";
		Map<Character, Integer> mapCharCount = new LinkedHashMap<>();

		String sDistinct = s.chars()
				.distinct()
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();

		for (int i = 0; i < sDistinct.length(); i++) {
			char ch = sDistinct.charAt(i);
			int count = (int) s.chars().filter(c -> c == ch).count();
			mapCharCount.put(ch, count);
		}

		mapCharCount = mapCharCount.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));		

		for (Map.Entry<Character, Integer> entry : mapCharCount.entrySet()) {
			String temp = entry.getKey() + "";
			result += temp.repeat(entry.getValue());
		}

		return result;
	}
}