package com.SplitBill.api;

import com.SplitBill.data_transmission_object.ProductDTO;
import com.SplitBill.data_transmission_object.mapper.ProductDTOMapper;
import com.SplitBill.domain.Product;
import com.SplitBill.service.add_product_group.AddProductGroupInputBoundary;
import com.SplitBill.service.general_service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private AddProductGroupInputBoundary addProductService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductDTOMapper mapper;

    @PostMapping()
    public ProductDTO addProduct(@RequestBody ProductDTO product) {
        return productService.add(mapper.create(product));
    }

    @RequestMapping(value = "/productId={productId}", method = RequestMethod.GET)
    public ProductDTO getProduct(@PathVariable UUID productId) {
        return productService.get(productId);
    }


    @RequestMapping(value = "/productId={productId}", method = RequestMethod.PUT)
    public ProductDTO updatePrice(@PathVariable UUID productId, @RequestBody float price) {
        Product product = mapper.create(productService.get(productId));
        product.setProductPrice(price);
        return productService.add(product);
    }

}
