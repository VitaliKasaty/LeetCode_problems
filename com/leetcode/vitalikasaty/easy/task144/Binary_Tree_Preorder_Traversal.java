package com.leetcode.vitalikasaty.easy.task144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given the root of a binary tree, return the preorder traversal of its nodes' values.
*/

public class Binary_Tree_Preorder_Traversal {
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode();
		root.val = 3;
		TreeNode one = new TreeNode();
		TreeNode two = new TreeNode();
		root.left = one;
		root.right = two;
		one.val = 1;
		two.val = 2;
		root.left = one;
		root.right = two;
		System.out.println(solution.preorderTraversal(root));
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {

		List<Integer> result = new ArrayList<>();
		List<TreeNode> temp = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);

		if (root != null) {
			while (stack.size() != 0) {
				TreeNode currentNode = stack.peek();
				if (!temp.contains(currentNode)) {
					temp.add(currentNode);
					result.add(currentNode.val);
				} else {
					if (currentNode.left != null && !temp.contains(currentNode.left)) {
						stack.push(currentNode.left);
					} else if (currentNode.right != null && !temp.contains(currentNode.right)) {
						stack.push(currentNode.right);
					} else {
						stack.pop();
					}
				}
			}
		}
		return result;
	}
}
