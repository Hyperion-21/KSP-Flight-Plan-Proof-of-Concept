package kspFlightPlan;

import java.util.Arrays;

/**
 * Main class
 * @author Hyperion_21
 *
 */
public class Runner {

	public static void main(String[] args) {
		
		// Run InputManager
		DVarrayObject[] stageDV = InputManager.startVessel();
		int[] compressedDV = DVcompressor.compress(stageDV);
		RouteObject route = InputManager.startRoute();

	}
}
