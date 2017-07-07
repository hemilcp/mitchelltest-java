package DAO;

import java.util.ArrayList;
import java.util.List;

import models.vehicle;

public class VehicleStoreDB {

	static List<vehicle> vehicledb = new ArrayList<>();
	
	public VehicleStoreDB(){
		
	}
	
	public List<vehicle> getAllVehicleList(){
		return this.vehicledb;
	}
}
