package com.leetcode.vitalikasaty.easy.task263;

public class Ugly_Number {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isUgly(6));
	}
}

class Solution {
	public boolean isUgly(int n) {

		while (n > 1) {
			if (n % 2 == 0) {
				n /= 2;
			} else if (n % 3 == 0) {
				n /= 3;
			} else if (n % 5 == 0) {
				n /= 5;
			} else {
				break;
			}
		}

		return n == 1;
	}
}