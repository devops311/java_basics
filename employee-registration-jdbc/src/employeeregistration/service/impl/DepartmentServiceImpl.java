package employeeregistration.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import employeeregistration.dao.DepartmentDao;
import employeeregistration.dao.impl.DepartmentDaoImpl;
import employeeregistration.entity.Department;
import employeeregistration.exception.DaoException;
import employeeregistration.exception.NoSuchDepartmentException;
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
	public Set<Department> getAllDepartment() throws ServiceException, IOException {
		Set<Department> departments = null;
		File file = new File("E:\\orchard\\department.txt");
		file.createNewFile();
		FileWriter fileWriter = new FileWriter(file);
		try {
			departments =  departmentDao.getAllDepartment();
			departments.forEach(e->{
				try {
					fileWriter.write(e.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		} catch (DaoException e) {
			throw new ServiceException();
		}
		finally {
			fileWriter.close();
		}
		return departments;
	}

	@Override
	public Department getDepartmentById(int departmentId) throws ServiceException {
		Department department = null;
		try {
			department =  departmentDao.getDepartmentById(departmentId);
			if(department.getDepartmentId() == null) {
				throw new NoSuchDepartmentException("The department you are looking for does not exist");
			}
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return department;
	}

}
