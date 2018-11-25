package com.ravi.practice.coding_practice.treesandheaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 
 * @author Ravi.Katiyar Given an array of integer and a number k find K largest
 *         element in it
 */
public class KLargestElements {

	public static void main(String args[]) {

		int arr[] = { 10, 20, 5, 30, 1, 18 };
		int k = 3;

		List<Integer> inputArray = new ArrayList<Integer>(arr.length);
		for (int e : arr) {
			inputArray.add(e * (-1));
		}
		TreeMap<Integer, Integer> treeMap;
		//treeMap.
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(inputArray);
		for (int i = 0; i < k; i++) {
			System.out.println(priorityQueue.poll() * (-1));
		}
	}
}
