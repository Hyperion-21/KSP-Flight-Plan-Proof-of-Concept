package kspFlightPlan;

import java.util.HashMap;

public class MapMaker {

	/**
	 * Assigns dv values for each planet
	 * @param map
	 * @return HashMap, in format <planet, {elliptical orbit, low orbit, land}>
	 */
	public static HashMap<String, Integer[]> start(HashMap<String, Integer[]> map) {
		map.put("moho", 	new Integer[] {760, 2400, 870*2});
		map.put("eve", 		new Integer[] {90+80, 1300, 8000});
		map.put("gilly", 	new Integer[] {60, 410, 30*2});
		map.put("mun", 		new Integer[] {860, 280, 580*2});
		map.put("minmus", 	new Integer[] {930, 150, 180*2});
		map.put("duna", 	new Integer[] {130+250, 360, 1450});
		map.put("ike", 		new Integer[] {30, 150, 390*2});
		map.put("dres", 	new Integer[] {610, 1300, 430*2});
		map.put("jool", 	new Integer[] {980+160, 2780, null});
		map.put("laythe", 	new Integer[] {930, 890, 2900});
		map.put("vall", 	new Integer[] {620, 850, 860*2});
		map.put("tylo", 	new Integer[] {400, 1050, 2270*2});
		map.put("bop", 		new Integer[] {220, 890, 230*2});
		map.put("pol", 		new Integer[] {160, 810, 130*2});
		map.put("eeloo",	new Integer[] {1140, 1370, 620*2});
		return map;
	}
}
