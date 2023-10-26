package computerSpare;

import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet implementation class CardinsertServlet
 */
public class CardinsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String card_number = request.getParameter("card_number");
		String cardholder_name = request.getParameter("cardholder_name");
		String CVC = request.getParameter("CVC");
		String expiry_date = request.getParameter("expiry_date");
		
		
		//catch output value from return value from dbutil
				boolean isTrue;
				
				iCustomerDButil inter = new CustomerDBUtil();
				
				isTrue = inter.insertcard(card_number, cardholder_name, CVC, expiry_date);
				
				if(isTrue == true) {
					RequestDispatcher dis = request.getRequestDispatcher("frontmain.jsp");
					dis.forward(request, response);
				} else {
					RequestDispatcher dis2 = request.getRequestDispatcher("#");
					dis2.forward(request, response);
				}
	}

}
