package com.leetcode.vitalikasaty.easy.task100;

import java.util.ArrayList;
import java.util.List;

/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
*/

public class Same_Tree {
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root1 = new TreeNode();
		root1.val = 3;
		TreeNode one1 = new TreeNode();
		TreeNode two1 = new TreeNode();
		root1.left = one1;
		root1.right = two1;
		one1.val = 1;
		two1.val = 2;
		root1.left = one1;
		root1.right = two1;

		TreeNode root2 = new TreeNode();
		root2.val = 3;
		TreeNode one2 = new TreeNode();
		TreeNode two2 = new TreeNode();
		root2.left = one2;
		root2.right = two2;
		one2.val = 1;
		two2.val = 2;
		root2.left = one2;
		root2.right = two2;

		System.out.println(solution.isSameTree(root1, root2));
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
	List<Integer> values = new ArrayList<>();

	public boolean isSameTree(TreeNode p, TreeNode q) {

		getValTree(p);
		List<Integer> firstTree = new ArrayList<>(values);
		values.clear();
		getValTree(q);
		List<Integer> secondTree = new ArrayList<>(values);

		return firstTree.equals(secondTree);
	}

	public void getValTree(TreeNode treeNode) {
		if (treeNode == null) {
			values.add(Integer.MIN_VALUE);
		} else {
			getValTree(treeNode.left);
			getValTree(treeNode.right);
			values.add(treeNode.val);
		}

	}
}
