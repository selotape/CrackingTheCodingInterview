package org.vis.ctci;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PoisonedVials {

	private class Vial {
		public boolean isPoisoned;
		int id;
	}
	private class LacmusIndicator{
		int WAIT_TIME = 7;
		int today = 0;
		boolean isPoisoned = false;
		Map<Vial, Integer> vials = new HashMap<Vial, Integer>();
		void addVial(Vial vial){
			vials.put(vial, today);
		}
		void waitDay(){
			today++;
		}
		boolean isPoisoned(){ // returns true if a poisoned tube was added 7 or more days ago
			if (isPoisoned) return true; // Lacmus was already ruined

			Iterator<Map.Entry<Vial,Integer>> iter = vials.entrySet().iterator();
			while (iter.hasNext()) { // 
				Map.Entry<Vial,Integer> entry = iter.next();
			    if (today >= entry.getValue() + WAIT_TIME) {
			    	if (entry.getKey().isPoisoned) this.isPoisoned = true;
			    	iter.remove();
			    }
			}
			return isPoisoned;
		}
	}
	
	public static Vial findPoisonedTube(List<Vial> tubes, List<LacmusIndicator> testers){ // assumes ln(tubes.size) <= testers.size
		
		return null;
	}
}
