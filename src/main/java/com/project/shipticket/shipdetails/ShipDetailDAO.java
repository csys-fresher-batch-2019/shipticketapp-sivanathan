package com.project.shipticket.shipdetails;

public interface ShipDetailDAO {

	public void addShip(ShipDetail s) throws Exception;//admin work

	public void updateShip(ShipDetail s) throws Exception;//admin work

	public void deleteShip(ShipDetail s) throws Exception;//admin work

	public void getShip(ShipDetail s) throws Exception;//user work

	public void distinctShip(String s) throws Exception;// used for differentiate in classes in sql //user work

}
