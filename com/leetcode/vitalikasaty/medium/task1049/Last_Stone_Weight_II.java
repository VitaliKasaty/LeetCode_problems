package com.leetcode.vitalikasaty.medium.task1049;

import java.util.HashSet;
import java.util.Set;

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
		System.out.println(solution.lastStoneWeightII(new int[] { 31, 26, 33, 21, 40 }));
	}

}

class Solution {
	public int lastStoneWeightII(int[] stones) {

		Set<Integer> hitValues = new HashSet<>();
		hitValues.add(stones[0]);
		hitValues.add(-stones[0]);

		for (int i = 1; i < stones.length; i++) {
			Set<Integer> tempHitValues = new HashSet<>();
			for (int value : hitValues) {
				tempHitValues.add(value - stones[i]);
				tempHitValues.add(value + stones[i]);
			}
			hitValues = tempHitValues;
		}

		return hitValues.stream().sorted().filter(value -> value >= 0).findFirst().orElse(0);
	}

}