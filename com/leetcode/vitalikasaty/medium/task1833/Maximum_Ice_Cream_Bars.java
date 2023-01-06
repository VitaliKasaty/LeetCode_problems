package com.leetcode.vitalikasaty.medium.task1833;

import java.util.Arrays;

public class Maximum_Ice_Cream_Bars {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.maxIceCream(new int[] { 1, 3, 2, 4, 1 }, 7));
	}
}

class Solution {
	public int maxIceCream(int[] costs, int coins) {
		int result = 0;
		Arrays.sort(costs);
		System.out.println(Arrays.toString(costs));
		
		for (int i = 0; i < costs.length; i++) {
			if (coins >= costs[i]) {
				result++;
				coins -= costs[i];
			} else {
				break;
			}
		}
		return result;
	}
}