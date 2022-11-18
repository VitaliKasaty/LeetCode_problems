package com.leetcode.vitalikasaty.easy.task1886;

/*
Given two n x n binary matrices mat and target, 
return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.

Example 1:
Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.

Example 2:
Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
Output: false
Explanation: It is impossible to make mat equal to target by rotating mat.

Example 3:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
Output: true
Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
*/

public class Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation {
	public static void main(String[] args) {
		Solution solution = new Solution();
		//System.out.println(solution.findRotation(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } },
		//		new int[][] { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 0, 0 } }));	
		System.out.println(solution.findRotation(new int[][] { { 0, 1}, { 1, 1 } },	new int[][] { { 1, 0 }, { 0, 1}}));
	}
}

class Solution {
	public boolean findRotation(int[][] mat, int[][] target) {

		if (canRotate90(mat, target)) {
			return true;
		} else if (canRotate180(mat, target)) {
			return true;
		} else if (canRotate270(mat, target)) {
			return true;
		} else return false;
	}

	public boolean canRotate90(int[][] mat, int[][] target) {
		int n = target.length - 1;

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (target[i][j] != mat[n - j][i]) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean canRotate180(int[][] mat, int[][] target) {
		int n = mat.length - 1;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (target[i][j] != mat[n - i][n - j]) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean canRotate270(int[][] mat, int[][] target) {
		int n = mat.length - 1;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (target[i][j] != mat[j][n - i]) {
					return false;
				}
			}
		}
		return true;
	}

}