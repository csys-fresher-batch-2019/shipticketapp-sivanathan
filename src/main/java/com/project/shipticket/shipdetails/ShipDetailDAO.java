package com.project.shipticket.shipdetails;

public interface ShipDetailDAO {

	public void addShip(ShipDetail s);

	public void updateShip(ShipDetail s);

	public void deleteShip(ShipDetail s);

	public void getShip(ShipDetail s);

	public void distinctShip(ShipDetail s);// used for differentiate in classes in sql

}
