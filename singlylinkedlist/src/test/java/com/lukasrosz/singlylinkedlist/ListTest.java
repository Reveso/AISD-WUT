package com.lukasrosz.singlylinkedlist;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class ListTest {
	
	private Integer[] shortIntArray;
	private int notContainedInt;
	private Node<Integer> list;
	
	@Before
	public void initialize() {
		shortIntArray = new Integer[3];
		shortIntArray[0] = 4;
		shortIntArray[1] = 2;
		shortIntArray[2] = 7;
		notContainedInt = 12;
		
		list = new Node<Integer>();
		addToList(list);
	}
	
	
	private void addToList(Node<Integer> list) {
		list.add(shortIntArray[0]);
		list.add(shortIntArray[1]);
		list.add(shortIntArray[2]);	
	}
		
	@Test
	public void addTest() {		
		Node<Integer> list = new Node<Integer>();
		addToList(list);
		
		Integer[] actuals = new Integer[3];
		
		actuals[0] = list.getObject();
		actuals[1] = list.getNext().getObject();
		actuals[2] = list.getNext().getNext().getObject();
		
		assertArrayEquals(shortIntArray, actuals);
	}
	
	@Test
	public void iterativeSearchTest() {
		for(int i=0; i<shortIntArray.length; i++) {
			Node<Integer> node = list.iterativeSearch(shortIntArray[i]);
			assertEquals(shortIntArray[i], node.getObject());
		}
		assertEquals(list.iterativeSearch(notContainedInt), null);
	}
	
	@Test
	public void recurrentSearchTest() {
		for(int i=0; i<shortIntArray.length; i++) {
			Node<Integer> node = list.recurrentSearch(list, shortIntArray[i]);
			assertEquals(shortIntArray[i], node.getObject());
		}
		assertEquals(list.iterativeSearch(notContainedInt), null);	
	}

}
