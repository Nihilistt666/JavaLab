package com.lab4;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Employee> employees = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "input.txt";

    public static void main(String[] args) {
        loadFromFile();
        System.out.println("=== Практична робота №10 - Пошук у колекціях ===");

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
            } catch (InputMismatchException e) {
                System.out.println("Помилка: введіть число!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Помилка: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("1. Створити нового працівника");
        System.out.println("2. Вивести всіх працівників");
        System.out.println("3. Пошук працівника");
        System.out.println("0. Вийти (зберегти у файл)");
        System.out.println("=".repeat(50));
        System.out.print("Вибір: ");
    }

    private static void createEmployee() {
        System.out.println("\nТип працівника:");
        System.out.println("1. ContractEmployee");
        System.out.println("2. FullTimeEmployee");
        System.out.println("3. RemoteEmployee");
        System.out.println("4. SalesEmployee");
        System.out.print("Вибір: ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ПІБ: "); String name = scanner.nextLine();
        System.out.print("Посада: "); String pos = scanner.nextLine();
        System.out.print("Зарплата: "); double sal = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Відділ: "); String dep = scanner.nextLine();
        System.out.print("Стаж: "); int exp = scanner.nextInt(); scanner.nextLine();

        switch (type) {
            case 1 -> {
                System.out.print("Місяців контракту: "); int m = scanner.nextInt(); scanner.nextLine();
                employees.add(new ContractEmployee(name, pos, sal, dep, exp, m));
            }
            case 2 -> {
                System.out.print("Бонус (%): "); double b = scanner.nextDouble(); scanner.nextLine();
                employees.add(new FullTimeEmployee(name, pos, sal, dep, exp, b));
            }
            case 3 -> {
                System.out.print("Бонус (%): "); double b = scanner.nextDouble(); scanner.nextLine();
                System.out.print("Локація: "); String loc = scanner.nextLine();
                employees.add(new RemoteEmployee(name, pos, sal, dep, exp, b, loc));
            }
            case 4 -> {
                System.out.print("Бонус (%): "); double b = scanner.nextDouble(); scanner.nextLine();
                System.out.print("План продажів: "); double t = scanner.nextDouble(); scanner.nextLine();
                employees.add(new SalesEmployee(name, pos, sal, dep, exp, b, t));
            }
        }
        System.out.println("Працівник доданий.");
    }

    private static void printAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Список порожній.");
            return;
        }
        System.out.println("\n=== Всі працівники ===");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    private static void searchMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("Пошук за:");
        System.out.println("1. ПІБ");
        System.out.println("2. Посада");
        System.out.println("3. Зарплата більше ніж");
        System.out.println("0. Повернутися");
        System.out.println("=".repeat(40));
        System.out.print("Вибір: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> searchByFullName();
            case 2 -> searchByPosition();
            case 3 -> searchBySalary();
            case 0 -> {}
            default -> System.out.println("Невірний вибір!");
        }
    }

    private static void searchByFullName() {
        System.out.print("Введіть ПІБ для пошуку: ");
        String name = scanner.nextLine().trim();
        boolean found = false;
        for (Employee e : employees) {
            if (e.getFullName().equalsIgnoreCase(name)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) System.out.println("Не знайдено.");
    }

    private static void searchByPosition() {
        System.out.print("Введіть посаду: ");
        String pos = scanner.nextLine().trim();
        boolean found = false;
        for (Employee e : employees) {
            if (e.getPosition().equalsIgnoreCase(pos)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) System.out.println("Не знайдено.");
    }

    private static void searchBySalary() {
        System.out.print("Зарплата більше ніж: ");
        double minSalary = scanner.nextDouble();
        scanner.nextLine();
        boolean found = false;
        for (Employee e : employees) {
            if (e.getSalary() > minSalary) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) System.out.println("Не знайдено.");
    }

    private static void loadFromFile() {
        employees.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] p = line.split("\\|");
                String type = p[0];
                String name = p[1];
                String pos = p[2];
                double sal = Double.parseDouble(p[3]);
                String dep = p[4];
                int exp = Integer.parseInt(p[5]);

                switch (type) {
                    case "ContractEmployee" -> employees.add(new ContractEmployee(name, pos, sal, dep, exp, Integer.parseInt(p[6])));
                    case "FullTimeEmployee" -> employees.add(new FullTimeEmployee(name, pos, sal, dep, exp, Double.parseDouble(p[6])));
                    case "RemoteEmployee" -> employees.add(new RemoteEmployee(name, pos, sal, dep, exp, Double.parseDouble(p[6]), p[7]));
                    case "SalesEmployee" -> employees.add(new SalesEmployee(name, pos, sal, dep, exp, Double.parseDouble(p[6]), Double.parseDouble(p[7])));
                    default -> employees.add(new Employee(name, pos, sal, dep, exp));
                }
            }
        } catch (Exception e) {

        }
    }

    private static void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Employee e : employees) {
                pw.println(e.toFileString());
            }
        } catch (Exception e) {
            System.out.println("Помилка збереження.");
        }
    }
}
