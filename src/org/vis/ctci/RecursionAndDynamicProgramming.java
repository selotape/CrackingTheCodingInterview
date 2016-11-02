package org.vis.ctci;

public class RecursionAndDynamicProgramming {
	public static class CountWaysToClimb{
		public static int countWaysRec(int stairs){
			if (stairs <= 0) return 0;
			if (stairs == 1 || stairs == 2) return stairs;
			if (stairs == 3) return 4;
			
			return countWaysRec(stairs -1) +countWaysRec(stairs -2) +countWaysRec(stairs -3) ;
		}
		public static int countWaysMemo(int stairs){
			int[] memo = new int[stairs/*OFF BY ONE!*/+1];
			return countWaysMemo(stairs, memo);
		}
		private static int countWaysMemo(int stairs, int[] memo){
			if (stairs <= 0) return 0;
			if (stairs == 1 || stairs == 2) return stairs;
			if (stairs == 3) return 4;
			
			if (memo[stairs] == 0){
				memo[stairs] = countWaysMemo(stairs-3, memo) + countWaysMemo(stairs-2, memo) + countWaysMemo(stairs-1, memo);
			}
			
			return memo[stairs];
		}
		public static int countWaysIter(int stairs){
			if (stairs <= 0) return 0;
			if (stairs == 1 || stairs == 2) return stairs;
			if (stairs == 3) return 4;
			
			int a = 1, b = 2, c = 4, d = 0;
			for (int i = 4 ; i <=stairs ; i++){
				d = a + b + c;
				a = b; b = c; c = d;
			}
			return d;
		}
	}
}
