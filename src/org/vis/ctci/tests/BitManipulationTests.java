package org.vis.ctci.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.vis.ctci.BitManipulation.*;


public class BitManipulationTests {

	@Test
	public void testBitStrech() {
		assertEquals(1, longestBitStrech(0 /*00000000*/ ));
		assertEquals(5, longestBitStrech(15 /*00001111*/ ));
		assertEquals(8, longestBitStrech(239 /*11101111*/ ));
		assertEquals(4, longestBitStrech(714 /*01011001010*/ ));
		assertEquals(Integer.BYTES*8, longestBitStrech(Integer.MAX_VALUE/*111...111*/));
	}
	
	@Test
	public void testNextSmallestWSameBitCount(){
		assertEquals(52, nextSmallestWithSameBitCount(56));
		assertEquals(50, nextSmallestWithSameBitCount(52));
		assertEquals(49, nextSmallestWithSameBitCount(50));
		
		assertEquals(0, nextSmallestWithSameBitCount(-1234));
		assertEquals(0, nextSmallestWithSameBitCount(7));
	}
	
	
	@Test
	public void testnextLargestWSameBitCount(){
		assertEquals(88, nextLargestWithSameBitCount(56)); // 000111000 -> 001011000
		assertEquals(104, nextLargestWithSameBitCount(88)); // 001011000 -> 001101000
		assertEquals(112, nextLargestWithSameBitCount(104));// 001101000 -> 001110000
		
		assertEquals(112, nextLargestWithSameBitCount(104)); // 01111 -> 10111
		
		assertEquals(0, nextLargestWithSameBitCount(-1)); 
		
	}

}
