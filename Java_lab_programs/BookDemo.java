import java.util.Scanner;

class Book {
    private String name;
    private String author;
    private double price;
    private int numPages;

    // Constructor
    public Book(String name, String author, double price, int numPages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getNumPages() {
        return numPages;
    }

    // toString method
    public String toString() {
        return "Book Name: " + name + "\nAuthor: " + author + 
               "\nPrice: ₹" + price + "\nNumber of Pages: " + numPages;
    }
}

public class BookDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of book " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Number of pages: ");
            int numPages = sc.nextInt();
            sc.nextLine(); // consume newline

            books[i] = new Book(name, author, price, numPages);
        }

        System.out.println("\n--- Book Details ---");
        for (int i = 0; i < n; i++) {
            System.out.println("\nBook " + (i + 1) + ":\n" + books[i]);
        }

        sc.close();
    }
}