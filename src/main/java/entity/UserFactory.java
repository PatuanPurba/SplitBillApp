package entity;

public interface UserFactory {
    User create(String user_id, String first_name, String last_name, String username);
}
