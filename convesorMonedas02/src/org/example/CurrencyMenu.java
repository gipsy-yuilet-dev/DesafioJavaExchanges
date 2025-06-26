package org.example;

import com.google.gson.JsonObject;
import java.util.Scanner;

public class CurrencyMenu {
    private static final String[] CURRENCIES = {"CLP", "ARS", "BRL", "COP", "PEN"};
    private static final String[] NAMES = {
            "Peso Chileno (CLP)", "Peso Argentino (ARS)", "Real Brasileño (BRL)", "Peso Colombiano (COP)", "Soles Peruanos (PEN)"
    };

    public static void showMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        JsonObject rates = CurrencyConverter.getRates();

        while (true) {
            System.out.println("=== Conversor de Monedas ===");
            for (int i = 0; i < NAMES.length; i++) {
                System.out.println((i + 1) + ". " + NAMES[i]);
            }
            System.out.println("0. Salir");
            System.out.print("Seleccione una moneda para su conversion: ");
            int option = scanner.nextInt();

            if (option == 0) break;
            if (option < 1 || option > CURRENCIES.length) {
                System.out.println("Opción inválida.");
                continue;
            }

            String currency = CURRENCIES[option - 1];
            double rate = rates.get(currency).getAsDouble();

            System.out.print(" Por favor,Ingrese el monto: ");
            double amount = scanner.nextDouble();

            System.out.println("1. Convertir a Dólares (USD)");
            System.out.println("2. Convertir de Dólares (USD) a " + currency);
            int action = scanner.nextInt();

            if (action == 1) {
                double usd = CurrencyConverter.convertToUSD(amount, rate);
                System.out.printf("%.2f %s = %.2f USD\n", amount, currency, usd);
            } else if (action == 2) {
                double local = CurrencyConverter.convertFromUSD(amount, rate);
                System.out.printf("%.2f USD = %.2f %s\n", amount, local, currency);
            } else {
                System.out.println("Opción inválida.");
            }
            System.out.println();
        }
        scanner.close();
    }
}