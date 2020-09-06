package user_interface;

import dto.Employee;
import dto.Position;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class NewEmployeeInput {

    private Employee employee; //TODO: sprawdzic czy dziala bez tego

    public static Employee createNewEmployee() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Wpisz imie pracownika: ");
        String firstName = scn.nextLine();
        System.out.print("Wpisz nazwisko pracownika: ");
        String lastName = scn.nextLine();
        System.out.print("Wpisz date urodzin pracownika (RRRR-MM-DD): ");
        LocalDate birthDate = LocalDate.parse(scn.nextLine());
        System.out.print("Wpisz pensje pracownika: ");
        BigDecimal salary = BigDecimal.valueOf(Long.parseLong(scn.nextLine()));
        System.out.print("Wpisz stanowisko pracownika(JUNIOR_DEVELOPER, DEVELOPER, SENIOR_DEVELOPER, NONE, MANAGER): ");
        Position position = Position.valueOf(scn.nextLine());
        return new Employee(firstName, lastName, birthDate, salary, position);
    }
}
