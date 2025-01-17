package user_interface;

import dao.EmployeeDAO;
import dto.Employee;
import user_interface.table_creator.TableComponents;

import java.util.List;

public class EmployeeTablePrint {

    public static void printEmployees() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> empList = employeeDAO.getAll();
        System.out.println(TableComponents.tableHeader());
        for (Employee employee: empList) {
            System.out.println(TableComponents.empRecord(employee));
            System.out.println(TableComponents.tableInterline());
        }
    }

    public static void printSingleEmployee(Employee emp) {
        System.out.println(TableComponents.tableHeader());
        System.out.println(TableComponents.empRecord(emp));
        System.out.println(TableComponents.tableInterline());
    }
}
