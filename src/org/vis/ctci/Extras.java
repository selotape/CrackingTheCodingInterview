package org.vis.ctci;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Multiset;

import javafx.util.Pair;

public class Extras {
	public static Pair<Integer, Integer> getSummingPair(Multiset<Integer> nums, int target){
		Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
		for (int num : nums){
			if (numsMap.containsKey(num)) {
				numsMap.put(num, numsMap.get(num) + 1);
			} else {
				numsMap.put(num, 1);
			}
		}
		for (int num : nums){
			if (numsMap.containsKey(target-num)) {
				if ((num != target-num) || (numsMap.get(num) > 1)) {
					return new Pair<Integer, Integer>(num, target-num);
				}
			}
		}

		return null;
	}
}
