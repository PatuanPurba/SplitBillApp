package entity;

import java.util.List;
import java.util.UUID;

public interface User {
    UUID getUserId();

    String getUsername();

    String getFirstName();

    String getLastName();

    String getPassword();
}
