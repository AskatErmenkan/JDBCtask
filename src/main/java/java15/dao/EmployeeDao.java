package java15.dao;

import java15.models.Employee;
import java15.models.Job;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    void createEmployee() throws SQLException;
    void addEmployee(Employee employee);
    void dropTable();
    void cleanTable();
    void updateEmployee(Long id,Employee employee);
    List<Employee> getAllEmployees();
    Employee findByEmail(String email);
    Map<Employee, Job> getEmployeeById(Long employeeId);
    List<Employee> getEmployeeByPosition(String position);
}
