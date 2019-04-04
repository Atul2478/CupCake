package DataMapper;

import DB.Connector;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserMapper {

    public static User receiveUser(String emails) {

        User tempUser = null;

        if (emails != null) {
            Connection con = null;
            PreparedStatement ps = null;
            String sql = null;
            try {
                con = Connector.connection();
                sql = "select * from user where email = ?";
                ps = con.prepareStatement(sql);

                ps.setString(1, emails);

                ResultSet resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    int permission = resultSet.getInt("permission");
                    String nyEmail = resultSet.getString("email");
                    Double balance = resultSet.getDouble("balance");

                    tempUser = new User(id, username, password, permission, nyEmail, balance);

                    return tempUser;
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return tempUser;
    }

    public static User receiveUserById(int searchId) {

        User tempUser = null;

        if (searchId != 0) {
            Connection con = null;
            PreparedStatement ps = null;
            String sql = null;
            try {
                con = Connector.connection();
                sql = "select * from user where id = ?";
                ps = con.prepareStatement(sql);

                ps.setInt(1, searchId);

                ResultSet resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    int permission = resultSet.getInt("permission");
                    String nyEmail = resultSet.getString("email");
                    Double balance = resultSet.getDouble("balance");

                    tempUser = new User(id, username, password, permission, nyEmail, balance);

                    return tempUser;
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return tempUser;
    }

    public static void createUser(String username, String password, String email) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";

        final int permission = 0;
        final Double balance = 0.0;

        try {
            Connection con = Connector.connection();

            sql = "INSERT INTO user (`username`, `password`, `permission`, `email`, `balance`) VALUES (?, ?, ?, ?, ?);";

            ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, permission);
            ps.setString(4,email);
            ps.setDouble(5, balance);

            ps.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateBalance(int user_id, Double newBalance) {
        try {
            Connection con = Connector.connection();

            String sql = "UPDATE user SET balance = ? WHERE (id = ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, newBalance);
            ps.setInt(2, user_id);

            ps.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> loadUsers() {
        ArrayList<User> userList = new ArrayList<>();

        try {
            Connection connection = Connector.connection();
            String sql = "SELECT * FROM user";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int permission = rs.getInt("permission");
                String email = rs.getString("email");
                Double balance = rs.getDouble("balance");


                User newUser = new User(id, username, password, permission, email, balance);

                userList.add(newUser);
            }

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return userList;

    }

    public static void updateEmail(int user_id, String newEmail) {
        try {
            Connection con = Connector.connection();

            String sql = "UPDATE user SET email = ? WHERE (id = ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, newEmail);
            ps.setInt(2, user_id);

            ps.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUsername(int user_id, String newUsername) {
        try {
            Connection con = Connector.connection();

            String sql = "UPDATE user SET username = ? WHERE (id = ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, newUsername);
            ps.setInt(2, user_id);

            ps.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void removeUser(int user_id) {
        Connection connection = null;
        PreparedStatement ps = null;
        String sql;
        try {
            Connection con = Connector.connection();
            sql = "DELETE FROM user WHERE id = ?";
            ps = con.prepareStatement(sql);

            ps.setInt(1, user_id);
            ps.executeUpdate();

        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


