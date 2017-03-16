package models;

import java.util.PriorityQueue;

public class HuffTree {
	
	/*
	 * We need to keep track of root
	 * we need to keep track of current node
	 * We take the smallest two elements out of the queue and put htem in the tree
	 */
	public Node root;
	public Node currentNode;
	
	public HuffTree(){
		root = null;
		currentNode = null;
	}
	
	
	
	public Node add(Node n1, Node n2){
		if(this.root == null){
			root = n1;
			currentNode = root;
			currentNode.c = n1.c + n2.c;
			currentNode.freq = n1.freq + n2.freq;
			currentNode.left = n1;
			currentNode.right = n2;
		}
		else{
			currentNode = new Node();
			currentNode.c = n1.c + n2.c;
			currentNode.freq = n1.freq + n2.freq;
			currentNode.left = n1;
			currentNode.right = n2;
			if(root.freq < currentNode.freq)
			{
				root = currentNode;
			}
		}
		
		return currentNode;
	}
	
	public Node add(Node n1){
		currentNode = new Node();
		currentNode.c = n1.c + root.c;
		currentNode.freq = n1.freq + root.freq;
		currentNode.left = n1;
		currentNode.right = root;
		
		root = currentNode;
		return root;
	}
	
	public Node getRoot(){
		return root;
	}
	
	public String toString(){
		String str = "";
		
		if(root.left == null && root.right == null){
			str = root.c + "" + root.freq;
		}
		
		return str;
	}
	
	
	// Check to see if the HuffTree is empty
	public boolean isEmpty(){
		return root == null;
	}

}
