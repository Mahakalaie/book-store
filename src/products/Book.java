package products;

public class Book extends Product{

    private String author;
    private String publication;
    private String genre;

    private static int numberOfBooksAdded = 1;

    public Book(String title, Double price,
                String author, String publication, String genre) {

        super(title, price);
        setAuthor(author);
        setPublication(publication);
        setGenre(genre);
    }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public String getPublication() { return publication; }

    public void setPublication(String publication) { this.publication = publication; }

    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public String toString() {
        return super.toString() + "author: " + author + "\npublication: " + publication + "\ngenre: " + genre + "\n";
    }

    @Override
    protected String generateId() {
        String output = "1" + String.format("%03d", numberOfBooksAdded);
        numberOfBooksAdded++;
        return output;
    }
}
