package com.emp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.dao.DeptDAO;
import com.emp.dto.Dept;
import com.emp.dto.Employee;
import com.emp.utility.Connector;

public class DeptDAOImpl implements DeptDAO {
	private Connection con;

	public DeptDAOImpl() {
		this.con = Connector.requestConnection();
	}

	@Override
	public void addDept(Dept t) {
		String query = "INSERT INTO dept VALUES(?,?,?)";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, t.getDno());
			ps.setString(2, t.getDname());
			ps.setString(3, t.getLocation());
			ps.executeUpdate();

		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}

	}

	@Override
	public Dept findById(Integer dno) {

		Dept d = null;
		try {
			String query = "select * from dept where dno=?";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, dno);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Dept();
				d.setDno(rs.getInt("dno"));
				d.setDname(rs.getString("dname"));
				d.setLocation(rs.getString("location"));

			}

		} catch (SQLException e1) {
			
			e1.printStackTrace();

		}
		return d;
	}

	@Override
	public List<Dept> findAll() {
		List<Dept> dl = new ArrayList<>();

		Dept d = null;

		String query = "SELECT * FROM DEPT";
		try {
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Dept();
				d.setDname(rs.getString("dname"));
				d.setDno(rs.getInt("dno"));
				d.setLocation(rs.getString("location"));
				dl.add(d);
			}

		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		return dl;
	}

	@Override
	public void updateDept(Dept d) {
		String query = "UPDATE DEPT SET DNO=?, DNAME=?, LOCATION=? WHERE DNO=?";

		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, d.getDno());
			ps.setString(2, d.getDname());
			ps.setString(3, d.getLocation());
			ps.setInt(4, d.getDno());
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteDept(Dept d) {

		String query = "DELETE FROM Dept WHERE DNO=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, d.getDno());

			ps.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
}
