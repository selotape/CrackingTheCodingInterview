package org.vis.ctci.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.vis.ctci.RecursionAndDynamicProgramming;
import static org.vis.ctci.RecursionAndDynamicProgramming.CountWaysToClimb.*;

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

}
