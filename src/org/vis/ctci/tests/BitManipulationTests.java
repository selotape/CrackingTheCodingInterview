package org.vis.ctci.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.vis.ctci.BitManipulation.*;


public class BitManipulationTests {

	@Test
	public void testBitStrech() {
		assertEquals(1, bitStrech(0 /*00000000*/ ));
		assertEquals(5, bitStrech(15 /*00001111*/ ));
		assertEquals(8, bitStrech(239 /*11101111*/ ));
		assertEquals(4, bitStrech(714 /*01011001010*/ ));
		assertEquals(Integer.BYTES*8, bitStrech(Integer.MAX_VALUE/*111...111*/));
	}

}
