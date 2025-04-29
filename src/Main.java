import inventory.Inventory;
import products.Accessory;
import products.Book;
import products.NoteBook;
import products.Product;

public class Main {
    public static void main(String[] args) {

        Inventory<Book> inventory1 = new Inventory<>();
        Inventory<NoteBook> inventory2 = new Inventory<>();
        Inventory<Accessory> inventory3 = new Inventory<>();

        inventory1.addItems(new Book("book1", 100000.0, "author1","Ofogh", "novel"));
        inventory1.addItems(new Book("book2", 200000.0, "author1", "fandogh", "comedy"));

        inventory2.addItems(new NoteBook("notebook1", 50000.0, 80, true));
        inventory2.addItems(new NoteBook("notebook2", 90000.0, 120, false));

        inventory3.addItems(new Accessory("accessory1", 400000.0, "red"));
        inventory3.addItems(new Accessory("accessory2", 70000.0, "yellow"));

        inventory1.displayAll();
        inventory2.displayAll();
        inventory3.displayAll();

        inventory1.removeItemsById(1001);
        inventory2.removeItemsById(2002);

        System.out.println("Total price of books: " + calculateTotalPrice(inventory1));
        System.out.println("Total price of notebooks: " + calculateTotalPrice(inventory2));
        System.out.println("Total price of accessories: " + calculateTotalPrice(inventory3));
        System.out.println();

        Product product1 = inventory1.findItemsById(1001);
        Product product2 = inventory3.findItemsById(3002);

        try {
            System.out.println(product1.toString());
        } catch (NullPointerException e ) {
            System.out.println();
        }
        System.out.println(product2.toString());

        inventory2.applyDiscount("notebook1", 50);
        inventory3.applyDiscount("accessory1", 80);

        inventory1.displayAll();
        inventory2.displayAll();
        inventory3.displayAll();
    }

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