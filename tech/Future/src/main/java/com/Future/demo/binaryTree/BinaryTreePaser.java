package com.Future.demo.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreePaser {

	private Node root;

	private List<Integer> valuelist;

	private List<Node> NodeList = new ArrayList<Node>();

	public void init(Integer[] array) {
		valuelist = Arrays.asList(array);
	}

	public boolean ValidateArrayIsEmpty() {
		if (valuelist == null || valuelist.isEmpty()) {
			return true;
		}
		return false;
	}

	public void add(Node parent, Node child, String orientation) {
		if (orientation.equals("left")) {
			parent.setLeftNode(child);
		} else {
			parent.setRightNode(child);
		}
	}

	public Node CreateNodeTerr() {
		for (int i = 0; i < valuelist.size(); i++) {
			Integer value = valuelist.get(i);
			if (!(value == null)) {
				if (NodeList.size() == 0) {
					Node node = new Node();
					node.setValue(value);
					node.setLevel(0);
					NodeList.add(node);
					root = node;
				} else {
					CreateNode(root, value, true);
				}
			}
		}
		return root;
	}

	public boolean CreateNode(Node node, Integer value, boolean searchNextLevel) {
		if (node.getLeftNode() == null) {
			Node leftNode = new Node();
			leftNode.setValue(value);
			leftNode.setLevel(node.getLevel() + 1);
			node.setLeftNode(leftNode);
			NodeList.add(leftNode);
			return true;
		}
		if (node.getRightNode() == null) {
			Node rightNode = new Node();
			rightNode.setValue(value);
			rightNode.setLevel(node.getLevel() + 1);
			node.setRightNode(rightNode);
			NodeList.add(rightNode);
			return true;
		}

		if (searchNextLevel) {
			boolean isFinish = CreateNode(node.getLeftNode(), value, false);
			if (!isFinish) {
				isFinish = CreateNode(node.getRightNode(), value, false);
			}
			if (!isFinish) {
				isFinish = CreateNode(node.getLeftNode(), value, true);
				if (!isFinish) {
					CreateNode(node.getRightNode(), value, true);
				}
			}
		}
		return false;
	}

	public void PrintBinaryTree() {
		if (ValidateArrayIsEmpty()) {
			System.out.println("Please excute init method first ");
			return;
		}
		if (NodeList.isEmpty()) {
			CreateNodeTerr();
		}

		int currentLevel = 0;
		for (int i = 0; i < NodeList.size(); i++) {
			Node node = NodeList.get(i);
			if (node.getLevel() == currentLevel && i == 0) {
				System.out.print("(" + node.getValue() + ")");
			} else if (node.getLevel() == currentLevel) {
				System.out.print(", (" + node.getValue() + ")");
			} else {
				System.out.println("");
				System.out.print("(" + node.getValue() + ")");
				currentLevel = node.getLevel();
			}
		}
	}

}
