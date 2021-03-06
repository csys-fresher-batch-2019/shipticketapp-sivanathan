package com.project.shipticket.journey;

import java.util.ArrayList;

import com.project.shipticket.util.DBException;

public interface JourneyDAO {
	public void addJourney(Journey a) throws DBException;//user work

	public void updateJourney(Journey a) throws DBException;//admin work

	public void deleteJourney(Journey a) throws DBException;//admin work

	public ArrayList<Journey> getJourney(int a) throws DBException;//user work
}
