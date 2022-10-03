package com.leetcode.vitalikasaty.easy.task605;

import javax.net.ssl.SSLEngine;

/*
 You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false 

Constraints:
1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length
*/

public class Can_Place_Flowers {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.canPlaceFlowers(new int[] { 0, 0, 0 }, 1));
	}
}

class Solution {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {

		if (n == 0) {
			return true;
		}
		if (flowerbed.length == 1 && flowerbed[0] == 0) {
			return true;
		}

		for (int i = 0; i < flowerbed.length - 1; i++) {

			if (flowerbed[i] == 0) {
				if (flowerbed[i + 1] == 0) {
					n--;
				}
				i++;
			} else {
				i++;
			}
			if (i == flowerbed.length - 2 && n != 0) {
				if (flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
					n--;
				}
			}

			if (n == 0) {
				return true;
			}

		}
		return false;
	}
}
