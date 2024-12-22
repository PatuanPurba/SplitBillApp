package entity;

import jakarta.persistence.*;

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
}
