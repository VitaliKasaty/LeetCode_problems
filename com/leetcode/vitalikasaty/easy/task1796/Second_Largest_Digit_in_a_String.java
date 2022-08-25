package com.leetcode.vitalikasaty.easy.task1796;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/*
Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.
An alphanumeric string is a string consisting of lowercase English letters and digits. 

Example 1:
Input: s = "dfa12321afd"
Output: 2
Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.

Example 2:
Input: s = "abc1111"
Output: -1
Explanation: The digits that appear in s are [1]. There is no second largest digit.  

Constraints:
1 <= s.length <= 500
s consists of only lowercase English letters and/or digits.
*/

public class Second_Largest_Digit_in_a_String {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.secondHighest("vwkxfq9791769"));
	}
}

class Solution {
	public int secondHighest(String s) {

		SortedSet<Integer> numbersInString = new TreeSet<>();
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
				int num = Character.getNumericValue(s.charAt(i));
				numbersInString.add(num);
			}
		}
		
		List<Integer> nums = new ArrayList<>(numbersInString);
		if (nums.size() >= 2) {
			return nums.get(nums.size() - 2);
		} else {
			return -1;
		}

	}
}
