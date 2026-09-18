package com.mycompany.poe;

// Imports Scanner so we can get user input
import java.util.Scanner;

// Create the Main class
public class Main {
    
    // Create Scanner for user input
    static Scanner input = new Scanner(System.in);
    
    // Store the user's entered details 
    static String username;
    static String password;
    static String cellphone;
    
    // Stores the registered username
    static String registeredUsername;
    
    // Store the registered password
    static String registeredPassword;
    
    // Store the registered cellphone number
    static String registeredCellphone;
    
    // Create the username checking method
    public static boolean checkUserName(String username) {
        // Username must have exactly 5 characters and must contain an underscore
        if (username.length() == 5 && username.contains("_")) {
            return true;
        } else {
            return false;
        }
    }
   
    // Create the password checking method
    public static boolean checkPasswordComplexity(String password) {
        // Password must have at least 8 characters 
        // and contains uppercase, lowercase, number, special characters 
        if (password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[a-z].*")
                && password.matches(".*[0-9].*")
                && password.matches(".*[^a-zA-Z0-9].*")) {
            return true;
        } else {
            return false;
        }
    }
    
    // Create the cellphone checking method
    public static boolean checkCellphoneNumber(String number) {
        // Number must start with +27 followed by exactly 9 digits
        if (number.matches("^\\+27[0-9]{9}$")) {
            return true;
        } else {
            return false;
        }
    }
    
    // Create the registration method
    public static void registerUser() {
        boolean registrationSuccessful = false;
        
        while (!registrationSuccessful) {
            // Ask for username
            System.out.print("Enter your username: ");
            username = input.nextLine();
            
            // Ask for password
            System.out.print("Enter your password: ");
            password = input.nextLine();
            
            // Ask for cellphone number
            System.out.print("Enter your cellphone number (+27): ");
            cellphone = input.nextLine();
            
            // Check details
            boolean usernameCorrect = checkUserName(username);
            boolean passwordCorrect = checkPasswordComplexity(password);
            boolean phoneCorrect = checkCellphoneNumber(cellphone);
            
            // Check if all registration details are correct
            if (usernameCorrect && passwordCorrect && phoneCorrect) {
                registeredUsername = username;
                registeredPassword = password;
                registeredCellphone = cellphone;
                System.out.println("User registered successfully.");
                registrationSuccessful = true;
            } else {
                System.out.println("Registration failed. Please ensure your username contains an underscore and is 5 chars, your password meets complexity rules, and your phone number starts with +27 followed by 9 digits.\n");
            }
        }
    }
    
    // Create the login method
    public static boolean loginUser(String loginUsername, String loginPassword) {
        // Compare entered details with registered details 
        if (loginUsername.equals(registeredUsername)
                && loginPassword.equals(registeredPassword)) {
            return true;
        } else {
            return false;
        }
    }
    
    // Create the login status method
    public static String returnLoginStatus(boolean loginSuccessful) {
        if (loginSuccessful) {
            return "Welcome, it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
    
    // Main method where the program starts
    public static void main(String[] args) {
        // Call registration method
        registerUser();
        
        // Prompt for login to test functionality
        System.out.println("\n--- Login ---");
        System.out.print("Enter username to login: ");
        String loginUserameInput = input.nextLine();
        
        System.out.print("Enter password to login: ");
        String loginPasswordInput = input.nextLine();
        
        // Call login method
        boolean loginSuccessful = loginUser(loginUserameInput, loginPasswordInput);
        
        // Call login status method
        System.out.println(returnLoginStatus(loginSuccessful));
    }
}