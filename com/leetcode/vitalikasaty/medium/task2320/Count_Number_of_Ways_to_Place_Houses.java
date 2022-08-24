package com.leetcode.vitalikasaty.medium.task2320;

/*
There is a street with n * 2 plots, where there are n plots on each side of the street. The plots on each side are numbered from 1 to n.
On each plot, a house can be placed.
Return the number of ways houses can be placed such that no two houses are adjacent to each other on the same side of the street.
Since the answer may be very large, return it modulo 109 + 7.
Note that if a house is placed on the ith plot on one side of the street, a house can also be placed on the ith plot on the other side of the street.

Example 1:
Input: n = 1
Output: 4
Explanation: 
Possible arrangements:
1. All plots are empty.
2. A house is placed on one side of the street.
3. A house is placed on the other side of the street.
4. Two houses are placed, one on each side of the street.

Example 2:
Input: n = 2
Output: 9
Explanation: The 9 possible arrangements are shown in the diagram above. 

Constraints:
1 <= n <= 104
*/

public class Count_Number_of_Ways_to_Place_Houses {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.countHousePlacements(1000));
	}

}

class Solution {
	public int countHousePlacements(int n) {

		int mod = 1000000007;
		long result;
		long countPerN[];

		if (n < 3) {
			countPerN = new long[3];
		} else {
			countPerN = new long[n + 1];
		}

		countPerN[1] = 2;
		countPerN[2] = 3;

		for (int i = 3; i <= n; i++) {
			countPerN[i] = (countPerN[i - 1] + countPerN[i - 2]) % mod;
		}
		result = (countPerN[n] * countPerN[n]) % mod;

		return (int) result;
	}

}
