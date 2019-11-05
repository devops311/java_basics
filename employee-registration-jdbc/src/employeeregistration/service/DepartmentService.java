package employeeregistration.service;

import java.util.List;
import java.util.Set;

import employeeregistration.entity.Department;

public interface DepartmentService {
	
	public Department addDepartment(Department department);
	
	public Set<Department> getAllDepartment();
	
	public Department getDepartmentById(Department department);

}
