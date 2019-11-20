package employeeregistration.service;

import java.io.IOException;
import java.util.Set;

import employeeregistration.entity.Department;
import employeeregistration.exception.ServiceException;

public interface DepartmentService {
	
	public Department addDepartment(Department department) throws ServiceException;
	
	public Set<Department> getAllDepartment() throws ServiceException, IOException;

	public Department getDepartmentById(int departmentId) throws ServiceException;

}
