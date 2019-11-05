package employeeregistration.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import employeeregistration.dao.DepartmentDao;
import employeeregistration.entity.Department;
import employeeregistration.util.ConnectionUtil;
import employeeregistration.util.EmployeeRegistrationQueries;

public class DepartmentDaoImpl implements DepartmentDao {
	
	private Connection conn = ConnectionUtil.getConnection();

	@Override
	public Department addDepartment(Department department) {
		try(
			PreparedStatement statement = conn.prepareStatement(EmployeeRegistrationQueries.ADD_DEPARTMENT_QUERY, Statement.RETURN_GENERATED_KEYS)){
			statement.setString(1, department.getDepartmentName());
			statement.executeUpdate();
			try(ResultSet rs = statement.getGeneratedKeys()){
			rs.next();
			int generatedDepartmentId = rs.getInt(1);
			department.setDepartmentId(generatedDepartmentId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return department;
	}

	@Override
	public Set<Department> getAllDepartment() {
		Set<Department> departments = new HashSet<Department>();
		Department department = null;
		try {
			PreparedStatement statement = conn.prepareStatement("select * from department where departmentName = ?");
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				department = new Department();
				department.setDepartmentId(rs.getInt(1));
				department.setDepartmentName(rs.getString(2));
				departments.add(department);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return departments;
	}

	@Override
	public Department getDepartmentByName(String departmentName) {
		Department department = null;
		try {
			department = new Department();
			PreparedStatement statement = conn.prepareStatement("select * from department where departmentName = ?");
			statement.setString(1, departmentName);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				department.setDepartmentId(rs.getInt(1));
				department.setDepartmentName(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return department;
	}
}
