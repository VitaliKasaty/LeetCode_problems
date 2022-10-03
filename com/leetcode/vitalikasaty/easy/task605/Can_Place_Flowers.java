package com.leetcode.vitalikasaty.easy.task605;

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
		System.out.println(solution.canPlaceFlowers(new int[] { 0 }, 0));
	}
}

class Solution {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {

		for (int i = 0; i < flowerbed.length - 1 && n != 0; i++) {
			if (flowerbed[i] == 0) {
				if (flowerbed[i + 1] == 0) {
					flowerbed[i] = 1;
					i++;
					n--;
				}
			} else {
				i++;
			}
			if (n == 0) {
				break;
			}

		}

		if (flowerbed.length > 2 && flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0
				&& n != 0) {
			n--;
		} else if (flowerbed.length == 1 && flowerbed[0] == 0 && n != 0) {
			n--;
		}

		if (n == 0) {
			return true;
		} else {
			return false;
		}

	}
}