package products;

import java.util.Locale;

public class NoteBook extends Product{

    private int pageCount;
    private boolean isHardCover;

    private static int numberOfNoteBooksAdded = 1;

    public NoteBook(String title, Double price, int pageCount, boolean isHardCover) {

        super(title, price);
        setPageCount(pageCount);
        setHardCover(isHardCover);
    }

    public int getPageCount() { return pageCount; }

    public void setPageCount(int pageCount) {
        if(pageCount > 0)
            this.pageCount = pageCount;
        else
            throw new IllegalArgumentException("number of pages must be positive");
    }

    public boolean isHardCover() { return isHardCover; }

    public void setHardCover(boolean isHardCover) { this.isHardCover = isHardCover; }

    @Override
    public String toString() {
        String output = super.toString() + "number of pages: " + pageCount;

        if(isHardCover)
            output += "\nHard cover\n";
        else
            output += "\nNot Hard cover\n";

        return output;
    }

    @Override
    protected String generateId() {
        String output = String.format(Locale.ENGLISH,"%d%03d", 2, numberOfNoteBooksAdded);
        numberOfNoteBooksAdded++;
        return output;
    }
}
