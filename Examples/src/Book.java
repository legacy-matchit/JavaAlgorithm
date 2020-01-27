public class Book implements Comparable<Book>{
    private String isbn;
    private String title;
    private String author;
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
    public String toString() {
        return author + ": " + title;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Book)){
            return false;
        }
        Book o = (Book)obj;
        return isbn.compareTo(o.isbn)==0 ? true : false;
    }

    @Override
    public int compareTo(Book o) {
        return isbn.compareTo(o.isbn);
    }
}
