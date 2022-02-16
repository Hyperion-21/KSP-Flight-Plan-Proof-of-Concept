package kspFlightPlan;

import java.util.Arrays;

public class Runner {

	public static void main(String[] args) {
		
		DVarrayObject[] outputObjects = InputManager.startVessel();
		System.out.println(Arrays.toString(InputManager.startRoute().getPlanets()));
	}
}
