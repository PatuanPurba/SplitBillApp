package use_case.use_product;

import java.util.UUID;

public class UseProductInputData {
    private String username;
    private String groupName;
    private String productName;
    private UUID token;

    public UseProductInputData(String username, String groupName, String productName, UUID token) {
        this.username = username;
        this.groupName = groupName;
        this.productName = productName;
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

    public UUID getToken() {
        return token;
    }
}
