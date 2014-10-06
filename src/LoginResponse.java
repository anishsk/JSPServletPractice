

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginResponse
 */
@WebServlet("/LoginResponse")
public class LoginResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginResponse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		returnResponse(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		returnResponse(request, response);
	}
	
	private void returnResponse(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String uname=request.getParameter("uname");
		String pass=request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		if(uname.equals(pass))
			out.println("Welcome " + uname);
		else
			out.println("Error!! Invalid Username and password");
	}
}
