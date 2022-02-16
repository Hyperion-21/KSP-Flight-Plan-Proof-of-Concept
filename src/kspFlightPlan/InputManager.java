package kspFlightPlan;
import java.util.Scanner;
import java.util.ArrayList;

public class InputManager {
	
	private static Scanner sc = new Scanner(System.in);
	private static int routeID = 0;
	
	public static DVarrayObject[] startVessel() {
		System.out.println("Enter dv of each stage, first to last including non-engine stages (enter nothing to finish insertion or to skip this step)");
		boolean dvAssignmentIsDone = false;
		boolean dvAssignmentSkip = true;
		ArrayList<Integer> dvArray = new ArrayList<Integer>();
		ArrayList<Integer> dvArrayRole = new ArrayList<Integer>();
		
		while (dvAssignmentIsDone == false) {
			String tempString = sc.nextLine();
			int tempInt = 0;
			try {
				tempInt = Integer.parseInt(tempString);
				dvArray.add(tempInt);
			} catch (Exception e) {
				dvAssignmentIsDone = true;
				break;
			}
			dvAssignmentSkip = false;
		}
		
		if (dvAssignmentSkip == true) return null;
		System.out.println("Insert each stage's role\n"
				+ "a - Kerbin Ascent/Orbit\n"
				+ "i - Interplanetary transfer and capture\n"
				+ "l - Interplanetary Landing/Ascent/Orbit\n"
				+ "r - Return\n"
				+ "x - Trivial (decoupler-only, heat shield, etc.)");
		for (int i = 0; i < dvArray.size(); i++) {
			System.out.print("S" + (dvArray.size() -1 -i ) + " (" + dvArray.get(i) + "): ");
			String tempString = sc.nextLine().toLowerCase();
			switch (tempString) {
			case "a":	dvArrayRole.add(0); break;
			case "i":	dvArrayRole.add(1); break;
			case "l":	dvArrayRole.add(2); break;
			case "r":	dvArrayRole.add(3); break;
			case "x":	dvArrayRole.add(4); break;
			default:	i--; break;
			}
		}
		
		DVarrayObject[] objectArray = new DVarrayObject[dvArray.size()];
		for (int i = 0; i < dvArray.size(); i++) {
			objectArray[i] = new DVarrayObject(dvArray.get(i), dvArrayRole.get(i));
		}
		return objectArray;
	}
	
	public static RouteObject startRoute() {
		System.out.println("\nSelect route type:\n"
				+ "1 - To Planet/Moon, Orbit\n"
				+ "2 - To Planet/Moon, Land\n"
				+ "3 - Orbit Kerbin\n"
				+ "4 - Solar Orbit\n"
				+ "5 - Multiple Planet/Moon Orbiting Trip\n"
				+ "6 - Multiple Planet/Moon Landing Trip\\n");
		while (true) {
			String tempString = sc.nextLine();
			try {
				routeID = Integer.parseInt(tempString);
				break;
			} catch (Exception e) {
			}
		}
		System.out.println("Return to Kerbin? (y/n)");
		while (true) {
			String tempString;
			tempString = sc.nextLine().toLowerCase();
			switch (tempString) {
				case "y": break;
				case "yes": break;
				case "n": routeID += 6; break;
				case "no": routeID += 6; break;
				default: continue;
			}
			break;
		}
		if (routeID % 6 == 1 || routeID % 6 == 2) return planetHandler();
		if (routeID % 6 == 3 || routeID % 6 == 4) return altitudeHandler();
		return tourHandler();
	}
	
	private static RouteObject planetHandler() {
		System.out.println("\nWhere is your destination? DO NOT include host planet if moon");
		String[] planets = new String[1];
		while (true) {
			String tempString = sc.nextLine().toLowerCase();
			switch (tempString) {
				case "moho": 	planets[0] = "moho"; 	break;
				case "eve": 	planets[0] = "eve"; 	break;
				case "gilly": 	planets[0] = "gilly"; 	break;
				case "mun": 	planets[0] = "mun"; 	break;
				case "minmus": 	planets[0] = "minmus"; 	break;
				case "duna": 	planets[0] = "duna"; 	break;
				case "ike": 	planets[0] = "ike"; 	break;
				case "dres": 	planets[0] = "dres"; 	break;
				case "jool": 	planets[0] = "jool"; 	break;
				case "laythe": 	planets[0] = "laythe"; 	break;
				case "vall": 	planets[0] = "vall"; 	break;
				case "tylo": 	planets[0] = "tylo"; 	break;
				case "bop": 	planets[0] = "bop"; 	break;
				case "pol": 	planets[0] = "pol"; 	break;
				case "eeloo": 	planets[0] = "eeloo"; 	break;
				default: continue;
			}
			break;
		}
		return new RouteObject(routeID, planets, 0);
	}
	
	private static RouteObject altitudeHandler() {
		System.out.println("\nAltitude?");
		int altitude;
		while (true) {
			String tempString = sc.nextLine();
			try {
				altitude = Integer.parseInt(tempString);
			} catch (Exception e) {
				continue;
			}
			break;
		}
		String[] planets = new String[1];
		if (routeID % 6 == 3) {planets[0] = "kerbin";}
		else {planets[0] = "sun";}
		return new RouteObject(routeID, planets, altitude);
	}
	
	private static RouteObject tourHandler() {
		System.out.println("\nList target planets in order. Enter nothing to go finish.");
		String[] planets = new String[256];
		int i = 0;
		boolean looping = true;
		while (looping) {
			String tempString = sc.nextLine().toLowerCase();
			switch (tempString) {
				case "moho": 	planets[i] = "moho"; 	break;
				case "eve": 	planets[i] = "eve"; 	break;
				case "gilly": 	planets[i] = "gilly"; 	break;
				case "kerbin":	planets[i] = "kerbin";	break;
				case "mun": 	planets[i] = "mun"; 	break;
				case "minmus": 	planets[i] = "minmus"; 	break;
				case "duna": 	planets[i] = "duna"; 	break;
				case "ike": 	planets[i] = "ike"; 	break;
				case "dres": 	planets[i] = "dres"; 	break;
				case "jool": 	planets[i] = "jool"; 	break;
				case "laythe": 	planets[i] = "laythe"; 	break;
				case "vall": 	planets[i] = "vall"; 	break;
				case "tylo": 	planets[i] = "tylo"; 	break;
				case "bop": 	planets[i] = "bop"; 	break;
				case "pol": 	planets[i] = "pol"; 	break;
				case "eeloo": 	planets[i] = "eeloo"; 	break;
				case "":		looping = false;
				default: continue;
			}
			i++;
		}
		return new RouteObject(routeID, planets, 0);
	}
}

