import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
    public static void main(String[] args) {

        // add
        ArrayList<String> names = new ArrayList<>();
        names.add("ahmad");
        names.add("ali");
        names.add("sara");
        names.add(2, "omar");
        System.out.println("After add: " + names);   // [ahmad, ali, omar, sara]

        // get
        System.out.println("get(2): " + names.get(2)); // omar

        // set
        names.set(1, "khaled");
        System.out.println("After set: " + names);   // [ahmad, khaled, omar, sara]

        // Problem: remove inside a regular for loop (Index Shifting)
        ArrayList<String> wrong = new ArrayList<>(names);
        System.out.println("size before: " + wrong.size());   // 4
        for (int i = 0; i < wrong.size(); i++) {
            wrong.remove(i);
        }
        System.out.println("size after (wrong): " + wrong.size()); // 2, not 0

        // Solution: Iterator
        ArrayList<String> correct = new ArrayList<>(names);
        Iterator<String> it = correct.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        System.out.println("size after (Iterator): " + correct.size()); // 0
        System.out.println(correct.isEmpty() ? "Yes, it is empty" : "No, is not");
    }
}