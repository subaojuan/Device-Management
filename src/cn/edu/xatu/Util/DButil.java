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
	          //驱动程序名
	         static String driver = "com.mysql.jdbc.Driver";
	          //URL指向要访问的数据库名mydata
	       static   String url = "jdbc:mysql://localhost:3306/test_1";
	          //MySQL配置时的用户名
	          static String user = "root";
	         //MySQL配置时的密码
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
