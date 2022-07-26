package com.leetcode.vitalikasaty.easy.task1185;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/*
Given a date, return the corresponding day of the week for that date.
The input is given as three integers representing the day, month and year respectively.
Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.

Example 1:
Input: day = 31, month = 8, year = 2019
Output: "Saturday"
	
Example 2:
Input: day = 18, month = 7, year = 1999
Output: "Sunday"
	
Example 3:
Input: day = 15, month = 8, year = 1993
Output: "Sunday" 

Constraints:
The given dates are valid dates between the years 1971 and 2100.
*/

public class Day_of_the_Week {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.dayOfTheWeek(31, 8, 2019));
	}

}

class Solution {
	public String dayOfTheWeek(int day, int month, int year) {
		Calendar calendar = new GregorianCalendar(year, month - 1, day);
		String result = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US);
		return result;
	}
}
