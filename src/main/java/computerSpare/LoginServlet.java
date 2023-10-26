package computerSpare;

import jakarta.servlet.ServletException ;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static boolean isTrue;
	private static String Uname;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		//catch insert data in login form
		String userName = request.getParameter("uid");
		String password = request.getParameter("pass");
		Uname = userName;
		
		iCustomerDButil inter = new CustomerDBUtil();
				
		isTrue = inter.validate(userName, password);
		
		if(isTrue == true)
		{
			
			//List<Customer> cusDetails = CustomerDBUtil.getCustomer(userName);
			//request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("frontmain.jsp");
			dis.forward(request, response);
			
			
		}else {
			//print in customer interface
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location='login.jsp'");
			out.println("</script>");
			
		}
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if(isTrue == true)
		{
			
			iCustomerDButil inter = new CustomerDBUtil();
			
			List<Customer> cusDetails = inter.getCustomer(Uname);
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/my-account.jsp");
			dispatcher.forward(request, response);
			
			
		}
	}

}
