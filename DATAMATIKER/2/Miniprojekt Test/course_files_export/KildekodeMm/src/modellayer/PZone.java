package modellayer;

public class PZone {
	
	// Id of actual parkingzone
	private int pZoneId;

	// Hard coded value
	public PZone() {
		this.pZoneId = 2;
	}
	
	// Dynamicallt set parkingzone
	public PZone(int pZoneIdent) {
		this.pZoneId = pZoneIdent;
	}	
	
	public int getpZoneId() {
		return pZoneId;
	}

	public void setpZoneId(int pZoneId) {
		this.pZoneId = pZoneId;
	}
	
}
