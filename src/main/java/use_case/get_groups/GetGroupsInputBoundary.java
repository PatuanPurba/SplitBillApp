package use_case.get_groups;

import data_transmission_object.GroupDTO;

import java.util.List;

public interface GetGroupsInputBoundary {
    List<GroupDTO> execute(GetGroupsInputData request);
}
