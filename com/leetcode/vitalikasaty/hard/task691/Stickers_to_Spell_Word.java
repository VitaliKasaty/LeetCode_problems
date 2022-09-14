package com.leetcode.vitalikasaty.hard.task691;

import java.util.Arrays;
import java.util.HashMap;
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
		System.out.println(solution
				.minStickers(new String[] { "these","guess","about","garden","him"}, "atomher"));
	}
}

class Solution {

	public int minStickers(String[] stickers, String target) {

		int result = 0;
		while (target != "") {
			String bestSticker = bestStickerForTarget(stickers, target);
			System.out.println("Взят = " + bestSticker);
			if (bestSticker == null) {
				return -1;
			} else {
				result++;
				for (int i = 0; i < bestSticker.length(); i++) {
					char symbolSearch = bestSticker.charAt(i);
					if (target.indexOf(symbolSearch) != -1) {
						target = new StringBuffer(target).deleteCharAt(target.indexOf(symbolSearch)).toString();
					}
				}
			}
		}
		return result;
	}

	public String bestStickerForTarget(String stickers[], String target) {

		int[] valueStickers = new int[stickers.length];

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

		int bestValueI = -1;
		int maxСonsilience = 0;
		System.out.println("Target = " + target);
		for (int i = 0; i < valueStickers.length; i++) {
			System.out.println("Ценность " + stickers[i] + " = " + valueStickers[i]);
			if (valueStickers[i] > maxСonsilience && valueStickers[i] > 0) {
				maxСonsilience = valueStickers[i];
				bestValueI = i;
			}
		}
		System.out.println("-----------");

		if (bestValueI == -1) {
			return null;
		} else {
			return stickers[bestValueI];
		}
	}

}
