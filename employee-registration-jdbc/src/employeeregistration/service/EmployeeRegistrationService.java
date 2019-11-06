package employeeregistration.service;

import employeeregistration.entity.Employee;
import employeeregistration.exception.EmployeeNotFoundException;
import employeeregistration.exception.NoSuchDepartmentException;
import employeeregistration.exception.RegistrationFailureException;
import employeeregistration.exception.ServiceException;

public interface EmployeeRegistrationService {
	
	public Employee register(Employee employeeEntity) throws NoSuchDepartmentException, ServiceException;

}
