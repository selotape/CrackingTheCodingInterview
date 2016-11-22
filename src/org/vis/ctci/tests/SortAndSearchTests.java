package org.vis.ctci.tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.vis.ctci.SortAndSearch;

public class SortAndSearchTests {

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
		String[] strings = new String[]{ "ddd", "aaa", "bbz", "zbb",  "bbd", "aaaa"};
		String[] expected1 = new String[] {"aaa", "aaaa", "bbd", "ddd", "bbz", "zbb"};
		String[] expected2 = new String[] {"aaa", "aaaa", "bbd", "ddd", "zbb", "bbz"};
		SortAndSearch.SortByAnagram(strings);
		
		assertTrue( Arrays.equals(strings, expected1) || Arrays.equals(strings, expected2));
	}

}
