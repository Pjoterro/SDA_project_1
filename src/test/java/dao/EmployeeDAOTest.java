package dao;

import dto.Employee;
import dto.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOTest {

    Employee employeeTest1 = new Employee(
            "Jan",
            "Kowalski",
            LocalDate.now().minusYears(25),
            BigDecimal.valueOf(5500),
            Position.JUNIOR_DEVELOPER
    );
    Employee employeeTest2 = new Employee(
            "Pawel",
            "Nowak",
            LocalDate.now().minusYears(37),
            BigDecimal.valueOf(8500),
            Position.DEVELOPER
    );
    Employee employeeTest3 = new Employee(
            "Kamil",
            "Nowakowski",
            LocalDate.now().minusYears(55),
            BigDecimal.valueOf(18500),
            Position.SENIOR_DEVELOPER
    );
    Employee employeeTest4 = new Employee(
            "Justyna",
            "Kowalewska",
            LocalDate.now().minusYears(30),
            BigDecimal.valueOf(6500),
            Position.MANAGER
    );
    Employee employeeTest5 = new Employee(
            "Syn",
            "Szefa",
            LocalDate.now().minusYears(16),
            BigDecimal.valueOf(66666),
            Position.NONE
    );


    @Test
    public void testGetAll() {
        EntityManagerService.create();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.addEmployee(employeeTest1);
        employeeDAO.getAll();
        EntityManagerService.close();
    }

    @Test
    public void testAddEmployees() {
        EntityManagerService.create();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.addEmployee(employeeTest1);
        employeeDAO.addEmployee(employeeTest2);
        employeeDAO.addEmployee(employeeTest3);
        employeeDAO.addEmployee(employeeTest4);
        employeeDAO.addEmployee(employeeTest5);
        List<Employee> empList = employeeDAO.getAll();
        EntityManagerService.close();
        Assertions.assertEquals(5, empList.size());
    }

    @Test
    public void testEmployeeEquals() {
        EntityManagerService.create();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.addEmployee(employeeTest2);
        Employee empCheck = employeeDAO.getEmployee(1);
        EntityManagerService.close();
        Assertions.assertTrue(empCheck.isEqual(employeeTest2));
    }

    @Test
    public void testWholeDAO() { //TODO: dokonczyc test
        EntityManagerService.create();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.addEmployee(employeeTest1);
        employeeDAO.addEmployee(employeeTest2);
        employeeDAO.addEmployee(employeeTest3);
        employeeDAO.addEmployee(employeeTest4);
        employeeDAO.addEmployee(employeeTest5);
        List<Employee> empList = employeeDAO.getAll();
        Assertions.assertEquals(5, empList.size());
        employeeDAO.deleteEmployee(3);

        empList = employeeDAO.getAll();
        Assertions.assertEquals(4, empList.size());
        employeeDAO.updateEmployee(1, employeeTest3);
        Employee empCheck = employeeDAO.getEmployee(1);

        Assertions.assertTrue(empCheck.isEqual(employeeTest3));
        EntityManagerService.close();
    }
}