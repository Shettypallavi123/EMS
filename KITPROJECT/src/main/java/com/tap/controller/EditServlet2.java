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


@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int    id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int    salary = Integer.parseInt(request.getParameter("salary"));
        String department = request.getParameter("department");
       
       
        
        Employee e = new Employee(id, name, email, salary, department);
        EmployeeDaoImp EmpDao = new EmployeeDaoImp();

        int status = EmpDao.update(e);
        if (status > 0) {
        	 out.println("<h1>Successfully updated</h1>");
           response.sendRedirect("ViewServlet");
            
        } else {
            out.println("Sorry! unable to update record");
        }

        out.close();
    }

}

