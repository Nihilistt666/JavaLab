package com.lab4;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Company company;
    private static DatabaseManager dbManager;
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "input.txt";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Вкажіть шлях до db.properties як аргумент!");
            return;
        }

        company = new Company("Tech Solutions");
        dbManager = new DatabaseManager(args[0]);
        loadFromFile();

        System.out.println("=== Практична робота №12 - JDBC ===");

        while (true) {
            printMainMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> createEmployee();
                    case 2 -> printAllEmployees();
                    case 3 -> searchMenu();
                    case 0 -> {
                        saveToFile();
                        System.out.println("Дані збережено. Програма завершена.");
                        return;
                    }
                    default -> System.out.println("Невірний вибір!");
                }
            } catch (Exception e) {
                System.out.println("Помилка: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("1. Додати працівника");
        System.out.println("2. Вивести всіх");
        System.out.println("3. Пошук");
        System.out.println("0. Вийти");
        System.out.println("=".repeat(50));
        System.out.print("Вибір: ");
    }

    private static void createEmployee() {
        System.out.println("\n1.Contract 2.FullTime 3.Remote 4.Sales");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ПІБ: "); String name = scanner.nextLine();
        System.out.print("Посада: "); String pos = scanner.nextLine();
        System.out.print("Зарплата: "); double sal = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Відділ: "); String dep = scanner.nextLine();
        System.out.print("Стаж: "); int exp = scanner.nextInt(); scanner.nextLine();
        System.out.print("Кількість: "); int qty = scanner.nextInt(); scanner.nextLine();

        Employee emp = null;
        switch (type) {
            case 1 -> {
                System.out.print("Місяців контракту: "); int m = scanner.nextInt(); scanner.nextLine();
                emp = new ContractEmployee(name, pos, sal, dep, exp, m);
            }
            case 2 -> {
                System.out.print("Бонус (%): "); double b = scanner.nextDouble(); scanner.nextLine();
                emp = new FullTimeEmployee(name, pos, sal, dep, exp, b);
            }
            case 3 -> {
                System.out.print("Бонус (%): "); double b = scanner.nextDouble(); scanner.nextLine();
                System.out.print("Локація: "); String loc = scanner.nextLine();
                emp = new RemoteEmployee(name, pos, sal, dep, exp, b, loc);
            }
            case 4 -> {
                System.out.print("Бонус (%): "); double b = scanner.nextDouble(); scanner.nextLine();
                System.out.print("План продажів: "); double t = scanner.nextDouble(); scanner.nextLine();
                emp = new SalesEmployee(name, pos, sal, dep, exp, b, t);
            }
        }

        if (emp != null) {
            company.addEmployee(emp, qty);
            dbManager.saveEmployee(emp);
        }
    }

    private static void printAllEmployees() {
        System.out.println(company);
        for (Employee e : company.getEmployees()) {
            System.out.println(e);
        }
    }

    private static void searchMenu() {
        System.out.println("1. ПІБ 2. Посада 3. Зарплата >");
        int ch = scanner.nextInt();
        scanner.nextLine();

        switch (ch) {
            case 1 -> searchByFullName();
            case 2 -> searchByPosition();
            case 3 -> searchBySalary();
        }
    }

    private static void searchByFullName() {
        System.out.print("ПІБ: ");
        String name = scanner.nextLine().trim();
        boolean found = false;
        for (Employee e : company.getEmployees()) {
            if (e.getFullName().equalsIgnoreCase(name)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) System.out.println("Не знайдено.");
    }

    private static void searchByPosition() {
        System.out.print("Посада: ");
        String pos = scanner.nextLine().trim();
        boolean found = false;
        for (Employee e : company.getEmployees()) {
            if (e.getPosition().equalsIgnoreCase(pos)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) System.out.println("Не знайдено.");
    }

    private static void searchBySalary() {
        System.out.print("Зарплата більше ніж: ");
        double min = scanner.nextDouble();
        scanner.nextLine();
        boolean found = false;
        for (Employee e : company.getEmployees()) {
            if (e.getSalary() > min) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) System.out.println("Не знайдено.");
    }

    private static void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
            }
        } catch (Exception ignored) {}
    }

    private static void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Employee e : company.getEmployees()) {
                pw.println(e.toFileString());
            }
        } catch (Exception ignored) {}
    }
}
