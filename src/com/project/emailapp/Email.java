package com.project.emailapp;
import java.security.SecureRandom;
import java.util.Scanner;

public class Email implements EmailInterface {
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private int mailboxCapacity;
    private String department;
    private String password;
    private String alternateEmail;
    private final int DEFAULT_CAPACITY = 10000;
    private final int MAX_CAPACITY = 100000;
    Scanner sc = new Scanner(System.in);


    public Email(String f, String l, String company) { // email constructor setting name and company, asking for department, and generating a random password
        firstName = f.substring(0, 1).toUpperCase() + f.substring(1).toLowerCase();
        lastName = l.substring(0, 1).toUpperCase() + l.substring(1).toLowerCase();
        department = department();
        mailboxCapacity = DEFAULT_CAPACITY;
        password = generatePassword();
        this.company = company.toLowerCase();
        generateEmail(firstName, lastName, department, this.company);
    }
    public String generateEmail(String f, String l, String depart, String company) { // generates an email provided by the info in the Email constructor
        if (depart != null) {
            email = f.toLowerCase() + "." + l.toLowerCase() + "@" + depart.toLowerCase() + "." + company.toLowerCase() + ".com";
        }
        else {
            email = f.toLowerCase() + "." + l.toLowerCase() + "@" + company.toLowerCase() + ".com";
        }
        return email;
    }

    public String generatePassword() { // generates a random password
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance

        for (int i = 0; i < 15; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();

    }

    public String department() { // asks user for which department for email constructor
        String input;
        System.out.println("Hello, " + getName() + ". What department are you in (sales, accounting, development)? If no department, type 'none'");
        do {
            input = sc.nextLine().toLowerCase();
            switch (input) {
                case "sales" -> department = "Sales";
                case "accounting" -> department = "Accounting";
                case "development" -> department = "Development";
                case "none" -> department = null;
                default -> {
                    System.out.println("Invalid input");
                    input = "x";
                }
            }
        } while (input.equals("x"));
        return department;
    }

    public boolean setPassword(String pass) { // sets password based on user input and error checks based on length
        if (pass.length() > 16) {
            return false;
        }
        else if (pass.length() >= 8) {
            this.password = pass;
            return true;
        }
        else {
            return false;
        }
    }
    public void changePassword() {
        Scanner sc = new Scanner(System.in);
        String passInput;
        System.out.println("Would you like to change your password (Y or N)? ");
        char input = sc.nextLine().toUpperCase().charAt(0);
        if (input == 'Y') {
            do {
                System.out.println("Enter password: ");
                passInput = sc.nextLine();
                if(setPassword(passInput)) {
                    setPassword(passInput);
                    System.out.println("Your new password is " + getPassword());
                }
                else {
                    System.out.println("Invalid input");
                }
            } while(!(setPassword(passInput)));
        }
    }

    public boolean setMailboxCapacity(int capacity) {
        if (capacity < MAX_CAPACITY && capacity > 0) {
            mailboxCapacity = capacity;
            return true;
        }
        else {
            return false;
        }

    }
    public void changeMailboxCapacity() {
        Scanner sc = new Scanner(System.in);
        String input;
        int cap;
        char letter;
        System.out.println("Would you like to change your mailbox capacity (Y or N)");
        input = sc.nextLine().toUpperCase();
        letter = input.charAt(0);
        if (letter == 'Y') {
            do {
                System.out.println("Enter capacity (int): ");
                cap = sc.nextInt();
                if(setMailboxCapacity(cap)) {
                    System.out.println("Your new mailbox capacity is " + getMailboxCapacity());
                    break;
                }
                else if (cap > MAX_CAPACITY) {
                    System.out.println("That is over the max capacity. The max capacity is 100,000");
                }
                else {
                    System.out.println("Invalid input, try again");
                }
            } while (!setMailboxCapacity(cap));
        }
    }
    public String altEmail(String altEmail) {
        return this.alternateEmail = altEmail;
    }


    public String getName() {
        return firstName + " " + lastName;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }
}
