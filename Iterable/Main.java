import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Book B1 = new Book("s 55 " , 60);
        Book B2 = new Book("s 66 " , 70);
        Book B3 = new Book("s 77 " , 80);

       Library library = new Library(new ArrayList<>(Arrays.asList(B1, B2, B3)));
        System.out.println(library);
       for (Book book : library) {
           System.out.println(book);
       }


        Scanner scanner = new Scanner(System.in);

        System.out.print("كلمة البحث: ");
        String title = scanner.nextLine();

        System.out.print("cach: ");
        int cach = scanner.nextInt();

        library.removeBooksByTitle(title, cach);

        for (Book book : library) {
            System.out.println(book);
        }


    }
}