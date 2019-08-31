package co.com.sofka.kardexTodoUno.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.sofka.kardexTodoUno.domain.Product;

@Path("/kardex")
public class Controller {
	
	@POST
	@Path("/saveproduct")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public String SaveProduct(Product p) {
		return "";
	}
	
	@POST
	@Path("/saveuser")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public String SaveUser(Product p) {
		return "";
	}
	
	@GET
	@Path("/user")
	@Consumes({MediaType.APPLICATION_JSON})
	public String GetUser() {
		return "Mostrando Usuario";
	}
	@GET
	@Path("/product")
	@Consumes({MediaType.APPLICATION_JSON})
	public String GetProduct() {
		return "Mostrando Usuario";
	}
	
	
	
}
