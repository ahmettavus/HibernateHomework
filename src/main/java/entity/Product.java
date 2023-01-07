package entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "isim")
    private String name;
    @Column(name = "fiyat")
    private double price;

    public Product(String name, double price, List<Order> orders) {
        this.name = name;
        this.price = price;
        this.orders = orders;
    }

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
}
