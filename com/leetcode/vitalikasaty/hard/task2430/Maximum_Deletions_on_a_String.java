package com.leetcode.vitalikasaty.hard.task2430;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
You are given a string s consisting of only lowercase English letters. In one operation, you can:
Delete the entire string s, or
Delete the first i letters of s if the first i letters of s are equal to the following i letters in s,
for any i in the range 1 <= i <= s.length / 2.
For example, if s = "ababc", then in one operation, you could delete the first two letters of s to get "abc",
since the first two letters of s and the following two letters of s are both equal to "ab".

Return the maximum number of operations needed to delete all of s. 

Example 1:
Input: s = "abcabcdabc"
Output: 2
Explanation:
- Delete the first 3 letters ("abc") since the next 3 letters are equal. Now, s = "abcdabc".
- Delete all the letters.
We used 2 operations so return 2. It can be proven that 2 is the maximum number of operations needed.
Note that in the second operation we cannot delete "abc" again because the next occurrence of "abc" does not happen in the next 3 letters.

Example 2:
Input: s = "aaabaab"
Output: 4
Explanation:
- Delete the first letter ("a") since the next letter is equal. Now, s = "aabaab".
- Delete the first 3 letters ("aab") since the next 3 letters are equal. Now, s = "aab".
- Delete the first letter ("a") since the next letter is equal. Now, s = "ab".
- Delete all the letters.
We used 4 operations so return 4. It can be proven that 4 is the maximum number of operations needed.
		
Example 3:
Input: s = "aaaaa"
Output: 5
Explanation: In each operation, we can delete the first letter of s. 

Constraints:
1 <= s.length <= 4000
s consists only of lowercase English letters.
*/

public class Maximum_Deletions_on_a_String {

	public static void main(String[] args) {
		Solution solution = new Solution();
//		System.out.println(solution.deleteString("aaabaab"));
		System.out.println(solution.deleteString(
				"ssssslgyssssslgyssssslgyssssslgymxssssslgyssssslgyssssslgyssssslgymxnzssssslgyssssslgyssssslgyssssslgymxssssslgyssssslgyssssslgyssssslgymxnztnosoairsrczdapfqupaayeeczdlgxkmcquhbbhczjkrsnvqfewwyhdmdlvthtpahrbdvdbmuvnmiplfwfngoocfvsldlbqmyflnofwlkfaodbspieifvbibrbwbrztqlntsrab"));
//		System.out.println(solution.deleteString(
//				"qqqqqqqqfqqqqqqqqfqqqqqqqqfqqqqqqqqfqqqqqqqqfqqqqqqqqfqqqqqqqqfqqqqqqqqfqqqqqqqqfqqqqqqqqfqqqqqqqqfqqqqqqqqfqqqqqqqqfqqqqqqqqfqqqqqqqqfqqqqqqqqfcazmmclmylkhwddlwlyigvsqhelwqjwilpvweldtskbwqaodhttxvwcpcouehysyzqrbswovaxehm"));
	}
}

class Solution {

	public int deleteString(String s) {

		int result = 0;
//		int operations = 1;
		while (s.length() > 0) {
//			System.out.println("s input = " + s);
//			System.out.println("S length = " + s.length());
//			System.out.println("Operations = " + operations);
//			operations++;

			HashMap<Integer, Integer> map = new HashMap<>();
			List<Integer> pos = possibleDelete(s);

			for (int countDelete : pos) {
				String temp = deleteLetters(s, countDelete);
				map.put(countDelete, possibleDelete(temp).size() + 1);
			}

			int max;
			int bestKey = Integer.MAX_VALUE;
			int bestValue = Integer.MIN_VALUE;

			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//				System.out.println("entryKey = " + entry.getKey() + ", entryValue = " + entry.getValue());
				if (entry.getValue() > bestValue) {
					bestKey = entry.getKey();
					bestValue = entry.getValue();
				} else if (entry.getValue() == bestValue && bestKey > entry.getKey()) {
					bestKey = entry.getKey();
					bestValue = entry.getValue();
				}
			}

			if (map.size() > 0) {
				max = bestKey;
			} else {
				max = s.length();
			}

			s = deleteLetters(s, max);
//			System.out.println("Deleted = " + s.substring(0, max) + " length = " + s.substring(0, max).length());
//			System.out.println();
			result++;
		}

		return result;
	}

	public String deleteLetters(String s, int count) {
		return new StringBuffer(s).delete(0, count).toString();
	}

	public List<Integer> possibleDelete(String s) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < s.length() / 2; i++) {
			String firstLetters = s.substring(0, i + 1);
			String secondLetters = s.substring(i + 1, i + 1 + firstLetters.length());

			if (firstLetters.equals(secondLetters)) {
				result.add(i + 1);
			}
		}

		return result;
	}
}
