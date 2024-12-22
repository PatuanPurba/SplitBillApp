package use_case.use_product;

import data_transmission_object.GroupDTO;

public interface UseProductInputBoundary {
    GroupDTO execute(UseProductInputData inputData);
}
