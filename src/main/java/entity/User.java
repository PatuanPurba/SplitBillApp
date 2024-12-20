package entity;

import java.util.List;

public interface User {
    String getUserId();

    String getUsername();

    String getFirstName();

    String getLastName();

    List<String> getGroups();
}
