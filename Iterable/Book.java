
public class Book   {
    private String title;
    private int Cach;

    private boolean borrowed;

    public Book() {
    }

    public Book(String title, int Cach) {

        this.title = title;
        this.Cach = Cach;

    }

    public int getCach() {
        return Cach;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", Cach=" + Cach +
                ", borrowed=" + borrowed +
                '}';
    }

    public String getTitle() {
        return title;
    }
}

