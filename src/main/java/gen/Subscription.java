package gen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


/**
 * Servlet implementation class Subscription
 */
@WebServlet("/Subscription")
public class Subscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
   DataCollector datacol = new DataCollector();
   String hashkey="";
   
   
   String lastcombination = "";
   public static HashMap<String, Parameter> hashMapUssd = new HashMap<String, Parameter>();
   public static ConnectionManager connectionManager[] =  new ConnectionManager[1];
   
   
   public Subscription() {
	      
   }
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		PrintWriter out = response.getWriter();
		try {
			Parameter para = new Parameter();
			response.setContentType("text/xml");

			StringBuffer bf = new StringBuffer();
			String line = null;
			
			try
			{
				BufferedReader reader = request.getReader();
				while((line=reader.readLine()) != null)
				bf.append(line);
				System.out.println("line  "+line);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			System.out.println(bf.toString());
			JSONObject jsonObj = new JSONObject(bf.toString());
			String ani =jsonObj.get("msisdn").toString();
			String input = jsonObj.getString("keyword").toString();
			String dnis =jsonObj.get("shortcode").toString();
			
			synchronized (Subscription.class) {
				
				para.setAni(ani);  
				para.setInput(input);
				para.setDnis(dnis);
				para.setService("SC");
				para.setLinput(input);
				para.setOutput("NA");
				para.setType("USERENTRYLOGGING");
				
				datacol.addUserLogging(para, Loader.Conn);
				
				System.out.println("Message from user "+ani+" which is "+input+" from dnis "+dnis);
				 out.println("OK");
			}
		       
		}
		catch (Exception e) {
			
			e.printStackTrace();
			response.setStatus(500);
			out.print("Somethig Went Wrong ! ");
		}
		
	}

}
