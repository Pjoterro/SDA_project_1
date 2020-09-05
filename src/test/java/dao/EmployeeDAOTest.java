package dao;

import dto.Employee;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOTest {

    @Test
    public void testGetAll() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.getAll();
    }

}