import inventory.Inventory;
import products.Product;

public class Main {
    public static void main(String[] args) {}

    public static double calculateTotalPrice(Inventory<? extends Product> inventory)
    {
        double sum = 0;

        for(Product product : inventory.getItems())
        {
            sum += product.getPrice();
        }

        return sum;
    }
}