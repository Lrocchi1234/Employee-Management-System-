import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        int id;

        // Create an instance of DBConnection class
        DBConnection dbConnection = new DBConnection();
        
        // Create an instance of Employeedbimpl class and pass the dbConnection object
        Employeedbintrf db = new Employeedbimpl(dbConnection);
        
        System.out.println("Welcome to Employee Management System ");
        Scanner sc = new Scanner(System.in);

        // Establish a database connection
        dbConnection.createDBConnection();

        do {
            System.out.println("1. Add Employee\n" + "2. Show All Employee\n" + "3. Show Employee based on ID \n"
                    + "4. Update the Employee\n" + "5. Delete Employee");
            System.out.println("Enter Choice:");
            int ch = sc.nextInt();
            
            switch (ch) {
                case 1:
                    employee emp = new employee();
                    System.out.println("Enter ID: ");
                    id = sc.nextInt();
                    System.out.println("Enter name: ");
                    name = sc.next();
                    System.out.println("Enter Salary: ");
                    double salary = sc.nextDouble();
                    System.out.println("Enter Age: ");
                    int age = sc.nextInt();
                    
                    // Set the values for the employee object
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    
                    // Call the createEmployee method to add the employee to the database
                    db.createEmployee(emp);
                    break;
                    
                case 2:
                    // Call the showAllEmployee method to display all employees
                    db.showAllEmployee();
                    break;
                    
                case 3:
                    System.out.println("Enter ID to show the details:");
                    int empid = sc.nextInt();
                    
                    System.out.println("-----------------------------------");
                    System.out.format("%s\t%s\t%s\t%s\n", "ID   |", "Name  |", "Salary     |", "Age");
                    System.out.println("-----------------------------------");
                    
                    // Call the showEmployeeBasedOnID method to display the details of an employee based on ID
                    db.showEmployeeBasedOnID(empid);
                    
                    System.out.println("-----------------------------------");
                    break;
                    
                case 4:
                    System.out.println("Enter id to update the details:");
                    int empid1 = sc.nextInt();
                    System.out.println("Enter the new Name:");
                    name = sc.next();
                    
                    // Call the updateEmployee method to update the employee's name
                    db.updateEmployee(empid1, name);
                    System.out.println("-----------------------------------");
                    break;
                    
                case 5:
                    System.out.println("Enter the id to delete");
                    id = sc.nextInt();
                    
                    // Call the deleteEmployee method to delete an employee from the database
                    db.deleteEmployee(id);
                    break;
                    
                case 6:
                    System.out.println("Thank you for using our Application");
                    
                    // Close the database connection before exiting
                    dbConnection.closeConnection();
                    System.exit(0);
                    
                default:
                    System.out.println("Enter Valid Choice ");
                    break;
            }
        } while (true);
    }
}
