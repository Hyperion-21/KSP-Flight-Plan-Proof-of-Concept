package kspFlightPlan;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Main class
 * @author Hyperion_21
 *
 */
public class Runner {

	private static HashMap<String, Integer[]> dvMap = new HashMap<String, Integer[]>();
	
	public static void main(String[] args) {
		
		// Initialize dvMap
		MapMaker.start(dvMap);
		
		// Run InputManager
		DVarrayObject[] stageDV = InputManager.startVessel();
		int[] compressedDV = DVcompressor.compress(stageDV);
		RouteObject route = InputManager.startRoute();

		if (route.getRouteID() % 6 == 1 || route.getRouteID() % 6 == 2) OutputManager.solo(compressedDV, route, dvMap);
	}
}
