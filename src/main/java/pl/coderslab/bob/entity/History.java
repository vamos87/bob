package pl.coderslab.bob.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String operation;

    @Column
    @NotNull
    private LocalDateTime date;

    @ManyToOne
    private PurchasedProduct purchasedProduct;

    @Column
    private float value;

    public History() {
    }

    public History(String operation, LocalDateTime date, PurchasedProduct purchasedProduct, float value) {
        this.operation = operation;
        this.date = date;
        this.purchasedProduct = purchasedProduct;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public PurchasedProduct getPurchasedProduct() {
        return purchasedProduct;
    }

    public void setPurchasedProduct(PurchasedProduct purchasedProduct) {
        this.purchasedProduct = purchasedProduct;
    }
}
