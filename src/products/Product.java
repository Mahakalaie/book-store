package products;

public abstract class Product {

    private String title;
    private Double price;
    private String id;

    public Product(String title, Double price) {

        setTitle(title);
        setPrice(price);
        setId(generateId());
    }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        if(title != null && !title.isEmpty())
            this.title = title;
        else
            throw new IllegalArgumentException("title can't be empty");
    }

    public Double getPrice() { return price; }

    public void setPrice(Double price) {
        if(price < 0)
            throw new IllegalArgumentException("price can't be negative");
        else
            this.price = price;
    }

    public String getId() { return id; }

    //i define the setter private so id can't be changed from other classes
    private void setId(String id) {
        if(id.length() == 4)
            this.id = id;
        else
            throw new IllegalArgumentException("id should have four digits");
    }

    @Override
    public String toString() {

        return "id: " + id + "\ntitle: " + title + "\nprice: " + price + "\n";
    }

    protected abstract String generateId();
}
