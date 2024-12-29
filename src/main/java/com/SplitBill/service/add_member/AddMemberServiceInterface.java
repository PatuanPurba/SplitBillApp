package com.SplitBill.service.add_member;

import com.SplitBill.data_transmission_object.AddMemberDTO;
import com.SplitBill.data_transmission_object.GroupDTO;

public interface AddMemberServiceInterface {
    GroupDTO execute(AddMemberDTO inputData);
}
