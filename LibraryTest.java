import java.util.ArrayList;
import java.util.Scanner;

public class LibraryTest {

    public static class Book {
        private String title;
        private String author;
        private int id;

        public Book(String title, String author, int id) {
            this.title = title;
            this.author = author;
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getId() {
            return id;
        }

        public String toString() {
            return "Book Title: " + title + ", Author: " + author + ", ID: " + id;
        }
    }

    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("\nLibrary management: ");
            System.out.println("1. Add book ");
            System.out.println("2. Remove book by ID ");
            System.out.println("3. Display all books ");
            System.out.println("4. Exit ");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();  // Consume the newline

            if (choice == 1) {
                System.out.println("Enter book title: ");
                String title = input.nextLine();
                System.out.println("Enter book author: ");
                String author = input.nextLine();
                System.out.println("Enter book ID: ");
                int id = input.nextInt();
                boolean idExists = false;
                for (Book book : library) {
                    if (book.getId() == id) {
                        idExists = true;
                        break;
                    }
                }
                if (idExists) {
                    System.out.println("Book with this ID already exists. Please use a unique ID.");
                } else {
                    library.add(new Book(title, author, id));
                    System.out.println("Book added.");
                }
            } 
            else if (choice == 2) {
                System.out.println("Enter the book ID to remove: ");
                int idOfRemove = input.nextInt();
                boolean found = false;
                for (Book book : library) {
                    if (book.getId() == idOfRemove) {
                        library.remove(book);
                        System.out.println("Book removed.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("No book found with that ID.");
                }
            } 
            else if (choice == 3) {
                if (library.isEmpty()) {
                    System.out.println("No books to display.");
                } else {
                    System.out.println("Displaying all books:");
                    for (Book book : library) {
                        System.out.println(book);
                    }
                }
            } 
            else if (choice == 4) {
                System.out.println("Exiting...");
            } 
            else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}
