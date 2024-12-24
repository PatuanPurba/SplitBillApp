package com.SplitBill.service.use_product;

import java.util.UUID;

public class UseProductInputData {
    private String username;
    private String groupName;
    private String productName;
    private int quantity;
    private UUID token;

    public UseProductInputData(String username, String groupName, String productName, int quantity, UUID token) {
        this.username = username;
        this.groupName = groupName;
        this.productName = productName;
        this.quantity = quantity;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public UUID getToken() {
        return token;
    }
}
