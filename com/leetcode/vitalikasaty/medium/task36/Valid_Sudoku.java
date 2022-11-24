package com.leetcode.vitalikasaty.medium.task36;

import java.util.ArrayList;
import java.util.List;

/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
	Each row must contain the digits 1-9 without repetition.
	Each column must contain the digits 1-9 without repetition.
	Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
	
Note:
	A Sudoku board (partially filled) could be valid but is not necessarily solvable.
	Only the filled cells need to be validated according to the mentioned rules.

Example 1:
Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

Example 2:
Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
Since there are two 8's in the top left 3x3 sub-box, it is invalid.

Constraints:
board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
*/

public class Valid_Sudoku {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isValidSudoku(new char[][] { 
			{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
			{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
			{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
			{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
			{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
			{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
			{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
			{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
			{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));
	}

}

class Solution {
	public boolean isValidSudoku(char[][] board) {
		
		return checkColumns(board) && checkRows(board) && checkSubBox(board);
	}

	public boolean checkSubBox(char[][] board) {

		int row = 0;
		int column = 0;

		for (int n = 0; n < 9; n++) {
			List<Character> subBoxList = new ArrayList<>();
			for (int i = row; i < row + 3; i++) {				
				for (int j = column; j < column + 3; j++) {
					if (board[i][j] != '.') {
						if (subBoxList.contains(board[i][j])) {
							return false;
						} else {
							subBoxList.add(board[i][j]);
						}
					}
				}
			}			
			column += 3;
			if (column == 9) {
				column = 0;
				row += 3;
			}			
		}

		return true;
	}

	public boolean checkRows(char[][] board) {

		for (int i = 0; i < 9; i++) {
			List<Character> rowList = new ArrayList<>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (rowList.contains(board[i][j])) {
						return false;
					} else {
						rowList.add(board[i][j]);
					}

				}
			}
		}

		return true;
	}

	public boolean checkColumns(char[][] board) {

		for (int j = 0; j < 9; j++) {
			List<Character> rowList = new ArrayList<>();
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					if (rowList.contains(board[i][j])) {
						return false;
					} else {
						rowList.add(board[i][j]);
					}

				}
			}
		}

		return true;
	}
}