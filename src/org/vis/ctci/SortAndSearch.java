package org.vis.ctci;

public class SortAndSearch {
	/***
	 * receives two sorted arrays 'a' & 'b' and merges them into 'a'
	 */
	public static void mergeIntoA(int[] a, int aLength/*number of VALUES in 'a'*/, int[] b){
		int aHelper = aLength - 1;
		int bHelper = b.length - 1;
		int aEnd = aLength + b.length - 1 ;

		while ((aHelper >= 0) && (bHelper >= 0)){
			if (a[aHelper] > b[bHelper]) {
				a[aEnd] = a[aHelper];
				aHelper -= 1;
			} else {
				a[aEnd] = b[bHelper];
				bHelper -= 1;
			}
			aEnd -= 1;
		}
		
		while (bHelper >= 0) {
			a[aEnd] = b[bHelper];
			bHelper -= 1;
		}
	}
	
	public static void SortByAnagram(String[] strings){
		
	}
}
