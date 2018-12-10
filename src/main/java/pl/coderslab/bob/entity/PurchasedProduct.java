package pl.coderslab.bob.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.sql.Delete;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
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
    @Size(max = 100)
    private String note;

    @Column
    private boolean isActive;

    @OneToMany(mappedBy = "purchasedProduct")
    private List<History> histories = new ArrayList<>();

//    @Transient
//    private float sum;
//
//    @Transient
//    private float quantity;
//

    public PurchasedProduct(Product product, User user, float value, String note, boolean isActive, List<History> histories) {
        this.product = product;
        this.user = user;
        this.value = value;
        this.note = note;
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

//    public float getSum() {
//        return sum;
//    }
//
//    public void setSum(float sum) {
//        this.sum = sum;
//    }
//
//    public float getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(float quantity) {
//        this.quantity = quantity;
//    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
