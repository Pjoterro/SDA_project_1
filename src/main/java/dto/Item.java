package dto;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @ManyToOne
    private Employee owner;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(length = 100)
    private String description;

    public Item(Employee owner, String name, String description) {
        this.owner = owner;
        this.name = name;
        this.description = description;
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Item() {
    }
}
