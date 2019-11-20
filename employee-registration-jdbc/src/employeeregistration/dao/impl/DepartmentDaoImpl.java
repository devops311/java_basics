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
import employeeregistration.exception.DaoException;
import employeeregistration.exception.DatabaseConnectivityException;
import employeeregistration.util.ConnectionUtil;
import employeeregistration.util.EmployeeRegistrationQueries;
import employeeregistration.util.ErrorMessageConstants;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public Department addDepartment(Department department) throws DaoException {
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(
						EmployeeRegistrationQueries.ADD_DEPARTMENT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, department.getDepartmentName());
			statement.executeUpdate();
			try (ResultSet rs = statement.getGeneratedKeys()) {
				rs.next();
				int generatedDepartmentId = rs.getInt(1);
				department.setDepartmentId(generatedDepartmentId);
			}
		} catch (SQLException e) {
			throw new DaoException("There is some error in SQL", e);
		} catch (DatabaseConnectivityException e1) {
			throw new DaoException(ErrorMessageConstants.CONNECTION_UNAVAILABLE, e1);
		}
		return department;
	}

	@Override
	public Set<Department> getAllDepartment() throws DaoException {
		Set<Department> departments = new HashSet<>();
		Department department = null;
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement statement = connection
					.prepareStatement(EmployeeRegistrationQueries.GET_ALL_DEPARTMENT_QUERY)) {
				try (ResultSet rs = statement.executeQuery()) {
					while (rs.next()) {
						department = new Department();
						department.setDepartmentId(rs.getInt(1));
						department.setDepartmentName(rs.getString(2));
						departments.add(department);
					}
				}
			}
		} catch (SQLException e) {

		} catch (DatabaseConnectivityException e1) {
			throw new DaoException(ErrorMessageConstants.CONNECTION_UNAVAILABLE, e1);
		}
		return departments;
	}

	@Override
	public Department getDepartmentByName(String departmentName) throws DaoException {
		Department department = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			department = new Department();
			try (PreparedStatement statement = connection
					.prepareStatement(EmployeeRegistrationQueries.GET_DEPARTMENT_BY_NAME_QUERY)) {
				statement.setString(1, departmentName);
				try (ResultSet rs = statement.executeQuery()) {
					while (rs.next()) {
						department.setDepartmentId(rs.getInt(1));
						department.setDepartmentName(rs.getString(2));
					}
				}
			}
		} catch (SQLException e) {
			throw new DaoException(ErrorMessageConstants.QUERY_ERROR, e);
		} catch (DatabaseConnectivityException e1) {
			throw new DaoException(ErrorMessageConstants.CONNECTION_UNAVAILABLE, e1);
		}
		return department;
	}

	@Override
	public Department getDepartmentById(int departmentId) throws DaoException {
		Department department = new Department();
		Connection conn;
		try {
			conn = ConnectionUtil.getConnection();
			String query = "selet * from department where departmentId = ?";
			try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
				preparedStatement.setInt(1, departmentId);
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						department.setDepartmentId(resultSet.getInt("departmentId"));
						department.setDepartmentName(resultSet.getString("departmentName"));
					}
				}
			}
		} catch (DatabaseConnectivityException e) {
			throw new DaoException("There is some exception in DB connection", e);
		} catch (SQLException e) {
			throw new DaoException("There is some exception in SQL Query", e);
		}
		return department;
	}

}
