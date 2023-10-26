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
 * Servlet implementation class DeleteBookingServlet
 */
public class DeleteBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idbooking = request.getParameter("idbooking");
		boolean isTrue;
		
		iCustomerDButil inter = new CustomerDBUtil();
		
		isTrue = inter.deleteBooking(idbooking);
        if(isTrue == true)
        {
        	//navigate to customer insert page
        	RequestDispatcher dispatcher = request.getRequestDispatcher("frontmain.jsp");
        	dispatcher.forward(request, response);
        }
        else{
        	List<Booking> bookDetails = inter.getBookingDetails(idbooking);
        	request.setAttribute("bookDetails", bookDetails);
        	
        	RequestDispatcher dispatcher = request.getRequestDispatcher("Booking.jsp");
        	dispatcher.forward(request, response);
        }
	}

}
