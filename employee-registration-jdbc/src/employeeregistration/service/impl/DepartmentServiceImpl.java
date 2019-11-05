package employeeregistration.service.impl;

import java.util.Set;

import employeeregistration.dao.DepartmentDao;
import employeeregistration.dao.impl.DepartmentDaoImpl;
import employeeregistration.entity.Department;
import employeeregistration.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao departmentDao = new DepartmentDaoImpl();
	@Override
	public Department addDepartment(Department department) {
		return departmentDao.addDepartment(department);
	}

	@Override
	public Set<Department> getAllDepartment() {
		return departmentDao.getAllDepartment();
	}

	@Override
	public Department getDepartmentById(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

}
