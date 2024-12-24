package com.SplitBill.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
public class UserProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userProductId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "gp_id")
    private GroupProduct groupProduct;

    private int quantity;
    private float bill;

//    @Column(name = "date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    private Timestamp date;

    public UserProduct(UUID userProductId, User user, GroupProduct groupProduct, int quantity, float bill, Timestamp date) {
        this.userProductId = userProductId;
        this.user = user;
        this.groupProduct = groupProduct;
        this.quantity = quantity;
        this.bill = bill;
        this.date = date;
    }

    public UserProduct(User user, GroupProduct groupProduct, int quantity, float bill) {
        this.user = user;
        this.groupProduct = groupProduct;
        this.quantity = quantity;
        this.bill = bill;
    }

    public UserProduct(){}


    public UUID getUserProductId() {
        return userProductId;
    }

    public User getUser() {
        return user;
    }

    public GroupProduct getGroupProduct() {
        return groupProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getBill() {
        return bill;
    }

    public Timestamp getDate() {
        return date;
    }
}
