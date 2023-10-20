// Copyright (C) 2020
// All rights reserved
import java.util.Scanner;

public class VacationPackageCostEstimation {
  /**
   * Método para pedir datos por pantalla y calcular el precio del viaje.
   * @param args argumentos pasados a la función main
   */
    public static void main(String[] args) {
        
    	Scanner scanner = new Scanner(System.in);

        // Get user inputs
        System.out.println("Enter the destination of the vacation (Paris, New York City, or Other):");
        String destination = scanner.nextLine();
        System.out.println("Enter the number of travelers:");
        int numTravelers = scanner.nextInt();
        System.out.println("Enter the duration of the vacation in days:");
        int duration = scanner.nextInt();

        // Close the scanner
        scanner.close();

        // Calculate the base cost
        double baseCost = 1000.0;

        // Check if the destination is a popular tourist spot and add the corresponding cost
        if (destination.equalsIgnoreCase("Paris")) {
            baseCost += 500.0;
        } else if (destination.equalsIgnoreCase("New York City")) {
            baseCost += 600.0;
        } else if (!destination.equalsIgnoreCase("Other")) {
            // Invalid destination
            System.out.println("Invalid destination. Please choose from Paris, New York City, or Other.");
            System.out.println("Total cost: -1");
            return;
        }

        // Check if the number of travelers is valid
        if (numTravelers <= 0 || numTravelers > 80) {
            System.out.println("Invalid number of travelers. It should be between 1 and 80.");
            System.out.println("Total cost: -1");
            return;
        }

        double totalCost = baseCost * numTravelers;
        if (numTravelers > 4 && numTravelers <= 10) {
            totalCost *= 0.90;
        } else if (numTravelers > 10) {
            totalCost *= 0.80;
        }

        if (duration < 7) {
            totalCost += 200.0; // Penalty fee
        } else if (duration > 30 || numTravelers == 2) {
            totalCost -= 200.0; // Promotion
        }

        // Display the total cost
        if (totalCost < 0) {
            System.out.println("Invalid total cost due to calculation error.");
        } else {
            System.out.println("Total cost: " + (int) totalCost);
        }
    }
}