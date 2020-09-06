package dto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    private Position position;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(scale = 2)
    private BigDecimal salary;

    @OneToMany(mappedBy = "owner")
    @Column(name = "items")
    private List<Item> items;

    public Employee() {
    }

    public Employee(String firstName, String lastName, LocalDate birthDate, BigDecimal salary, Position position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.salary = salary;
        this.position = position;
        //this.items = Item.createDefaultItemList(); //TODO: rework
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

    public boolean isEqual(Employee emp) {
        return (
                this.firstName.equals(emp.getFirstName()) &&
                        this.lastName.equals(emp.getLastName()) &&
                        this.birthDate.isEqual(LocalDate.parse(emp.getBirthDate())) &&
                        this.position.compareTo(Position.valueOf(emp.getPosition())) == 0 &&
                        this.salary.compareTo(emp.getSalary()) == 0

        );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position.toString();
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getBirthDate() {
        return birthDate.toString();
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
