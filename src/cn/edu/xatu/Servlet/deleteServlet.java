package cn.edu.xatu.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.xatu.Daoimpl.DeviceImpl;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   DeviceImpl dao = new DeviceImpl();
		   String number = request.getParameter("number");
		   int t = dao.DelDeviceById(number);
		   if(t>0) {
			   request.getRequestDispatcher("./FindAllWithPage?pageNumber=1").forward(request, response);
		   }
		   
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
