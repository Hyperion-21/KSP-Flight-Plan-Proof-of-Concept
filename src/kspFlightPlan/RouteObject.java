package kspFlightPlan;

/**
 * Contains routeID, target planet(s), and altitude of route
 * @author Hyperion_21
 *
 */
public class RouteObject {

	private int routeID;
	private String[] planets;
	private int altitude;
	
	/**
	 * Contains routeID, target planet(s), and altitude of route
	 * @param routeID
	 * @param planets
	 * @param altitude
	 */
	public RouteObject(int routeID, String[] planets, int altitude) {
		this.routeID = routeID;
		this.planets = planets;
		this.altitude = altitude;
	}

	/**
	 * Get routeID
	 * @return routeID
	 */
	public int getRouteID() {
		return routeID;
	}
	
	/**
	 * Get planets
	 * @return planets
	 */
	public String[] getPlanets() {
		return planets;
	}
	
	/**
	 * Get altitude
	 * @return altitude
	 */
	public int getAltitude() {
		return altitude;
	}
}
