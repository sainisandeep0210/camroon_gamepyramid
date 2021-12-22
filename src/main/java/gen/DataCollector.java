package gen;

import static gen.Configurator.getInstance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONObject;

//import gen.msg.HttpMethod;

public class DataCollector {
	//HttpMethod http = new HttpMethod();
	private static Configurator configurator = getInstance();
	Configurator conf = new  Configurator();
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public Parameter UpdateQuery(Parameter objparameter, Connection conn, String query) {
		try {
			System.out.println("Query --------- " + query);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.executeUpdate();
			objparameter.setQueryResponse("200");

		} catch (Exception e) {
			e.printStackTrace();
			objparameter.setQueryResponse("500");
		}
		return objparameter;
	}

	
	
	
	public void addUserLogging(Parameter para, Connection conn) {
		try {
			String query = configurator.getProperty("addLogging");
			query = query.replace("<ani>", para.getAni()).replace("<input>", para.getLinput())
					.replace("<output>", para.getOutput()).replace("<type>", para.getType())
					.replace("<service>", "SC");
			UpdateQuery(para, conn, query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


//	public  Parameter getActiveStatus(Parameter vmsObj, Connection conn) {
//		vmsObj.setStatus("");
//		try {
//			String check_status = configurator.getProperty("check_status");
//			check_status = check_status.replace("<ani>", vmsObj.getAni()).replace("<service_type>",
//					vmsObj.getService());
//			
//			ResultSet res = getResultSet(check_status, conn);
//			if (res.next()) {
//				if (res.getString("status").equalsIgnoreCase("active")) {
//					
//					vmsObj.setStatus("99");
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return vmsObj;
//		}
//		return vmsObj;
//	}

	
}
