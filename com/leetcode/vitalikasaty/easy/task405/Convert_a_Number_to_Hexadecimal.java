package com.leetcode.vitalikasaty.easy.task405;

import java.util.HashMap;
import java.util.Map;

/*Given an integer num, return a string representing its hexadecimal representation.
For negative integers, two’s complement method is used.
All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.

Note: You are not allowed to use any built-in library method to directly solve this problem.

Example 1:
Input: num = 26
Output: "1a"
	
Example 2:
Input: num = -1
Output: "ffffffff" 

Constraints:
-231 <= num <= 231 - 1*/

public class Convert_a_Number_to_Hexadecimal {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.toHex(-2));
	}
}

class Solution {
	public String toHex(int num) {

		Map<Integer, String> hexaMap = new HashMap<>();
		hexaMap.put(0, "0");
		hexaMap.put(1, "1");
		hexaMap.put(2, "2");
		hexaMap.put(3, "3");
		hexaMap.put(4, "4");
		hexaMap.put(5, "5");
		hexaMap.put(6, "6");
		hexaMap.put(7, "7");
		hexaMap.put(8, "8");
		hexaMap.put(9, "9");
		hexaMap.put(10, "a");
		hexaMap.put(11, "b");
		hexaMap.put(12, "c");
		hexaMap.put(13, "d");
		hexaMap.put(14, "e");
		hexaMap.put(15, "f");

		String result = "";

		if (num > 0) {
			while (num > 0) {
				int convert = num % 16;
				num = num / 16;
				result += hexaMap.get(convert);
			}
		} else if (num == 0) {
			return "0";
		} else {
			long test = (long) Integer.MAX_VALUE * 2 + 2 + num;
			while (test > 0) {
				long convert = test % 16;
				test = test / 16;
				result += hexaMap.get((int) convert);
			}
		}

		return new StringBuilder(result).reverse().toString();
		// return Integer.toHexString(num); // 1 line solution
	}
}