package org.printinghouse;

import org.printinghouse.exceptions.InvalidMachineTypeException;
import org.printinghouse.models.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Employee> employees = new ArrayList<>();
    private static List<Publication> publications = new ArrayList<>();
    private static List<PrintingFactory> factories = new ArrayList<>();
    private static PrintingFactory currentFactory = null;
    private static BigDecimal totalCosts = BigDecimal.ZERO;
    private static Publication Publication;

    public Main() {
    }

    public static void main(String[] args) throws InvalidMachineTypeException {
        System.out.println("Welcome to the Printing House Management System!");
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addFactory(scanner);
                    break;
                case 2:
                    addMachine(scanner);
                    break;
                case 3:
                    createPublication(scanner);
                    break;
                case 4:
                    addEmployee(scanner);
                    break;
                case 5:
                    loadPaper(scanner);
                    break;
                case 6:
                    printPublication(scanner);
                    break;
                case 7:
                    calculateCostsAndRevenues();
                    break;
                case 8:
                    selectFactory(scanner);
                    break;
                case 9:
                    showAvailableMachines();
                    break;
                case 10:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void printPublication(Scanner scanner) {

    }

    private static void calculateCostsAndRevenues() {
    }

    private static void loadPaper(Scanner scanner) {
    }

    private static void showAvailableMachines() {
        if (currentFactory == null) {
            System.out.println("Please select a factory first.");
        } else {
            List<PrintingMachine> machines = currentFactory.getMachines();
            System.out.println("Available machines in " + currentFactory.getName() + ":");
            Iterator<PrintingMachine> iterator = machines.iterator();

            while (iterator.hasNext()) {
                PrintingMachine machine = iterator.next();
                System.out.println(machine.getId() + " - " + (machine.isColor() ? "Color" : "Black and White"));
            }

        }
    }

    private static void selectFactory(Scanner scanner) {
        System.out.println("Select a factory:");

        int choice;
        for (choice = 0; choice < factories.size(); ++choice) {
            System.out.println(choice + 1 + ". " + factories.get(choice).getName());
        }

        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();
        if (choice >= 1 && choice <= factories.size()) {
            currentFactory = factories.get(choice - 1);
            System.out.println("Selected factory: " + currentFactory.getName());
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addMachine(Scanner scanner) {
        if (currentFactory == null) {
            System.out.println("Please select a factory first.");
        } else {
            System.out.print("Enter machine type (1 for color, 2 for black and white): ");
            int type = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter machine ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter max paper capacity: ");
            int maxPaperCapacity = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter pages per minute: ");
            int pagesPerMinute = scanner.nextInt();
            scanner.nextLine();
            PrintingMachine machine;
            if (type == 1) {
                machine = new ColorPrintingMachine(id, maxPaperCapacity, pagesPerMinute);
            } else {
                if (type != 2) {
                    System.out.println("Invalid machine type. Please try again.");
                    return;
                }

                machine = new BWPrintingMachine(id, maxPaperCapacity, pagesPerMinute);
            }

            currentFactory.addMachine(machine);
        }
    }

    private static void addFactory(Scanner scanner) {
        System.out.print("Enter factory name: ");
        String name = scanner.nextLine();
        System.out.println("Enter price for a Book printing: ");
        BigDecimal bookPrice = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.println("Enter price for a Poster printing: ");
        BigDecimal posterPrice = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.println("Enter price for a Newspaper printing: ");
        BigDecimal newspaperPrice = scanner.nextBigDecimal();
        scanner.nextLine();
        System.out.println("Enter amount for deduction: ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter deduction percent: ");
        BigDecimal deduction = scanner.nextBigDecimal();
        scanner.nextLine();
        PrintingFactory factory = new PrintingFactory(name, bookPrice, posterPrice, newspaperPrice, amount, deduction);
        factories.add(factory);
        currentFactory = factory;
    }

    private static void printMenu() {
        System.out.println("Printing House Management System");
        System.out.println("1. Add new factory");
        System.out.println("2. Add new machine");
        System.out.println("3. Create Publication");
        System.out.println("4. Add Employee");
        System.out.println("5. Load Paper into Machine");
        System.out.println("6. Print Publication");
        System.out.println("7. Calculate Costs and Revenues");
        System.out.println("8. Select factory");
        System.out.println("9. Show available machines");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void createPublication(Scanner scanner) {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter number of pages: ");
        int numberOfPages = scanner.nextInt();
        System.out.print("Enter paper size (A1, A2, A3, A4, A5): ");
        PaperSize paperSize = PaperSize.valueOf(scanner.next().toUpperCase());
        scanner.nextLine();
        System.out.println("Enter paper type (REGULAR, GLOSSY, NEWSPAPER):");
        PaperType paperType = PaperType.valueOf(scanner.next().toUpperCase());
        scanner.nextLine();
        System.out.print("Enter type (1 for Book, 2 for Poster, 3 for Newspaper): ");
        int type = scanner.nextInt();
        scanner.nextLine();
        Object publication;
        switch (type) {
            case 1:
                publication = new Book(title, numberOfPages, paperSize, paperType, currentFactory.getPriceForBook());
                break;
            case 2:
                publication = new Poster(title, numberOfPages, paperSize, paperType, currentFactory.getPriceForPoster());
                break;
            case 3:
                publication = new NewsPaper(title, numberOfPages, paperSize, paperType, currentFactory.getPriceForNewsPaper());
                break;
            default:
                System.out.println("Invalid type. Publication not created.");
                return;
        }

        publications.add(Publication);
        System.out.println("Publication created successfully.");
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter base salary: ");
    }
}
