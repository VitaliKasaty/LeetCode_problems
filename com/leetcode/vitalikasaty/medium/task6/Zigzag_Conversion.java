package com.leetcode.vitalikasaty.medium.task6;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number 
of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);
 
Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
	
Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:
Input: s = "A", numRows = 1
Output: "A"
Constraints:
	1 <= s.length <= 1000
	s consists of English letters (lower-case and upper-case), ',' and '.'.
	1 <= numRows <= 1000	
*/

public class Zigzag_Conversion {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.convert("a", 2));
	}

}

class Solution {
	public String convert(String s, int numRows) {

		if (numRows == 1) {
			return s;
		}

		int numColumns = 0;
		int test = s.length();

		while (test > 0) {
			test -= numRows;
			numColumns++;

			if (test > 0 && (test - (numRows - 2)) > 0) {
				numColumns += numRows - 2;
				test -= numRows - 2;
			} else if (test > 0) {
				numColumns += test;
				test -= test;
			}
		}

		int numSymbol = 0;
		String[][] zigZag = new String[numRows][numColumns];
		String result = "";

		for (int j = 0; j < numColumns; j++) {
			for (int i = 0; i < numRows; i++) {

				if (numSymbol + 1 > s.length()) {
					break;
				}

				if (j % (numRows - 1) == 0) {
					zigZag[i][j] = Character.toString(s.charAt(numSymbol));
					numSymbol++;
				} else if ((i + j) % (numRows - 1) == 0) {
					zigZag[i][j] = Character.toString(s.charAt(numSymbol));
					numSymbol++;
				} else {
					zigZag[i][j] = " ";
				}
			}
		}

		for (int i = 0; i < numRows; i++) {

			for (int j = 0; j < numColumns; j++) {

				if (zigZag[i][j] != null) {
					if (!zigZag[i][j].equals(" ")) {
						result += zigZag[i][j];
					}

				}

			}
		}
		return result;
	}
}