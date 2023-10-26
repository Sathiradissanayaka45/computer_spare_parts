package computerSpare;

import jakarta.servlet.ServletException;  
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class CustomersServlet
 */
public class CustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		//save insert data to variable
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String username = request.getParameter("uid");
		String password = request.getParameter("psw");
		
		
		
		//catch output value from return value from dbutil
		boolean isTrue;
		
		iCustomerDButil inter = new CustomerDBUtil();
		
		isTrue = inter.insertcustomer(name, phone, email, username, password);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("index.html");
			dis2.forward(request, response);
		}

}

}
