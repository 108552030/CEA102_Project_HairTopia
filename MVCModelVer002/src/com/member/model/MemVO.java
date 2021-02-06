package com.member.model;


public class MemVO implements java.io.Serializable{
	private Integer memNo;
	private String 	memName;
	private Integer memGender;
	private Byte[] 	memPic;
	private String 	memInform;
	private String 	memEmail;
	private String 	memPswd;
	private String 	memPhone;
	private String 	memAddr;
	private Integer memBal;
	private Byte 	memStatus;
	private java.sql.Date memEnddate;
	
	public MemVO() {
		
	}
	public Integer getMemNo() {
		return memNo;
	}
	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public Integer getMemGender() {
		return memGender;
	}
	public void setMemGender(Integer memGender) {
		this.memGender = memGender;
	}
	public Byte[] getMemPic() {
		return memPic;
	}
	public void setMemPic(Byte[] memPic) {
		this.memPic = memPic;
	}
	public String getMemInform() {
		return memInform;
	}
	public void setMemInform(String memInform) {
		this.memInform = memInform;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemPswd() {
		return memPswd;
	}
	public void setMemPswd(String memPswd) {
		this.memPswd = memPswd;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemAddr() {
		return memAddr;
	}
	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}
	public Integer getMemBal() {
		return memBal;
	}
	public void setMemBal(Integer memBal) {
		this.memBal = memBal;
	}
	public Byte getMemStatus() {
		return memStatus;
	}
	public void setMemStatus(Byte memStatus) {
		this.memStatus = memStatus;
	}
	public java.sql.Date getMemEnddate() {
		return memEnddate;
	}
	public void setMemEnddate(java.sql.Date memEnddate) {
		this.memEnddate = memEnddate;
	}
	
	
}
