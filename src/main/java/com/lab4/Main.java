package com.lab4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Employee> employees = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Практична робота №8 - Розширена ієрархія ===");

        while (true) {
            printMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> createEmployee();
                    case 2 -> printAllEmployees();
                    case 0 -> {
                        System.out.println("Програма завершена.");
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

    private static void printMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("1. Створити нового працівника");
        System.out.println("2. Вивести всіх працівників");
        System.out.println("0. Вийти");
        System.out.println("=".repeat(60));
        System.out.print("Ваш вибір: ");
    }

    private static void createEmployee() {
        System.out.println("\nОберіть тип працівника:");
        System.out.println("1. ContractEmployee");
        System.out.println("2. FullTimeEmployee");
        System.out.println("3. RemoteEmployee");
        System.out.println("4. SalesEmployee");
        System.out.print("Тип: ");

        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ПІБ: ");
        String name = scanner.nextLine();
        System.out.print("Посада: ");
        String pos = scanner.nextLine();
        System.out.print("Зарплата: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Відділ: ");
        String dept = scanner.nextLine();
        System.out.print("Стаж (років): ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        switch (type) {
            case 1 -> {
                System.out.print("Тривалість контракту (міс): ");
                int months = scanner.nextInt();
                scanner.nextLine();
                employees.add(new ContractEmployee(name, pos, salary, dept, exp, months));
            }
            case 2 -> {
                System.out.print("Бонус (%): ");
                double bonus = scanner.nextDouble();
                scanner.nextLine();
                employees.add(new FullTimeEmployee(name, pos, salary, dept, exp, bonus));
            }
            case 3 -> {
                System.out.print("Бонус (%): ");
                double bonus = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Локація віддаленої роботи: ");
                String loc = scanner.nextLine();
                employees.add(new RemoteEmployee(name, pos, salary, dept, exp, bonus, loc));
            }
            case 4 -> {
                System.out.print("Бонус (%): ");
                double bonus = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("План продажів: ");
                double target = scanner.nextDouble();
                scanner.nextLine();
                employees.add(new SalesEmployee(name, pos, salary, dept, exp, bonus, target));
            }
            default -> System.out.println("Невірний тип!");
        }
    }

    private static void printAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Список порожній.");
            return;
        }
        System.out.println("\n=== Всі працівники (" + employees.size() + ") ===");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
