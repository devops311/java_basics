package employeeregistration.dao;

import java.util.Set;

import employeeregistration.entity.Department;
import employeeregistration.exception.DaoException;

public interface DepartmentDao {
	
	public Department addDepartment(Department department);
	
	public Set<Department> getAllDepartment();
	
	public Department getDepartmentByName(String departmentName) throws DaoException;

}
