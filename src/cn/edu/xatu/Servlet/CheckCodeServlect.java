package cn.edu.xatu.Servlet;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@WebServlet(name="CheckCodeServlect", urlPatterns="/CheckCodeServlet",initParams={
		@WebInitParam(name="Width",value = "60"),
		@WebInitParam(name="Height",value = "20"),
		@WebInitParam(name="number",value = "4"),
		@WebInitParam(name="code",value = "ABCDEFGHIGK0123456789LNSrgynh")
	
})

public class CheckCodeServlect extends HttpServlet {
	private int Width;
	private int Height;
	private int number;
	private String code;

	@Override
	public void init() throws ServletException {
		Width = Integer.parseInt(this.getInitParameter("Width"));
		Height = Integer.parseInt(this.getInitParameter("Height"));
		number = Integer.parseInt(this.getInitParameter("number"));
		code = this.getInitParameter("code");
		
		
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		BufferedImage img = new BufferedImage(60,20 ,BufferedImage.TYPE_INT_BGR);
		Graphics2D g = img.createGraphics();

		g.fillRect(0, 0, Width, Height);
		
		StringBuffer f = new StringBuffer();
		for(int i = 0;i < number ;i++){
	         char  c = code.charAt(RandomInt((code.length() - 1)));
	         String cod = String.valueOf(c);
	         Color cc = new Color(RandomInt(255), RandomInt(255), RandomInt(255));
	         g.setColor(cc);
	         g.drawString(cod, 5 + (i*14), 18);
	        
	         f.append(cod);
		}
		request.getSession().setAttribute("checkcode", f.toString());
		
		
		OutputStream  out = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(img);
		out.flush();
		out.close();
	}
   

	public   int RandomInt(int n){
		return (int) (Math.random()*n);
	}

}
