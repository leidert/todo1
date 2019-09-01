package co.com.sofka.kardexTodoUno.domain;

import java.util.List;


public interface Repository   {
	
	public  List<User> findAll();
	
	public void CreateUser (User user);
	
	public void updateUser (String id, User user);
	
	public User findByIdUser(String id);
	
	public List<Product> getAllproduct();
	
	public void createProduct(Product product);
	
	public void updateProduct (String id, Product product);
	
	public Product findByIdProduct(String id);
	
	public List<kardex> getAllKardex();
	
	
	
}
