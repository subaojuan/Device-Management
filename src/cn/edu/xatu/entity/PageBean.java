package cn.edu.xatu.entity;

import java.util.List;

public class PageBean<T> {
	private int pageNumber;//��ǰҳ��
	private int pageSize;//ÿҳ��ʾ��������
	private int totalRecord;//�ܼ�¼��
	private int totalPage;//��ҳ��
	private int startindex;
	private int start; //��ҳ��ʾ��ҳ�� �� 1,2,3,4,5
	private int end;//satrt = 1,end =5
	private List<T> list;//��ÿҳ��ʾ�����ݷŵ�list������
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartindex() {
		return startindex;
	}
	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public PageBean() {
		
	}
	public PageBean(int pageNumber,int pageSize,int totalRecord){
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		if(totalRecord%pageSize==0) {
			this.totalPage = totalRecord/pageSize;
		}else {
			this.totalPage = totalRecord/pageSize+1;
		}
		System.out.println("total:"+this.totalPage);
		this.startindex = (pageNumber-1)*pageSize;
		//this.start = 1;
		this.end = 5;
		if(totalPage<=5) {
			this.end =totalPage;
			this.start = 1;
		}else {
			
			if(pageNumber==2) {
				this.end = pageNumber+3;
				this.start=1;
				
			}else {
				this.end=pageNumber+2;
				this.start = pageNumber-2;	
			}
		
			//Ԥ��ǰ��Խ��
			if(this.start<0) {
				this.start = 1;
				this.end =5;
				 
			}
			if(this.end>totalPage) {
				this.end = totalPage;
				this.start  = end-5;
				
			}
			
		}
		
	}
	
	
	

}
