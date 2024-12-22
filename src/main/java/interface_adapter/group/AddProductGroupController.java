package interface_adapter.group;

import data_transmission_object.GroupDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import use_case.add_product_group.AddProductGroupInputBoundary;
import use_case.add_product_group.AddProductGroupInputData;

@RestController
@RequestMapping("api/v1/group/addProduct")
public class AddProductGroupController {
    private final AddProductGroupInputBoundary use_case;


    public AddProductGroupController(AddProductGroupInputBoundary useCase) {
        use_case = useCase;
    }

    @PostMapping
    public GroupDTO execute(@RequestBody AddProductGroupRequest request) {
        String productName = request.productName();
        float productPrice = request.productPrice();
        int quantity = request.quantity();
        String groupName = request.groupName();

        AddProductGroupInputData inputData = new AddProductGroupInputData(productName, productPrice, quantity, groupName);
        return use_case.execute(inputData);
    }

    public record AddProductGroupRequest(String productName, float productPrice, int quantity, String groupName){}
}
