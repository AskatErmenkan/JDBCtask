package java15.dao.daoImpl;

import java15.config.DBConnection;
import java15.dao.EmployeeDao;
import java15.models.Employee;
import java15.models.Job;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao {
    private final Connection connection = DBConnection.getConnection();

    @Override
    public boolean createEmployee() throws SQLException {
        String sql = """
                        create table if not exists Employees (
                        id serial primary key,
                        first_name varchar not null,
                        last_name varchar not null,
                        age int not null,
                        email varchar not null,
                        job_id int not null
                        )
                """;

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Employee created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public String addEmployee(Employee employee) {
        String query = """
                 insert into Employees (first_name, last_name, age, email, job_id)
                 values (?,?,?,?,?)
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setInt(3, employee.getAge());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setInt(5, employee.getJobId());
            preparedStatement.executeUpdate();
            return "Employee added";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        Employee employee = new Employee();
        String query = """
                select * from Employees where email = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employee.setId(resultSet.getLong("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setAge(resultSet.getInt("age"));
                employee.setEmail(resultSet.getString("email"));
                employee.setJobId(resultSet.getInt("job_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employee;


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
