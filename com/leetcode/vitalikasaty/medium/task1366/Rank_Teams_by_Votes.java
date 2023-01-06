package com.leetcode.vitalikasaty.medium.task1366;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
In a special ranking system, each voter gives a rank from highest to lowest to all teams participating in the competition.
The ordering of teams is decided by who received the most position-one votes. 
If two or more teams tie in the first position, we consider the second position to resolve the conflict, 
if they tie again, we continue this process until the ties are resolved. If two or more teams are still tied after considering all positions,
we rank them alphabetically based on their team letter.
You are given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to the ranking system described above.
Return a string of all teams sorted by the ranking system. 

Example 1:
Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
Output: "ACB"
Explanation: 
Team A was ranked first place by 5 voters. No other team was voted as first place, so team A is the first team.
Team B was ranked second by 2 voters and ranked third by 3 voters.
Team C was ranked second by 3 voters and ranked third by 2 voters.
As most of the voters ranked C second, team C is the second team, and team B is the third.

Example 2:
Input: votes = ["WXYZ","XYZW"]
Output: "XWYZ"
Explanation:
X is the winner due to the tie-breaking rule. X has the same votes as W for the first position, but X has one vote in the second position, while W does not have any votes in the second position. 

Example 3:
Input: votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
Output: "ZMNAGUEDSJYLBOPHRQICWFXTVK"
Explanation: Only one voter, so their votes are used for the ranking. 

Constraints:
1 <= votes.length <= 1000
1 <= votes[i].length <= 26
votes[i].length == votes[j].length for 0 <= i, j < votes.length.
votes[i][j] is an English uppercase letter.
All characters of votes[i] are unique.
All the characters that occur in votes[0] also occur in votes[j] where 1 <= j < votes.length.
*/

public class Rank_Teams_by_Votes {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.rankTeams(new String[] { "ABCDEFGH", "BACDEFGH", "GHABCDEF", "GHBACDEF", "EFGHABCD",
				"EFGHBACD", "CDEFGHBA", "CDEFGHBA" }));
	}
}

class Solution {

	public String rankTeams(String[] votes) {

		String result = "";
		TreeMap<Character, TreeMap<Integer, Integer>> teamRanks = createTeamAllRanks(votes);
		int countTeams = votes[0].length();

		for (int i = 0; i < countTeams; i++) {
			char currentBestTeam = bestTeamOfAll(teamRanks);
			result += currentBestTeam;
			teamRanks.remove(currentBestTeam);
		}

		return result;
	}

	public TreeMap<Character, TreeMap<Integer, Integer>> createTeamAllRanks(String[] votes) {
		TreeMap<Character, TreeMap<Integer, Integer>> result = new TreeMap<>();

		for (String vote : votes) {

			for (int i = 0; i < vote.length(); i++) {
				char ch = vote.charAt(i);

				if (result.containsKey(ch)) {
					TreeMap<Integer, Integer> temp = result.get(ch);

					if (temp.containsKey(i + 1)) {
						temp.put(i + 1, temp.get(i + 1) + 1);
					} else {
						temp.put(i + 1, 1);
					}
					result.put(ch, temp);

				} else {
					TreeMap<Integer, Integer> temp = new TreeMap<>();
					temp.put(i + 1, 1);
					result.put(ch, temp);
				}
			}
		}

		return result;
	}

	public char bestTeamOfAll(TreeMap<Character, TreeMap<Integer, Integer>> teamsRanks) {

		char result = ' ';
		TreeMap<Character, TreeMap<Integer, Integer>> teamsByBestPlace = new TreeMap<>();
		int startRank = 0;
		for (int j = 1; j <= 26; j++) {
			int tempJ = j;
			teamsRanks.entrySet().stream().filter(x -> x.getValue().containsKey(tempJ))
					.forEach(x -> teamsByBestPlace.put(x.getKey(), x.getValue()));
			startRank = j;
			if (!teamsByBestPlace.isEmpty()) {
				break;
			}
		}

		if (teamsByBestPlace.size() == 1) {
			result = teamsByBestPlace.firstKey();
		} else {
			TreeMap<Character, Integer> bestOfTheBest = new TreeMap<>();

			for (Map.Entry<Character, TreeMap<Integer, Integer>> entry : teamsByBestPlace.entrySet()) {
				if (entry.getValue().containsKey(startRank)) {
					bestOfTheBest.put(entry.getKey(), entry.getValue().get(startRank));
				}
			}

			while (result == ' ') {

				if (bestOfTheBest.size() == 1) {
					result = bestOfTheBest.firstKey();
				} else {

					int max = Collections.max(bestOfTheBest.values());
					int countMax = (int) bestOfTheBest.entrySet().stream().filter(x -> x.getValue() == max).count();
					if (countMax == 1) {
						for (Map.Entry<Character, Integer> entryTemp : bestOfTheBest.entrySet()) {
							if (entryTemp.getValue() == max) {
								result = entryTemp.getKey();
								break;
							}
						}
					} else {
						bestOfTheBest.entrySet().removeIf(x -> x.getValue() < max);
						List<Character> valueList = new ArrayList<>(bestOfTheBest.keySet());
						bestOfTheBest.clear();

						while (bestOfTheBest.isEmpty() && startRank < 27) {
							startRank++;
							for (Character ch : valueList) {
								if (teamsByBestPlace.get(ch).containsKey(startRank)) {
									bestOfTheBest.put(ch, teamsByBestPlace.get(ch).get(startRank));
								}
							}
						}

						if (startRank == 27) {
							result = valueList.get(0);
						}
					}
				}
			}
		}
		return result;
	}

}