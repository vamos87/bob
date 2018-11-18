package pl.coderslab.bob.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotBlank
    @Size(max = 50)
    private String name;

    @Column(unique = true)
    @NotBlank
    private String email;

    @Column
    @NotBlank
    @Size(min = 8)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<PurchasedProduct> purchasedProducts;


    public User(String name, String email, String password, List<PurchasedProduct> purchasedProducts) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.purchasedProducts = purchasedProducts;
    }

    public User() {
    }

    public List<PurchasedProduct> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(List<PurchasedProduct> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
