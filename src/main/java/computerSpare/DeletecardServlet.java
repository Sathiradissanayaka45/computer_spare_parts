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
 * Servlet implementation class DeletecardServlet
 */
public class DeletecardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idcard = request.getParameter("idcard");
		boolean isTrue;
		
		iCustomerDButil inter = new CustomerDBUtil();

		isTrue = inter.deletecard(idcard);
        if(isTrue == true)
        {
        	//navigate to customer insert page
        	RequestDispatcher dispatcher = request.getRequestDispatcher("frontmain.jsp");
        	dispatcher.forward(request, response);
        }
        else{
        	List<Card> cardDetails = inter.getCardDetails(idcard);
        	request.setAttribute("cardDetails", cardDetails);
        	
        	RequestDispatcher dispatcher = request.getRequestDispatcher("dopay.jsp");
        	dispatcher.forward(request, response);
        }
	}

}
