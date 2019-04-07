package cn.edu.xatu.Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import cn.edu.xatu.Util.DButil;
import cn.edu.xatu.dao.DeviceDao;
import cn.edu.xatu.entity.Device;
import cn.edu.xatu.entity.PageBean;

public class DeviceImpl implements DeviceDao {
	@Override
	public int AddDevice(Device a) {
		String sql = "insert into device(devicenumber,DeviceName,DeciveType,deviceUser,laboratory,isUse) values(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		int t = 0;
		try {
			conn = DButil.getConnection();
			prst = conn.prepareStatement(sql);
			prst.setString(1, a.getNumber());
			prst.setString(2, a.getDevicename());
			prst.setString(3, a.getType());
			prst.setString(4, a.getDeviceUser());
			prst.setString(5, a.getLaboratory());
			prst.setInt(6, a.getIsUse());
			
			 t = prst.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DButil.close(conn, prst);
		return t;
	}

	@Override
	public int DelDeviceById(String  id) {
		String sql = "delete from device where devicenumber = ?";
		
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		int t = 0;
		conn = DButil.getConnection();
		
		try {
			prst = conn.prepareStatement(sql);

			prst.setString(1, id);
			
			 t = prst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DButil.close(conn, prst);

		return t;
	}

	
	@Override
	public void UpdateDevice(Device a) {
		String sql ="update device set DeviceName = ?,DeciveType = ?,deviceUser = ?,laboratory = ?,isUse=? where devicenumber = ?";
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		conn = DButil.getConnection();
		try {
			prst = conn.prepareStatement(sql);
			prst.setString(1, a.getDevicename());
			prst.setString(2, a.getType());
			prst.setString(3, a.getDeviceUser());
			prst.setString(4, a.getLaboratory());
			prst.setInt(5, a.getIsUse());
			prst.setString(6, a.getNumber());
			int t = prst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
     @Override
	public ArrayList<Device> QueryDevice(int offset, int pageSize,String type) {
    	 
		String sql = "select *  from device where DeciveType = '"+type+"' order by iddevice   limit ?,?  ";
		
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		ArrayList<Device> devices = new ArrayList<Device>();
		
		conn = DButil.getConnection();
		try {
			prst = conn.prepareStatement(sql);
			prst.setInt(1, offset);
			prst.setInt(2, pageSize);
			rs = prst.executeQuery();
			
			while(rs.next()){
				Device a= new Device();
				  a.setNumber(rs.getString("devicenumber"));
				  a.setDevicename(rs.getString("DeviceName"));
				  a.setDeviceUser((rs.getString("deviceUser")));
				  a.setLaboratory((rs.getString("laboratory")));
				  a.setIsUse(((rs.getInt("isuse"))));
				  a.setType((rs.getString("DeciveType")));
                 devices.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		   DButil.close(conn, prst, rs);
		   
		}
		return devices;
		 
		
		
	}

	@Override
	public ArrayList<Device> queryDevice(String sql) {
		Connection conn = null;
		PreparedStatement prst = null;
		ResultSet rs = null;
		
		ArrayList<Device> devices = new ArrayList<Device>();
		
		
		conn = DButil.getConnection();
		try {
			prst = conn.prepareStatement(sql);
			rs = prst.executeQuery();
			while(rs.next()){
				Device a = new Device();
				  a.setNumber(rs.getString("devicenumber"));
				  a.setDevicename(rs.getString("DeviceName"));
				  a.setDeviceUser((rs.getString("deviceUser")));
				  a.setLaboratory((rs.getString("laboratory")));
				  a.setIsUse(((rs.getInt("isuse"))));
				  a.setType((rs.getString("DeciveType")));
				  devices.add(a);
				  
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		   DButil.close(conn, prst, rs);
		   
		}
		return devices;
		
		
		
	}

	

	@Override
	public Device FindDeviceByid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
