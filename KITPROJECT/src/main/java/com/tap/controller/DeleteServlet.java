package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.Dao.EmployeeDaoImp;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException { 
		PrintWriter out=response.getWriter();  
		  String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid); 
	        EmployeeDaoImp EmpDao = new EmployeeDaoImp();
	       // EmpDao.delete(id);  s
	        int i = EmpDao.delete(id);
	        if(i>0)
	        {
	        out.print("<h1>Record deleted successfully!</h1>");
	        request.getRequestDispatcher("ViewServlet").include(request, response);; 
	        }
	        else{  
	            out.println("Sorry! unable to save record");  
	        } 
		
	}
}