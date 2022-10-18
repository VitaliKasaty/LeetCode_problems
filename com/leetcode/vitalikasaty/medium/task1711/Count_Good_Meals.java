package com.leetcode.vitalikasaty.medium.task1711;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
A good meal is a meal that contains exactly two different food items with a sum of deliciousness equal to a power of two.
You can pick any two different foods to make a good meal.
Given an array of integers deliciousness where deliciousness[i] is the deliciousness of the i​​​​​​th​​​​​​​​ item of food,
return the number of different good meals you can make from this list modulo 10^9 + 7.

Note that items with different indices are considered different even if they have the same deliciousness value.

Example 1:
Input: deliciousness = [1,3,5,7,9]
Output: 4
Explanation: The good meals are (1,3), (1,7), (3,5) and, (7,9).
Their respective sums are 4, 8, 8, and 16, all of which are powers of 2.

Example 2:
Input: deliciousness = [1,1,1,3,3,3,7]
Output: 15
Explanation: The good meals are (1,1) with 3 ways, (1,3) with 9 ways, and (1,7) with 3 ways. 

Constraints:
1 <= deliciousness.length <= 105
0 <= deliciousness[i] <= 220
*/

public class Count_Good_Meals {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.numsPowerOf2());
		// System.out.println(solution.countPairs(new int[] { 1, 1, 1, 3, 3, 3, 7 }));
		// System.out.println(solution.countPairs(new int[] { 1, 3, 5, 7, 9 }));

		// System.out.println(solution.countPairs(new int[] {
		// 149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234}));

	}
}

class Solution {

	public int countPairs(int[] deliciousness) {

		return 1;
	}

	public Map<Integer, Integer> valueCount() {

	}

	public List<Integer> numsPowerOf2() {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i <= 21; i++) {
			int powerOf2 = (int) Math.pow(2, i);
			result.add(powerOf2);
		}
		return result;
	}

}

//	public int countPairs(int[] deliciousness) {
//		
//		int result = 0;
//		int[] distinct = Arrays.stream(deliciousness).distinct().toArray();
//		int mod = 1000000000 + 7; 
//		//Arrays.sort(deliciousness);
//		Arrays.sort(distinct);
//		System.out.println(Arrays.toString(distinct));
//		 
//		List<Integer> numsPowerOf2 = numsPowerOf2();
//		for (int i = 0; i < distinct.length; i++) {
//			for (int j = i; j < distinct.length; j++) {
//				int goodMeal1 = distinct[i];
//				int goodMeal2 = distinct[j];
//				int sum = goodMeal1 + goodMeal2;
//				
//				if (sum > numsPowerOf2.get(numsPowerOf2.size() - 1)) {
//					return result;
//				}
//				if (numsPowerOf2.contains(sum)) {
//
//					int countGoodMeal1 = (int) Arrays.stream(deliciousness).filter(x -> x == goodMeal1).count();
//					int countGoodMeal2 = (int) Arrays.stream(deliciousness).filter(x -> x == goodMeal2).count();
//					
//					
//					
//					if (goodMeal1 == goodMeal2) {
//						result += ((countGoodMeal1 - 1) * countGoodMeal1) / 2;
//					} else {
//						result += countGoodMeal1 * countGoodMeal2;
//					}
//					result %= mod;		
//					
//					
//				}
//			}
//		}
//
//		return result;
//	}

//	public boolean isNumberPowerOf2(int a, int b) {
//
//		int sum = a + b;
//		double log = Math.log(sum) / Math.log(2);
//
//		if (log % 1 == 0) {
//			return true;
//		} else {
//			return false;
//		}
//	}
