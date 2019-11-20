package employeeregistration.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import employeeregistration.dao.EmployeeDao;
import employeeregistration.entity.Employee;
import employeeregistration.exception.DaoException;
import employeeregistration.exception.DatabaseConnectivityException;
import employeeregistration.util.ConnectionUtil;
import employeeregistration.util.EmployeeRegistrationQueries;
import employeeregistration.util.ErrorMessageConstants;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Employee addEmployee(Employee employee) throws DaoException {
		try {
			Connection connection = ConnectionUtil.getConnection();
			try (PreparedStatement statement = connection.prepareStatement(
					EmployeeRegistrationQueries.ADD_EMPLOYEE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1, employee.getName());
				statement.setInt(2, employee.getDepartment().getDepartmentId());
				statement.executeUpdate();
				try (ResultSet rs = statement.getGeneratedKeys()) {
					rs.next();
					int generatedEmployeeId = rs.getInt(1);
					employee.setId(generatedEmployeeId);
				}
			}
		} catch (SQLException e) {
			throw new DaoException(ErrorMessageConstants.QUERY_ERROR, e);
		} catch (DatabaseConnectivityException e1) {
			throw new DaoException(ErrorMessageConstants.CONNECTION_UNAVAILABLE, e1);
		}
		return employee;
	}

}
