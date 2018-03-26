package com.Future.demo;

import org.junit.Before;
import org.junit.Test;

import com.Future.demo.binaryTree.BinaryTreePaser;
import com.Future.demo.binaryTree.Node;

public class BinaryTreeTest {
	
	private Integer[] testArray= {1,2,3,4,5,7};
	private BinaryTreePaser btp;
	
	@Before
	public void SetUp() {
		btp=new BinaryTreePaser();
	}

	
	public void TestBinaryTreePaser() {
		btp=new BinaryTreePaser();
		btp.init(testArray);
		Node root = btp.CreateNodeTerr();
		System.out.println(root.getRightNode().getRightNode().getValue());
	}
	
	@Test
	public void TestPrintBinaryTree(){
		btp.init(testArray);
		btp.PrintBinaryTree();
	}

}
