package com.project.shipticket.shipdetails;

import java.util.ArrayList;

public interface ShipDetailDAO {

	public void addShip(ShipDetail s) throws Exception;//admin work

	public void updateShip(ShipDetail s) throws Exception;//admin work

	public void deleteShip(ShipDetail s) throws Exception;//admin work

	public  ArrayList<ShipDetail> getShip(ShipDetail s);//user work
	
	public  ArrayList<ShipDetail> Ship();//user work
	public void distinctShip(String s) throws Exception;// used for differentiate in classes in sql //user work

}
