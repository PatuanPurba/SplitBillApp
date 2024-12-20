package entity;

public class CommonUserFactory implements UserFactory{
    @Override
    public User create(String user_id, String first_name, String last_name, String username) {
        return new CommonUser(user_id, first_name, last_name, username);
    }
}
