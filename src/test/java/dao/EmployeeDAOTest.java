package dao;

import dto.Employee;
import dto.Position;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOTest {

    Employee employeeTest1 = new Employee("Jan", "Kowalski", LocalDate.now().minusYears(25), BigDecimal.valueOf(5500), Position.JUNIOR_DEVELOPER);


    @Test
    public void testGetAll() {
        EntityManagerService.create();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.addEmployee(employeeTest1);
        employeeDAO.getAll();
        EntityManagerService.close();
    }

}