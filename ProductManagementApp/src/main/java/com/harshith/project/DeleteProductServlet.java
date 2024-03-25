package com.harshith.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int ProId = Integer.parseInt(request.getParameter("proId"));
		ProductDao dao = new ProductDao();
		int result = dao.deletebyId(ProId);
		
		if(result==1)
		{
			// To send the data to JSP 
			request.setAttribute("deleteResult", result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);	
		}
		
		else
		{
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.println("Data Deletion failed "+result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);
		}
	}


}
