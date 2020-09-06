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
}
