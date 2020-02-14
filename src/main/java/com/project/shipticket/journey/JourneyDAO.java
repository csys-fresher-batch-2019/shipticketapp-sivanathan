package com.project.shipticket.journey;

import java.time.LocalDate;

public interface JourneyDAO {
	public void addJourney(Journey a) throws Exception;//user work

	public void updateJourney(Journey a) throws Exception;//admin work

	public void deleteJourney(Journey a) throws Exception;//admin work

	public void getJourney(LocalDate date, LocalDate date1) throws Exception;//user work
}
