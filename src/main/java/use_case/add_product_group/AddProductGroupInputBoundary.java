package use_case.add_product_group;

import data_transmission_object.GroupDTO;

public interface AddProductGroupInputBoundary {
    GroupDTO execute(AddProductGroupInputData inputData);
}
