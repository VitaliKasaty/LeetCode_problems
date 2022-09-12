package com.leetcode.vitalikasaty.easy.task953;

/*
In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order.
The order of the alphabet is some permutation of lowercase letters.
Given a sequence of words written in the alien language, and the order of the alphabet,
return true if and only if the given words are sorted lexicographically in this alien language. 

Example 1:
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

Example 2:
Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

Example 3:
Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.)
According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the
blank character which is less than any other character (More info).

Constraints:
1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are English lowercase letters.
*/

public class Verifying_an_Alien_Dictionary {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isAlienSorted(new String[] { "my", "f" }, "gelyriwxzdupkjctbfnqmsavho"));
	}
}

class Solution {
	public boolean isAlienSorted(String[] words, String order) {

		for (int i = 0; i < words.length - 1; i++) {

			if (words[i].contains(words[i + 1]) && words[i].length() > words[i + 1].length()) {
				return false;

			} else if (order.indexOf(words[i].charAt(0)) == order.indexOf(words[i + 1].charAt(0))) {
				int minLenthFromTwoo = Math.min(words[i].length(), words[i + 1].length());
				for (int j = 1; j < minLenthFromTwoo; j++) {
					if (order.indexOf(words[i].charAt(j)) < order.indexOf(words[i + 1].charAt(j))) {
						break;
					} else if (order.indexOf(words[i].charAt(j)) > order.indexOf(words[i + 1].charAt(j))) {
						return false;
					}
				}

			} else if (order.indexOf(words[i].charAt(0)) > order.indexOf(words[i + 1].charAt(0))) {
				return false;
			}
		}

		return true;
	}
}
