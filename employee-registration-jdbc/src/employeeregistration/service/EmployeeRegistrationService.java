package employeeregistration.service;

import employeeregistration.entity.Employee;
import employeeregistration.exception.EmployeeNotFoundException;
import employeeregistration.exception.NoSuchDepartmentException;
import employeeregistration.exception.RegistrationFailureException;

public interface EmployeeRegistrationService {
	
	public Employee register(Employee employeeEntity) throws NoSuchDepartmentException;

}
