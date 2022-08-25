package com.leetcode.vitalikasaty.easy.task13;

import java.util.HashMap;
import java.util.Map;

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II.
The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. 

Example 1:
Input: s = "III"
Output: 3
Explanation: III = 3.

Example 2:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 3:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/

public class Roman_to_Integer {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.romanToInt("CMI"));
	}
}

class Solution {

	public int romanToInt(String s) {
		s += " ";
		Map<String, Integer> romanNums = new HashMap<>();
		romanNums.put("I", 1);
		romanNums.put("V", 5);
		romanNums.put("X", 10);
		romanNums.put("L", 50);
		romanNums.put("C", 100);
		romanNums.put("D", 500);
		romanNums.put("M", 1000);
		romanNums.put("IV", 4);
		romanNums.put("IX", 9);
		romanNums.put("XL", 40);
		romanNums.put("XC", 90);
		romanNums.put("CD", 400);
		romanNums.put("CM", 900);

		int result = 0;

		for (int i = 0; i < s.length() - 1; i++) {
			String symbols = "" + s.charAt(i) + s.charAt(i + 1);
			if (romanNums.containsKey(symbols)) {
				result += romanNums.get(symbols);
				i++;
			} else {
				symbols = "" + s.charAt(i);
				symbols.trim();
				result += romanNums.get(symbols);
			}
		}
		return result;
	}
}