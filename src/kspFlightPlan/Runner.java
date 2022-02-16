package kspFlightPlan;

import java.util.Arrays;

public class Runner {

	public static void main(String[] args) {
		
		DVarrayObject[] stageDV = InputManager.startVessel();
		int[] compressedDV = DVcompressor.compress(stageDV);
		RouteObject route = InputManager.startRoute();

	}
}
