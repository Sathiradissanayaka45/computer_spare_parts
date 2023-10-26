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
 * Servlet implementation class DeleteCustomerServlet
 */
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ID = request.getParameter("cusid");
		boolean isTrue;
		
		iCustomerDButil inter = new CustomerDBUtil();
		
		isTrue = inter.deleteCustomer(ID);
        if(isTrue == true)
        {
        	//navigate to customer insert page
        	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        	dispatcher.forward(request, response);
        }
        else
        {
        	List<Customer> cusdetails = inter.getCustomerDetails(ID);
        	request.setAttribute("cusDetails", cusdetails);
        	
        	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        	dispatcher.forward(request, response);
        }
	}

}
