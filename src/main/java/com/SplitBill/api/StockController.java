package com.SplitBill.api;

import com.SplitBill.data_transmission_object.*;
import com.SplitBill.data_transmission_object.get_product_group.GetProductGroupRequestDTO;
import com.SplitBill.data_transmission_object.mapper.ProductDTOMapper;
import com.SplitBill.domain.Product;
import com.SplitBill.service.add_product_group.AddProductGroupInputBoundary;
import com.SplitBill.service.delete_product_group.DeleteProductGroupServiceInterface;
import com.SplitBill.service.get_product_group.GetProductGroupServiceInterface;
import com.SplitBill.service.get_products_group.GetProductsGroupServiceInterface;
import com.SplitBill.service.update_product_group.UpdateProductGroupServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Controller for manage relation between Group and Product (Stock in a group)
@RestController
@RequestMapping("/api/v1/group_product")
public class StockController {
    @Autowired
    ProductDTOMapper mapper;

    @Autowired
    private AddProductGroupInputBoundary addProductService;

    @Autowired
    private GetProductsGroupServiceInterface getProductsService;

    @Autowired
    private GetProductGroupServiceInterface getProductService;

    @Autowired
    private UpdateProductGroupServiceInterface updateProductService;

    @Autowired
    private DeleteProductGroupServiceInterface deleteProductService;

    @PostMapping
    public ProductDTO addProduct(@RequestBody AddStockDTO request) {
        System.out.println("AddStock: " + request);
        return addProductService.execute(request);
    }

    @RequestMapping(value = "/groupId={groupId}", method = RequestMethod.GET)
    public List<StockDTO> getProducts(@PathVariable String groupId) {
        UUID formatted_groupId = UUID.fromString(groupId);
        return getProductsService.execute(formatted_groupId);
    }

    @GetMapping
    public StockDTO getProduct(@RequestBody GetProductGroupRequestDTO request) {
        return getProductService.execute(request);
    }

    @PutMapping
    public StockDTO updateProduct(@RequestBody UpdateStockDTO request) {
        return updateProductService.execute(request);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody DeleteStockDTO request){
        deleteProductService.execute(request);
    }
}
