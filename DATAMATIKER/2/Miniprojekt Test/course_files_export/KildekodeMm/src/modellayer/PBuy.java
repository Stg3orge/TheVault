package modellayer;

import java.time.LocalDate;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik Bærbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class PBuy {

	// Buy ident
	private long id;
	// Time of buy
	private LocalDate buyTime;
	// Parkingtime in minutes
	private int parkingDuration;
	// Payed amount in cents
	private double payedCentAmount;
	// PayStation that generated buy 
	private PPayStation associatedPaystation;
	
	// Constructor
	public PBuy(int foundId) {
		id = foundId;
	}	
	public PBuy(LocalDate buyTime, int parkingDuration, double payedCentAmount) {
		this.buyTime = buyTime;
		this.parkingDuration = parkingDuration;
		this.payedCentAmount = payedCentAmount;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(LocalDate buyTime) {
		this.buyTime = buyTime;
	}

	public int getParkingDuration() {
		return parkingDuration;
	}

	public void setParkingDuration(int parkingDuration) {
		this.parkingDuration = parkingDuration;
	}

	public double getPayedCentAmount() {
		return payedCentAmount;
	}

	public void setPayedCentAmount(double payedCentAmount) {
		this.payedCentAmount = payedCentAmount;
	}

	public PPayStation getAssociatedPaystation() {
		return associatedPaystation;
	}

	public void setAssociatedPaystation(PPayStation associatedPaystation) {
		this.associatedPaystation = associatedPaystation;
	}
	
}
