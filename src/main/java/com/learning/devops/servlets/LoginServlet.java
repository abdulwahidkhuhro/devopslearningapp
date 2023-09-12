package com.learning.devops.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learning.devops.dao.UserDao;
import com.learning.devops.entities.Message;
import com.learning.devops.entities.User;
import com.learning.devops.helper.ConnectionProvider;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Title</title>");
			out.println("</head>");
			out.println("<body>");
			String userEmail = request.getParameter("useremail");
			String userPassword = request.getParameter("userpassword");

			UserDao userDao = new UserDao(ConnectionProvider.getConnection());
			User user = userDao.getUserByEmailandPassword(userEmail, userPassword);
			
			if(user == null) {
				Message message = new Message("Invalid Details ! try with another.", "Error", "error-message");
				
				HttpSession session = request.getSession();
				session.setAttribute("message", message);
				response.sendRedirect("login_page.jsp");
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("currentUser", user);
				response.sendRedirect("home_page.jsp");
			}

			out.println("</body>");
			out.println("</html>");

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
