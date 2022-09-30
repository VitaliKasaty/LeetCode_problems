package com.leetcode.vitalikasaty.medium.task735;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
We are given an array asteroids of integers representing asteroids in a row.
For each asteroid, the absolute value represents its size, and the sign represents
its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
If both are the same size, both will explode. Two asteroids moving in the same direction will never meet. 

Example 1:
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:
Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

Constraints:
2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
*/

public class Asteroid_Collision {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.asteroidCollision(new int[] { -2, -1, 1, 2})));
	}
}

class Solution {
	public int[] asteroidCollision(int[] asteroids) {		
		List<Integer> listAsteroids = Arrays.stream(asteroids).boxed().collect(Collectors.toList());

		int i = 0;
		while (i != listAsteroids.size() - 1 && listAsteroids.size() != 0) {
			boolean isDestroyedAsteroids = false;
			if ((sign(listAsteroids.get(i)) != sign(listAsteroids.get(i + 1))) && listAsteroids.get(i) > 0) {
				isDestroyedAsteroids = true;
				if (Math.abs(listAsteroids.get(i)) > Math.abs(listAsteroids.get(i + 1))) {
					listAsteroids.remove(i + 1);
				} else if (Math.abs(listAsteroids.get(i)) < Math.abs(listAsteroids.get(i + 1))) {
					listAsteroids.remove(i);
				} else {
					listAsteroids.remove(i);
					listAsteroids.remove(i);
				}
			}
			if (isDestroyedAsteroids) {
				i = 0;
			} else {
				i++;
			}
		}
		
		return listAsteroids.stream().mapToInt(Integer::intValue).toArray();
	}

	public int sign(int x) {
		if (x > 0) {
			return 1;
		} else if (x < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
