
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;


 // Servlet implementation class addtestservlet
 
@WebServlet("/addtestservlet")
public class addtestservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    // @see HttpServlet#HttpServlet()
    
    public addtestservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	//  @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	// @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
        PrintWriter out = response.getWriter();
		
		try {
			
			Random rand = new Random();
			int random = rand.nextInt((999999 - 100000) + 1) + 100000;
            String CusID = "C"+random;

			String fullName = request.getParameter("fullname");
			String Initials = request.getParameter("nameWithInitials");
			String NIC = request.getParameter("NICno");
            String Address = request.getParameter("address");
            String City = request.getParameter("city");
            String Bday = request.getParameter("birthday");
            String Gender = request.getParameter("gender");
            String Contact = request.getParameter("contact");
            int Pcode = Integer.parseInt(requst.getParameter("pcode"));
            String Email = request.getParameter("email");
            String Password = request.getParameter("password");
			
			Date dateNow = new Date( );
         	SimpleDateFormat frmt = new SimpleDateFormat ("dd.MM.yyyy");
         	String CreateDate = frmt.format(dateNow);

			int randomACC = rand.nextInt((999999999 - 100000000) + 1) + 100000000;
            int AccNo = randomACC;
		
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank_app","root","");
			Statement st = conn.createStatement();
			
            String sql = "INSERT INTO customer VALUES ('"+CusID+"', '"+fullName+"', '"+Initials+"', '"+NIC+"', '"+Address+"','"+City+"', '"+Pcode+"','"+Bday+"', '"+Gender+"', '"+Contact+"', '"+Email+"', '"+Password+"', '"+CreateDate+"', '"+AccNo+"')";
					
			st.executeUpdate(sql);
			out.println("Servlet file working and added some data to database");
			
			}catch(Exception e) {
			out.print(e.getMessage());
		
		}
		
	}

}
