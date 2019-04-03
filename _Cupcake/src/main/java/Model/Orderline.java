package Model;

public class Orderline {

    private int orderline_id;
    private int order_id;
    private int top_id;
    private int bottom_id;
    private int amount;
    private Double price;

    public Orderline(int top_id, int bottom_id, int amount, Double price) {
        this.top_id = top_id;
        this.bottom_id = bottom_id;
        this.amount = amount;
        this.price = price;
    }

    public Orderline(int orderline_id, int order_id, int top_id, int bottom_id, int amount, Double price) {
        this.orderline_id = orderline_id;
        this.order_id = order_id;
        this.top_id = top_id;
        this.bottom_id = bottom_id;
        this.amount = amount;
        this.price = price;
    }

    public int getOrderline_id() {
        return orderline_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public int getTop_id() {
        return top_id;
    }

    public int getBottom_id() {
        return bottom_id;
    }

    public int getAmount() {
        return amount;
    }

    public Double getPrice() {
        return price;
    }
}
