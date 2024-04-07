package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.Dao.EmployeeDaoImp;
import com.tapmodles.Employee;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       PrintWriter out = response.getWriter();
    	int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        int salary = Integer.parseInt(request.getParameter("salary"));
        Employee e = new Employee(id, name, email, salary, department);
        EmployeeDaoImp dao = new EmployeeDaoImp();
        int i = dao.save(e);

        if (i > 0) {
        	 out.print("<h1>Record Inserted successfully!</h1>");
        	 
        	 request.getRequestDispatcher("ViewServlet").include(request, response); 
        } 
    }
}

