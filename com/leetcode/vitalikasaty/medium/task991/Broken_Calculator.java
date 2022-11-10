package com.leetcode.vitalikasaty.medium.task991;

/*
There is a broken calculator that has the integer startValue on its display initially. In one operation, you can:
	multiply the number on display by 2, or
	subtract 1 from the number on display.
Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.

Example 1:
Input: startValue = 2, target = 3
Output: 2
Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.

Example 2:
Input: startValue = 5, target = 8
Output: 2
Explanation: Use decrement and then double {5 -> 4 -> 8}.

Example 3:
Input: startValue = 3, target = 10
Output: 3
Explanation: Use double, decrement and double {3 -> 6 -> 5 -> 10}. 

Constraints:
1 <= startValue, target <= 109
*/

public class Broken_Calculator {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.brokenCalc(3, 10));

	}

}

class Solution {
	public int brokenCalc(int startValue, int target) {

		int result = 0;
		if (startValue >= target) {
			return startValue - target;
		} else {
			while (startValue != target) {
				if (target % 2 == 0 && target > startValue) {
					target /= 2;
					result++;
				} else {
					target++;
					result++;
				}

			}
		}
		return result;
	}
}
