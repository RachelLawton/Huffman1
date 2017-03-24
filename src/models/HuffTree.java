
package models;

import java.util.ArrayList;
import java.util.HashMap;
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
			currentNode.parent = null;
			n1.parent = currentNode;
			n2.parent = currentNode;
			currentNode.c = n1.c + n2.c;
			currentNode.freq = n1.freq + n2.freq;
			currentNode.left = n1;
			currentNode.right = n2;
			root = n1;
		}
		else{
			currentNode = new Node();
			currentNode.parent = null;
			n1.parent = currentNode;
			n2.parent = currentNode;
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
			root.parent = null;
			currentNode = root;
		}
		else{
			if(n1 != root){
				currentNode = new Node();
				currentNode.parent = null;
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
		return this.root.toString();
	}


	/**
	 * Check to see if the HuffTree is empty
	 * @return
	 */
	public boolean isEmpty(){
		return root == null;
	}
	
	
	public HashMap<String, String> traverseTree(Node theRoot){
		HashMap<String, String> mapping = new HashMap<String, String>();
		ArrayList<Node> visitedList = new ArrayList<Node>();
		Node cNode = null;
		
		if(isEmpty()){
			return mapping;
		}
		else{
			cNode = theRoot;
			
			while(!visitedList.contains(theRoot)){
				if(visitedList.contains(cNode.left) && visitedList.contains(cNode.right)){
					// if both the left and right child nodes are in the list, we can add the current node to the visited list
					visitedList.add(cNode);
					cNode = cNode.parent;
				}
				if(cNode != null && cNode.left == null && cNode.right == null){
					// We are at the bottom. The binaryName should contain the huffcode for this letter
					mapping.put(cNode.c, cNode.binaryName);
					// go up one node in the tree cause we are at the bottom
					visitedList.add(cNode);
					cNode = cNode.parent;
				}
				else {
					if(cNode != null && cNode.left != null && !visitedList.contains(cNode.left)){
						cNode = cNode.left;
						cNode.binaryName = cNode.calculateBinaryName(cNode, theRoot);						
					}
					if(cNode != null && cNode.right != null && !visitedList.contains(cNode.right)){
						cNode = cNode.right;
						cNode.binaryName = cNode.calculateBinaryName(cNode, theRoot);
					}
				}
			}
		}
		return mapping;
	}

}
