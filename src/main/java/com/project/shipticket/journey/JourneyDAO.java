package com.project.shipticket.journey;

import java.time.LocalDate;
import java.util.ArrayList;

public interface JourneyDAO {
	public void addJourney(Journey a) throws Exception;//user work

	public void updateJourney(Journey a) throws Exception;//admin work

	public void deleteJourney(Journey a) throws Exception;//admin work

	public ArrayList<Journey> getJourney(int a) throws Exception;//user work
}
