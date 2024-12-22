package use_case.use_product;

import data_transmission_object.GroupDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import repository.*;

public class UseProductInteractor {
    private final TokenRepository tokenRepository;
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final GroupProductRepository groupProductRepository;


    public UseProductInteractor(TokenRepository tokenRepository, GroupRepository groupRepository, UserRepository userRepository, ProductRepository productRepository, GroupProductRepository groupProductRepository) {
        this.tokenRepository = tokenRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.groupProductRepository = groupProductRepository;
    }

    GroupDTO execute(UseProductInputData inputData){
        try {
            if(!tokenRepository.existsById(inputData.getToken())){
                throw new Exception("Invalid Token");
            }

            String username = inputData.getUsername();
            String groupName = inputData.getGroupName();
            String productName = inputData.getProductName();

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return null;
    }
}
