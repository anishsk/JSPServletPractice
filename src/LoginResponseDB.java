

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginResponseDB
 */
@WebServlet("/LoginResponseDB")
public class LoginResponseDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// JDBC driver name and database URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost/servletDB";
    
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "anishkumar";
    // Database query and connection strings
    Statement stmt;
    String sql;
    ResultSet rs;
    Connection conn;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginResponseDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		loginUser(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		loginUser(request, response);
	}
	
	private void loginUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String uname=request.getParameter("uname");
		String pass=request.getParameter("password");
		
		try{
			
			//Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//open a connection
			 conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			//Execute SQL query
			stmt= conn.createStatement();
			sql = "SELECT pass from logincreden where uname='" + uname + "';";
	        rs = stmt.executeQuery(sql);
	        if(rs.isBeforeFirst()){
	        	while(rs.next()){
	        		if(rs.getString("pass").compareTo(pass)==0){
	        			request.setAttribute("uname", uname);
	        			request.getRequestDispatcher("/Successful").forward(request, response);
	        		}
	        		else
	        		{
	        			request.getRequestDispatcher("/FailedLogin").forward(request, response);
	        		}
	        	}
	        }else{
	        	request.getRequestDispatcher("/FailedLogin").forward(request, response);
	        }
		}
		catch(Exception e){
			PrintWriter out = response.getWriter();
			out.println(e);
		}
		finally{
	         //finally block used to close resources
	         try{
	            if(stmt!=null)
	               stmt.close();
	         }
	         catch(SQLException se2){
	         }// nothing we can do
	         try{
	            if(conn!=null)
	            conn.close();
	         }
	         catch(SQLException se){
	         }//end finally try
	      } //end try
	}

}
