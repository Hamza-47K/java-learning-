import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Library implements Iterable<Book>  {


List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public void removeBooksByTitle(String title, int Cach) {
Iterator<Book> it = books.iterator();
while (it.hasNext()) {
    Book b = it.next();
    if (b.getTitle().toLowerCase().contains(title.toLowerCase()) &&  b.getCach() == Cach) {
        it.remove();
    }
}
    }

    @Override
    public Iterator<Book> iterator() {
        return Collections.unmodifiableList(books).iterator();
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}
