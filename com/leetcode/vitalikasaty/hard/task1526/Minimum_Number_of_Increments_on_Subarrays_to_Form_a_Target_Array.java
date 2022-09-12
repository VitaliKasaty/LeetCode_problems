package com.leetcode.vitalikasaty.hard.task1526;

/*
You are given an integer array target. You have an integer array initial of the same size as target with all elements initially zeros.
In one operation you can choose any subarray from initial and increment each value by one.
Return the minimum number of operations to form a target array from initial.
The test cases are generated so that the answer fits in a 32-bit integer.

Example 1:
Input: target = [1,2,3,2,1]
Output: 3
Explanation: We need at least 3 operations to form the target array from the initial array.
[0,0,0,0,0] increment 1 from index 0 to 4 (inclusive).
[1,1,1,1,1] increment 1 from index 1 to 3 (inclusive).
[1,2,2,2,1] increment 1 at index 2.
[1,2,3,2,1] target array is formed.

Example 2:
Input: target = [3,1,1,2]
Output: 4
Explanation: [0,0,0,0] -> [1,1,1,1] -> [1,1,1,2] -> [2,1,1,2] -> [3,1,1,2]
		
Example 3:
Input: target = [3,1,5,4,2]
Output: 7
Explanation: [0,0,0,0,0] -> [1,1,1,1,1] -> [2,1,1,1,1] -> [3,1,1,1,1] -> [3,1,2,2,2] -> [3,1,3,3,2] -> [3,1,4,4,2] -> [3,1,5,4,2].

Constraints:
1 <= target.length <= 105
1 <= target[i] <= 105
*/

public class Minimum_Number_of_Increments_on_Subarrays_to_Form_a_Target_Array {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.minNumberOperations(new int[] { 3, 1, 5, 4, 2 }));

	}

}

class Solution {
    public int minNumberOperations(int[] target) {
    	
    	int result = target[0];
    	
    	for (int i = 1; i < target.length; i++) {
    		result += Math.max(0, target[i] - target[i - 1]);
    	}
    	
    	return result;
        
    }
}

//class Solution {
//
//	int startSearchPos = 0;
//
//	public int minNumberOperations(int[] target) {
//
//		int myArr[] = new int[target.length];
//		int countOperations = 0;
//
//		while (!Arrays.equals(target, myArr)) {
//
//			int start = startSearchPos;
//			int end = findSubArrayEndPos(target, myArr);
//
//			int countToAdd = Arrays.stream(Arrays.copyOfRange(target, start, end)).min().getAsInt() - myArr[start];
//			
//			for (int i = start; i < end; i++) {
//				myArr[i] += countToAdd;
//			}
//
//			for (int i = start; i < myArr.length; i++) {
//				if (myArr[i] != target[i]) {
//					startSearchPos = i;
//					break;
//				}
//			}
//
//			countOperations += countToAdd;
//
//		}
//
//		return countOperations;
//	}
//
//	public int findSubArrayEndPos(int[] target, int[] myArr) {
//		int result = myArr.length;
//
//		for (int i = startSearchPos; i < myArr.length; i++) {
//			if (myArr[i] == target[i]) {
//				result = i;
//				break;
//			}
//		}
//
//		return result;
//	}
//
//}