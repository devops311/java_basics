package employeeregistration.service.impl;

import java.util.Set;

import employeeregistration.dao.DepartmentDao;
import employeeregistration.dao.impl.DepartmentDaoImpl;
import employeeregistration.entity.Department;
import employeeregistration.exception.DaoException;
import employeeregistration.exception.ServiceException;
import employeeregistration.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao = new DepartmentDaoImpl();
	@Override
	public Department addDepartment(Department department) throws ServiceException {
		try {
			return departmentDao.addDepartment(department);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public Set<Department> getAllDepartment() throws ServiceException {
		try {
			return departmentDao.getAllDepartment();
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

	@Override
	public Department getDepartmentById(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

}
