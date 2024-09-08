import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeTest {

    public static class Employee {
        private String name;
        private int id;
        private int salary;

        public Employee(String name, int id, int salary) {
            this.name = name;
            this.id = id;
            this.salary = salary;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public int getSalary() {
            return salary;
        }

        public String toString() {
            return "Employee Name: " + name + ", ID: " + id + ", Salary: $" + salary;
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("\nEmployee management: ");
            System.out.println("1. Add employee ");
            System.out.println("2. Remove employee by ID ");
            System.out.println("3. Display all employees ");
            System.out.println("4. Exit ");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();  // Consume the newline

            if (choice == 1) {
                System.out.println("Enter employee name: ");
                String name = input.nextLine();
                System.out.println("Enter employee ID: ");
                int id = input.nextInt();
                boolean idExists = false;
                for (Employee emp : employees) {
                    if (emp.getId() == id) {
                        idExists = true;
                        break;
                    }
                }
                if (idExists) {
                    System.out.println("Employee with this ID already exists. Please use a unique ID.");
                } else {
                    System.out.println("Enter employee salary: ");
                    int salary = input.nextInt();
                    employees.add(new Employee(name, id, salary));
                    System.out.println("Employee added.");
                }
            } 
            else if (choice == 2) {
                System.out.println("Enter the employee ID to remove: ");
                int idOfRemove = input.nextInt();
                boolean found = false;
                for (Employee emp : employees) {
                    if (emp.getId() == idOfRemove) {
                        employees.remove(emp);
                        System.out.println("Employee removed.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("No employee found with that ID.");
                }
            } 
            else if (choice == 3) {
                if (employees.isEmpty()) {
                    System.out.println("No employees to display.");
                } else {
                    System.out.println("Displaying all employees:");
                    for (Employee employee : employees) {
                        System.out.println(employee);
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
