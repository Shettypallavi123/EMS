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


@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException { 
         
           response.setContentType("text/html");  
           PrintWriter out=response.getWriter();  
           out.println("<!DOCTYPE html>");
           out.println("<html>");
           out.println("<head>");
           out.println("<title>Edit Employee</title>");
           out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"edit.css\">");
           out.println("<style>table { margin: 0 auto; } </style>");
           out.println("</head>");
           out.println("<body>");
           out.println("<h1 style='text-align:center;'>Update Employee</h1>");
           String sid=request.getParameter("id");  
           int id=Integer.parseInt(sid); 
           EmployeeDaoImp EmpDao = new EmployeeDaoImp();
             
           Employee e=EmpDao.getEmployeeById(id);  

           out.println("<div class=\"container\" style=\"margin: 68px 489px 22px 500px; border-radius: 15px; background-color: rgba(119, 119, 119, 0.305); border: 4px solid #00ffc6de;\">");
           out.println("<form action='EditServlet2' method='post' id=\"in\">"); 
           out.println("<input type=\"hidden\" name=\"id\" value="+e.getId()+" > <br>");  
           out.println("<label>NAME :</label><br>");
           out.println("<input type=\"text\" name=\"name\" id=\"na1\" value="+e.getName()+" placeholder=\"Enter your name\"><br><br>");
          
           out.println("<label>EMAIL :</label><br>");
           out.println("<input type=\"email\" name=\"email\" id=\"na3\" value="+e.getEmail()+" placeholder=\"Enter your Email\"><br><br>");
           out.println("<label>Salary:</label><br>");
           out.println("<input type=\"number\" name=\"salary\" value="+e.getSalary()+" id=\"na2\" placeholder=\"Enter your salary\"><br><br> ");
           out.println("<label>Department:</label><br>");
           out.println("<input type=\"text\" name=\"department\" id=\"na4\" value="+e.getDept()+" placeholder=\"Enter Department\"><br><br>");
           out.println("<button type=\"submit\" value=\"Save Employee\" id=\"sub\">Update</button>");
           out.println("</form>");  
           out.println("</div>");
           out.println("</body>");
           out.println("</html>");
           out.close();
    }
}
