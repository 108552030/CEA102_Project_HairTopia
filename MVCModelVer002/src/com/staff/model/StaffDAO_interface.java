package com.staff.model;

import java.util.List;
import java.util.Set;

import com.staff.model.StaffVO;

public interface StaffDAO_interface {
	public void insert(StaffVO staffVO);
	public void update(StaffVO staffVO);
	public void delete(Integer staffno);
    public StaffVO findByPrimaryKey(Integer staffno);
    public List<StaffVO> getAll();
}
