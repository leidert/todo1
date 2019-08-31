package co.com.sofka.kardexTodoUno.domain;

public class User {
	private int Id;
	private int Nit;
	private String Name;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getNit() {
		return Nit;
	}
	public void setNit(int nit) {
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
