package kspFlightPlan;

/**
 * Contains dv and role of each stage
 * @author Hyperion_21
 *
 */
public class DVarrayObject {

	private int dv;
	private int role;
	
	/**
	 * Contains dv and role of each stage
	 * @param dv
	 * @param role
	 */
	public DVarrayObject(int dv, int role) {
		this.dv = dv;
		this.role = role;
	}
	
	/**
	 * Gets dv
	 * @return dv
	 */
	public int getDV() {
		return dv;
	}
	
	/**
	 * Gets role
	 * @return role
	 */
	public int getRole() {
		return role;
	}
}
