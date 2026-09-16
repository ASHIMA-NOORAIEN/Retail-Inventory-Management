package MyProjects.java;
import java.util.ArrayList;
import java.util.Scanner;

// Custom User-Defined Exception for Stock Management
class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

// Interface for applying dynamic modifications
interface Discountable {
    void applyDiscount(double percentage);
}

// Base Class demonstrating Encapsulation
abstract class Product {
    private String id;
    private String name;
    protected double price;
    private int stock;

    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void reduceStock(int quantity) throws OutOfStockException {
        if (this.stock < quantity) {
            throw new OutOfStockException("Error: Not enough stock available for " + name);
        }
        this.stock -= quantity;
    }

    // Abstract method to force polymorphic behavior in subclasses
    public abstract void displayDetails();
}

// Subclass 1: Electronics
class Electronics extends Product implements Discountable {
    private int warrantyMonths;

    public Electronics(String id, String name, double price, int stock, int warrantyMonths) {
        super(id, name, price, stock);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public void applyDiscount(double percentage) {
        this.price -= (this.price * percentage / 100);
    }

    @Override
    public void displayDetails() {
        System.out.println("[Electronics] Name: " + getName() + " | Price: $" + getPrice() + 
                           " | Stock: " + getStock() + " | Warranty: " + warrantyMonths + " months");
    }
}

// Subclass 2: Clothing
class Clothing extends Product implements Discountable {
    private String size;

    public Clothing(String id, String name, double price, int stock, String size) {
        super(id, name, price, stock);
        this.size = size;
    }

    @Override
    public void applyDiscount(double percentage) {
        // Special rule: Clothing gets an extra flat 5% off during festival sales
        this.price -= (this.price * (percentage + 5) / 100);
    }

    @Override
    public void displayDetails() {
        System.out.println("[Clothing] Name: " + getName() + " | Price: $" + getPrice() + 
                           " | Stock: " + getStock() + " | Size: " + size);
    }
}

// Main System Class
public class MicroProjectSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> inventory = new ArrayList<>();

        // Seeding initial inventory data
        inventory.add(new Electronics("E101", "Laptop", 899.99, 5, 24));
        inventory.add(new Electronics("E102", "Smartphone", 499.99, 2, 12));
        inventory.add(new Clothing("C201", "Jacket", 79.99, 10, "L"));

        System.out.println("====== WELCOME TO THE RETAIL MANAGEMENT SYSTEM ======");
        
        while (true) {
            System.out.println("\n1. View Inventory");
            System.out.println("2.Place an Order");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("\n--- Current Inventory ---");
                for (Product p : inventory) {
                    p.displayDetails();
                }
            } 
            else if (choice == 2) {
                System.out.println("\n--- Available Items ---");
                for (int i = 0; i < inventory.size(); i++) {
                    System.out.println((i + 1) + ". " + inventory.get(i).getName() + " (In Stock: " + inventory.get(i).getStock() + ")");
                }
                
                System.out.print("Enter item number to purchase: ");
                int itemIdx = scanner.nextInt() - 1;
                System.out.print("Enter quantity: ");
                int qty = scanner.nextInt();

                if (itemIdx >= 0 && itemIdx < inventory.size()) {
                    Product selectedProduct = inventory.get(itemIdx);
                    // Standard Try-Catch block to safely handle out-of-stock incidents
                    try {
                        selectedProduct.reduceStock(qty);
                        double total = selectedProduct.getPrice() * qty;
                        System.out.println("Order Successful! Total Bill: $" + total);
                    } catch (OutOfStockException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Invalid selection.");
                }
            } 
            else if (choice == 3) {
                System.out.println("Exiting system. Goodbye!");
                break;
            } 
            else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}


