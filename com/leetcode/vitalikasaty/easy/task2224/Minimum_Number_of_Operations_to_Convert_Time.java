package com.leetcode.vitalikasaty.easy.task2224;

/*
You are given two strings current and correct representing two 24-hour times.

24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. 
The earliest 24-hour time is 00:00, and the latest is 23:59.

In one operation you can increase the time current by 1, 5, 15, or 60 minutes. 
You can perform this operation any number of times.

Return the minimum number of operations needed to convert current to correct. 

Example 1:
Input: current = "02:30", correct = "04:35"
Output: 3
Explanation:
We can convert current to correct in 3 operations as follows:
- Add 60 minutes to current. current becomes "03:30".
- Add 60 minutes to current. current becomes "04:30".
- Add 5 minutes to current. current becomes "04:35".
It can be proven that it is not possible to convert current to correct in fewer than 3 operations.

Example 2:
Input: current = "11:00", correct = "11:01"
Output: 1
Explanation: We only have to add one minute to current, so the minimum number of operations needed is 1. 

Constraints:
current and correct are in the format "HH:MM"
current <= correct
*/

public class Minimum_Number_of_Operations_to_Convert_Time {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.convertTime("09:41", "10:34"));
	}
}

class Solution {
	public int convertTime(String current, String correct) {

		int currentHour = Integer.parseInt(current.split(":")[0]);
		int currentMinute = Integer.parseInt(current.split(":")[1]);
		int correctHour = Integer.parseInt(correct.split(":")[0]);
		int correctMinute = Integer.parseInt(correct.split(":")[1]);
		int result = 0;

		if (currentMinute > correctMinute) {
			currentHour++;
			correctMinute += 60;
		}

		while (currentMinute != correctMinute) {
			if ((currentMinute + 15) <= correctMinute) {
				currentMinute += 15;
			} else if ((currentMinute + 5) <= correctMinute) {
				currentMinute += 5;
			} else if ((currentMinute + 1) <= correctMinute) {
				currentMinute += 1;
			}
			result++;
		}

		if (currentHour < correctHour) {
			result += correctHour - currentHour;
		} else if (currentHour > correctHour) {
			result += (24 - correctHour) + correctHour;
		}

		return result;
	}
}