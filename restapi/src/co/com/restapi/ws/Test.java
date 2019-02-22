package co.com.restapi.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.restapi.pojo.Pojo;

@Path("/test")
public class Test {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Pojo helloWorld(Pojo pojo) {
		return pojo;
	}
	
}
