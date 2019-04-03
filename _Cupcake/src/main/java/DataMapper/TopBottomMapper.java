package DataMapper;

import DB.Connector;
import Model.Bottom;
import Model.Top;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopBottomMapper {

    public static ArrayList<Top> readTops() {

        ArrayList<Top> topList = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String sql = "SELECT * FROM top;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);

            while (resultSet.next()) {

                int top_id = resultSet.getInt("top_id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");

                Top newTop = new Top(top_id, name, price);
                topList.add(newTop);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topList;
    }

    public static ArrayList<Bottom> readBottoms() {
        ArrayList<Bottom> bottomList = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String sql = "SELECT * FROM bottom;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);

            while (resultSet.next()) {

                int bottom_id = resultSet.getInt("bottom_id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");

                Bottom newBottom = new Bottom(bottom_id, name, price);
                bottomList.add(newBottom);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bottomList;
    }
}
