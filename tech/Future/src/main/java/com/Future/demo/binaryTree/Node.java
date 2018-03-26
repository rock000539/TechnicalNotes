package com.Future.demo.binaryTree;

public class Node {

	private Integer level;
	
	private Integer value;

	private Node leftNode;

	private Node rightNode;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	
}
