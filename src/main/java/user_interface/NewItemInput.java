package user_interface;

import dao.EmployeeDAO;
import dao.EntityManagerService;
import dto.Employee;
import dto.Item;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class NewItemInput {

    public static Item createNewItem() {
        Scanner scn = new Scanner(System.in);
        EntityManager entityManager = EntityManagerService.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        EmployeeDAO employeeDAO = new EmployeeDAO();
        System.out.print("Wpisz ID pracownika do ktorego nalezy przedmiot (uzytkownik musi byc juz w bazie): ");
        int id = Integer.parseInt(scn.nextLine());
        System.out.print("Wpisz nazwe przedmiotu: ");
        String name = scn.nextLine();
        System.out.print("Wpisz opis przedmiotu: ");
        String desc = scn.nextLine();
        Employee owner = employeeDAO.getEmployee(id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return new Item(owner, name, desc);
    }
}
