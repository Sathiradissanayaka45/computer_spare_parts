package computerSpare;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class UpdateCustomerServlet
 */
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("cusid");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		
		boolean isTrue;
		
		iCustomerDButil inter = new CustomerDBUtil();
		
		isTrue = inter.updatecustomer(id, name, email, phone, username, password);
        
		if(isTrue == true)
		{
			//what data get to account page
			List<Customer> cusDetails = inter.getCustomerDetails(id);
			request.setAttribute("cusDetails", cusDetails);
			RequestDispatcher dis = request.getRequestDispatcher("my-account.jsp");
		    dis.forward(request, response);
	    } else {
			List<Customer> cusDetails = inter.getCustomerDetails(id);
			request.setAttribute("cusDetails", cusDetails);
		    RequestDispatcher dis = request.getRequestDispatcher("my-account.jsp");
		    dis.forward(request, response);
	    }
	}

}
