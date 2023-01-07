package entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ad")
    private String name;

    @Column(name = "konum")
    private String location;

    @OneToMany(mappedBy = "department")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

}

