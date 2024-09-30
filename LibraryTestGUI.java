import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LibraryTestGUI {

    public static class Book {
        private String title;
        private String author;
        private int id;

        public Book(String title, String author, int id) {
            this.title = title;
            this.author = author;
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
        // Create the library array list
        ArrayList<Book> library = new ArrayList<>();

        // Create the main frame
        JFrame frame = new JFrame("Library Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        
        // Create panels
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        
        JPanel displayPanel = new JPanel();
        JTextArea displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        
        // Create labels and text fields
        JLabel titleLabel = new JLabel("Book Title:");
        JTextField titleField = new JTextField(15);
        
        JLabel authorLabel = new JLabel("Book Author:");
        JTextField authorField = new JTextField(15);
        
        JLabel idLabel = new JLabel("Book ID:");
        JTextField idField = new JTextField(15);
        
        // Create buttons
        JButton addButton = new JButton("Add Book");
        JButton removeButton = new JButton("Remove Book by ID");
        JButton displayButton = new JButton("Display All Books");
        JButton exitButton = new JButton("Exit");

        // Add action listeners for buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();
                int id;
                
                try {
                    id = Integer.parseInt(idField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid ID format.");
                    return;
                }

                boolean idExists = false;
                for (Book book : library) {
                    if (book.getId() == id) {
                        idExists = true;
                        break;
                    }
                }

                if (idExists) {
                    JOptionPane.showMessageDialog(frame, "Book with this ID already exists.");
                } else {
                    library.add(new Book(title, author, id));
                    displayArea.append("Book added: " + title + " by " + author + " (ID: " + id + ")\n");
                    titleField.setText("");
                    authorField.setText("");
                    idField.setText("");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id;
                try {
                    id = Integer.parseInt(idField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid ID format.");
                    return;
                }

                boolean found = false;
                for (Book book : library) {
                    if (book.getId() == id) {
                        library.remove(book);
                        displayArea.append("Book removed: ID " + id + "\n");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(frame, "No book found with that ID.");
                }

                idField.setText("");
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (library.isEmpty()) {
                    displayArea.append("No books to display.\n");
                } else {
                    displayArea.append("Displaying all books:\n");
                    for (Book book : library) {
                        displayArea.append(book + "\n");
                    }
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add components to the panel
        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(authorLabel);
        panel.add(authorField);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(displayButton);
        panel.add(exitButton);

        // Add panels to frame
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);

        // Make the frame visible
        frame.setVisible(true);
    }
}
