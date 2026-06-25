package com.emp.test;

import com.emp.dto.Dept;
import com.emp.dao.*;
import com.emp.dto.Employee;
import com.emp.dao.impl.*;

import java.util.List;
import java.util.Scanner;

import com.emp.dao.EmployeeDAO;

public class Test {
	public static void main(String[] args) {
		Employee e = new Employee();
		EmployeeDAO edao = new EmployeeDAOImpl();
		Dept t = new Dept();
		DeptDAO tdao = new DeptDAOImpl();
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to employee Portal!!");
		System.out.println("enter mail and password");
		Employee emp = edao.findByMailAndPassword(sc.next(), sc.next());
		if (emp != null) {
			if (emp.getId() == 1) {

				System.out.println("welcome admin");
				System.out.println("enter choice ");
				System.out.println("1. add employee");
				System.out.println("2.view employee");
				System.out.println("3.delete employee");
				System.out.println("4.add dept");
				System.out.println("5.update dept");
				System.out.println("6.delete dept");
				System.out.println("7. view all dept");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("add an employee");
					System.out.println("enetr name");
					e.setName(sc.next());
					System.out.println("enetr job");
					e.setJob(sc.next());
					System.out.println("enetr sal");
					e.setSal(sc.nextDouble());
					System.out.println("enetr deptno.");
					e.setDno(sc.nextInt());
					System.out.println("enetr mail");
					e.setMail(sc.next());
					System.out.println("enetr pass");
					e.setPassword(sc.next());

					edao.addEmployee(e);
					break;

				case 2:
					System.out.println("view all employee");
					List<Employee> em = edao.findAll();
					for (Employee e1 : em) {
						System.out.println(e1);
					}
					break;

				case 3:
					System.out.println("delete emp by id");
					System.out.println("enter id you want to delete");

					e.setId(sc.nextInt());
					edao.deleteEmployee(e);

					break;

				case 4:
					System.out.println("add dept");
					System.out.println("enetr id");
					t.setDno(sc.nextInt());
					System.out.println("enetr dept name");
					t.setDname(sc.next());
					System.out.println("enetr location");
					t.setLocation(sc.next());

					tdao.addDept(t);

					break;

				case 5:
					System.out.println("update dept");
					List<Dept> dept = tdao.findAll();
					for (Dept d1 : dept) {
						System.out.println(d1);
					}
					System.out.println("Enter DNO of department to update:");
					int dno = sc.nextInt();
					Dept td = tdao.findById(dno);

					System.out.println("you have entered updated choose what you have to update");
					System.out.println("1.enter dno to be updated ");
					System.out.println("2.enter dname to be updated");
					System.out.println("3. enter location to be updated");

					int choose = sc.nextInt();
					switch (choose) {
					case 1:
						System.out.println("enter dno to be updated");
						td.setDno(sc.nextInt());
						break;
					case 2:
						System.out.println("enter dname to be updated");
						td.setDname(sc.next());
						break;
					case 3:
						System.out.println("enter location to be updated");
						td.setLocation(sc.next());
						break;
					}

					tdao.updateDept(td);
					System.out.println(td);
					break;

				case 6:
					System.out.println("view all dept");

					List<Dept> deptt = tdao.findAll();
					for (Dept d1 : deptt) {
						System.out.println(d1);
					}
					break;

				default:
					System.out.println("wronggggggggggggggg");

				}
			} else {
				System.out.println("welcome user");
				System.out.println("enter choice ");

				int choice = sc.nextInt();
				System.out.println("1.view profile");
				System.out.println("update any thing");
				switch (choice) {
				case 1:
					System.out.println("view profile");
					System.out.println(emp);
					break;
				case 2:
					System.out.println("update your profile");
					System.out.println("before update");
					System.out.println(emp);
					System.out.println("enter field to be updated");
					System.out.println("1. name");
					System.out.println("2. mail");
					System.out.println("3. pass");
					System.out.println("4. Dno");
					System.out.println("5. sal");
					System.out.println("6. job");
					Integer choicee = sc.nextInt();
					switch (choicee) {
					case 1:
						System.out.println("enter name");
						emp.setName(sc.next());
						break;

					case 2:
						System.out.println("enter mail");
						emp.setMail(sc.next());
						break;
					case 3:
						System.out.println("enter pass");
						emp.setPassword(sc.next());
						break;

					case 4:
					System.out.println("enter dno");
						emp.setDno(sc.nextInt());
						break;

					case 5:
						System.out.println("enter sal");
						emp.setSal(sc.nextDouble());
						break;
					case 6:
						System.out.println("enter job ");
						emp.setJob(sc.next());
						break;

					default:
						System.out.println("wrong input");

					}

					edao.updateEmployee(emp);
					System.out.println(emp);
					break;
				default:
					System.out.println("wromng ");

				}

			}
		}

//		System.out.println("enetr name");
//		e.setName(sc.next());
//		System.out.println("enetr job");
//		e.setJob(sc.next());
//		System.out.println("enetr sal");
//		e.setSal(sc.nextDouble());
//		System.out.println("enetr deptno.");
//		e.setDno(sc.nextInt());
//		System.out.println("enetr mail");
//		e.setMail(sc.next());
//		System.out.println("enetr pass");
//		e.setPassword(sc.next());
//		
//		edao.addEmployee(e);

//		System.out.println("enter id");
//	Employee emp= edao.findById(sc.nextInt());
//	System.out.println(emp);

