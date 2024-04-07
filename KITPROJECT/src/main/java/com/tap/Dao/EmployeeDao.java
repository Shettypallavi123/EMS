package com.tap.Dao;

import java.util.List;

import com.tapmodles.Employee;

public interface EmployeeDao {
	int save(Employee e);
	int delete(int id);
	int delete(Employee e);
	int update(Employee e);
	Employee getEmployeeById(int id);
	List<Employee> getAllEmployees();
	

}
