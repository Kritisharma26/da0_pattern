package com.emp.dao;

import java.util.List;

import com.emp.dto.Employee;

public interface EmployeeDAO {
	void addEmployee(Employee e);//create
	Employee findById (Integer id);//read
	List<Employee> findAll();//read
	Employee findByMailAndPassword(String mail,String password);//read
	void updateEmployee(Employee e);//update
	void deleteEmployee(Employee e);//delete
	

}
