package computerSpare;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class CustomerBookingServlet
 */
public class CustomerBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//save insert data to variable
		String date = request.getParameter("date");
		String destination = request.getParameter("destination");
		String requests = request.getParameter("requests");
		
		
		//catch output value from return value from dbutil
				boolean isTrue;
				
				iCustomerDButil inter = new CustomerDBUtil();
				
				isTrue = inter.insertbooking(date, destination, requests);
				
				if(isTrue == true) {
					RequestDispatcher dis = request.getRequestDispatcher("frontmain.jsp");
					dis.forward(request, response);
				} else {
					RequestDispatcher dis2 = request.getRequestDispatcher("frontmain.jsp");
					dis2.forward(request, response);
				}

		


	}

}
