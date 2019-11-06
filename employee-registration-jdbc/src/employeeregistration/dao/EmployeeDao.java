package employeeregistration.dao;

import employeeregistration.entity.Employee;
import employeeregistration.exception.DaoException;

public interface EmployeeDao {
	
	public Employee addEmployee(Employee employee) throws DaoException;

}
