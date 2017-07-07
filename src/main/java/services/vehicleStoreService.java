package services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import DAO.VehicleStoreDB;
import models.vehicle;

@Path("vehicles")
public class vehicleStoreService {

	VehicleStoreDB db = new VehicleStoreDB();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<vehicle> getAllVehiclesList(){
		return db.getAllVehicleList();
	}
}
