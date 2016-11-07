package org.vis.ctci.tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.vis.ctci.SortAndSearch;

public class SortAndSearchTest {

	@Test
	public void testMergeIntoA() {
		int[] a = new int[]{1, 3, 5, 7, 9, 11, 0, 0, 0, 0, 0, 0};
		int[] b = new int[]{2, 4, 6, 8};
		
		int[] expected = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 0, 0};
		SortAndSearch.mergeIntoA(a, 6, b);
		assertTrue(Arrays.equals(a, expected));
	}

	@Test
	public void testSortByAnagram() {
		fail("Not yet implemented"); // TODO
	}

}