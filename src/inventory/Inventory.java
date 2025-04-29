package inventory;

import products.Product;

import java.util.ArrayList;
import java.util.Collections;

public class Inventory<T extends Product> {

    private ArrayList<T> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public ArrayList<T> getItems() { return items; }

    public void setItems(ArrayList<T> items) {
        this.items.clear();
        this.items.addAll(items);
    }

    public void applyDiscount(String productName, int discount) {

        boolean notFound = true;

        for (T t : items)
        {
            if( ! t.getTitle().equals(productName))
                continue;

            t.setPrice((double) (100 - discount) / 100 * t.getPrice());
            notFound = false;
        }

        if(notFound)
            throw new IllegalArgumentException("No product found with this name");
    }

    public void addItems( T product) {
        items.add(product);
    }

    public void removeItemsById(int id) {

        items.removeIf(t -> t.getId().equals(Integer.toString(id)));
    }

    public T findItemsById(int id) {

        for(T t : items)
        {
            if( ! t.getId().equals(Integer.toString(id)))
                continue;

            return t;
        }
        System.out.println("no product found with this id");
        return null;
    }

    public void displayAll() {

        for(T t : items)
        {
            System.out.println(t.toString());
        }
    }
}
