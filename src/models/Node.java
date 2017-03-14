package models;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import javax.swing.tree.TreeNode;

public class Node  {


	public Character c;
	public int freq;
	public Node parent;
	public Node right;
	public Node left;


	PriorityQueue<TreeNode> pQueue = new PriorityQueue<TreeNode>();
	Map<Character, Integer> huff = new HashMap<Character,Integer>();
	PriorityQueue <Node> priQueue = new PriorityQueue<Node>(new HuffCompartor());


	public Node(){
		//this.c = '';
		this.freq = 0;
		this.parent = null;
		this.right = null;
		this.left = null;
	}

	public Node(Character c, int freq, Node left, Node Right){// Node parent, Node right, Node left){
		this.c = c;
		this.freq = freq;
		this.parent = parent;
		this.right = right;
		this.left = left;
	}


	public PriorityQueue<Node> pQueue(HashMap<Character, Integer> huff){
		for(Entry<Character, Integer> entry : huff.entrySet()){
			priQueue.add(new Node(entry.getKey(), entry.getValue(), null, null));
		}
		//System.out.println("your queue is" + priQueue.toString());
		return priQueue;
	}
	
	//public Node huffTree(HashMap<Character, Integer> huff){
		
	//}



	public class HuffCompartor implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {

			return o1.freq- o2.freq;
		}

		public Character getC() {
			return c;
		}


		public int getFreq() {
			return freq;
		}
	}
}



