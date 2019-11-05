package employeeregistration.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import employeeregistration.dao.EmployeeDao;
import employeeregistration.entity.Employee;
import employeeregistration.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	private Connection conn = ConnectionUtil.getConnection();
	@Override
	public Employee addEmployee(Employee employee) {
		try {
			PreparedStatement statement = conn.prepareStatement("insert into employee(employeeName, departmentId) values (?,?)", Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, employee.getName());
			statement.setInt(2, employee.getDepartment().getDepartmentId());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			rs.next();
			int generatedEmployeeId = rs.getInt(1);
			employee.setId(generatedEmployeeId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}
	

}
