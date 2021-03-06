package employeeregistration.service.impl;

import java.util.ArrayList;
import java.util.List;

import employeeregistration.dao.DepartmentDao;
import employeeregistration.dao.EmployeeDao;
import employeeregistration.dao.impl.DepartmentDaoImpl;
import employeeregistration.dao.impl.EmployeeDaoImpl;
import employeeregistration.entity.Department;
import employeeregistration.entity.Employee;
import employeeregistration.exception.DaoException;
import employeeregistration.exception.EmployeeNotFoundException;
import employeeregistration.exception.NoSuchDepartmentException;
import employeeregistration.exception.RegistrationFailureException;
import employeeregistration.exception.ServiceException;
import employeeregistration.service.EmployeeRegistrationService;

public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService {
	
	EmployeeDao employeeDao = new EmployeeDaoImpl();
	DepartmentDao departmentDao = new DepartmentDaoImpl();
	
	@Override
	public Employee register(Employee employee) throws ServiceException{
		int departmentId = 0;
		try {
			Department department = departmentDao.getDepartmentByName(employee.getDepartment().getDepartmentName());
			if(department == null) {
				throw new NoSuchDepartmentException("The department name entered is invalid");
			}
			departmentId = department.getDepartmentId();
			
		} catch (DaoException e) {
			
		}
		employee.getDepartment().setDepartmentId(departmentId);
		try {
			return employeeDao.addEmployee(employee);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
