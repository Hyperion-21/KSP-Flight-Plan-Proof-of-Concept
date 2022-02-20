package kspFlightPlan;

import java.text.DecimalFormat;
import java.util.HashMap;

public class OutputManager {

	public static void solo(int[] dv, RouteObject route, HashMap<String, Integer[]> dvMap) {
		String planet = route.getPlanets()[0];
		int routeID = route.getRouteID();
		
		System.out.print("\nAscent:   ");
		double tempDouble = Math.round((dv[0] / 3400d) * 100);
		DecimalFormat format = new DecimalFormat("0.#");
		
		if (dv[0] >= 3400 * 1.5) {
			System.out.println("WARN\n"
					+ format.format(tempDouble) + "% of Minimum (" + dv[0] + "/3400)\n"
					+ "Excessive Fuel! Aim closer to ~120%!");
		} else if (dv[0] >= 3400 * 1.1) {
			System.out.println("GOOD\n"
					+ format.format(tempDouble) + "% of Minimum (" + dv[0] + "/3400)");
		} else if (dv[0] >= 3400) {
			System.out.println("WARN\n"
					+ format.format(tempDouble) + "% of Minimum (" + dv[0] + "/3400)\n"
					+ "Extra fuel recommended!");
		} else {
			System.err.println("BAD!\n"
					+ format.format(tempDouble) + "% of Minimum (" + dv[0] + "/3400)\n"
					+ "Not enought fuel! Cannot safely get to orbit!");
		}
		
		System.out.print("\nTransfer: ");
		int tempInt = dvMap.get(planet)[0] + dvMap.get(planet)[1] + 980;
		tempDouble = Math.round((dv[1] * 1.0d) / (tempInt * 1.0d) * 100);
		
		if (dv[1] >= tempInt * 1.75) {
			System.out.println("WARN\n"
					+ format.format(tempDouble) + "% of Minimum (" + dv[1] + "/" + tempInt + ")\n"
					+ "Excessive Fuel! Aim closer to ~135%!");
		} else if (dv[1] >= tempInt * 1.25) {
			System.out.println("GOOD\n"
					+ format.format(tempDouble) + "% of Minimum (" + dv[1] + "/" + tempInt + ")");
		} else if (dv[1] >= tempInt) {
			System.out.println("WARN\n"
					+ format.format(tempDouble) + "% of Minimum (" + dv[1] + "/" + tempInt + ")\n"
					+ "Extra fuel recommended!");
		} else {
			System.err.println("BAD!\n"
					+ format.format(tempDouble) + "% of Minimum (" + dv[1] + "/" + tempInt + ")\n"
					+ "Not enought fuel! Cannot safely transfer to " + planet.substring(0, 1).toUpperCase() + planet.substring(1) + "! Gravity assists / aerocapturing may be required!");
		}
		
		if (routeID % 6 == 2) {
			System.out.print("\nLanding:  ");
			tempInt = dvMap.get(planet)[2];
			tempDouble = Math.round((dv[2] * 1.0d) / (tempInt * 1.0d) * 100);
			
			if (dv[2] >= tempInt * 1.5) {
				System.out.println("WARN\n"
						+ format.format(tempDouble) + "% of Minimum (" + dv[2] + "/" + tempInt + ")\n"
						+ "Excessive Fuel! Aim closer to ~120%!");
			} else if (dv[2] >= tempInt * 1.1) {
				System.out.println("GOOD\n"
						+ format.format(tempDouble) + "% of Minimum (" + dv[2] + "/" + tempInt + ")");
			} else if (dv[2] >= tempInt) {
				System.out.println("WARN\n"
						+ format.format(tempDouble) + "% of Minimum (" + dv[2] + "/" + tempInt + ")\n"
						+ "Extra fuel recommended!");
			} else {
				System.err.println("BAD!\n"
						+ format.format(tempDouble) + "% of Minimum (" + dv[2] + "/" + tempInt + ")\n"
						+ "Not enought fuel! Cannot safely get to orbit!");
			}
		}
		
		if (routeID % 6 == 1 && dv[2] > 0) System.err.println("\nPotentially unused fuel! " + dv[2] + "dv is marked as landing!");
		
		if (routeID >= 6) {
			if (dv[3] > 0) System.err.println("\nPotentially unused fuel! " + dv[3] + "dv is marked as return!");
			return;
		} else {
			System.out.print("\nReturn:   ");
			tempInt = dvMap.get(planet)[0] + dvMap.get(planet)[1] + 980;
			tempDouble = Math.round((dv[3] * 1.0d) / (tempInt * 1.0d) * 100);
			
			if (dv[3] >= tempInt * 1.75) {
				System.out.println("WARN\n"
						+ format.format(tempDouble) + "% of Minimum (" + dv[3] + "/" + tempInt + ")\n"
						+ "Excessive Fuel! Aim closer to ~135%!");
			} else if (dv[3] >= tempInt * 1.25) {
				System.out.println("GOOD\n"
						+ format.format(tempDouble) + "% of Minimum (" + dv[3] + "/" + tempInt + ")\n");
			} else if (dv[3] >= tempInt) {
				System.out.println("WARN\n"
						+ format.format(tempDouble) + "% of Minimum (" + dv[3] + "/" + tempInt + ")\n"
						+ "Extra fuel recommended!");
			} else {
				System.err.println("BAD!\n"
						+ format.format(tempDouble) + "% of Minimum (" + dv[3] + "/" + tempInt + ")\n"
						+ "Not enought fuel! Cannot safely get home! Gravity assists / aerocapturing may be required!");
			}
		}
	}
}
