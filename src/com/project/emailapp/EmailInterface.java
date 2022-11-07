package com.project.emailapp;

public interface EmailInterface {
    public String generatePassword();
    public String department();
    public boolean setPassword(String password);
    public boolean setMailboxCapacity(int capacity);
    public String altEmail(String altEmail);
    public String getName();
    public String getEmail();
    public int getMailboxCapacity();
}
