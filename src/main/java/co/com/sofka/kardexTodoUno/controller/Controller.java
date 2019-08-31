package co.com.sofka.kardexTodoUno.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.core.InjectParam;

import co.com.sofka.kardexTodoUno.domain.Product;
import co.com.sofka.kardexTodoUno.domain.User;
import co.com.sofka.kardexTodoUno.infrastructure.Service;

@Stateless
@Path("/kardex")
public class Controller {
	
	@InjectParam
	Service service;

	
	
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
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> GetUser() {
		return service.findAll();
	}
	@GET
	@Path("/product")
	@Consumes({MediaType.APPLICATION_JSON})
	public String GetProduct() {
		return service.getAllproduct();
	}
	
@GET
@Path("/kardex")
@Consumes({MediaType.APPLICATION_JSON})
public String GetKardex() {
	return service.getAllKardex();
}
	
	
	
}
