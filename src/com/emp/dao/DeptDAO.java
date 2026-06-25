package com.emp.dao;

import java.util.List;

import com.emp.dto.Dept;

public interface DeptDAO {
	void addDept(Dept t);
	Dept findById(Integer dno);
	List<Dept> findAll();
	void updateDept(Dept d);
	void deleteDept(Dept d);
	

}
