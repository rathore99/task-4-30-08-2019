package com.ssi.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageEmployee {
	private ArrayList<Employee> employeeList;
	private ArrayList<String> departmentList;
	private HashMap<String, ArrayList<Employee>> departmentWiseList;

	public ManageEmployee() {
		super();

		this.employeeList = new ArrayList<Employee>();
		this.departmentList = new ArrayList<String>();
		this.departmentWiseList = new HashMap<String, ArrayList<Employee>>();
	}
    /*
     * method to update records in hashmap
     * inserts new emp record in array list
     */
	public void updateDepartmentRecord(Employee employee) {
		String departmentName = employee.getDepartmentName();
		// to check key is present or not
		boolean keyFound = departmentWiseList.containsKey(departmentName);
		// if not present ..insert key in map
		if (!keyFound) {
			departmentWiseList.put(departmentName, new ArrayList<>());
		}
		// if key is present ..then add new record
		departmentWiseList.get(departmentName).add(employee);
	}
  /*
   * method to show list of employees department wise 
   */
	public void showEmployeeDeparment(String departmentName) {
		ArrayList<Employee> list = departmentWiseList.get(departmentName); 
		System.out.println("Employees of  " + departmentName + " are: ");
		for (Employee employee : list) {
			System.out.println("\t" + employee.getEmployeeName() + "( " + employee.getEmployeeNo() + ")");
		}
	}

	/*
	 * method to add new department
	 */
	public void addDepartment(String departmentName) {
		boolean departmentFound = this.searchDepartment(departmentName);
		// if department name not found
		// then add it to departmentlist
		if (!departmentFound) {

			departmentList.add(departmentName);
		}
	}
    /*
     * method to serach department name
     */
	public boolean searchDepartment(String departmentName) {
		return departmentList.contains(departmentName);
	}

	public void addEmployee(Scanner sc) throws InputMismatchException {
		// to add new employee
		// Scanner sc = new Scanner(System.in);
		System.out.println("Enter the following values ");
		System.out.println("Employee No: ");
		int employeeNo = sc.nextInt();
		System.out.println("Employee Name:");
		String employeeName = sc.next();
		System.out.println("Salary:  ");
		double salary = sc.nextDouble();
		System.out.println("Designation :");
		String designation = sc.next();
		System.out.println("Department Name");
		String departmentName = sc.next();
		// sc.close();
		Employee newEmp = new Employee(employeeNo, employeeName, salary, designation, departmentName);
		employeeList.add(newEmp);
		this.showEmployeeDetails(newEmp);
		this.updateDepartmentRecord(newEmp);
	}

	public void showEmployeeList() {
		System.out.println("List of Employee is:");
		for (Employee employee : employeeList) {
			System.out.println(employee.getEmployeeName());
		}
	}

	public void showEmployeeDetails(Employee employee) {
		System.out.println("#------------------------------------------------------------#");
		System.out.println("Employee Details");
		System.out.println("#------------------------------------------------------------#");
		System.out.println("Employee No: " + employee.getEmployeeNo());
		System.out.println("Employee Name: " + employee.getEmployeeName());
		System.out.println("Salary: " + employee.getSalary());
		System.out.println("Designation: " + employee.getDesignation());
		System.out.println("Department: " + employee.getDepartmentName());
		System.out.println("#------------------------------------------------------------#");
	}

	public void removeEmployee(int employeeNo) {
		Employee employee = this.searchEmployee(employeeNo);

		if (employee == null) {
			System.out.println("No record found");
			return;
		}
		employeeList.remove(employee);
		System.out.println("Deleted employee record is :");
		this.showEmployeeDetails(employee);

	}

	public void deleteRecord() {
		employeeList.clear();
	}

	public void changeSalary(int employeeNo, double newSalary) {
		Employee employee = this.searchEmployee(employeeNo);
		if (employee == null) {
			System.out.println("No record found");
			return;
		}
		employee.setSalary(newSalary);
		System.out.println("Employee details with updated salary");
		this.showEmployeeDetails(employee);
	}

	public Employee searchEmployee(int employeeNo) {
		boolean employeeFound = false;
		for (Employee employee : employeeList) {
			if (employeeNo == employee.getEmployeeNo() && !employeeFound) {
				return employee;
				// employeeFound = true;
			}

		}
		if (!employeeFound) {
			System.out.println("Employee record Not available");
			return null;
		}
		return null;
	}

	public void showdepartmentList() {
		System.out.println("List of Departments is:");
		for (String department : departmentList) {
			System.out.println(department);
		}

	}

}
