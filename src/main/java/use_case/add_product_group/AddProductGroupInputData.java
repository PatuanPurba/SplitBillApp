package use_case.add_product_group;

public class AddProductGroupInputData {
    private final String productName;
    private final float productPrice;
    private final int quantity;
    private final String groupName;


    public AddProductGroupInputData(String productName, float productPrice, int quantity, String groupName) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.groupName = groupName;
    }

    public String getProductName() {
        return productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public int getQuantity() {return quantity;}

    public String getGroupName() {return groupName;}
}
