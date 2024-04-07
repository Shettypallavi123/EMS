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
import com.tapmodles.Employee;



@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("    <title>Customer Details</title>");
        out.println("    <link rel=\"stylesheet\" href=\"table.css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("    <header>");
        out.println("        <pre><h1>                                           Employee Details</h1></pre>");
        out.println("        <a href=\"logout\"><button id=\"logoutBtn\" type=\\\"button\\\">LogOut</button></a>");
        out.println("    </header>");
        out.println("    <nav>");
        out.println("       <a href='index.html'> <button id=\"add\">Add New Employee</button></a>");
        out.println("    </nav>");
        EmployeeDaoImp empDao = new EmployeeDaoImp();
        List<Employee> list = empDao.getAllEmployees();

        out.println("<table>");
        out.println("<tr> <th> EMP ID</th> <th> NAME</th> <th>EMAIL</th> <th>Salary</th> <th>Department</th> <th>EDIT</th> <th>DELETE</th> </tr>");
        for (Employee e : list) {
            out.println("<tr>");
            out.println("<td>" + e.getId() + "</td>");
            out.println("<td>" + e.getName() + "</td>");
            out.println("<td>" + e.getEmail() + "</td>");
            out.println("<td>" + e.getSalary() + "</td>");
            out.println("<td>" + e.getDept() + "</td>");
            out.println("<td><a href='EditServlet?id=" + e.getId() + "'><button id=\"bt1\" type=\"button\">EDIT</button></a></td>");
            out.println("<td><a href='DeleteServlet?id=" + e.getId() + "'><button id=\"bt2\" type=\"button\">DELETE</button></a></td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</div>"); // Close content div

        out.println("</body></html>");
        out.close();

    }

}
