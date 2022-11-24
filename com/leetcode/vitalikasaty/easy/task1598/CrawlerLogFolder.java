package com.leetcode.vitalikasaty.easy.task1598;

public class CrawlerLogFolder {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.minOperations(new String[] { "d1/", "d2/", "./", "d3/", "../", "d31/" }));
	}

}

class Solution {
	public int minOperations(String[] logs) {

		int count = 0;

		for (String log : logs) {
			if (log.equals("../")) {
				if (count > 0) {
					count--;
				}
			} else if (log.equals("./")) {
				continue;
			} else {
				count++;
			}
		}
		return count;
	}
}