		// System.out.println(emp);

//		
//		List<Employee> emp = edao.findAll();
//		for (Employee e1 : emp) {
//		    System.out.println(e1);
//		}

//		System.out.println("enter id you want to delete");
//		
//		e.setId(sc.nextInt());
//    edao.deleteEmployee(e);

		// for dept
//		System.out.println("enetr id");
//		t.setDno(sc.nextInt());
//		System.out.println("enetr dept name");
//		t.setDname(sc.next());
//		System.out.println("enetr location");
//		t.setLocation(sc.next());
//		
//		tdao.addDept(t);

//		System.out.println("enter did");
//	Dept d=tdao.findById(sc.nextInt());
//	
//	System.out.println(d);
//		

//		List<Dept> dept = tdao.findAll();
//	for (Dept d1 : dept) {
//		    System.out.println(d1);
//		}

//		System.out.println("enter did");
//	
//		t.setDno(sc.nextInt());
//		tdao.deleteDept(t);
//	

//		System.out.println("enter the emp id:");
//		Employee e = edao.findById(sc.nextInt());
//     System.out.println("before update");
//	 System.out.println(e);
//	 System.out.println("enter field to be updated");
//	 System.out.println("1. name");
//	 System.out.println("2. mail");
//	 System.out.println("3. pass");
//	 System.out.println("4. Dno");
//	 System.out.println("5. sal");
//	 System.out.println("6. job");
//	 Integer choice =sc.nextInt();
//	 switch(choice){
//		 case 1 : System.out.println("enter name");
//		 e.setName(sc.next());
//		 break;
//		 
//		 case 2 : System.out.println("enter mail");
//		 e.setMail(sc.next());
//		 break;
//		 case 3 : System.out.println("enter pass");
//		 e.setPassword(sc.next());
//		 break;
//		 
//		 case 4 : System.out.println("enter dno");
//		 e.setDno(sc.nextInt());
//		 break;
//		 
//		 case 5: System.out.println("enter sal");
//		 e.setSal(sc.nextDouble());
//		 break;
//		 case 6: System.out.println("enter job ");
//		 e.setJob(sc.next());
//		 break;
//		 
//		 
//		default:
//			System.out.println("wrong input");
//		 
//	 }
//	 
//	 edao.updateEmployee(e);
//	 System.out.println(e);
//	 

	}

}
