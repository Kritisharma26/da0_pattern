package com.emp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.dao.EmployeeDAO;
import com.emp.dto.Employee;
import com.emp.utility.Connector;

public class EmployeeDAOImpl implements EmployeeDAO {

	private Connection con;

	public EmployeeDAOImpl() {
		this.con = Connector.requestConnection();
	}

	@Override
	public void addEmployee(Employee e) {
		String query = "INSERT INTO EMPLOYEE VALUES(0,?,?,?,?,sysdate(),?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, e.getName());
			ps.setString(2, e.getJob());
			ps.setDouble(3, e.getSal());
			ps.setInt(4, e.getDno());
			ps.setString(5, e.getMail());
			ps.setString(6, e.getPassword());
			ps.executeUpdate();

		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}

	}

	@Override
	public Employee findById(Integer id) {
		Employee e = null;

		try {
			String query = "select * from employee where id=?";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e = new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setJob(rs.getString("job"));
				e.setSal(rs.getDouble("sal"));
				e.setDno(rs.getInt("dno"));
				e.setMail(rs.getString("mail"));
				e.setPassword(rs.getString("password"));

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}
		return e;

	}

	@Override
	public List<Employee> findAll() {

		List<Employee> li = new ArrayList<>();
		Employee e = null;
		String query = "SELECT * from EMPLOYEE";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e = new Employee();
				e.setMail(rs.getString("mail"));
				e.setPassword(rs.getString("password"));
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setJob(rs.getString("job"));
				e.setSal(rs.getDouble("sal"));
				e.setDno(rs.getInt("Dno"));
				li.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return li;
	}

	@Override
	public Employee findByMailAndPassword(String mail, String password) {
		Employee e = null;
		String query = "SELECT * FROM EMPLOYEE WHERE MAIL=? AND PASSWORD=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, mail);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				e = new Employee();
				e.setMail(rs.getString("mail"));
				e.setPassword(rs.getString("password"));
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setJob(rs.getString("job"));
				e.setSal(rs.getDouble("sal"));
				e.setDno(rs.getInt("Dno"));

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public void updateEmployee(Employee e) {

		String query = "UPDATE EMPLOYEE SET NAME=?, JOB=?, SAL=?, DNO=?, MAIL=?, PASSWORD=? WHERE ID=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, e.getName());
			ps.setString(2, e.getJob());
			ps.setDouble(3, e.getSal());
			ps.setInt(4, e.getDno());
			ps.setString(5, e.getMail());
			ps.setString(6, e.getPassword());
			ps.setInt(7, e.getId());

			ps.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void deleteEmployee(Employee e) {
		Employee e2 = null;
		String query = "DELETE FROM EMPLOYEE WHERE ID =?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, e.getId());
			ps.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

}
