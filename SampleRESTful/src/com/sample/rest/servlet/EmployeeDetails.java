package com.sample.rest.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeDetails/*")
public class EmployeeDetails extends HttpServlet {
	Map<String,String> employee;
	private static final long serialVersionUID = 1L;

    public EmployeeDetails() {
    	employee = new HashMap<String, String>();
    	employee.put("101", "Abhishek");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In method : " + request.getMethod());
		String url = request.getRequestURI();
		String[] tokens = url.split("/");
		if(employee.containsKey(tokens[tokens.length -1])){
		String name = employee.get(tokens[tokens.length -1]);
		response.getWriter().println("Name of the employee read : " + name);
		}
		else{
			response.getWriter().println("Unable to read, Employee with this id does not exists");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In method : " + request.getMethod());
		String url = request.getRequestURI();
		String[] tokens = url.split("/");
		if(!employee.containsKey(tokens[tokens.length -2])){
			employee.put(tokens[tokens.length -2],tokens[tokens.length -1]);
			response.getWriter().println("Employee details added successfully Employee id : " + tokens[tokens.length -2] + " employee name : " + tokens[tokens.length -1]);
		}
		else{
			response.getWriter().println("Unable to create, Employee with this id already exists");
		}
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In method : " + request.getMethod());
		String url = request.getRequestURI();
		String[] tokens = url.split("/");
		if(employee.containsKey(tokens[tokens.length -2])){
			employee.put(tokens[tokens.length -2],tokens[tokens.length -1]);
			response.getWriter().println("Employee details updated successfully Employee id : " + tokens[tokens.length -2] + " employee name : " + tokens[tokens.length -1]);
		}
		else{
			response.getWriter().println("Unable to update, Employee with this id does not exists");
		}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In method : " + request.getMethod());
		System.out.println("In method : " + request.getMethod());
		String url = request.getRequestURI();
		String[] tokens = url.split("/");
		if(employee.containsKey(tokens[tokens.length -1])){
			employee.remove(tokens[tokens.length -1]);
			response.getWriter().println("Employee details deleted successfully Employee id : " + tokens[tokens.length -1]);
		}
		else{
			response.getWriter().println("Unable to delete, Employee with this id does not exists");
		}
	}

}
