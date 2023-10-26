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
 * Servlet implementation class UpdatecardServlet
 */
public class UpdatecardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idcard = request.getParameter("idcard");
		String CardNumber = request.getParameter("CardNumber");
		String CardHolderName = request.getParameter("CardHolderName");
		String CVC = request.getParameter("CVC");
		String ExpiredDate = request.getParameter("ExpiredDate");

		boolean isTrue;
		
		iCustomerDButil inter = new CustomerDBUtil();
		
		isTrue = inter.updatecard(idcard, CardNumber, CardHolderName, CVC, ExpiredDate);
        
		if(isTrue == true)
		{
			//what data get to account page
			List<Card> cardDetails = inter.getCardDetails(idcard);
			request.setAttribute("cardDetails", cardDetails);
			RequestDispatcher dis = request.getRequestDispatcher("dopay.jsp");
		    dis.forward(request, response);
	    } 
	}

}
