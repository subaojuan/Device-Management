package cn.edu.xatu.Servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.xatu.Daoimpl.DeviceImpl;
import cn.edu.xatu.entity.Device;
import cn.edu.xatu.entity.PageBean;

@WebServlet("/FindAllWithPage1")
public class FindAllWithPage1 extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // int pagenumber =Integer.parseInt(request.getParameter("number"));
		  int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		  int pageSize = 5;
		  DeviceImpl dao = new DeviceImpl();
		  String sql = "select * from device where DeciveType = '路由器' ";
		 ArrayList<Device> list1 =  dao.queryDevice(sql);
		 int totalRecord = list1.size();
		  PageBean<Device> bean = new PageBean<Device>(pageNumber,pageSize,totalRecord);
		  int offset = bean.getStartindex();
		  List<Device> list =  dao.QueryDevice(offset, pageSize,"路由器");
		    for (int i = 0; i < list.size();i++) {
		    	
		  System.out.println(list.get(i).getDevicename()+list.get(i).getDeviceUser()+list.get(i).getLaboratory());
				
			}
		  
		  System.out.println("offerset:"+offset+"size:"+pageSize+"istshuju"+list);
		  bean.setList(list);
		  request.setAttribute("pageBean", bean);
		  request.getRequestDispatcher("/backend/luyou1.jsp").forward(request, response);
		  
	}

	

}
