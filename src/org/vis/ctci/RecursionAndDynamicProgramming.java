package org.vis.ctci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sun.org.apache.xml.internal.serializer.ElemDesc;

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

	public static class SearchBotPath{
		public static List<Integer> recursive(boolean[][] grid){
			if (isValid(grid)) {
				return recursive(grid, 0, 0);
			} else {
				return null;
			}
		}
		private static List<Integer> recursive(boolean[][] grid, int row, int column){
			List<Integer> path;
			int numRows = grid.length;
			int numCols = grid[0].length;
			if (!isValid(grid, row, column)){
				return null;
			}
			int ADVANCE_ROW = 0; int ADVANCE_COLUMN = 1; //TODO - move somewhere static and higher up

			if ((row == numRows-1) && (column == numCols-1)){ // reached goal!
				return new ArrayList<Integer>();
			}
			if (canAdvanceColumn(grid, row, column)){
				path = recursive(grid, row, column+1);
				if (path != null){
					path.add(0, ADVANCE_COLUMN);
					return path;
				}
			} 
			if (canAdvanceRow(grid, row, column)){
				path = recursive(grid, row+1, column);
				if (path != null){
					path.add(0, ADVANCE_ROW);
					return path;
				}
			}
			return null;
		}


//		public static List<Integer> memoization(boolean[][] grid){
//			if (isValid(grid)) {
//				List<List<List<Integer>>> memo = initMemo(grid.length, grid[0].length);
//				return memoization(grid, memo, 0, 0);
//			} else {
//				return null;
//			}
//		}

		public static List<Integer> iterative(boolean[][] grid){
			if (isValid(grid)) {
				return recursive(grid, 0, 0);
			} else {
				return null;
			}
		}

		private static boolean canAdvanceColumn(boolean[][] grid, int row, int column) {
			int numCols = grid[0].length;
			return ((column < numCols-1) && (grid[row][column+1]));
		}
		private static boolean canAdvanceRow(boolean[][] grid, int row, int column) {
			int numRows = grid.length;
			return ((row < numRows-1) && (grid[row+1][column]));
		}
		private static boolean isValid(boolean[][] grid) {
			// TODO Auto-generated method stub
			return true;
		}
		private static boolean isValid(boolean[][] grid, int row, int column) {
			// TODO Auto-generated method stub
			return true;
		}
	}

	public static class SuperSets{
		public static <T> Set<Set<T>> recursive(Set<T> mySet) {
			Map<Set<T>, Set<Set<T>>> memo = new HashMap<Set<T>, Set<Set<T>>>();
			Set<Set<T>> result = generateSuperSet(mySet, memo);
			return result;
		}

		private static <T> Set<Set<T>> generateSuperSet(Set<T> mySet, Map<Set<T>, Set<Set<T>>> memo) {
			if (mySet.size() == 0) return new HashSet<Set<T>>();
			if (memo.containsKey(mySet)){
				return memo.get(mySet);
			} else {
				T element = mySet.iterator().next();
				mySet.remove(element);
				Set<Set<T>> subSuperSet = generateSuperSet(mySet, memo);
				mySet.add(element);
				Set<Set<T>> superSet = merge(element, subSuperSet);
				memo.put(mySet, superSet);
				return superSet;
			}
		}
		private static <T> Set<Set<T>> merge(T element, Set<Set<T>> subSuperSet){
			Set<Set<T>> result = new HashSet<Set<T>>();
			if (subSuperSet.isEmpty()){
				result.add(new HashSet<T>());
				
				result.add((new HashSet<T>(){{add(element);}}));
			} else {
				for (Set<T> subset : subSuperSet){
					result.add(new HashSet<T>(subset));
					subset.add(element);
					result.add((new HashSet<T>(subset)));
					subset.remove(element);
				}
			}
			return result;
		}
	}
}
