import dao.EntityManagerService;
import user_interface.ConsoleInterface;

public class Main {

    public static void main(String[] args) {
        EntityManagerService.create();
        ConsoleInterface.consoleStartup();
        EntityManagerService.close();
    }

}
