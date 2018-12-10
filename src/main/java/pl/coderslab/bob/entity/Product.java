package pl.coderslab.bob.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotBlank
    @Size(max = 25)
    private String name;

    @ManyToOne
    @NotNull
    private Bank bank;

    @ManyToOne
    @NotNull
    private InstrumentType instrumentType;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<PurchasedProduct> purchasedProducts;

    @Transient
    private long popularity;


    public Product(String name, Bank bank, InstrumentType instrumentType, List<PurchasedProduct> purchasedProducts) {
        this.name = name;
        this.bank = bank;
        this.instrumentType = instrumentType;
        this.purchasedProducts = purchasedProducts;
    }

    public Product() {
    }

    public List<PurchasedProduct> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(List<PurchasedProduct> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    public long getPopularity() {
        return popularity;
    }

    public void setPopularity(long popularity) {
        this.popularity = popularity;
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

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    @Override
    public String toString() {
        return bank.getName()+"  |  "+name;
    }
}
