import dao.EntityManagerService;
import dto.Employee;
import dto.Position;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        EntityManagerService.create();


        EntityManagerService.close();
    }

}
