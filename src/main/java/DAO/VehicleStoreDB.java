package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import models.Vehicle;

public class VehicleStoreDB {

	static List<Vehicle> vehicledb = new ArrayList<>();
	static int Id_count = 1;
	
	public VehicleStoreDB(){
//		Vehicle v1 = new Vehicle(0,2010,"Tesla","Model S");
//		vehicledb.add(v1);
	}
	
	public List<Vehicle> getAllVehicleList(){
		return this.vehicledb;
	}
	
	public boolean addVehicleDetails(Vehicle input){
		if(!checkIfVehicleExists(input)){
			input.id = Id_count;
			Id_count++;
			vehicledb.add(input);
			return true;
		}
		return false;
	}

	private boolean checkIfVehicleExists(Vehicle input) {
		for(int i = 0; i < vehicledb.size(); i++){
			if(vehicledb.get(i).getMake() == input.getMake() && 
					vehicledb.get(i).getModel() == input.getModel()
					&& vehicledb.get(i).getYear() == input.getYear()){
				return true;
			}
					
		}
		return false;
	}
	
	
}
