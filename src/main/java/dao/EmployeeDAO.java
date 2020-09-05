package dao;

import dto.Employee;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeeDAO {
    public List<Employee> getAll() {
        EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        List<Employee> resultList = entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }

    public void addEmployee(Employee emp) {
        EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(emp);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
