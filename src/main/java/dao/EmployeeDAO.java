package dao;

import dto.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeDAO {
    public List<Employee> getAll() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Employee> resultList = entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        entityManager.close();
        entityManagerFactory.close();
        return resultList;
    }
}
