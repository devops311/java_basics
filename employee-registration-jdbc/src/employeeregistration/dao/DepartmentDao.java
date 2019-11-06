package employeeregistration.dao;

import java.util.Set;

import employeeregistration.entity.Department;
import employeeregistration.exception.DaoException;

public interface DepartmentDao {
	
	public Department addDepartment(Department department) throws DaoException;
	
	public Set<Department> getAllDepartment() throws DaoException;
	
	public Department getDepartmentByName(String departmentName) throws DaoException;

}
