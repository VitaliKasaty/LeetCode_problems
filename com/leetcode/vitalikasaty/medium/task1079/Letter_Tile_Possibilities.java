package com.leetcode.vitalikasaty.medium.task1079;

import java.util.HashMap;
import java.util.Map;

/*
You have n  tiles, where each tile has one letter tiles[i] printed on it.
Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles. 

Example 1:
Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".

Example 2:
Input: tiles = "AAABBC"
Output: 188

Example 3:
Input: tiles = "V"
Output: 1 

Constraints:
1 <= tiles.length <= 7
tiles consists of uppercase English letters.
*/

public class Letter_Tile_Possibilities {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.numTilePossibilities("AAABBC"));
	}
}

class Solution {

	public int result = 0;

	public int numTilePossibilities(String tiles) {

		Map<Character, Integer> mapCharCount = new HashMap<>();

		for (int i = 0; i < tiles.length(); i++) {
			mapCharCount.put(tiles.charAt(i), mapCharCount.getOrDefault(tiles.charAt(i), 0) + 1);
		}
		System.out.println(mapCharCount);
		recursion(mapCharCount);
		return result;
	}

	public void recursion(Map<Character, Integer> map) {
		for (char ch : map.keySet()) {
			if (map.get(ch) > 0) {
				map.put(ch, map.get(ch) - 1);
				result++;
				recursion(map);
				map.put(ch, map.get(ch) + 1);
			}
		}
	}
}