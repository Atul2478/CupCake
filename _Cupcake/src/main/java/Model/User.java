package Model;

public class User {
    private int id;
    private String username;
    private String password;
    private int permission;
    private String email;
    private Double balance;

    public User(int id, String username, String password, int permission, String email, Double balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.permission = permission;
        this.email = email;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPermission() {
        return permission;
    }

    public String getEmail() {
        return email;
    }

    public Double getBalance() {
        return balance;
    }
}
