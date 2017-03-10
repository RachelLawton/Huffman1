package models;

import java.util.HashMap;
import java.util.Map;

public class Node {
	
	
	public String c;
	public int freq;
	public Node parent;
	public Node right;
	public Node left;
	
	Map<Character, Integer> huff = new HashMap<Character,Integer>();
	
	public Node(){
		this.c = "";
		this.freq = 0;
		this.parent = null;
		this.right = null;
		this.left = null;
	}
		
	public Node(String c, int freq, Node parent, Node right, Node left){
		this.c = c;
		this.freq = freq;
		this.parent = parent;
		this.right = right;
		this.left = left;
	}
}
