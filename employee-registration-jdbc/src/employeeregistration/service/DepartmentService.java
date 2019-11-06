package employeeregistration.service;

import java.util.List;
import java.util.Set;

import employeeregistration.entity.Department;
import employeeregistration.exception.ServiceException;

public interface DepartmentService {
	
	public Department addDepartment(Department department) throws ServiceException;
	
	public Set<Department> getAllDepartment() throws ServiceException;
	
	public Department getDepartmentById(Department department);

}
