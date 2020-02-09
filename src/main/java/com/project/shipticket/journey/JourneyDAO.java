package com.project.shipticket.journey;

import java.time.LocalDate;

public interface JourneyDAO {
	public void addJourney(Journey a) throws Exception;

	public void updateJourney(Journey a) throws Exception;

	public void deleteJourney(Journey a) throws Exception;

	public void getJourney(LocalDate date, LocalDate date1) throws Exception;
}
