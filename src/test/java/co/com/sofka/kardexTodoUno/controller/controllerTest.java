package co.com.sofka.kardexTodoUno.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import co.com.sofka.kardexTodoUno.domain.Product;
import co.com.sofka.kardexTodoUno.domain.User;
import co.com.sofka.kardexTodoUno.domain.kardex;
import co.com.sofka.kardexTodoUno.infrastructure.Service;

public class controllerTest {
	
	List<kardex> kardexArray = new ArrayList<kardex>();
	List<User> userArray = new ArrayList<User>();
	List<Product> producsArray = new ArrayList<Product>();
	
	kardex kardex = new kardex();
	Service service = new Service();
	User user = new User();
	Product product = new Product();
	
	@Spy
	Service services;
	Controller controller;
	
	@Before
	public void Before() {
		
		service = Mockito.mock(Service.class);
		controller = new Controller(service);
		kardex.setId("1");
		kardex.setAmountOutput("10");
		kardex.setTotalOutput("40000");
		kardex.setInputAmount("30");
		kardex.setBalanceAmount("20");
		kardex.setTotalEntry("50000");
		kardex.setDetail("camisa");
		kardex.setValue("1000");
		kardex.setTotalBalance("40000");
		kardex.setDate("");
		
		kardexArray.add(kardex);
		
		user.setId("1");
		user.setName("leider");
		user.setNit("123");
		
		userArray.add(user);
		
		product.setId("1");
		product.setDetail("camisa");
		
		producsArray.add(product);
	}
	
	@Test
	public void GetKardexBringEverythingTest() {
		Mockito.when(service.getAllKardex()).thenReturn(kardexArray);
		assertEquals(kardexArray, controller.GetKardex());
		//Assert.assertEquals(kardexArray, services.getAllKardex());
	}
	
	@Test
	public void updactkardexCorrectUpdate() {
		Mockito.doNothing().when(service).updateKardex("camisa", this.kardex);
		Mockito.verify(controller).updateKardex("camisa", kardex);
	}
	
	@Test
	public void findByNameKardexTest() {
		Mockito.when(service.findByNameKardex("camisa")).thenReturn(kardex);
		assertEquals(kardex, controller.findByNameKardex("camisa"));
	}
	
	@Test
	public void findByIdUserTest() {
		Mockito.when(service.findByIdUser("1")).thenReturn(user);
		assertEquals(user, controller.findByIdUser("1"));
	}
	
	@Test
	public void GetUserTest() {
		Mockito.when(service.findAll()).thenReturn(userArray);
		assertEquals(userArray, controller.GetUser());
	}
	
	@Test
	public void findByIdProductTest() {
		Mockito.when(service.findByIdProduct("1")).thenReturn(product);
		assertEquals(product, controller.findByIdProduct("1"));
	}
	
	@Test
	public void GetProductTest() {
		Mockito.when(service.getAllproduct()).thenReturn(producsArray);
		assertEquals(producsArray, controller.GetProduct());
	}
	
}
