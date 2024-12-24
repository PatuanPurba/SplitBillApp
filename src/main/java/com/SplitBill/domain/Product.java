package com.SplitBill.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID productId;

    String productName;
    float productPrice;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    Set<GroupProduct> groupProducts = new HashSet<GroupProduct>();

    public Product() {}

    public Product(UUID productId, String productName, float productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Set<GroupProduct> getGroupProducts() {return groupProducts;}

    public UUID getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice){this.productPrice = productPrice;}
}
