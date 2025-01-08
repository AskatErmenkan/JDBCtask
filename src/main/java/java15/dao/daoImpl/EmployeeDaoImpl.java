package java15.dao.daoImpl;

import java15.config.DBConnection;
import java15.dao.EmployeeDao;
import java15.models.Employee;
import java15.models.Job;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao {
    private final Connection connection = DBConnection.getConnection();
    @Override
    public void createEmployee() throws SQLException {
    String sql = """
            create table if not exists Employees(" +
            "id serial primary key," +
            "first_name varchar not null," +
            "last_name varchar not null," +
            "age int not null," +
            "email varchar not null," +
            "job_id int not null,)
            """;
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Employee created");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addEmployee(Employee employee) {

    }

    @Override
    public void dropTable() {

    }

    @Override
    public void cleanTable() {

    }

    @Override
    public void updateEmployee(Long id, Employee employee) {

    }

    @Override
    public List<Employee> getAllEmployees() {
        return List.of();
    }

    @Override
    public Employee findByEmail(String email) {
        return null;
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
