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
 * Servlet implementation class UpdateBookingServlet
 */
public class UpdateBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idbooking = request.getParameter("idbooking");
		String date = request.getParameter("date");
		String destination = request.getParameter("destination");
		String requests = request.getParameter("requests");

		boolean isTrue;
		
		iCustomerDButil inter = new CustomerDBUtil();
		
		isTrue = inter.updatebooking(idbooking, date, destination, requests);
        
		if(isTrue == true)
		{
			//what data get to account page
			List<Booking> bookDetails = inter.getBookingDetails(idbooking);
			request.setAttribute("bookDetails", bookDetails);
			RequestDispatcher dis = request.getRequestDispatcher("BookingView.jsp");
		    dis.forward(request, response);
	    } 
	}

}
