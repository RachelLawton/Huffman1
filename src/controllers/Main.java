package controllers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

import javax.swing.tree.TreeNode;

import models.Node;
import utility.NodeComparator;

public class Main {
	/*
	 * Requirements
	 * 1. Scan text to be compressed and tally occurrences of all characters
	 * 2. Sort or prioritise characters based on occurrences in text
	 * 3. Build Huffman code tree based on prioritised list
	 * 4. Perform a traversal of tree to determine all code words
	 * 5. Encode a file based on Huffman codes
	 */
	
	/*
	PriorityQueue<TreeNode> pQueue = new PriorityQueue<TreeNode>();
	Map<Character, Integer> huff = new HashMap<Character,Integer>();
	PriorityQueue <Node> priQueue = new PriorityQueue<Node>(new HuffCompartor());
	
	public PriorityQueue<Node> pQueue(HashMap<Character, Integer> huff){
		for(Entry<Character, Integer> entry : huff.entrySet()){
			priQueue.add(new Node(entry.getKey(), entry.getValue(), null, null));
		}
		//System.out.println("your queue is" + priQueue.toString());
		return priQueue;
	}

	//public Node huffTree(HashMap<Character, Integer> huff){

	//}
	 =======
	public void huffTree(HashMap<Character, Integer> huff){

			Node newNode = new Node(c,freq,left,right);

			if(parent ==  null){
				parent = newNode;
			}else{
				Node activeNode = parent;

				while(true){
					parent = activeNode;

					if(c.compareTo(c) < activeNode.c){

						activeNode = activeNode.left;

						if(activeNode ==  null){
							parent.left = newNode;
							return;
						}

					}else{
						activeNode = activeNode.right;

						if(activeNode == null){
							parent.right = newNode;
							return;
						}
					}
				}
			}
		}
		



	public class HuffCompartor implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {

			return o1.freq- o2.freq;
>>>>>>> Stashed changes 
	 
	 */
	
	public static void freqCounter(String word, HashMap<Character, Integer> huff){
		for(int i = 0; i < word.length(); i++){
			char letter = word.charAt(i);

			if(huff.containsKey(letter)){
				// increment it by one
				Integer frequency = huff.get(letter);
				huff.put(letter, ++frequency);
			}
			else{
				// add it and make it one
				Integer val = new Integer(1);
				huff.put(letter,  val);
			}
		}
	}
	
	public static void populateQueue(HashMap<Character,Integer> freqHash, PriorityQueue<Node> priQueue){
		// Loop over the freqHash, and for each element put it into the priQueue
		for(Entry<Character, Integer> entry : freqHash.entrySet()){
			Character c = entry.getKey();
			Integer i = entry.getValue();
			priQueue.add(new Node(c, i));
		}
	}

	public static void main(String args[]){
		// For testing I want to use this string test. 
		// But for the assignment I need to read in data from a file at this point..
		String test = "mississippi river";
		
		// Declare a HashMap to hold my characters and the frequency of each character in the test string
		HashMap<Character, Integer> freqHash = new HashMap<Character,Integer>();
		
		// Calculate the frequency of each chracter in the test string
		freqCounter(test, freqHash);
		
		// Declare a priority list/queue
		NodeComparator nodeCompare = new NodeComparator(); // I can use this nodeCompare to compare Node objects
		PriorityQueue <Node> priQueue = new PriorityQueue<Node>(nodeCompare);

		// Add each character/frequency pair to the PriorityQueue
		populateQueue(freqHash, priQueue);

		// Print out the results
		System.out.println(freqHash.toString());
		//System.out.println(priQueue.toString());
		while (priQueue.size() > 0) {
		    System.out.print(priQueue.remove() + " ");
		}
	}
}
