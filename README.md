# Smart Retail Inventory & Exception Management System

A robust, console-based Java application designed to manage retail store assets, monitor live inventory counts, and handle transactions securely. This application models real-world business mechanics by integrating strict object relationships and fallback systems to maintain database stability when stock boundaries are crossed.

 Object-Oriented System Architecture

This project maps real-world retail workflows directly into Java source structures by utilizing core Object-Oriented Programming (OOP) concepts from our course syllabus:

*Encapsulation Protects individual item states by mapping variable parameters (like `id`, `name`, and absolute stock values) as private data boundaries. State updates are accessed strictly via regulated getter and setter interfaces.
* Inheritance: Minimizes code duplication by nesting shared properties inside a root abstract template (`Product`). Specialized downstream models (`Electronics` and `Clothing`) extend this template to inherit core stock traits.
* Polymorphism (Dynamic Method Overriding): Overrides structural display logic across child classes via the `displayDetails()` implementation loop. Java dynamically binds execution paths at runtime based on the target class type.
* Interface Contracts: Enforces standard pricing modifiers via a standalone `Discountable` interface pattern, allowing scalable runtime markdown integrations without modifying underlying master classes.
*  Custom Exception Handling: Utilizes a custom user-defined
* `OutOfStockException  workflow to capture processing conflicts gracefully inside an isolation `try-catch` routine instead of letting the program crash.
Core Functional Modules

1. Warehouse Inventory Directory : Prints a comprehensive manifest of all warehouse listings complete with standard tracking parameters along with unique product line identifiers (such as active warranty contracts or clothing sizes).
2. Transactional Order Router: Maps user inputs against database availability metrics, executing dynamic inventory deductions upon successful payment balance validation.
3. Boundary Interception Matrix: Intercepts out-of-bounds orders immediately when single or bulk transactions exceed current warehouse capacity metrics, printing context-specific error lines.
 Expected System Output Logs
Scenario A: Warehouse Manifest Review
====== WELCOME TO THE RETAIL MANAGEMENT SYSTEM ======

1. View Inventory
2. Place an Order
3. Exit
Select an option: 1

--- Current Inventory ---
[Electronics] Name: Laptop | Price: $899.99 | Stock: 5 | Warranty: 24 months
[Electronics] Name: Smartphone | Price: $499.99 | Stock: 2 | Warranty: 12 months
[Clothing] Name: Jacket | Price: $79.99 | Stock: 10 | Size: L
```
Scenario B: Processing a Valid Sales Transaction

Select an option: 2

--- Available Items ---
1. Laptop (In Stock: 5)
2. Smartphone (In Stock: 2)
3. Jacket (In Stock: 10)
Enter item number to purchase: 3
Enter quantity: 2
Order Successful! Total Bill: $159.98
```
Scenario C: Boundary Interception Triggered (Out of Stock Exception)

Select an option: 2

--- Available Items ---
1. Laptop (In Stock: 5)
2. Smartphone (In Stock: 2)
3. Jacket (In Stock: 8)
Enter item number to purchase: 2
Enter quantity: 5
Error: Not enough stock available for Smartphone

Local Compilation & Execution

To compile and launch this program locally from your machine terminal workspace, execute the following commands:

```bash
 1. Compile the source file into a Java bytecode class
javac MicroProjectSystem.java

2. Initialize the application engine execution runner
java MicroProjectSystem
```
