package employeeregistration.client;

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

	public static void main(String[] args) {
		DepartmentService departmentService = new DepartmentServiceImpl();
		EmployeeRegistrationService employeeRegistrationService = new EmployeeRegistrationServiceImpl();
		// registerDepartment(departmentService);
		//getAllDepartment(departmentService);
		registerEmployee(employeeRegistrationService);
	}

	private static void registerDepartment(DepartmentService departmentService) {
		Department department = new Department();
		System.out.println("Enter department name");
		String departmentName = scanner.nextLine();
		department.setDepartmentName(departmentName);
		Department savedDepartment = departmentService.addDepartment(department);
		System.out.println("Department have been saved with ID " + savedDepartment.getDepartmentId());
	}

	private static void getAllDepartment(DepartmentService departmentService) {
		System.out.println(departmentService.getAllDepartment());
	}
	
	private static void registerEmployee(EmployeeRegistrationService employeeRegistrationService) {
		System.out.println("Enter the department you want to register in");
		String departmentName = scanner.nextLine();
		Department department = new Department();
		department.setDepartmentName(departmentName);
		System.out.println("Enter Employee Name");
		String employeeName = scanner.nextLine();
		Employee employee = new Employee();
		employee.setName(employeeName);
		employee.setDepartment(department);
		Employee savedEmployee = null;
		try {
			savedEmployee = employeeRegistrationService.register(employee);
		} catch (NoSuchDepartmentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Employee "+savedEmployee.getName()+" has been saved with ID : "+savedEmployee.getId());
	}

}
