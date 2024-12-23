package interface_adapter.user;

import data_transmission_object.GroupDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import use_case.use_product.UseProductInputBoundary;
import use_case.use_product.UseProductInputData;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/user/useProduct")
public class UseProductController {
    private final UseProductInputBoundary use_case;


    public UseProductController(UseProductInputBoundary useCase) {
        use_case = useCase;
    }

    @PostMapping
    public GroupDTO execute(@RequestBody UseProductRequest request){
        UseProductInputData inputData = new UseProductInputData(request.username(), request.groupName(), request.productName(), request.quantity(), request.token());
        return use_case.execute(inputData);
    }

    private record UseProductRequest(String username, String groupName, String productName, int quantity, UUID token){}
}
