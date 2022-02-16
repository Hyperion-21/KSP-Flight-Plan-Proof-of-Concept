package kspFlightPlan;

public class RouteObject {

	private int routeID;
	private String[] planets;
	private int altitude;
	
	public RouteObject(int routeID, String[] planets, int altitude) {
		this.routeID = routeID;
		this.planets = planets;
		this.altitude = altitude;
	}

	public int getRouteID() {
		return routeID;
	}
	
	public String[] getPlanets() {
		return planets;
	}
	
	public int getAltitude() {
		return altitude;
	}
}
