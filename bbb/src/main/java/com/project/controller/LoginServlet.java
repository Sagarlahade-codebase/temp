package com.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.daoImplementation.UserImpl;
import com.project.daoInterface.UserInterface;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String uname=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(uname+"  "+password);
		
		HttpSession loginSession =request.getSession();
		UserInterface ui=new UserImpl();
		int i=ui.loginUser(uname, password);
		System.out.println("login user::"+i);
			if(i>0)
			{
				loginSession.setAttribute("userID", i);
				request.setAttribute("msg", "Login Successfull");
				request.getRequestDispatcher("loginThumb.jsp").forward(request, response);
				
			}else{
				
				request.setAttribute("msg", "Login Un..Successfull");
				request.setAttribute("message", "Login Un..Successfull");

				request.getRequestDispatcher("login.jsp").forward(request, response);
				
				
			}
		
		
	}

}
