package user_interface;

import dao.EmployeeDAO;

import java.util.Scanner;

public class ConsoleInterface {
    public static void consoleStartup() {
        int chosenOption;
        do {
            Scanner scn = new Scanner(System.in);
            EmployeeDAO employeeDAO = new EmployeeDAO();
            System.out.println("1 - Wypisz pierwszych 100 pracownikow\n" +
                    "2 - Dodaj nowego pracownika\n" +
                    "\n" +
                    "0 - Zakoncz program");
            chosenOption = Integer.parseInt(scn.nextLine());

            switch (chosenOption) {
                case 1:
                    EmployeeTablePrint.printEmployee();
                    break;
                case 2:
                    employeeDAO.addEmployee(NewEmployeeInput.createNewEmployee());
                    break;
            }
        } while(chosenOption != 0);
    }
}
