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

/**
 * Servlet implementation class UpdateDevice
 */
@WebServlet("/UpdateComputerServlet")
public class UpdateComputerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String  number = request.getParameter("devicenumber");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String leader = request.getParameter("leader");
		String lab = request.getParameter("lab");
		Integer isuse =Integer.parseInt(request.getParameter("isuse").trim());
		Device  device = new Device(number,name,category,leader,lab,isuse);
		
		  DeviceImpl dao = new DeviceImpl();
		  dao.UpdateDevice(device);
		  
		  
		  response.sendRedirect("./QueryServletComputer?pageNumber=1");
		  
		doGet(request, response);
	}

}
