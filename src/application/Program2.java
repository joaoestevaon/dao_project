package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== Test 1: department findById ===");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		
		System.out.println("\n=== Test 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("\n=== Test 3: department insert ===");
		Department newDepartment = new Department(null, "Items");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Department = " + newDepartment.getName());
		
		System.out.println("\n=== Test 4: department update ===");
		dep = departmentDao.findById(2);
		dep.setName("Medicine");
		departmentDao.update(dep);
		System.out.println("Update completed");
		
		System.out.println("\n=== Test 5: department delete ===");
		System.out.print("Enter id for delete test:" );
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		
		sc.close();
		
	}
}
