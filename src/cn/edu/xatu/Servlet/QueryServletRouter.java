package cn.edu.xatu.Servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.xatu.Daoimpl.DeviceImpl;
import cn.edu.xatu.entity.Device;

@WebServlet("/QueryServlet")
public class QueryServletRouter extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 request.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=utf-8");
		   DeviceImpl  dao = new DeviceImpl();
		  String sql = "select * from device where DeciveType = 'Â·ÓÉÆ÷'";
		  ArrayList<Device>  devices = dao.queryDevice(sql);
		  request.setAttribute("devices", devices);
		  request.getRequestDispatcher("/backend/luyou.jsp").forward(request, response);
		   
		  }
		
		  


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
