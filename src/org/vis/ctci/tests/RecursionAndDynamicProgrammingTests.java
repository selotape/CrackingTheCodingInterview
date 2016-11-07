package org.vis.ctci.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.vis.ctci.RecursionAndDynamicProgramming.CountWaysToClimb.countWaysIter;
import static org.vis.ctci.RecursionAndDynamicProgramming.CountWaysToClimb.countWaysMemo;
import static org.vis.ctci.RecursionAndDynamicProgramming.CountWaysToClimb.countWaysRec;
import static org.vis.ctci.RecursionAndDynamicProgramming.SuperSets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.vis.ctci.RecursionAndDynamicProgramming;

public class RecursionAndDynamicProgrammingTests {

	@Test
	public void countWaysRecTest() {
		assertEquals(4, countWaysRec(3));
		assertEquals(7, countWaysRec(4));
		assertEquals(13, countWaysRec(5));
	}

	@Test
	public void countWaysMemoTest() {
		assertEquals(4, countWaysMemo(3));
		assertEquals(7, countWaysMemo(4));
		assertEquals(13, countWaysMemo(5));
	}

	@Test
	public void countWaysIterTest() {
		assertEquals(4, countWaysIter(3));
		assertEquals(7, countWaysIter(4));
		assertEquals(13, countWaysIter(5));
	}


	@Test
	public void SearchBotPathTest() {
		List<Integer> expected;
		boolean[][] grid;
		List<Integer> result;

		expected = Arrays.asList(1, 0);
		grid = new boolean[2][2];
		grid[0][0] = true; grid[0][1] = true;
		grid[1][1] = true; grid[1][0] = false;
		result = RecursionAndDynamicProgramming.SearchBotPath.recursive(grid);
		assertTrue(expected.equals(result));
		//		result = RecursionAndDynamicProgramming.SearchBotPath.memoization(grid);
		//		assertTrue(expected.equals(result));
		result = RecursionAndDynamicProgramming.SearchBotPath.iterative(grid);
		assertTrue(expected.equals(result));

		expected = Arrays.asList(1, 0, 0, 1);
		grid = new boolean[3][3];
		grid[0][0] = true;  grid[0][1] = true;  grid[0][2] = false; 
		grid[1][0] = false; grid[1][1] = true;  grid[1][2] = false;
		grid[2][0] = true;  grid[2][1] = true; grid[2][2] = true;
		result = RecursionAndDynamicProgramming.SearchBotPath.recursive(grid);
		assertTrue(expected.equals(result));
	}

	@Test
	public void generateSuperSetTest(){
		Set<Integer> mySet = new HashSet<Integer>(){{
			add(3);
			add(2);
			add(5);
		}};
		
		System.out.println(SuperSets.recursive(mySet));
	}
}
