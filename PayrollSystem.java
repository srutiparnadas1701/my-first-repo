import java.util.*;

// Employee Class
class Employee {
    private int id;
    private String name;
    private double basicSalary;
    private double hra;
    private double da;
    private double tax;
    private double netSalary;

    // Constructor
    public Employee(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        calculateSalary();
    }

    // Salary Calculation
    public void calculateSalary() {
        hra = 0.20 * basicSalary;
        da = 0.10 * basicSalary;
        tax = 0.05 * basicSalary;
        netSalary = basicSalary + hra + da - tax;
    }

    // Display Employee Details
    public void display() {
        System.out.println("--------------------------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("HRA (20%): " + hra);
        System.out.println("DA (10%): " + da);
        System.out.println("Tax (5%): " + tax);
        System.out.println("Net Salary: " + netSalary);
        System.out.println("--------------------------------------------------");
    }

    public int getId() {
        return id;
    }
}

// Main Class
public class PayrollSystem {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Employee
    public static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, salary);
        employees.add(emp);

        System.out.println("✅ Employee Added Successfully!");
    }

    // View All Employees
    public static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("⚠ No employees found!");
            return;
        }

        for (Employee emp : employees) {
            emp.display();
        }
    }

    // Search Employee
    public static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.display();
                return;
            }
        }

        System.out.println("❌ Employee not found!");
    }

    // Delete Employee
    public static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.getId() == id) {
                iterator.remove();
                System.out.println("🗑 Employee Deleted!");
                return;
            }
        }

        System.out.println("❌ Employee not found!");
    }

    // Menu
    public static void menu() {
        int choice;

        do {
            System.out.println("\n====== Employee Payroll System ======");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("👋 Exiting Program...");
                    break;
                default:
                    System.out.println("⚠ Invalid choice!");
            }

        } while (choice != 5);
    }

    // Main Method
    public static void main(String[] args) {
        menu();
    }
}
