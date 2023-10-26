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
 * Servlet implementation class UpdateFeedbackServlet
 */
public class UpdateFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idbooking = request.getParameter("idbooking");
		String date = request.getParameter("date");
		String name = request.getParameter("name");
		String feedbacks = request.getParameter("feedbacks");

		boolean isTrue;
		
		iCustomerDButil inter = new CustomerDBUtil();
		
		isTrue = inter.updatefeedback(idbooking, date, name, feedbacks);
        
		if(isTrue == true)
		{
			//what data get to account page
			List<Feedback> feedbackDetails = inter.getfeedbackDetails(idbooking);
			request.setAttribute("feedbackDetails", feedbackDetails);
			RequestDispatcher dis = request.getRequestDispatcher("FeedbackView.jsp");
		    dis.forward(request, response);
	    } 
	}

}
