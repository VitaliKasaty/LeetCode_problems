package com.leetcode.vitalikasaty.easy.task1217;

import java.util.Arrays;

/*
We have n chips, where the position of the ith chip is position[i].
We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:
	position[i] + 2 or position[i] - 2 with cost = 0.
	position[i] + 1 or position[i] - 1 with cost = 1.
Return the minimum cost needed to move all the chips to the same position.

Example 1:
Input: position = [1,2,3]
Output: 1
Explanation: First step: Move the chip at position 3 to position 1 with cost = 0.
Second step: Move the chip at position 2 to position 1 with cost = 1.
Total cost is 1.

Example 2:
Input: position = [2,2,2,3,3]
Output: 2
Explanation: We can move the two chips at position  3 to position 2. Each move has cost = 1. The total cost = 2.

Example 3:
Input: position = [1,1000000000]
Output: 1 

Constraints:
1 <= position.length <= 100
1 <= position[i] <= 10^9
*/

public class Minimum_Cost_to_Move_Chips_to_The_Same_Position {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.minCostToMoveChips(new int[] { 1, 1000000000 }));
	}
}

class Solution {
	public int minCostToMoveChips(int[] position) {

		int countEvenPosition = (int) Arrays.stream(position).filter(x -> x % 2 == 0).count();
		int countOddPosition = (int) Arrays.stream(position).filter(x -> x % 2 == 1).count();

		if (countEvenPosition >= countOddPosition) {
			return countOddPosition;
		} else {
			return countEvenPosition;
		}

	}
}
