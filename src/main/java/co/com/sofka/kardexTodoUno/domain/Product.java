package co.com.sofka.kardexTodoUno.domain;

public class Product {
	private int id;
	private String detail;
	private int stock;
	
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", detail=" + detail + ", stock=" + stock + "]";
	}
	
	

}
