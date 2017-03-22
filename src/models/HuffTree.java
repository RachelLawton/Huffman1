package models;

import java.util.PriorityQueue;


/*
 * I need to keep track of root
 * I need to keep track of current node
 * I take the smallest two elements out of the queue and put them in the tree
 */
public class HuffTree {

	public Node root;
	public Node currentNode;

	/**
	 * HuffTree Constructor
	 */
	public HuffTree(){
		root = null;
		currentNode = null;
	}

	/**
	 * add a pair of nodes to the HuffTree
	 * @param n1
	 * @param n2
	 * @return
	 */
	public Node add(Node n1, Node n2){
		if(isEmpty()){
			// Only ever do this when the HuffTree is empty
			currentNode = new Node();
			currentNode.c = n1.c + n2.c;
			currentNode.freq = n1.freq + n2.freq;
			currentNode.left = n1;
			currentNode.right = n2;
			root = n1;
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

	/**
	 * Add a single node to the tree
	 * @param n1
	 * @return
	 */
	public Node add(Node n1){
		if(isEmpty()){
			// Only ever do this when the HuffTree is empty
			root = n1;
			currentNode = root;
		}
		else{
			if(n1 != root){
				currentNode = new Node();
				currentNode.c = n1.c + root.c;
				currentNode.freq = n1.freq + root.freq;
				currentNode.left = n1;
				currentNode.right = root;

				root = currentNode;
			}
		}
		return currentNode;
	}

	/**
	 * return the top of the tree
	 * @return
	 */
	public Node getRoot(){
		return root;
	}

	/**
	 * convert the HuffTree to a String
	 */
	public String toString(){
		String str = "";

		if(root.left == null && root.right == null){
			str = root.c + "" + root.freq;
		}

		return str;
	}


	/**
	 * Check to see if the HuffTree is empty
	 * @return
	 */
	public boolean isEmpty(){
		return root == null;
	}

}
