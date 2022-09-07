package com.leetcode.vitalikasaty.medium.task2;

import java.math.BigInteger;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself. 

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]
		
Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1] 

Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
*/

public class Add_Two_Numbers {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(2);
		ListNode l11 = new ListNode(4);
		ListNode l111 = new ListNode(3);
		l1.next = l11;
		l11.next = l111;

		ListNode l2 = new ListNode(5);
		ListNode l22 = new ListNode(6);
		ListNode l222 = new ListNode(4);
		l2.next = l22;
		l22.next = l222;

		Solution solution = new Solution();
		solution.addTwoNumbers(l1, l2).print();

	}
}

class Solution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode current = l1;
		ListNode next = l1.next;
		String l1Value = "";
		do {

			l1Value += Integer.toString(current.val);
			current = current.next;
		} while (current != null);
		l1Value = new StringBuilder(l1Value).reverse().toString();

		current = l2;
		next = l2.next;
		String l2Value = "";
		do {

			l2Value += Integer.toString(current.val);
			current = current.next;
		} while (current != null);		
		l2Value = new StringBuilder(l2Value).reverse().toString();

		BigInteger resultValue = new BigInteger(l1Value).add(new BigInteger(l2Value));
		String l3Value = resultValue.toString();
		
		l3Value = new StringBuilder(l3Value).reverse().toString();
		ListNode l3;
		if (l3Value.length() == 1) {
			l3 = new ListNode(Integer.parseInt(l3Value.substring(0, 1)));
		} else {
			l3 = new ListNode(Integer.parseInt(l3Value.substring(0, 1)), new ListNode());
		}

		next = l3.next;
		for (int i = 1; i < l3Value.length(); i++) {
			current = next;
			current.val = Integer.parseInt(l3Value.substring(i, i + 1));
			current.next = new ListNode();
			next = current.next;

			if (i == l3Value.length() - 1) {
				current.next = null;
			}
		}
		
		return l3;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public void print() {

		ListNode current = this;
		do {
			System.out.println(current.val);
			current = current.next;
		} while (current != null);
	}
}
