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
		if(!checkIfVehicleExists(input.id) && checkValidation(input)){
			input.id = Id_count;
			Id_count++;
			vehicledb.add(input);
			return true;
		}
		return false;
	}

	private boolean checkIfVehicleExists(int id) {
		for(int i = 0; i < vehicledb.size(); i++){
			if(vehicledb.get(i).id == id)
				return true;
		}
		return false;
	}

	private boolean checkValidation(Vehicle input) {
				if(input.getMake()!=null && input.getModel()!=null 
					&& input.getYear() > 1949 && input.getYear() < 2051){
				return true;
			}
		return false;
	}
	
	public Vehicle findExistingVehicleRecord(int id){
		for(int i = 0; i < vehicledb.size(); i++){
			if(vehicledb.get(i).id == id){
				return vehicledb.get(i);
			}
		}
		return null;
	}
	
	public boolean updateVehicleDetails(Vehicle input){
				
		if(this.checkIfVehicleExists(input.id)){
					Vehicle record = this.findExistingVehicleRecord(input.id);
					record.setMake(input.make); 
					record.setModel(input.model);
					record.setYear(input.year);
					return true;
		}
		return false;
	}
	
	public boolean deleteVehicleDetails(int id){
		if(this.checkIfVehicleExists(id)){
			Vehicle record = this.findExistingVehicleRecord(id);
			return vehicledb.remove(record);
		}
		return false;
	}
	
}
