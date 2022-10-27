package com.leetcode.vitalikasaty.hard.task30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*You are given a string s and an array of strings words. All the strings of words are of the same length.
A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.
	For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.
Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.

Example 1:
Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Since words.length == 2 and words[i].length == 3, the concatenated substring has to be of length 6.
The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
The output order does not matter. Returning [9,0] is fine too.

Example 2:
Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
Explanation: Since words.length == 4 and words[i].length == 4, the concatenated substring has to be of length 16.
There is no substring of length 16 is s that is equal to the concatenation of any permutation of words.
We return an empty array.
		
Example 3:
Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]
Explanation: Since words.length == 3 and words[i].length == 3, the concatenated substring has to be of length 9.
The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"] which is a permutation of words.
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"] which is a permutation of words.
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"] which is a permutation of words.

Constraints:
1 <= s.length <= 104
1 <= words.length <= 5000
1 <= words[i].length <= 30
s and words[i] consist of lowercase English letters.*/

public class Substring_with_Concatenation_of_All_Words {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[] { "word","good","best","good"}));
	}
}

class Solution {
	public List<Integer> findSubstring(String s, String[] words) {

		List<Integer> result = new ArrayList<>();
		String wordsFull = String.join("", words);
		int wordsLength = wordsFull.length();
		
		for (int i = 0; i < words.length; i++) {
			words[i] = sortStringByWords(words[i]);
		}

		Map<Character, Integer> mapS1Letters = lettersByNum(wordsFull);
		// System.out.println(mapS1Letters);
		for (int i = 0; i < s.length(); i++) {
			
//			String subS;
//			if (i + wordsLength == s.length()) {
//				subS = s.substring(i);
//			} else {
//				subS = s.substring(i, i + wordsLength);
//			}
			
			String subS = s.substring(i, i + wordsLength);
			Map<Character, Integer> mapS2Letters = lettersByNum(subS);

			//System.out.println("Map words = " + mapS1Letters);
			//System.out.println("Map subs = " + mapS2Letters);

			int countNoMatchesLetters = countNoMatchesLetters(mapS1Letters, mapS2Letters);			


			if (countNoMatchesLetters == 0) {
				result.add(i);

				if (i + wordsLength < s.length()) {
					i = i + findFirstMinEqualWord(subS, words) - 1;
				} else {
					break;
				}

			} else {
				if (i + countNoMatchesLetters + wordsLength < s.length()) {
					i += countNoMatchesLetters - 1;
				} else {
					break;
				}
			}

		}

		return result;
	}

	public String sortStringByWords(String s) {

		char[] words = s.toCharArray();
		Arrays.sort(words);
		s = new String(words);

		return s;
	}
	
	public int findFirstMinEqualWord (String s1, String words[]) { 
		
		String temp = "";
		int result = 0;
		for (int i = 0; i < s1.length(); i++) {
			temp = sortStringByWords(temp + s1.charAt(i));
			
			if (Arrays.asList(words).contains(temp)) {
				result = temp.length();
				break;
			}
		}
		
		
		return result;
	}

	public int countNoMatchesLetters(Map<Character, Integer> map1, Map<Character, Integer> mapS2) {

		int countNoMatches = 0;

		for (Map.Entry<Character, Integer> mapS1 : map1.entrySet()) {
			Character keyS1 = mapS1.getKey();
			Integer valueS1 = mapS1.getValue();
			if (mapS2.containsKey(keyS1)) {
			//	if (mapS2.get(keyS1) < valueS1) {
				//	countNoMatches += valueS1 - mapS2.get(keyS1);
				//}

			} else {
				countNoMatches += valueS1;
			}
		}

		return countNoMatches;
	}
	
	public Map<Character, Integer> lettersByNum(String s) {
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			map.merge(s.charAt(i), 1, (value, plus1) -> value + plus1);
		}

		return map;
	}
}
