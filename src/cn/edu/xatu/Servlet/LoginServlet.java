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
		// ȡ��������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checknumber = request.getParameter("chknumber");
		
		String check = request.getParameter("check");
	
		// ȡ���������˵���֤��
		String checkcode = (String) request.getSession().getAttribute(
				DButil.CHECK_CODE);

		// ����У����֤�룬Ȼ�����û���
		if (checkcode.equals(checknumber)) {
			String sql = "select * from user1 where username = ?";
//			������ݿ�����
			Connection conn = DButil.getConnection();
			
			PreparedStatement prst = null;
			ResultSet rs = null;
			
			try {
				prst = conn.prepareStatement(sql);
				
				prst.setString(1, username);
//				ִ�����
				rs = prst.executeQuery();
//				 �ж��Ƿ���ڸ��û�
				if (rs.next()) {
//					���ڸ��û�������֤�����Ƿ���ȷ
					String p = rs.getString("password");
					if (p.equals(password)) {
// 				��¼�ɹ������û������������
						request.getSession().setAttribute(DButil.CURRENT_USER,
								username);
//				��ת����̨ҳ��
						if("admin".equals(check)) {
							//response.sendRedirect("");
						  request.getRequestDispatcher("../backend/frame.jsp")
								.forward(request, response);
						}else {
							
							request.getRequestDispatcher("../backend/frame1.jsp").forward(request, response);;
							
						}
						
					} else {
//					��ʾ��Ϣ
						request.setAttribute(DButil.ERROR_MESSAGE, "���벻��ȷ��");
					}
				} else {
					request.setAttribute(DButil.ERROR_MESSAGE, "����ע����Ϣ�ڵ�¼");
					request.getRequestDispatcher("/backend/login.jsp").forward(request, response);
					request.setAttribute(DButil.ERROR_MESSAGE, username + "�û������ڣ�");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
//			�رս������������䣬����
			DButil.close(conn, prst, rs);
			
		}else{
			request.setAttribute(DButil.ERROR_MESSAGE, "У���벻��ȷ��");
		}
		request.getRequestDispatcher("/backend/login.jsp").forward(
				request, response);
	}

}
