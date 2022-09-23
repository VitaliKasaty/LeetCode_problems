package com.leetcode.vitalikasaty.hard.task691;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

		System.out.println(
				solution.minStickers(new String[] { "these", "guess", "about", "garden", "him", "pppp" }, "atomher"));
		System.out.println(solution.minStickers(new String[] { "control", "heart", "interest", "stream", "sentence",
				"soil", "wonder", "them", "month", "slip", "table", "miss", "boat", "speak", "figure", "no", "perhaps",
				"twenty", "throw", "rich", "capital", "save", "method", "store", "meant", "life", "oil", "string",
				"song", "food", "am", "who", "fat", "if", "put", "path", "come", "grow", "box", "great", "word",
				"object", "stead", "common", "fresh", "the", "operate", "where", "road", "mean" }, "stoodcrease"));

		System.out.println(solution.minStickers(
				new String[] { "heavy", "often", "just", "map", "door", "soil", "surface", "high", "middle", "noise",
						"during", "my", "yes", "sugar", "ship", "special", "late", "spell", "receive", "silent",
						"would", "person", "since", "children", "cell", "favor", "choose", "listen", "then", "finish",
						"north", "safe", "molecule", "wrong", "mouth", "dead", "ask", "such", "trouble", "protect",
						"last", "whether", "dream", "act", "turn", "double", "push", "happy", "where", "steam" },
				"strangefell"));

		System.out.println(solution.minStickers(
				new String[] { "represent", "seven", "least", "fair", "is", "need", "sudden", "are", "want", "type",
						"dear", "morning", "check", "subject", "again", "eye", "prepare", "sit", "since", "long",
						"food", "only", "before", "white", "valley", "clothe", "tool", "difficult", "real", "leg",
						"read", "thousand", "object", "nation", "break", "inch", "ice", "imagine", "dad", "grow",
						"kept", "born", "island", "drop", "final", "will", "person", "sand", "block", "quotient" },
				"enterbehind"));

		System.out.println(solution.minStickers(new String[] { "with", "example", "science" }, "thehat"));
	}
}

class Solution {

	public int result = 0;

	public int minStickers(String[] stickers, String target) {

		int result = 0;
		List<String> targets = new ArrayList<String>();
		targets.add(target);

		if (canCalculateStickers(stickers, target)) {
			for (int i = 1; i < Integer.MAX_VALUE; i++) {
				targets = targetsAfterDeleteOneSticker(stickers, targets);

				boolean isEnd;
				isEnd = (int) targets.stream().filter(s -> s.equals("")).count() > 0 ? true : false;
				if (isEnd) {
					result = i;
					break;
				}

			}
		} else {
			return -1;
		}

		return result;
	}

	public boolean canCalculateStickers(String[] stickers, String target) {
		boolean result = true;

		String heapStickers = "";

		for (int i = 0; i < stickers.length; i++) {
			heapStickers += stickers[i];
		}

		for (int i = 0; i < target.length(); i++) {
			if (!heapStickers.contains("" + target.charAt(i))) {
				return false;
			}
		}

		return result;
	}

	public List<String> targetsAfterDeleteOneSticker(String[] stickers, List<String> targets) {
		List<String> result = new ArrayList<>();

		for (int i = 0; i < targets.size(); i++) {
			String[] bestStickersForTarget = bestStickersBasket(stickers, targets.get(i));

			for (int j = 0; j < bestStickersForTarget.length; j++) {
				String currentSticker = bestStickersForTarget[j];
				String tempTarget = targets.get(i);

				for (int k = 0; k < currentSticker.length(); k++) {
					tempTarget = tempTarget.replaceFirst("" + currentSticker.charAt(k), "");
				}
				result.add(tempTarget);
			}

		}

		return result;
	}

	public String[] bestStickersBasket(String[] stickers, String target) {

		List<String> listStickers = new ArrayList<>();
		String[] result = null;

		for (int i = 0; i < stickers.length; i++) {
			String cleanSticker = "";
			for (int j = 0; j < stickers[i].length(); j++) {
				if (target.indexOf(stickers[i].charAt(j)) != -1) {
					cleanSticker += stickers[i].charAt(j);
				}
			}
			if (!cleanSticker.equals("")) {
				cleanSticker = sortSymbols(cleanSticker);
				cleanSticker = deleteUselessDuplicateSymbolsFromBasket(cleanSticker, target);
				listStickers.add(cleanSticker);
			}
		}
		listStickers = listStickers.stream().distinct().collect(Collectors.toList());
		Collections.sort(listStickers, (s1, s2) -> s2.length() - s1.length());

		int maxLength = listStickers.get(0).length();

		int countMaxSticker = (int) listStickers.stream().filter(s -> s.length() == maxLength).count();

		if (countMaxSticker == 1 && listStickers.size() > 1) {
			int nextMaxLength = listStickers.get(1).length();
			countMaxSticker = (int) listStickers.stream().filter(s -> s.length() == nextMaxLength).count();
		}

		if (countMaxSticker == 2 && listStickers.size() > 2) {
			int nextMaxLength = listStickers.get(2).length();
			countMaxSticker = (int) listStickers.stream().filter(s -> s.length() == nextMaxLength).count();
		}

		result = new String[countMaxSticker];
		for (int i = 0; i < countMaxSticker; i++) {
			result[i] = listStickers.get(i);
		}

		return result;
	}

	public String deleteUselessDuplicateSymbolsFromBasket(String sticker, String target) {

		for (int i = 0; i < sticker.length(); i++) {
			char symbol = sticker.charAt(i);
			int countSymbolInSticker = (int) sticker.chars().filter(ch -> ch == symbol).count();

			int countSymbolInTarget = (int) target.chars().filter(ch -> ch == symbol).count();

			if (countSymbolInSticker > countSymbolInTarget) {
				int countUselessSymbols = countSymbolInSticker - countSymbolInTarget;

				for (int j = 0; j < countUselessSymbols; j++) {
					sticker += " ";
					sticker = new StringBuffer(sticker).delete(sticker.indexOf(symbol), sticker.indexOf(symbol) + 1)
							.toString().strip();
				}
			}
		}

		return sticker;
	}

	public String sortSymbols(String s) {

		return s.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
	}

}
