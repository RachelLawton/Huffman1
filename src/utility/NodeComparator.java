package utility;

import java.util.Comparator;

import models.Node;

public class NodeComparator implements Comparator<Node> {

	// Explanation how to use a priority queue and how to implement the 
	// comparator/comparable interfaces 
	// https://stackoverflow.com/questions/683041/how-do-i-use-a-priorityqueue
	public int compare(Node arg0, Node arg1) {
		// If the frequency of the current node is greater than the frequency of object o, return 1
		if(arg0.freq.intValue() > arg1.freq.intValue()){
			return 1;
		}
		// If the frequency of the current node is less than the frequency of object o, return -1
		if(arg0.freq.intValue() < arg1.freq.intValue()){
			return -1;
		}
		// Else return 0 because the frequency must be the same
		return 0;
	}

}
