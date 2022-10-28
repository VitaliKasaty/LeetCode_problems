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
		//System.out.println(solution.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[] { "fooo","barr","wing","ding","wing"}));
	//	System.out.println(solution.findSubstring("barfoofoobarthefoobarman", new String[] { "bar","foo","the"}));
		System.out.println(solution.findSubstring("ababababab", new String[] { "ababa","babab"}));
	}
}

class Solution {
	public List<Integer> findSubstring(String s, String[] words) {

		Map<String, Integer> mapWords = new HashMap<>();
		List<Integer> result = new ArrayList<>();

		int wordsLength = String.join("", words).length();

		for (String word : words) {
			mapWords.merge(word, 1, (old, add) -> old + 1);
		}
		System.out.println(mapWords);
		for (int i = 0; i <= s.length(); i++) {
			String subS;
			//System.out.println(mapWords);
			if (i + wordsLength <= s.length()) {
				if (i == 0) {
					subS = s.substring(0, wordsLength);
				} else {
					subS = s.substring(i, i + wordsLength);
				}
				System.out.println("Исследуемая строка = " + subS);
				int shiftLength = shiftLength(subS, mapWords);
				System.out.println("Сдвиг = " + shiftLength);
				if (shiftLength == 0) {
					result.add(i);
					i += shiftLengthFirstEqualWord(subS, mapWords) - 1;
				} else {
					i += shiftLengthFirstEqualWord(subS, mapWords) - 1;
				}

			} else {
				break;
			}
		}
		return result;

	}
	
	public int shiftLengthFirstEqualWord(String subS, Map<String, Integer> mapWords) {
		
		int result = Integer.MAX_VALUE;
		String word = "";
		for (int i = 0; i < subS.length(); i++) {
			word += subS.charAt(i);
			
			if (mapWords.containsKey(word)) {
				return word.length();
			}
		}
		
		for (Map.Entry<String, Integer> map : mapWords.entrySet()) {
			if (subS.indexOf(map.getKey()) != -1) {
				if (subS.indexOf(map.getKey()) < result && subS.indexOf(map.getKey()) != 0) {
					result = subS.indexOf(map.getKey());
				}
			}
		}
		
		return result;
	}

	public int shiftLength(String subS, Map<String, Integer> mapWords) {
		
		int indexOfirstWord = -1;
		
		Map<String, Integer> mapWordsTemp = new HashMap<>(mapWords);
		
		StringBuffer subSTemp = new StringBuffer(subS);

		for (Map.Entry<String, Integer> map : mapWordsTemp.entrySet()) {			
			String word = map.getKey();
			int value = map.getValue();
			for (int i = 0; i < value; i++) {
				
				int indexOfWord = subSTemp.indexOf(map.getKey());

				if (indexOfWord != -1) {
					
					if (indexOfirstWord == -1) {
						indexOfirstWord = indexOfWord;
					}					
					subSTemp.delete(indexOfWord, indexOfWord + word.length());
					System.out.println("Substemp после удаления = " + subSTemp);
					mapWordsTemp.put(word, mapWordsTemp.get(word) - 1);				

				}
			}
		}

		return subSTemp.length();
	}
}
