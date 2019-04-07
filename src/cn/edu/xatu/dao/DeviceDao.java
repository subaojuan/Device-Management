package cn.edu.xatu.dao;
import java.util.ArrayList;
import cn.edu.xatu.entity.Device;
public interface DeviceDao {	
	//添加设备
	public int AddDevice(Device a);
	//删除设备
	public int DelDeviceById(String  id);
	//显示某一个具体的设备
	public Device FindDeviceByid(String id);
	//更新设备
	public void UpdateDevice(Device a);
	//查询所有的设备
	public ArrayList<Device>  QueryDevice(int startIndex, int pagSize,String type);
	public ArrayList<Device> queryDevice(String sql);
	
	

}
