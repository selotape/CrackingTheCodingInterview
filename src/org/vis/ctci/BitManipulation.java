package org.vis.ctci;

public class BitManipulation {

	public static int getBit(int num, int i){ // TODO - add error handling (i < 0, i > int size)
		return (num >> i) & 1;
	}
	public static int flipBit(int num, int i){
		return num ^ (1 << i);
	}
	public static boolean isAlmostPowerOfTwo(int num) {
		return isPowerOfTwo(num+1);
	}
	public static boolean isPowerOfTwo(int num) {
		return (num != 0) && ((num & (num-1)) == 0);
	}
	public static int countBits(int num){ //TODO - write tests
		int count = 0;
		while (num!=0){
			if ((num & 1) == 1) count++;
			num >>>= 1;
		}
		return count;
	}

	public static int longestBitStrech(int num){
		if (num == Integer.MAX_VALUE) return Integer.BYTES*8; //all ones
		int bestStrech = 1; // can always have atleast one one
		int prevStrech = 0, curStrech = 0;

		for (int i = 0 ; i<Integer.BYTES*8 ; i++){
			if (getBit(num, i)==1){ // reached a 1
				curStrech++;
				if ((curStrech + 1 + prevStrech) > bestStrech) {
					bestStrech = curStrech + 1 + prevStrech;
				}
			} else { // reached a 0
				if ( (i>0) &&  (getBit(num, i-1)==0)){ // reached two zeros in a row. reset all vars 
					prevStrech = 0;
				} else {
					prevStrech = curStrech;
				}
				curStrech = 0;
			}
		}

		if ((curStrech + 1 + prevStrech) > bestStrech) {
			bestStrech = curStrech + 1 + prevStrech;
		}

		return bestStrech;
	}

	public static int nextLargestWithSameBitCount(int num){
		if (num == Integer.MAX_VALUE || num <= 0 || isAlmostPowerOfTwo(num)) { // TODO - change edgecase to be 0111111000...
			return 0;
		}

		int position = 0;

		while (getBit(num, position) == 0) position++; // skip lsb 0's
		while (getBit(num, position) == 1) position++; // now skip lsb 1's

		return flipBit(flipBit(num, position), position-1);
	}
	public static int nextSmallestWithSameBitCount(int num){
		if (num == Integer.MAX_VALUE || num <= 0 || isAlmostPowerOfTwo(num)) {
			return 0;
		}
		int position = 0;
		while (getBit(num, position) == 1) position++; // skip over lsb 1's
		while (getBit(num, position) == 0) position++; // skip to where lsb 0's end

		return flipBit(flipBit(num, position), position -1);
	}

	public static int bitDistance(int a, int b){
		int xored = a^b;
		return countBits(xored);
	}
}