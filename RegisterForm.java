

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterForm
 */
@WebServlet("/RegisterForm")
public class RegisterForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html");
	
		PrintWriter out =  response.getWriter()	;
		 
		String gname = request.getParameter("gname");
		String p1 = request.getParameter("p1");
		String mobile = request.getParameter("mobile");
		String p2 = request.getParameter("p2");
		String p3 = request.getParameter("p2");
		String p4 = request.getParameter("p3");
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerform","root","shreyasrane");
			
			PreparedStatement ps= con.prepareStatement("insert into registerform values(?,?,?,?,?,?)");
			
			ps.setString(1, gname);
			ps.setString(2, p1);
			ps.setString(3, mobile);
			ps.setString(4, p2);
			ps.setString(5, p3);
			ps.setString(6, p4);
			int i = ps.executeUpdate();
			
			if(i>0) {
				out.print("<h1 style=\"text-align: center; margin-top: 25%;\">You are Successfully Registered !!!</h1>");
				
				
			}
			
			
			
		}catch(Exception e ) {
			
			System.out.println(e);
		}
		
		


	}

}
