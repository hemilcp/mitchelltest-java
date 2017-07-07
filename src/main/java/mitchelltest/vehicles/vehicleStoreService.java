package mitchelltest.vehicles;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import DAO.VehicleStoreDB;
import models.Vehicle;

@Path("vehicles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class vehicleStoreService {

	VehicleStoreDB db = new VehicleStoreDB();
	
	@GET
	public List<Vehicle> getAllVehiclesList(){
		List<Vehicle> vlist =  db.getAllVehicleList();
	return vlist;
		//	return Response.ok(vlist).build();
	//return "Hello World!";
	}
	
	@POST
	public Response addNewVehicleDetails(Vehicle input){
		String result = "";
		if(db.addVehicleDetails(input)) result = "Vehicle details saved successfully!";
		else result = "A record with same details exists already!";
		
		return Response.ok(result).build();
	}
}
