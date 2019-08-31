package co.com.sofka.kardexTodoUno.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	
	@XmlElement(name = "_id")
	private String Id;
	private String Nit;
	private String Name;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getNit() {
		return Nit;
	}
	public void setNit(String nit) {
		Nit = nit;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	@Override
	public String toString() {
		return "User [Id=" + Id + ", Nit=" + Nit + ", Name=" + Name + "]";
	}
	
	
}
