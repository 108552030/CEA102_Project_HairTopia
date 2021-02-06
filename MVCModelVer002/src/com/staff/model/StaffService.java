package com.staff.model;

import java.util.*;

public class StaffService {
	private StaffDAO_interface dao;
	
	public StaffService() {
		dao = new StaffDAO();
	}
	
	public StaffVO addStaff(String staaccnt, String stapswd) {
		StaffVO staffVO = new StaffVO();
		staffVO.setStaaccnt(staaccnt);
		staffVO.setStapswd(stapswd);
		dao.insert(staffVO);
		
		return staffVO;
	}
	
	public StaffVO updateStaff(Integer stano, String staaccnt, String stapswd) {
		
		StaffVO staffVO = new StaffVO();
		
		staffVO.setStaaccnt(staaccnt);
		staffVO.setStapswd(stapswd);
		dao.update(staffVO);
		
		return staffVO;
	}
	
	public void deleteStaff(Integer stano) {
		dao.delete(stano);
	}
	
	public StaffVO getOneEmp(Integer stano) {
		return dao.findByPrimaryKey(stano);
	}
	
	public List<StaffVO> getAll() {
		return dao.getAll();
	}
	
}
