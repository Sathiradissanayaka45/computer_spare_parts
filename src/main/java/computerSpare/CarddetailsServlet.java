package computerSpare;

import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class CarddetailsServlet
 */
public class CarddetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		iCustomerDButil inter = new CustomerDBUtil();
		
		
		List<Card> cardDetails = inter.getCard(CustomerDBUtil.cusID);
		request.setAttribute("cardDetails", cardDetails);
		
		RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher("/dopay.jsp");
		dispatcher1.forward(request, response);
	}

}
