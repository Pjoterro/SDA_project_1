package dto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    private Position position;

    private LocalDate birthDate;

    @Column(scale = 2)
    private BigDecimal salary;

    public Employee() {
    }

    public Employee(String firstName, String lastName, Position position, LocalDate birthDate, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", birthDate=" + birthDate +
                ", salary=" + salary +
                '}';
    }
}
