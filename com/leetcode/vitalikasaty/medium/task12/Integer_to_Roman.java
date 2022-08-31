package com.leetcode.vitalikasaty.medium.task12;

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

For example, 2 is written as II in Roman numeral, just two one's added together. 
12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. 

Example 1:
Input: num = 3
Output: "III"
Explanation: 3 is represented as 3 ones.

Example 2:
Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.

Example 3:
Input: num = 1994
Output: "MCMXCIV"	
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

Constraints:
1 <= num <= 3999
*/

public class Integer_to_Roman {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.intToRoman(1994));
	}
}

class Solution {
	public String intToRoman(int num) {

		int units;
		int tens;
		int hundreds;
		int thousands;
		String result = "";

		thousands = num / 1000;
		num %= 1000;
		hundreds = num / 100;
		num %= 100;
		tens = num / 10;
		num %= 10;
		units = num;

		for (int i = 0; i < thousands; i++) {
			result += "M";
		}

		if (hundreds > 0) {
			if (hundreds <= 3) {
				for (int i = 0; i < hundreds; i++) {
					result += "C";
				}
			} else if (hundreds == 4) {
				result += "CD";
			} else if (hundreds >= 5 && hundreds < 9) {
				result += "D";
				for (int i = 0; i < hundreds - 5; i++) {
					result += "C";
				}
			} else if (hundreds == 9) {
				result += "CM";
			}
		}

		if (tens > 0) {
			if (tens <= 3) {
				for (int i = 0; i < tens; i++) {
					result += "X";
				}
			} else if (tens == 4) {
				result += "XL";
			} else if (tens >= 5 && tens < 9) {
				result += "L";
				for (int i = 0; i < tens - 5; i++) {
					result += "X";
				}
			} else if (tens == 9) {
				result += "XC";
			}
		}

		if (units > 0) {
			if (units <= 3) {
				for (int i = 0; i < units; i++) {
					result += "I";
				}
			} else if (units == 4) {
				result += "IV";
			} else if (units >= 5 && units < 9) {
				result += "V";
				for (int i = 0; i < units - 5; i++) {
					result += "I";
				}
			} else if (units == 9) {
				result += "IX";
			}
		}

		return result;
	}
}
