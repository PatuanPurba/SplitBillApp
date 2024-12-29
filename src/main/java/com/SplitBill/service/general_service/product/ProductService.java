package com.SplitBill.service.general_service.product;

import com.SplitBill.data_transmission_object.ProductDTO;
import com.SplitBill.data_transmission_object.mapper.ProductDTOMapper;
import com.SplitBill.domain.Product;
import com.SplitBill.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private ProductDTOMapper mapper;

    public ProductService(ProductRepository productRepository, ProductDTOMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public ProductDTO add(Product product) {
        return mapper.map(productRepository.save(product));
    }


    public ProductDTO get(UUID productId) {
        return mapper.map(productRepository.findById(productId).get());
    }
}
