package com.project.emailapp;

import java.util.Scanner;

public class tempmain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Email acc1 = new Email("Kyler" , "Kinsey", "Amazon");
        if (acc1.getDepartment() == null) {
            System.out.println("Hello " + acc1.getName());
        }
        else {
            System.out.println("Hello " + acc1.getName() + " from " + acc1.getDepartment());
        }
        System.out.println("Your email is " + acc1.getEmail());
        System.out.println("Your mailbox capacity is " + acc1.getMailboxCapacity());
        System.out.println("Your default password is " + acc1.getPassword());
        acc1.changeMailboxCapacity();
        acc1.changePassword();
        System.out.println("Thank you for using our service!");
    }
}
