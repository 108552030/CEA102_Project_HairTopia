package com.staff.model;


public class StaffVO implements java.io.Serializable{
	private Integer stano;
	private String staaccnt;
	private String stapswd;
	
	public Integer getStano() {
		return stano;
	}

	public void setStano(Integer stano) {
		this.stano = stano;
	}

	public String getStaaccnt() {
		return staaccnt;
	}

	public void setStaaccnt(String staaccnt) {
		this.staaccnt = staaccnt;
	}

	public String getStapswd() {
		return stapswd;
	}

	public void setStapswd(String stapswd) {
		this.stapswd = stapswd;
	}

}
