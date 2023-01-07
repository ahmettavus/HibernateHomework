package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "isim")
    private String name;
    @Column(name = "sokak")
    private String surname;
    @Column(name = "maas")
    private double salary;
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    public Employee(String name, String surname, double salary, Department department) {

        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
    }
}
