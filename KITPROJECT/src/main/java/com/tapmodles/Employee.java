package com.tapmodles;

public class Employee {
	private int  id;
	private String name;
	private String email;
	private  int salary;
	private String dept;
	public Employee()
	{
		
	}

	public Employee(int id, String name, String email, int salary, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.dept = dept;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary + ", dept=" + dept
				+ "]";
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}



}
