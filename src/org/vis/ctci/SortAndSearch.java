package org.vis.ctci;

import java.util.Arrays;
import java.util.Comparator;

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
	
	private static class Anagram implements Comparable<Anagram>{
		private static final int a_ASCII = 97;
		private static final int ALPHA_SIZE = 26;
		public int[] charCount = new int[ALPHA_SIZE]; // TODO - encapsulate charCount!!
		public Anagram(String str){
			for (int i = 0; i< str.length() ; i++){
				char c = str.charAt(i);
				int pos = (int)c - a_ASCII;
				this.charCount[pos] += 1;
			}
		}
		@Override
		public int compareTo(Anagram that){
			for (int i = ALPHA_SIZE-1 ; i>=0 ; i--) {
				if (this.charCount[i] != that.charCount[i]){
					return (this.charCount[i] - that.charCount[i]);
				}
			}
			return 0;
		}
	}
	public static void SortByAnagram(String[] strings){ 
		/*
		 * assumptions:
		 * 1- alphabet is only small-case letters (i.e. no white-spaces, caps, special chars etc.
		 * 2- 'strings' isn't null
		 */
		Arrays.sort(strings, new Comparator<String>(){
			@Override
			public int compare(String a, String b){
				Anagram aAnag = new Anagram(a);
				Anagram bAnag = new Anagram(b);
				return aAnag.compareTo(bAnag);
			}
		});
	}
}
