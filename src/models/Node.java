package models;

import java.util.Comparator;

public class Node implements Comparable {

	public Character c;
	public Integer freq;

	public Node(){
		char empty = '\0'; // https://coderanch.com/t/392740/java/Set-char-empty
		this.c = new Character(empty);
		this.freq = new Integer(0);
	}

	public Node(Character c, Integer freq){
		this.c = c;
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

	public String toString(){
		return this.c.toString() + ":" + this.freq.toString();
	}
}



