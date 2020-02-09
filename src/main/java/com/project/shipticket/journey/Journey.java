package com.project.shipticket.journey;

import java.time.LocalDate;

public class Journey {

	public int getJourneyId() {
		return journeyId;
	}

	public void setJourneyId(int journeyId) {
		this.journeyId = journeyId;
	}

	public LocalDate getSourceDate() {
		return sourceDate;
	}

	public void setSourceDate(LocalDate sourceDate) {
		this.sourceDate = sourceDate;
	}

	public LocalDate getDestinationDate() {
		return destinationDate;
	}

	public void setDestinationDate(LocalDate destinationDate) {
		this.destinationDate = destinationDate;
	}

	public int getShipId() {
		return shipId;
	}

	public void setShipId(int shipId) {
		this.shipId = shipId;
	}

	private int journeyId;
	private LocalDate sourceDate;
	private LocalDate destinationDate;
	private int shipId;

}
