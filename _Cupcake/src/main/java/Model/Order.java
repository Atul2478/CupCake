package Model;

public class Order {
    private int order_id;
    private String date;
    private Double total;
    private int user_id;

    public Order(int order_id, String date, Double total, int user_id) {
        this.order_id = order_id;
        this.date = date;
        this.total = total;
        this.user_id = user_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public String getDate() {
        return date;
    }

    public Double getTotal() {
        return total;
    }

    public int getUser_id() {
        return user_id;
    }
}
