package cn.edu.xatu.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.xatu.Util.DButil;
import cn.edu.xatu.entity.Device;

@WebServlet("/queryDetailServlet")
public class queryDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String number = request.getParameter("number");
		
		String sql = "select * from device where devicenumber = ?";
		
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		try {
			prst = conn.prepareStatement(sql);
			prst.setString(1, number);
			rs = prst.executeQuery();
			if(rs.next()){
				Device a = new Device();
				a.setNumber(rs.getString("devicenumber"));
				a.setDevicename((rs.getString("DeviceName")));
				a.setDeviceUser((rs.getString("deviceUser")));
				a.setLaboratory(rs.getString("laboratory"));
				String type = rs.getString("DeciveType");
				a.setType(type);
				a.setIsUse((rs.getInt("isUse")));
				request.setAttribute("device", a);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DButil.close(conn, prst, rs);
		
	
		{
			request.getRequestDispatcher("/backend/updateDevice.jsp").forward(request, response);
		}
		     
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
