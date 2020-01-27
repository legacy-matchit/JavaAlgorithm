import java.util.ArrayList;
import java.util.List;

public class MainDemo {
    public static void main(String[] args) {
        List<Book> list = new ArrayList<>();
        list.add(new Book("9780345917431","Abc","DDD"));
        list.add(new Book("9780345917432","Abc","DDD"));
        list.add(new Book("9780345917433","Abc","DDD"));
        list.add(new Book("9780345917434","Abc","DDD"));
        list.add(new Book("9780345917430","Abc","DDD"));

        System.out.println(list.contains(new Book("9780345917430","A","B")));
        System.out.println(list.indexOf(new Book("9780345917430","A","B")));


        Book b = new Book("9780345917430","Abc","DDD");
        Book c = new Book("9780345917430","Abc","DDD");

        System.out.println(b.compareTo(c));
    }
}
