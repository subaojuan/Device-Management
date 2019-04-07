package cn.edu.xatu.entity;
public class Device {
    private String number;//设备编号
	private String deviceUser; //设备领用人
    private String laboratory;//设备实验室
    private int isUse;//是否在使用
    private String devicename;//设备名称
    private String type; //设备类别
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Device(String devicenumber, String name, String category, String deviceUser2, String lab, int isuse2) {
		this.number = devicenumber;
		this.devicename = name;
		this.type = category;
		this.deviceUser=deviceUser2;
		this.laboratory = lab;
		this.isUse = isuse2;
	}
	public Device() {
		
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDeviceUser() {
		return deviceUser;
	}
	public void setDeviceUser(String deviceUser) {
		this.deviceUser = deviceUser;
	}
	public String getLaboratory() {
		return laboratory;
	}
	public void setLaboratory(String laboratory) {
		this.laboratory = laboratory;
	}
	public int getIsUse() {
		return isUse;
	}
	public void setIsUse(int isUse) {
		this.isUse = isUse;
	}
	public String getDevicename() {
		return devicename;
	}
	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}
	
    
}
