package com.learning.devops.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
			String userName = request.getParameter("username");
			String userEmail = request.getParameter("useremail");
			String userPassword = request.getParameter("userpassword");
			

			UserDao userDao = new UserDao(ConnectionProvider.getConnection());
			System.out.println(userDao.getUserByEmailandPassword(userEmail, userPassword));
			
			if(!userName.isEmpty() && !userEmail.isEmpty() && !userPassword.isEmpty()) {
				if(userDao.isUserExists(userEmail) ) {
					Message message = new Message("Account with this email already exists.", "Error", "error-message");
					
					HttpSession session = request.getSession();
					session.setAttribute("message", message);
					response.sendRedirect("signup_page.jsp");
				}else {
					System.out.println("user name : "+userName);
					System.out.println("user email : "+ userEmail);
					System.out.println("user password : "+ userPassword);
					if(userName != null && userEmail != null && userPassword != null) {
						userDao.saveUser(new User(userName, userEmail, userPassword));
						response.sendRedirect("login_page.jsp");
					}else {
						
						Message message = new Message("All fields are required.", "Error", "error-message");
						
						HttpSession session = request.getSession();
						session.setAttribute("message", message);
						response.sendRedirect("signup_page.jsp");
					}
					
					
				}
			}else {
				Message message = new Message("All fields are required.", "Error", "error-message");
				
				HttpSession session = request.getSession();
				session.setAttribute("message", message);
				response.sendRedirect("signup_page.jsp");
			}
			

			out.println("</body>");
			out.println("</html>");

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
