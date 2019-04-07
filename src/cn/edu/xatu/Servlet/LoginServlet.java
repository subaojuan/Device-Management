package cn.edu.xatu.Servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.edu.xatu.Util.DButil;
@WebServlet(name = "LoginServlet", urlPatterns = "/servlet/login")
public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 取出表单数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checknumber = request.getParameter("chknumber");
		
		String check = request.getParameter("check");
	
		// 取出服务器端的验证码
		String checkcode = (String) request.getSession().getAttribute(
				DButil.CHECK_CODE);

		// 首先校验验证码，然后是用户名
		if (checkcode.equals(checknumber)) {
			String sql = "select * from user1 where username = ?";
//			获得数据库连接
			Connection conn = DButil.getConnection();
			
			PreparedStatement prst = null;
			ResultSet rs = null;
			
			try {
				prst = conn.prepareStatement(sql);
				
				prst.setString(1, username);
//				执行语句
				rs = prst.executeQuery();
//				 判断是否存在该用户
				if (rs.next()) {
//					存在该用户，则验证密码是否正确
					String p = rs.getString("password");
					if (p.equals(password)) {
// 				登录成功，把用户名保存成令牌
						request.getSession().setAttribute(DButil.CURRENT_USER,
								username);
//				跳转到后台页面
						if("admin".equals(check)) {
							//response.sendRedirect("");
						  request.getRequestDispatcher("../backend/frame.jsp")
								.forward(request, response);
						}else {
							
							request.getRequestDispatcher("../backend/frame1.jsp").forward(request, response);;
							
						}
						
					} else {
//					提示信息
						request.setAttribute(DButil.ERROR_MESSAGE, "密码不正确！");
					}
				} else {
					request.setAttribute(DButil.ERROR_MESSAGE, "请先注册信息在登录");
					request.getRequestDispatcher("/backend/login.jsp").forward(request, response);
					request.setAttribute(DButil.ERROR_MESSAGE, username + "用户不存在！");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
//			关闭结果集，描述语句，连接
			DButil.close(conn, prst, rs);
			
		}else{
			request.setAttribute(DButil.ERROR_MESSAGE, "校验码不正确！");
		}
		request.getRequestDispatcher("/backend/login.jsp").forward(
				request, response);
	}

}
