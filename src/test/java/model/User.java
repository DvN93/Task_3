package model;

import java.util.UUID;

public class User {

    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static User generateUser() {
        String unique = UUID.randomUUID().toString().substring(0, 6);
        return new User("name-" + unique, "test-" + unique + "@yandex.ru", "password-" + unique);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
