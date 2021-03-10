public class Item {

    private double price;
    private int amount;
    private final int productId;
    private String name;

    public Item(double price, int amount, int productId, String name) {
        this.price = price;
        this.amount = amount;
        this.productId = productId;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
