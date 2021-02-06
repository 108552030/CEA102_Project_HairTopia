package com.member.model;

import java.util.List;
import java.util.Set;

import com.staff.model.StaffVO;

public interface MemDAO_interface {
	public void insert(MemVO memVO);
	public void update(MemVO memVO);
	public void delete(Integer memno);
    public MemVO findByPrimaryKey(Integer memno);
    public List<MemVO> getAll();
    public boolean validate(MemVO memVO);
}
