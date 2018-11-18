package pl.coderslab.bob.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class PurchasedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;

    @Column
    private float value;

    @Column
    private boolean isActive;

    @OneToMany(mappedBy = "purchasedProduct")
    private List<History> histories;

    public PurchasedProduct(Product product, User user, float value, boolean isActive, List<History> histories) {
        this.product = product;
        this.user = user;
        this.value = value;
        this.isActive = isActive;
        this.histories = histories;
    }

    public PurchasedProduct() {
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
