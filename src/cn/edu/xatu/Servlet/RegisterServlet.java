package cn.edu.xatu.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.xatu.Util.DButil;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 取出表单数据
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
					String username = request.getParameter("name");
					String password = request.getParameter("password");
					String realname = request.getParameter("realname");
					String phone = request.getParameter("phone");
					String email = request.getParameter("email");
					String address = request.getParameter("address");
					String sql = "insert into user1(username,password,telephone,email,address) values(?,?,?,?,?)";
//					获得数据库连接
					Connection conn = DButil.getConnection();
					
					PreparedStatement prst = null;
					try {
						prst = conn.prepareStatement(sql);
						prst.setString(1, username);
						prst.setString(2, password);
						prst.setString(3, phone);
						prst.setString(4, email);
						prst.setString(5, address);
//						prst.setString(7, realname);
						int i = prst.executeUpdate();
						if(i>0) {
							request.setAttribute(DButil.ERROR_MESSAGE, "注册成功请登录");
							response.sendRedirect("/DeviceMangement/backend/login.jsp");
						
							
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
			
		
	}
			
	

}
