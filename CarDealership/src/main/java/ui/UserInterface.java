package ui;

import data.DealershipFileManager;
import model.Dealership;
import model.Vehicle;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Dealership dealership;

    public void display() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
        System.out.println(dealership);

        Scanner scantron = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Welcome! Please choose your option below: ");
            String choice = scantron.nextLine();

            switch (choice) {
                case "1":
                    proccessGetByPrice();
                    break;

                case "2":
                    proccessGetByMakeModel();
                    break;

                case "3":
                    proccessGetByYear();
                    break;

                case "4":
                    processGetByColor();
                    break;

                case "5":
                    processGetByMileage();
                    break;

                case "6":
                    processGetByVehicleType();
                    break;

                case "7":
                    processGetByAllVehicles();
                    break;

                case "8":
                    processAddVehicleRequest();

                case "9":
                    processRemoveVehicleRequest();
                    break;

                case "10":
                    System.out.println("Exiting Program...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid inquiry try again");
            }
        }

        scantron.close();
    }

    private void displayMenu() {
        System.out.println("\n--- Dealership Menu ---");
        System.out.println("1. View All Vehicles");
        System.out.println("2. Search by Price");
        System.out.println("3. Search by Make and Model");
        System.out.println("4. Search by Year");
        System.out.println("5. Search by Color");
        System.out.println("6. Search by Vehicle Type");
        System.out.println("7. Add a Vehicle");
        System.out.println("8. Remove a Vehicle");
        System.out.println("9. Exit");

    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) ;
        System.out.println("No Vehicles Found.");
        return;
    }

    public void proccessGetByPrice() {

        Scanner scantron = new Scanner(System.in);

        try {
            System.out.println("Enter minimum price: ");
            double min = Double.parseDouble(scantron.nextLine);

            System.out.println("Enter maximum price: ");
            double max = Double.parseDouble(scantron.nextLine);

            List<Vehicle> results = proccessGetByPrice(min, max);
            displayVehicles(results);
        } catch (NumberFormatException e) {
            System.out.println("Invalid selection.");
        }
        scantron.close();
    }

    public void proccessGetByMakeModel() {
        Scanner scantron = new Scanner(System.in);

        System.out.println("Enter vehicle make: ");
        String make = scantron.nextLine();

        System.out.println("Enter vehicle model: ");
        String model = scantron.nextLine();

        List<Vehicle> results = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(results);

        scantron.close();
    }

public void proccessGetByYear() {
   Scanner scantron = new Scanner(System.in);
   try {
       System.out.println("Enter minimum year: ");
       int minYear = Integer.parseInt(scantron.nextLine);

       System.out.println("Enter maximun year: ");
       int maxYear = Integer.parseInt(scantron.nextLine);

       List<Vehicle> results = dealership.getVehiclesByYear(minYear, maxYear);
       displayVehicles(results);
   } catch (NumberFormatException e) {
       System.out.println("Invalid selection.");
   }
    scantron.close();
}

public void processGetByColor() {
        Scanner scantron = new Scanner(System.in);

    System.out.println("Enter vehicle color: ");
    String color = scantron.nextLine();

    List<Vehicle> results = dealership.getVehiclesByColor(color);
    displayVehicles(results);

    scantron.close();
}

public void processGetByVehicleType() {
        Scanner scantron = new Scanner(System.in);

    System.out.println("Enter vehicle type: ");
    String vehicleType = scantron.nextLine();

    List<Vehicle> results = dealership.getVehiclesByType(vehicleType);
    displayVehicles(results);

    scantron.close();
}

public void processAddVehicleRequest() {
        Scanner scantron = new Scanner(System.in);

    try {
        System.out.println("Enter VIN number: ");
        int vin = Integer.parseInt(scantron.nextLine();

        System.out.println("Enter vehicle year: ");
        int year = Integer.parseInt(scantron.nextLine);

        System.out.println("Enter vehicle make: ");
        String make = scantron.nextLine();

        System.out.println("Enter vehicle model: ");
        String model = scantron.nextLine();

        System.out.println("Enter vehicle type: ");
        String vehicleType = scantron.nextLine();

        System.out.println("Enter mileage: ");
        int mileage = Integer.parseInt(scantron.nextLine);

        System.out.println("Enter color: ");
        String color = scantron.nextLine();

        System.out.println("Enter price: ");
        double price = Double.parseDouble(scantron.nextLine);

    } catch (NumberFormatException e) {
        System.out.println("Invalid entry. Please try again.");
    }
    scantron.close();
}

    public void processRemoveVehicleRequest() {
        Scanner scantron = new Scanner(System.in);

        System.out.println("Enter VIN number to remove vehicle: ");
        try {
            int removeVehicle = Integer.parseInt(scantron.nextLine();

            List<Vehicle> results = dealership.removeVehicle(removeVehicle);
            displayVehicles(results);


        } catch (NumberFormatException e) {
            System.out.println("Invalid entry. Please try again.");
        }
        scantron.close();
    }
}

