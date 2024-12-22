package use_case.add_product_group;

import data_transmission_object.GroupDTO;
import entity.Group;
import entity.GroupProduct;
import entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import repository.GroupProductRepository;
import repository.GroupRepository;
import repository.ProductRepository;
import repository.TokenRepository;

@Service
public class AddProductGroupInteractor implements AddProductGroupInputBoundary{
    private final TokenRepository tokenRepository;
    private final GroupRepository groupRepository;
    private final ProductRepository productRepository;
    private final GroupProductRepository groupProductRepository;

    public AddProductGroupInteractor(TokenRepository tokenRepository, GroupRepository groupRepository, ProductRepository productRepository, GroupProductRepository groupProductRepository) {
        this.tokenRepository = tokenRepository;
        this.groupRepository = groupRepository;
        this.productRepository = productRepository;
        this.groupProductRepository = groupProductRepository;
    }



    @Override
    public GroupDTO execute(AddProductGroupInputData inputData) {
        try {
            String productName = inputData.getProductName();
            float productPrice = inputData.getProductPrice();

            if(!productRepository.existsByProductName(productName)) {
                Product product = new Product(null, productName, productPrice);
                productRepository.save(product);
            }

            Product product = productRepository.findByProductName(productName);
            Group group = groupRepository.findByGroupName(inputData.getGroupName());

            GroupProduct groupProduct = new GroupProduct(group, product, inputData.getQuantity());
            System.out.println("GroupName: " + inputData.getGroupName());
            System.out.println("groupId: " + group.getGroupId());
            System.out.println("productId: " + product.getProductId());
            groupProductRepository.save(groupProduct);



            return new GroupDTO(group.getGroupName());
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }


    }
}
