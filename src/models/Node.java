package models;

import java.util.Comparator;

public class Node implements Comparable {

	public String c;
	public String binaryName;
	public Integer freq;
	public Node left;
	public Node right;
	public Node parent;

	public Node(){
		char empty = '\0'; // https://coderanch.com/t/392740/java/Set-char-empty
		this.c = new String("");
		this.binaryName = new String("");
		this.freq = new Integer(0);
	}

	public Node(String c, Integer freq){
		this.c = c;
		this.binaryName = "";
		this.freq = freq;
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

	public String calculateBinaryName(Node cNode, Node root){
		if(cNode != root){
			if(cNode == root.left || cNode == cNode.parent.left){
				return cNode.parent.calculateBinaryName(cNode.parent, root) + "0";
			}
			if(cNode == root.right || cNode == cNode.parent.right){
				return cNode.parent.calculateBinaryName(cNode.parent, root) + "1";
			}
			return "";
		}
		else{
			return "";
		}
	}
	
	public String toString(){
		String str = "";
		str += "Name:" + this.c.toString() + 
			   " Frequency:" + this.freq.toString();
		if(left == null){
			//str += " left: null";
		}
		else
		{
			str += " left: " + left.toString();
		}
		
		if(right == null){
			//str += " right: null";
		}
		else
		{
			str += " right: " + right.toString();
		}
		
		str += " binary: " + binaryName;
		
		return str;
	}

}