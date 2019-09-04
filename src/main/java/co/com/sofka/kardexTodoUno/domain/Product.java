package co.com.sofka.kardexTodoUno.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
//@Document
public class Product {
	
	@Id
	private String id;
	private String detail;
	private String stock;
	private String price;
	
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getStok() {
		return stock;
	}
	public void setStok(String stock) {
		this.stock = stock;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", detail=" + detail + "]";
	}
	
	

}
