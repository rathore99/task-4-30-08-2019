package com.ssi.collection;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DashboardEmployee {
	/* Function to dsplaye menu. no parameter required no return type */
	public void showMenu() {
		System.out.println("#------------------------------------------------------------#");
		System.out.println("Employee Menu");
		System.out.println("#------------------------------------------------------------#");
		System.out.println("1. Add Employee");
		System.out.println("2. View All Employees");
		System.out.println("3. Remove Employee");
		System.out.println("4. Clear Employee Data");
		System.out.println("5. Change Salary");
		System.out.println("6. Search Employee");
		System.out.println("7. View Employee Departmentwise");
		System.out.println("8. Exit");

	}    

	/* function  to get user choice and accordingly perform the selected operation*/
	/* scanner object to take input
	 * ManageEmployee object to call methods to perform operation on employee data
	 * userChoice value given by user
	 * throws exception when user enter something wrong (string when expecting int value)
	 */
	public void performOperation(int userChoice, ManageEmployee obj, Scanner sc)throws InputMismatchException {
        int empno;
		switch (userChoice) {
		case 1:
			obj.addEmployee(sc);
			break;
		case 2:
			obj.showEmployeeList();
			break;
		case 3:
			System.out.println("enter employee no (numeric value expected)");
			 empno = sc.nextInt();
			obj.removeEmployee(empno);
			break;
		case 4:
			obj.deleteRecord();
			break;
		case 5:
			System.out.println("enter employee no(integer value)");
			 empno = sc.nextInt();
			 System.out.println("Enter new salary (numeric value )");
			 double salary = sc.nextDouble(); 
			obj.changeSalary(empno,salary);
			//obj.showEmployeeDetails(employee);
			break;
		case 6:
			System.out.println("enter employee no (numeric value)");
			 empno = sc.nextInt();
			Employee emp =obj.searchEmployee(empno);
			if(emp!=null)
			obj.showEmployeeDetails(emp);
			break;
		case 7:
			System.out.println("Enter department name");
			 String departmentName = sc.next();
			obj.showEmployeeDeparment(departmentName);
			break;
		case 8:
			System.out.println("---------------Thank you-------------");
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) {
		DashboardEmployee objAdmin = new DashboardEmployee();
		Scanner sc = new Scanner(System.in);
		int userChoice = 0;
		ManageEmployee obj = new ManageEmployee();
		while (true) {
			objAdmin.showMenu();
			System.out.println("select value from menu");
			try{
			userChoice = sc.nextInt();
			}
			//to handle inputmismatch exception
			catch(Exception e){
				System.out.println("Please enter the value specified in instructions.... exiting wrong value entered");
				userChoice=8;
			}
			objAdmin.performOperation(userChoice, obj, sc);
			if (userChoice == 8){
				sc.close();
				System.exit(0);
			}
		}
		

	}

}
