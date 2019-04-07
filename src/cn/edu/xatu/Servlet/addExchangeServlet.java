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

import cn.edu.xatu.Daoimpl.DeviceImpl;
import cn.edu.xatu.Util.DButil;
import cn.edu.xatu.entity.Device;

@WebServlet("/addExchangeServlet")
public class addExchangeServlet extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String devicenumber = request.getParameter("devicenumber");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String deviceUser = request.getParameter("leader");
		String lab = request.getParameter("lab");
		Integer isuse =Integer.parseInt( request.getParameter("isuse").trim());
	    Device  decvice = new Device(devicenumber,name,category,deviceUser,lab,isuse);
	    DeviceImpl dao   = new DeviceImpl();
	    int t = dao.AddDevice(decvice);
	    if(t>0) {
	      request.getRequestDispatcher("./QueryServletExchange?pageNumber=1").forward(request,response);
	    }
	    doGet(request, response);
		
	}
		
}


