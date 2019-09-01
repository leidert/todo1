package co.com.sofka.kardexTodoUno.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.sun.jersey.api.core.InjectParam;

import co.com.sofka.kardexTodoUno.domain.Product;
import co.com.sofka.kardexTodoUno.domain.User;
import co.com.sofka.kardexTodoUno.domain.kardex;
import co.com.sofka.kardexTodoUno.infrastructure.Service;

@Stateless
@Path("/kardex")
public class Controller {
	
	@InjectParam
	Service service;

	@GET
	@Path("/product")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<Product> GetProduct() {
		return this.service.getAllproduct();
	}
	
	@GET
	@Path("/findidproduct/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Product findByIdProduct(@PathParam("id") String id) {
		return this.service.findByIdProduct(id);
	}
	
	@POST
	@Path("/saveproduct")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public void SaveProduct(Product product) {
		this.service.createProduct(product);
	}
	
	@PUT
    @Path("/updacteproduct/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
    public void updateProduct(@PathParam("id") String id, Product product) {
        this.service.updateProduct(id, product);
    }
	
	@POST
	@Path("/saveuser")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public void SaveUser(User user) {
		this.service.CreateUser(user);
	}
	
	@PUT
    @Path("/updacteuser/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
    public void updateAccount(@PathParam("id") String id, User user) {
        this.service.updateUser(id, user);
    }
	
	@GET
	@Path("/findiduser/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public User findByIdUser(@PathParam("id") String id) {
		return this.service.findByIdUser(id);
	}
	
	@GET
	@Path("/user")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> GetUser() {
		return this.service.findAll();
	}
	
	@GET
	@Path("/kardex")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public List<kardex> GetKardex() {
		return this.service.getAllKardex();
	}
}
