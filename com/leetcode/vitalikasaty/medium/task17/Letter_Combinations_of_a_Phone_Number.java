package com.leetcode.vitalikasaty.medium.task17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
		
Example 2:
Input: digits = ""
Output: []
		
Example 3:
Input: digits = "2"
Output: ["a","b","c"] 

Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/

public class Letter_Combinations_of_a_Phone_Number {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.letterCombinations("56").toString());
	}

}

class Solution {
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();

		if (digits.equals("")) {
			return result;
		} else {

			Map<Integer, char[]> lettersByNumber = fillPhoneNumberAndLetters();

			for (int i = 0; i < digits.length(); i++) {

				if (i == 0) {
					
					char[] firstNumberLetters = lettersByNumber.get(Character.getNumericValue(digits.charAt(0)));
					for (int j = 0; j < firstNumberLetters.length; j++) {
						result.add(String.valueOf(firstNumberLetters[j]));
					}
				} else {
					
					char[] nextNumberLetters = lettersByNumber.get(Character.getNumericValue(digits.charAt(i)));
					int sizeList = result.size();
					for (int j = 0; j < sizeList; j++) {
						for (char letterByNumber : nextNumberLetters) {
							result.add(result.get(j) + letterByNumber);
						}
					}
					
					Iterator<String> combinationInterator = result.iterator();
					while (combinationInterator.hasNext()) {
						String currentCombination = combinationInterator.next();
						if (currentCombination.length() != (i + 1)) {
							combinationInterator.remove();
						}
					}
				}
			}

			return result;
		}
	}

	public Map<Integer, char[]> fillPhoneNumberAndLetters() {
		Map<Integer, char[]> result = new HashMap<>();
		result.put(2, new char[] { 'a', 'b', 'c' });
		result.put(3, new char[] { 'd', 'e', 'f' });
		result.put(4, new char[] { 'g', 'h', 'i' });
		result.put(5, new char[] { 'j', 'k', 'l' });
		result.put(6, new char[] { 'm', 'n', 'o' });
		result.put(7, new char[] { 'p', 'q', 'r', 's' });
		result.put(8, new char[] { 't', 'u', 'v' });
		result.put(9, new char[] { 'w', 'x', 'y', 'z' });
		return result;
	}
}
