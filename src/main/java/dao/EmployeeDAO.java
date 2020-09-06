package dao;

import dto.Employee;

import javax.persistence.EntityManager;
import java.time.LocalDate;
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

    public Employee getEmployee(int id) {
        EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return employee;
    }

    public void updateEmployee(int id, Employee emp) {
        EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Employee employee = entityManager.find(Employee.class, id);
        employee.setFirstName(emp.getFirstName());
        employee.setLastName(emp.getLastName());
        employee.setBirthDate(LocalDate.parse(emp.getBirthDate()));
        employee.setSalary(emp.getSalary());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deleteEmployee(int id) {
        EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Employee.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
