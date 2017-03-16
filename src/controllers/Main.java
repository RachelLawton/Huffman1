package controllers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

import javax.swing.tree.TreeNode;

import models.HuffTree;
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
	

	public void huffTree(PriorityQueue <Node> priQueue){
		
		HuffTree ht = new HuffTree();
		
		if(priQueue.size() > 2){
			// pull out two nodes
			Node n1 = priQueue.remove();
			Node n2 = priQueue.remove();
			Node parent = ht.add(n1, n2);
			priQueue.add(parent);
		}
		else{
			// pull out a single Node
			Node n1 = priQueue.remove();
			Node parent = ht.add(n1);
			priQueue.add(parent);
		}
		
	}

	public static void freqCounter(String word, HashMap<String, Integer> huff){
		for(int i = 0; i < word.length(); i++){
			char letter = word.charAt(i);

			if(huff.containsKey(String.valueOf(letter))){
				// increment it by one
				Integer frequency = huff.get(String.valueOf(letter));
				huff.put(String.valueOf(letter), ++frequency);
			}
			else{
				// add it and make it one
				Integer val = new Integer(1);
				huff.put(String.valueOf(letter),  val);
			}
		}
	}
	
	public static void populateQueue(HashMap<String,Integer> freqHash, PriorityQueue<Node> priQueue){
		// Loop over the freqHash, and for each element put it into the priQueue
		for(Entry<String, Integer> entry : freqHash.entrySet()){
			String c = entry.getKey();
			Integer i = entry.getValue();
			priQueue.add(new Node(c, i));
		}
	}

	public static void main(String args[]){
		// For testing I want to use this string test. 
		// But for the assignment I need to read in data from a file at this point..
		String test = "mississippi";
		
		// Declare a HashMap to hold my characters and the frequency of each character in the test string
		HashMap<String, Integer> freqHash = new HashMap<String,Integer>();
		
		// Calculate the frequency of each chracter in the test string
		freqCounter(test, freqHash);
		
		// Declare a priority list/queue
		NodeComparator nodeCompare = new NodeComparator(); // I can use this nodeCompare to compare Node objects
		PriorityQueue <Node> priQueue = new PriorityQueue<Node>(nodeCompare);

		// Add each character/frequency pair to the PriorityQueue
		populateQueue(freqHash, priQueue);
		
		// Create our HuffTree
		

		// Print out the results
		System.out.println(freqHash.toString());
		//System.out.println(priQueue.toString());
		while (priQueue.size() > 0) {
		    System.out.print(priQueue.remove() + " ");
		}
	}
}
