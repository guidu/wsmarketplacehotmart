package br.com.wsmarketplacehotmart.util;

public class Employee {
	private int id;
	private String firstName;
	private String LastName;
	public Employee(int id, String firstName, String LasrName) {
		this.id = id;
		this.firstName = firstName;
		this.LastName = LasrName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	

}
