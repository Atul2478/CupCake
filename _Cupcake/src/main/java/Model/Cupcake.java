package Model;

public class Cupcake {

    private int top_id;
    private String top_name;

    private int bottom_id;
    private String bottom_name;

    private Double price;

    private int amount;

    public Cupcake(int top_id, String top_name, int bottom_id, String bottom_name, int amount, Double price) {
        this.top_id = top_id;
        this.top_name = top_name;
        this.bottom_id = bottom_id;
        this.bottom_name = bottom_name;
        this.amount = amount;
        this.price = price;
    }

    public String getTop_name() {
        return top_name;
    }

    public String getBottom_name() {
        return bottom_name;
    }

    public int getAmount() {
        return amount;
    }

    public int getTop_id() {
        return top_id;
    }

    public int getBottom_id() {
        return bottom_id;
    }

    public Double getPrice() {
        return price;
    }
}
