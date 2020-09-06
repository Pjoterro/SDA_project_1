package user_interface;

import dao.EmployeeDAO;
import dto.Employee;

import java.util.Scanner;

public class ConsoleInterface {
    public static void consoleStartup() {
        int chosenOption;
        do {
            Scanner scn = new Scanner(System.in);
            EmployeeDAO employeeDAO = new EmployeeDAO();
            System.out.println("1 - Wypisz pierwszych 100 pracownikow\n" +
                    "2 - Dodaj nowego pracownika\n" +
                    "3 - Znajdz pracownika\n" +
                    "4 - Zaktualizuj pracownika\n" +
                    "5 - Usun pracownika\n" +
                    "0 - Zakoncz program");
            chosenOption = Integer.parseInt(scn.nextLine());

            switch (chosenOption) {
                case 1:
                    EmployeeTablePrint.printEmployees();
                    break;
                case 2:
                    employeeDAO.addEmployee(NewEmployeeInput.createNewEmployee());
                    break;
                case 3:
                    System.out.print("Wpisz ID szukanego pracownika: ");
                    chosenOption = Integer.parseInt(scn.nextLine());
                    EmployeeTablePrint.printSingleEmployee(employeeDAO.getEmployee(chosenOption));
                    break;
                case 4:
                    System.out.print("Wpisz ID pracownika ktorego dane chcesz zmienic: ");
                    chosenOption = Integer.parseInt(scn.nextLine());
                    EmployeeTablePrint.printSingleEmployee(employeeDAO.getEmployee(chosenOption));
                    System.out.println("Wpisz zaktualizowane dane pracownika: ");
                    Employee newEmp = NewEmployeeInput.createNewEmployee();
                    employeeDAO.updateEmployee(chosenOption, newEmp);
                    break;
                case 5:
                    System.out.println("Wpisz ID pracownika ktorego chcesz usunac: ");
                    chosenOption = Integer.parseInt(scn.nextLine());
                    employeeDAO.deleteEmployee(chosenOption);
                    break;
                default:
                    System.out.println("Nie ma takiej opcji");
            }
        } while(chosenOption != 0);
    }
}
