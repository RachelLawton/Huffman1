package controllers;

import java.util.HashMap;
import java.util.Map;

public class Main {

	
	
	public static void freqCounter(String word, HashMap<Character, Integer> huff){
		for(int i = 0; i < word.length(); i++){
			char letter = word.charAt(i);
			
			
			if(huff.containsKey(letter)){
				// increment it by one
				Integer frequency = huff.get(letter);
				huff.put(letter, ++frequency);
			}
			else{
				//System.out.println("The letter :"+ huff);
				// add it and make it one
				//Integer val = new Integer(1);
				//huff.put(letter,  val);
				huff.put(letter, new Integer(1));
			}
		}
	}
	
	public static void main(String args[]){
		// declare a priority list/queue and populate it with nodes and the frequency of how ofthen they appear in your test string
		HashMap<Character, Integer> huff = new HashMap<Character,Integer>();
		String test = "mississippi";
		
		freqCounter(test, huff);
		
		System.out.println(huff.toString());
	}
	
}
