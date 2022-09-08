package com.leetcode.vitalikasaty.medium.task5;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, return the longest palindromic substring in s.		 

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.
*/

public class Longest_Palindromic_Substring {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}
}

class Solution {
	public String longestPalindrome(String s) {

		List<String> palindromics = new ArrayList<>();
		String resultSubString;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j <= s.length(); j++) {
				resultSubString = s.substring(i, j);				
				if (isPalindrome(resultSubString)) {
					palindromics.add(resultSubString);
				}
			}
		}
		palindromics.sort((o1, o2) -> o2.length() - o1.length());
		
		return palindromics.get(0);
	}

	public boolean isPalindrome(String inputString) {

		String firstHalfString;
		String secondHalfString;

		if (inputString.length() % 2 == 0) {
			firstHalfString = inputString.substring(0, inputString.length() / 2);
			secondHalfString = new StringBuilder(inputString.substring(inputString.length() / 2)).reverse().toString();
		} else {
			firstHalfString = inputString.substring(0, inputString.length() / 2);
			secondHalfString = new StringBuilder(inputString.substring(inputString.length() / 2 + 1)).reverse()
					.toString();
		}

		if (firstHalfString.equals(secondHalfString)) {
			return true;
		} else {
			return false;
		}

	}
}
