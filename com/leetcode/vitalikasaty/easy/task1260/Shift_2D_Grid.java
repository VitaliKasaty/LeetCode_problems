package com.leetcode.vitalikasaty.easy.task1260;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
	In one shift operation:
	Element at grid[i][j] moves to grid[i][j + 1].
	Element at grid[i][n - 1] moves to grid[i + 1][0].
	Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times. 

Example 1:
Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]

Example 2:
Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
Example 3:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
Output: [[1,2,3],[4,5,6],[7,8,9]] 

Constraints:
m == grid.length
n == grid[i].length
1 <= m <= 50
1 <= n <= 50
-1000 <= grid[i][j] <= 1000
0 <= k <= 100
*/

public class Shift_2D_Grid {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.shiftGrid(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 1));
		System.out.println(solution.shiftGrid(new int[][] { { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 }, }, 1));
	}
}

class Solution {
	public List<List<Integer>> shiftGrid(int[][] grid, int k) {

		List<List<Integer>> result = new ArrayList<>();

		int m = grid.length;
		int n = grid[0].length;

		k %= m * n;

		List<Integer> listBefore = Arrays.stream(grid).flatMap(row -> Arrays.stream(row).boxed())
				.collect(Collectors.toList());

		List<Integer> listAfter = listBefore.stream().skip(listBefore.size() - k).collect(Collectors.toList());

		listBefore.stream().limit(listBefore.size() - k).forEach(x -> listAfter.add(x));

		for (int i = 0; i < m; i++) {
			List<Integer> iteration = listAfter.stream().skip(n * i).limit(n).toList();
			result.add(iteration);
		}

		return result;
	}
}
