package entity;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CommonUserFactory implements UserFactory{

    @Override
    public CommonUser create(UUID user_id, String username, String password, String first_name, String last_name) {
        return new CommonUser(user_id, username, password, first_name, last_name);
    }

    @Override
    public CommonUser create( String username, String password, String first_name, String last_name) {
        return new CommonUser(null, username, password, first_name, last_name);
    }
}
