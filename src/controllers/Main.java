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

	public static void huffTree(PriorityQueue <Node> priQueue, HuffTree ht){
		// while the pririty queue is not empty keep taking the nodes out and put them into the huff tree
		while(!priQueue.isEmpty()){
			if(priQueue.size() >= 2){
				// pull out two nodes
				Node n1 = priQueue.remove();
				Node n2 = priQueue.remove();
				
				// add them to the hufftree
				Node parent = ht.add(n1, n2);
				//System.out.println(n1.toString() + " " + n2.toString() + " -> " + parent.toString());

				// put the parent of these two nodes back into the priority queue
				priQueue.add(parent);
			}
			else{
				// pull out a single Node
				Node n1 = priQueue.remove();
				//System.out.println(n1.toString());
				
				// when there is only one node left it must be the one with the highest priority
				Node parent = ht.add(n1);
				//System.out.println("final -> " + parent.toString());
			}}
	}

	public static void main(String args[]){
		// For testing I want to use this string test. 
		// But for the assignment I need to read in data from a file at this point..
		String test_string = "mississippi";
		System.out.println("Test String: " + test_string);

		// Declare a HashMap to hold my characters and the frequency of each character in the test string
		HashMap<String, Integer> freqHash = new HashMap<String,Integer>();

		// Calculate the frequency of each character in the test string
		freqCounter(test_string, freqHash);
		System.out.println(freqHash);

		// Declare a priority list/queue
		NodeComparator nodeCompare = new NodeComparator(); // I can use this nodeCompare to compare Node objects
		PriorityQueue <Node> priQueue = new PriorityQueue<Node>(nodeCompare);

		// Add each character/frequency pair to the PriorityQueue
		populateQueue(freqHash, priQueue);
		System.out.println(priQueue);

		// Create my HuffTree
		HuffTree ht = new HuffTree();

		// Populate my HuffTree
		huffTree(priQueue, ht);
		System.out.println(ht);
		
		// Calculate the huffman codes for each letter
		HashMap<String, String> huff_codes =  ht.traverseTree(ht.root);
		System.out.println(huff_codes);
<<<<<<< HEAD
		
	}
	
}
=======
	}
}
>>>>>>> origin/master
