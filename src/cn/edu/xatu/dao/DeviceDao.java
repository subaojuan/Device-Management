package cn.edu.xatu.dao;
import java.util.ArrayList;
import cn.edu.xatu.entity.Device;
public interface DeviceDao {	
	//����豸
	public int AddDevice(Device a);
	//ɾ���豸
	public int DelDeviceById(String  id);
	//��ʾĳһ��������豸
	public Device FindDeviceByid(String id);
	//�����豸
	public void UpdateDevice(Device a);
	//��ѯ���е��豸
	public ArrayList<Device>  QueryDevice(int startIndex, int pagSize,String type);
	public ArrayList<Device> queryDevice(String sql);
	
	

}
