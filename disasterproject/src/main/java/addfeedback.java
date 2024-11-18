

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addfeedback
 */
@WebServlet("/addfeedback")
public class addfeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public addfeedback() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");  // exception
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/disaster", "root", "jasjot1011");
		Statement statement=connection.createStatement(); // execute all query
		String name=request.getParameter("name");
		String phone_no=request.getParameter("phone_no");
		String address=request.getParameter("address");
		String feedback=request.getParameter("feedback");
		String insertQuery="insert into feedback(`name`,`phone_no`,`address`,`feedback`) values('"+name+"','"+phone_no+"','"+address+"','"+feedback+"')";
		int flag=0;
		flag=statement.executeUpdate(insertQuery);
		if(flag==1)
		{
			response.sendRedirect("thank.html");
		}
		else
		{
			response.sendRedirect("feedback.html");
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
