package DataMapper;

import DB.Connector;
import Model.*;
import com.mysql.cj.protocol.Resultset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OrderMapper {
    public static ArrayList<Order> loadOrders() {
        ArrayList<Order> orderList = new ArrayList<>();

        try {
            Connection connection = Connector.connection();
            String sql = "SELECT * FROM orders";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                int order_id = rs.getInt("order_id");
                String date = rs.getString("date");
                Double price = rs.getDouble("total");
                int user_id = rs.getInt("user_id");

                Order newOrder = new Order(order_id, date, price, user_id);

                orderList.add(newOrder);
            }

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return orderList;

    }

    public static void createOrder(ArrayList<Cupcake> kurv, User user, Double totalPrice) {

        // Lad os lave en dato og formatere den.
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateFormatted = date.format(format);

        int order_id;

        // Database

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO orders (`date`, `total`, `user_id`) VALUES (?, ?, ?);";

        try {
            connection = Connector.connection();

            ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, dateFormatted);
            ps.setDouble(2, totalPrice);
            ps.setInt(3, user.getId());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();

            if (rs.next()) {
                order_id = rs.getInt(1);

                // Indsæt ordrelinjerne / orderlines

                String sqlOrderlines = "INSERT INTO orderline (`order_id`, `top_id`, `bottom_id`, `amount`, `price`) VALUES (?, ?, ?, ?, ?);";

                for (Cupcake c : kurv) {
                    ps = connection.prepareStatement(sqlOrderlines);

                    ps.setInt(1, order_id);
                    ps.setInt(2, c.getTop_id());
                    ps.setInt(3, c.getBottom_id());
                    ps.setInt(4, c.getAmount());
                    ps.setDouble(5, c.getPrice());
                    ps.executeUpdate();
                }

            }

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void removeOrder(int order_id) {
        Connection connection = null;
        PreparedStatement ps = null;
        String sql;
        try {
            Connection con = Connector.connection();
            sql = "DELETE FROM orders WHERE order_id = ?";
            ps = con.prepareStatement(sql);

            ps.setInt(1, order_id);
            ps.executeUpdate();

            sql = "DELETE FROM orderline WHERE order_id = ?";
            ps = con.prepareStatement(sql);

            ps.setInt(1, order_id);
            ps.executeUpdate();

        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
