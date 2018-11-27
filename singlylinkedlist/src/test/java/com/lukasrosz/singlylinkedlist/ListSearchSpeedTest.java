package com.lukasrosz.singlylinkedlist;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ListSearchSpeedTest {

	private Integer[] longIntArray;
	private Node<Integer> list;

	@Before
	public void initialize() {
		populateLongIntArray();
		populateList();
	}

	private void populateList() {
		list = new Node<>();
		for(int i=0; i<longIntArray.length; i++) {
			list.add(longIntArray[i]);
		}
	}
	
	private void populateLongIntArray() {
		longIntArray = new Integer[20000];
		for (int i = 0; i < longIntArray.length; i++) {
			longIntArray[i] = i;
		}
	}
	
	@Test
	public void speedTest() {
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("speedData.txt")))) {
			for(int i=10; i<(longIntArray.length - 200); i=i+50) {
				bufferedWriter.write(i + " ");
				
				long startTime = System.nanoTime();
				list.iterativeSearch(i);
				long endTime = System.nanoTime();
				long duration = (endTime - startTime);
				
				bufferedWriter.write(duration + " ");
				
				startTime = System.nanoTime();
				list.recurrentSearch(list, i);
				endTime = System.nanoTime();
				duration = (endTime - startTime);
				bufferedWriter.write(duration + "\n");
//				System.out.println(i + " " + startTime + " " + endTime + " " + duration);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
