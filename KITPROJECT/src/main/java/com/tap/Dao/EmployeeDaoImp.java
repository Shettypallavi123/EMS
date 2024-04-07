package com.tap.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tapmodles.Employee;


public class EmployeeDaoImp implements EmployeeDao



{
	private static Connection connection=null;
	private static PreparedStatement statement=null;
	private static Statement statement1=null;
	private static String INSERT_QUERY="insert into `employee` (id,name,email,department,salary)values(?,?,?,?,?)";
	private static String DELETE_QUERY="DELETE from `employee` where `id`=?";
	private static final String UPDATE_QUERY = "UPDATE employee SET name=?, email=?, department=?, salary=? WHERE id=?";
	private static String SELECT_QUERY="select * from employee where id=?";
	private static String SELECT_ALL_QUERY="select * from employee";
	
	
	
    public EmployeeDaoImp() {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcclass", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
	}

	int i=0;
	@Override
	public int save(Employee e) {
		try {
			
			
			PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
			statement.setInt(1, e.getId());
			statement.setString(2, e.getName());
			statement.setString(3, e.getEmail());
			statement.setString(4, e.getDept());
			statement.setInt(5, e.getSalary());
			
		    i = statement.executeUpdate();
		} 
		catch ( SQLException e1) 
		{
			
			e1.printStackTrace();
		}
		return i;
		
	}

	@Override
	public int delete(int id) {
		try {
		    statement = connection.prepareStatement(DELETE_QUERY);
			statement.setInt(1,id );
			return statement.executeUpdate();
			
			
	} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Employee e)
	{
		
		return delete(e.getId());
	}

	@Override
	public int update(Employee e)
	{
		try {
		   statement = connection.prepareStatement(UPDATE_QUERY);
		   statement.setString(1, e.getName());
           statement.setString(2, e.getEmail());
           statement.setString(3, e.getDept());
           statement.setInt(4, e.getSalary());
           statement.setInt(5, e.getId());
            return statement.executeUpdate();
		} catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		return 0;
	}

	@Override
	public Employee getEmployeeById(int id) {
		try {
			statement = connection.prepareStatement(SELECT_QUERY);
			 statement.setInt(1, id);
			ResultSet res=statement.executeQuery();
			
			
			if(res.next())
			{
				int id1 = res.getInt("id");
				
				String name = res.getString("name");
				String email = res.getString("email");
				String dpt = res.getString("department");
				int salary = res.getInt("salary");
				Employee e=new Employee(id1,name,email,salary,dpt);
				return e;
				
			}	
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public List<Employee> getAllEmployees() {
	   ArrayList<Employee> list = new ArrayList<Employee>();
		try {
			 statement1 = connection.createStatement();
			ResultSet res=statement1.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next())
			{
				int id = res.getInt("id");
				String name = res.getString("name");
				String email = res.getString("email");
				String dpt = res.getString("department");
				int salary = res.getInt("salary");
				Employee e=new Employee(id,name,email,salary,dpt);
				list.add(e);
				
			}	
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	

}
