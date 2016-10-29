package org.vis.ctci;

public class BitManipulation {
	
	public static int getBit(int num, int i){ // TODO - add error handling (i < 0, i > int size)
		return (num >> i) & 1;
	}
	
	public static int bitStrech(int num){
		if (num == Integer.MAX_VALUE) return Integer.BYTES*8; //all ones
		int bestStrech = 1; // can always have atleast one one
		int prevStrech = 0, curStrech = 0;

		for (int i = 0 ; i<Integer.BYTES*8 ; i++){
			System.out.print(i + ":");
			System.out.println(getBit(num, i)==1 ? 1 : 0);
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
}