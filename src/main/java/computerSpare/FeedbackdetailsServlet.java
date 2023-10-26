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
 * Servlet implementation class FeedbackdetailsServlet
 */
public class FeedbackdetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
		

			response.getWriter();
			response.setContentType("text/html");
			
			iCustomerDButil inter = new CustomerDBUtil();
			
			List<Feedback> feedbackDetails = inter.getfeedback(CustomerDBUtil.cusID);
			request.setAttribute("feedbackDetails", feedbackDetails);
			
			RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher("/FeedbackView.jsp");
			dispatcher1.forward(request, response);
			
		

}

}
