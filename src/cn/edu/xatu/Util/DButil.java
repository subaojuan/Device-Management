package cn.edu.xatu.Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DButil {
	public static String CHECK_CODE = "checkcode";
	public static String CURRENT_USER = "CURRENT_USER";
	public static String ERROR_MESSAGE = "ERROR_MESSAGE";
	 static Connection con;
	          //����������
	         static String driver = "com.mysql.jdbc.Driver";
	          //URLָ��Ҫ���ʵ����ݿ���mydata
	       static   String url = "jdbc:mysql://localhost:3306/test_1";
	          //MySQL����ʱ���û���
	          static String user = "root";
	         //MySQL����ʱ������
	         static  String password = "root";
	          public static Connection getConnection() {
	        	  try {
					Class.forName(driver);
					con = DriverManager.getConnection(url, user, password);
				} catch (Exception e) {
					e.printStackTrace();
				}
	        	  return con;
	          }
	          
	          
	          
	       public static void close(Connection conn,PreparedStatement state,ResultSet rest) {
	    	   if(conn!=null) {
	    		   
	    		     try {
						conn.close();
						if(state!=null) {
							state.close();
							if(rest!=null) {
								rest.close();
							}
						}
					} catch (Exception e) {
					
						e.printStackTrace();
					}
	    		   
	    	   }
	       }
	         
	       
	       public static void close(Connection conn,PreparedStatement state) {
	    	   if(conn!=null){
	    		   try {
					conn.close();
					if(state!=null) {
						state.close();
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
	    		   
	    	   }
	    	   
	       }
	       
	     

}
