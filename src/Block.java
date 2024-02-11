public class Block {
    private int quantity;
    private double price;
    //Setting up emtpy constructor
    public Block() {
    }

    //Setting up full constructor
    public Block(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    //Getters

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    //Setters

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
