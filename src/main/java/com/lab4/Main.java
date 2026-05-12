package com.lab4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Головний клас програми з консольним меню.
 * Обробляє винятки та некоректне введення.
 */
public class Main {
    private static final ArrayList<Employee> employees = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Практична робота №5 - Employee Management ===");

        while (true) {
            printMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // очищення буфера

                switch (choice) {
                    case 1 -> addNewEmployee();
                    case 2 -> printAllEmployees();
                    case 0 -> {
                        System.out.println("Програма завершена.");
                        return;
                    }
                    default -> System.out.println("Невірний вибір! Спробуйте ще раз.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка: введіть число!");
                scanner.nextLine(); // очищення некоректного вводу
            } catch (Exception e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("1. Додати нового працівника");
        System.out.println("2. Вивести всіх працівників");
        System.out.println("0. Вийти з програми");
        System.out.println("=".repeat(50));
        System.out.print("Ваш вибір: ");
    }

    private static void addNewEmployee() {
        try {
            System.out.println("\n=== Додавання нового працівника ===");

            System.out.print("ПІБ: ");
            String fullName = scanner.nextLine();

            System.out.print("Посада: ");
            String position = scanner.nextLine();

            System.out.print("Зарплата (грн): ");
            double salary = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Відділ: ");
            String department = scanner.nextLine();

            System.out.print("Стаж (років): ");
            int experience = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Номер телефону: ");
            String phone = scanner.nextLine();

            System.out.print("Повна зайнятість (true/false): ");
            boolean isFullTime = scanner.nextBoolean();
            scanner.nextLine();

            Employee emp = new Employee(fullName, position, salary, department,
                    experience, phone, isFullTime);

            employees.add(emp);
            System.out.println("✓ Працівник успішно доданий!");

        } catch (IllegalArgumentException e) {
            System.out.println("❌ Помилка валідації: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("❌ Помилка введення: введіть коректні дані!");
            scanner.nextLine();
        }
    }

    private static void printAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Список працівників порожній.");
            return;
        }

        System.out.println("\n=== СПИСОК ПРАЦІВНИКІВ (" + employees.size() + ") ===");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ". " + employees.get(i));
        }
    }
}
