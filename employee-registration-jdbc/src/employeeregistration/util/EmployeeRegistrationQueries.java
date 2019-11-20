package employeeregistration.util;

public class EmployeeRegistrationQueries {
	
	private EmployeeRegistrationQueries() {
		
	}
	
	public static final String ADD_DEPARTMENT_QUERY = "insert into department(departmentName) values (?)";
	public static final String GET_ALL_DEPARTMENT_QUERY = "select * from department";
	public static final String GET_DEPARTMENT_BY_NAME_QUERY = "select * from department where departmentName = ?";
	public static final String ADD_EMPLOYEE_QUERY = "insert into employee(employeeName, departmentId) values (?,?)";
}
