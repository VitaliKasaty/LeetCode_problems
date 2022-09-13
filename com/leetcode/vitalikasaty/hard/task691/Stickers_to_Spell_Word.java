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
		System.out.println(solution.minStickers(new String[] { "with", "example", "science" }, "thehat"));
	}
}

class Solution {

	public Map<Character, Integer> storageStickersSymbols = new HashMap<>();
	public Map<Character, Integer> storageTargetSymbols = new HashMap<>();

	public int minStickers(String[] stickers, String target) {		

		addStickersSymbolsToStorage(stickers);

		for (int i = 0; i < target.length(); i++) {
			if (!storageStickersSymbols.containsKey(target.charAt(i))) {
				return -1;
			}
		}
		
		bestStickerForTarget(stickers, target);
		
		


//		for (Map.Entry<Character, Integer> entry : storageStickersSymbols.entrySet()) {
//			System.out.println("Key=" + entry.getKey() + " : " + entry.getValue());
//		}
//		System.out.println("fdf");
//		for (Map.Entry<Character, Integer> entry : storageTargetSymbols.entrySet()) {
//			System.out.println("Key=" + entry.getKey() + " : " + entry.getValue());
//		}

		return 1;
	}

	public String bestStickerForTarget(String stickers[], String target) {

		String result = null;
		int[] valueSticker = new int[stickers.length];

		for (int i = 0; i < stickers.length; i++) {
			String tempTarget = new String(target);
			for (int j = 0; j < target.length(); j++) {
				if (stickers[i].contains("" + target.charAt(j))) {
					valueSticker[i] ++;
					tempTarget = tempTarget.substring(i);
					System.out.println(tempTarget);
				}
			}
			System.out.println("-----");
		}
		
		for (int i = 0; i < valueSticker.length; i++) {
			System.out.println("Слово N" + i + " = " + valueSticker[i] + " совпадений");
		}

		return result;
	}

	public void addTargetSymbolsToStorage(String target) {
		for (int i = 0; i < target.length(); i++) {
			if (storageTargetSymbols.containsKey(target.charAt(i))) {
				storageTargetSymbols.put(target.charAt(i), storageTargetSymbols.get(target.charAt(i)) + 1);
			} else {
				storageTargetSymbols.put(target.charAt(i), 1);
			}
		}
	}

	public void addStickersSymbolsToStorage(String[] stickers) {

		for (String sticker : stickers) {
			for (int i = 0; i < sticker.length(); i++) {
				if (storageStickersSymbols.containsKey(sticker.charAt(i))) {
					storageStickersSymbols.put(sticker.charAt(i), storageStickersSymbols.get(sticker.charAt(i)) + 1);
				} else {
					storageStickersSymbols.put(sticker.charAt(i), 1);
				}
			}
		}
	}
}
