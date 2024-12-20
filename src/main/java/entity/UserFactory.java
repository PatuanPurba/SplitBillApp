package entity;

import java.util.ArrayList;
import java.util.List;

public interface UserFactory {
    User create(String user_id, String first_name, String last_name, String username);

    User create(String user_id, String first_name, String last_name, String username, List<String> groups);
}
