package pl.coderslab.bob.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class InstrumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    private String name;

    @OneToMany(mappedBy = "instrumentType", cascade = CascadeType.ALL)
    private List<Product> products;

    public InstrumentType(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public InstrumentType() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
