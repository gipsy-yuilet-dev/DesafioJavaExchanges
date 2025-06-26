package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            CurrencyMenu.showMenu();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}