package user_interface;

import dao.EmployeeDAO;
import dto.Employee;

import java.util.List;

public class EmployeeTablePrint {

    public static void printEmployee() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> empList = employeeDAO.getAll();
        for (Employee employee: empList) {
            System.out.println(employee.toString());
        }
    }

}
