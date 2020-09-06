package dao;

import dto.Employee;
import dto.Item;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class ItemDAO {

    public List<Item> getAll() {
        EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        List<Item> resultList = entityManager.createQuery("SELECT i FROM Item i", Item.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }

    public void addItem(Item item) {
        EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(item);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Item getItem(int id) {
        EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Item item = entityManager.find(Item.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return item;
    }

//    public void updateItem(int id, Item item) {
//        EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();
//        entityManager.getTransaction().begin();
//        Item item = entityManager.find(Item.class, id);
//        item.setFirstName(emp.getFirstName());
//        item.setLastName(emp.getLastName());
//        item.setBirthDate(LocalDate.parse(emp.getBirthDate()));
//        item.setSalary(emp.getSalary());
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    } //TODO: naprawic

    public void deleteItem(int id) {
        EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Item.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
