package products;

public class Accessory extends  Product{

    private String color;

    private static int numberOfAccessoriesAdded = 1;

    public Accessory(String title, Double price, String color) {

        super(title, price);
        setColor(color);
    }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    @Override
    public String toString() {
        return super.toString() + "color: " + color + "\n";
    }

    @Override
    protected String generateId() {
        String output = "3" + String.format("%03d", numberOfAccessoriesAdded);
        numberOfAccessoriesAdded++;
        return output;
    }
}
