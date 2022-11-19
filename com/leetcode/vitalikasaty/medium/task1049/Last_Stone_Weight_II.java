package com.leetcode.vitalikasaty.medium.task1049;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose any two stones and smash them together.
Suppose the stones have weights x and y with x <= y. The result of this smash is:
	If x == y, both stones are destroyed, and
	If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
	At the end of the game, there is at most one stone left.
	
Return the smallest possible weight of the left stone. If there are no stones left, return 0.
*/

public class Last_Stone_Weight_II {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.lastStoneWeightII(new int[] { 2,7,4,1,8,1 }));
	}

}

class Solution {
	public int lastStoneWeightII(int[] stones) {

		List<Integer> stoneList = Arrays.stream(stones).boxed().collect(Collectors.toList());

		if (stones.length == 1) {
			return stones[0];
		} else {
			while (stoneList.size() > 1) {
				System.out.println("do sort");
				System.out.println(stoneList);
				Collections.sort(stoneList, Collections.reverseOrder());
				System.out.println("aftersort");
				System.out.println(stoneList);
				int stone1 = stoneList.get(0);
				int stone2 = stoneList.get(1);

				if (stone1 >= stone2) {
					stoneList.set(0, stone1 - stone2);
					stoneList.set(1, 0);
				} else {
					stoneList.set(1, stone2 - stone1);
					stoneList.set(0, 1);
				}

				stoneList.removeIf(stone -> stone <= 0);
			}
		}

		return stoneList.size() > 0 ? stoneList.get(0) : 0;
	}
}