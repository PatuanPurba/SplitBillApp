package com.SplitBill.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "group_product")
public class GroupProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID gpId;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "group_id")
    Group group;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @OneToMany(mappedBy = "groupProduct")
    Set<UserProduct> userProducts = new HashSet<UserProduct>();

    public GroupProduct(Group group, Product product, int quantity) {
        this.group = group;
        this.product = product;
        this.quantity = quantity;
    }


    public GroupProduct(){}

    public UUID getGpId() {
        return gpId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Group getGroup() {
        return group;
    }

    public Product getProduct() {
        return product;
    }

    public Set<UserProduct> getUserProducts() {return userProducts;}

    public void setQuantity(int quantity){this.quantity = quantity;}
}
