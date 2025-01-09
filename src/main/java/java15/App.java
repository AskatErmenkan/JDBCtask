package java15;

import java15.models.Employee;
import java15.services.EmployeeService;
import java15.services.employeeServiceImpl.EmployeeServiceImpl;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        EmployeeService employeeService = new EmployeeServiceImpl();

//         Create
        employeeService.createEmployee();

//        Save
//        System.out.println(employeeService.addEmployee(
//                new Employee(
//                8,
//                "rahat@gmail.com",
//                29,
//                "Saparov",
//                "Rahat")));

        System.out.println(employeeService.findByEmail("samat@gmail.com"));
    }
}
