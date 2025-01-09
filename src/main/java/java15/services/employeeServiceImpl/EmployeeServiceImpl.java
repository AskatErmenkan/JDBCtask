package java15.services.employeeServiceImpl;

import java15.dao.EmployeeDao;
import java15.dao.daoImpl.EmployeeDaoImpl;
import java15.models.Employee;
import java15.models.Job;
import java15.services.EmployeeService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public void createEmployee() throws SQLException {
        employeeDao.createEmployee();
    }

    @Override
    public String addEmployee(Employee employee) {
        return employeeDao.addEmployee(employee);

    }

    @Override
    public void dropTable() {
        employeeDao.dropTable();
    }

    @Override
    public void cleanTable() {
        employeeDao.cleanTable();
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
         employeeDao.updateEmployee(id, employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }

    @Override
    public Employee findByEmail(String email) {
        return  employeeDao.findByEmail(email);
    }

    @Override
    public Map<Employee, Job> getEmployeeById(Long employeeId) {
        return Map.of();
    }

    @Override
    public List<Employee> getEmployeeByPosition(String position) {
        return List.of();
    }
}
