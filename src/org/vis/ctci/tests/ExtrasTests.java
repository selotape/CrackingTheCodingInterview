package org.vis.ctci.tests;

import static org.junit.Assert.assertEquals;
import static org.vis.ctci.Extras.getSummingPair;

import org.junit.Test;

import com.google.common.collect.Multiset;
import com.google.common.collect.HashMultiset;

import javafx.util.Pair;

public class ExtrasTests {

	@Test
	public void testGetSummingPair() {
		
		Multiset<Integer> set1 = HashMultiset.create();//
		set1.add(1); set1.add(2); set1.add(3); set1.add(4); set1.add(5);
		int target1 = 9;
		int target2 = 3;
		int target3 = 10;
		Pair<Integer, Integer> expected1 = new Pair<Integer, Integer>(4, 5);
		Pair<Integer, Integer> expected2 = new Pair<Integer, Integer>(1, 2);
		
		assertEquals(getSummingPair(set1, target1), expected1);
		assertEquals(getSummingPair(set1, target2), expected2);
		assertEquals(getSummingPair(set1, target3), null);
	}

}
