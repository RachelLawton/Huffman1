package models;

import java.util.Comparator;

public class Node implements Comparable {

	public String c;
	public Integer freq;
	public Node left;
	public Node right;
	public Node currentNode;

	public Node(){
		char empty = '\0'; // https://coderanch.com/t/392740/java/Set-char-empty
		this.c = new String("");
		this.freq = new Integer(0);
	}

	public Node(String c, Integer freq){
		this.c = c;
		this.freq = freq;
	}
	
	public boolean end(){
		return ((CharSequence) currentNode).length() ==1;
	}
	

	// Explanation how to use a priority queue and how to implement the 
	// comparator/comparable interfaces 
	// https://stackoverflow.com/questions/683041/how-do-i-use-a-priorityqueue
	public int compareTo(Object o) {
		// If the frequency of the current node is greater than the frequency of object o, return 1
		if(this.freq.intValue() > ((Node)o).freq.intValue()){
			return 1;
		}
		// If the frequency of the current node is less than the frequency of object o, return -1
		if(this.freq.intValue() < ((Node)o).freq.intValue()){
			return -1;
		}
		// Else return 0 because the frequency must be the same
		return 0;
	}

	public String toString(){
		return this.c.toString() + ":" + this.freq.toString();
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public Integer getFreq() {
		return freq;
	}

	public void setFreq(Integer freq) {
		this.freq = freq;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public Node getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(Node currentNode) {
		this.currentNode = currentNode;
	}

	public char charAt(int i) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}



