package com.SplitBill.data_transmission_object.mapper;

import com.SplitBill.data_transmission_object.ProductDTO;
import com.SplitBill.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductDTOMapper {
    public Product create(ProductDTO productDTO){
        return new Product(productDTO.productId(), productDTO.productName(), productDTO.price());
    }

    public ProductDTO map(Product product){
        return new ProductDTO(product.getProductId(), product.getProductName(), product.getProductPrice());
    }
}
