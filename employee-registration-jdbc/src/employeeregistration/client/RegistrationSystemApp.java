package employeeregistration.client;

import java.io.IOException;
import java.util.Scanner;

import employeeregistration.entity.Department;
import employeeregistration.entity.Employee;
import employeeregistration.exception.NoSuchDepartmentException;
import employeeregistration.exception.ServiceException;
import employeeregistration.service.DepartmentService;
import employeeregistration.service.EmployeeRegistrationService;
import employeeregistration.service.impl.DepartmentServiceImpl;
import employeeregistration.service.impl.EmployeeRegistrationServiceImpl;

public class RegistrationSystemApp {

	private static Scanner scanner = new Scanner(System.in);
	private static DepartmentService departmentService = new DepartmentServiceImpl();
	private static EmployeeRegistrationService employeeRegistrationService = new EmployeeRegistrationServiceImpl();

	public static void main(String[] args) throws IOException {
		char cont = 'n';
		do {
			System.out.println("Enter your choice :");
			System.out.println("1. ADD Department");
			System.out.println("2. Get All Department");
			System.out.println("3. Register Employee in particular department");
			System.out.println("4. Get Department Details by ID");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				registerDepartment();
				break;
			case 2:
				getAllDepartment();
				break;
			case 3:
				registerEmployee();
				break;
			case 4:
				getDepartmentById();
				break;

			default:
				System.out.println("Invalid choice! Please try again");
				break;
			}
			System.out.println("Do you want to continue (y/n)");
			cont = scanner.next().charAt(0);
			scanner.nextLine();
		} while (cont == 'y');
		registerDepartment();
		getAllDepartment();
		registerEmployee();
		getDepartmentById();
	}

	private static void registerDepartment() {
		Department department = new Department();
		System.out.println("Enter department name");
		String departmentName = scanner.nextLine();
		department.setDepartmentName(departmentName);
		try {
			departmentService.addDepartment(department);
		} catch (ServiceException e) {
			System.out.println("Error while adding department " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Added Department : ");
		System.out.println("Department ID :: " + department.getDepartmentId());
		System.out.println("Department Name :: " + department.getDepartmentName());
	}

	private static void getAllDepartment() throws IOException {
		try {
			System.out.println(departmentService.getAllDepartment());
		} catch (ServiceException e) {
			System.out.println("Error while getting departments " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void registerEmployee() {
		System.out.println("Enter the department you want to register in");
		String departmentName = scanner.nextLine();
		Department department = new Department();
		department.setDepartmentName(departmentName);
		System.out.println("Enter Employee Name");
		String employeeName = scanner.nextLine();
		Employee employee = new Employee();
		employee.setName(employeeName);
		employee.setDepartment(department);
		try {
			employeeRegistrationService.register(employee);
		} catch (ServiceException e) {
			System.out.println("Error while adding employee " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Employee " + employee.getName() + " has been saved with ID : " + employee.getId());
	}

	public static void getDepartmentById() {
		System.out.println("Enter ID you want to search for");
		int departmentId = scanner.nextInt();
		Department department = null;
		try {
			department = departmentService.getDepartmentById(departmentId);
		} catch (ServiceException e) {
			System.out.println("Exception occured " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("The searched department detail is " + department);
	}

}
