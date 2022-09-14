package com.leetcode.vitalikasaty.hard.task691;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
We are given n different types of stickers. Each sticker has a lowercase English word on it.
You would like to spell out the given string target by cutting individual letters from your collection of stickers and rearranging them.
You can use each sticker more than once if you want, and you have infinite quantities of each sticker.
Return the minimum number of stickers that you need to spell out target. If the task is impossible, return -1.
		
Note: In all test cases, all words were chosen randomly from the 1000 most common US English words,
and target was chosen as a concatenation of two random words. 

Example 1:
Input: stickers = ["with","example","science"], target = "thehat"
Output: 3
Explanation:
We can use 2 "with" stickers, and 1 "example" sticker.
After cutting and rearrange the letters of those stickers, we can form the target "thehat".
Also, this is the minimum number of stickers necessary to form the target string.

Example 2:
Input: stickers = ["notice","possible"], target = "basicbasic"
Output: -1
Explanation:
We cannot form the target "basicbasic" from cutting letters from the given stickers. 

Constraints:
n == stickers.length
1 <= n <= 50
1 <= stickers[i].length <= 10
1 <= target.length <= 15
stickers[i] and target consist of lowercase English letters.
*/

public class Stickers_to_Spell_Word {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out
				.println(solution.minStickers(new String[] { "these", "guess", "about", "garden", "him" }, "atomher"));
	}
}

class Solution {

	public int result = 0;

	public int minStickers(String[] stickers, String target) {

		System.out.println(bestStickerForTarget(stickers, target));
		System.out.println(matchingStickerAndTarget("garden", "atomher"));
		
		String tempTarget = new String(target);
		while (target != "") {
			List<String> bestSticker = bestStickerForTarget(stickers, target);
			System.out.println("Взят = " + bestSticker);
			if (bestSticker == null) {
				return -1;
			} else {
				result++;
				target = matchingStickerAndTarget(bestSticker.get(0), target);
			}
		}
		
		return result;
	}
	

	public String matchingStickerAndTarget(String bestSticker, String target) {

		for (int i = 0; i < bestSticker.length(); i++) {
			char symbolSearch = bestSticker.charAt(i);
			if (target.indexOf(symbolSearch) != -1) {
				target = new StringBuffer(target).deleteCharAt(target.indexOf(symbolSearch)).toString();
			}
		}

		return target;
	}

	public List<String> bestStickerForTarget(String stickers[], String target) {

		int[] valueStickers = new int[stickers.length];
		List<String> bestStickers = new ArrayList<>();

		for (int i = 0; i < stickers.length; i++) {
			String tempTarget = new String(target);
			String tempSticker = new String(stickers[i]);

			for (int j = 0; j < tempSticker.length(); j++) {

				char symbolSearch = tempSticker.charAt(j);

				if (tempTarget.indexOf(symbolSearch) != -1) {
					valueStickers[i]++;
					tempTarget = new StringBuffer(tempTarget).deleteCharAt(tempTarget.indexOf(symbolSearch)).toString();
				}
			}
		}

		int maxСonsilience = Arrays.stream(valueStickers).max().getAsInt();

		if (maxСonsilience == 0) {
			return null;
		} else {
			for (int i = 0; i < valueStickers.length; i++) {
				if (valueStickers[i] == maxСonsilience) {
					bestStickers.add(stickers[i]);
				}
			}

		}
		return bestStickers;

	}

}
