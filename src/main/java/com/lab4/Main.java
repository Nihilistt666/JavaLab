package com.lab4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Employee> employees = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Практична робота №7 - Наслідування та Поліморфізм ===");

        while (true) {
            printMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> addContractEmployee();
                    case 2 -> addFullTimeEmployee();
                    case 3 -> printAllEmployees();
                    case 0 -> { System.out.println("Завершення програми."); return; }
                    default -> System.out.println("Невірний вибір!");
                }
            } catch (Exception e) {
                System.out.println("Помилка: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("1. Додати ContractEmployee");
        System.out.println("2. Додати FullTimeEmployee");
        System.out.println("3. Вивести всіх працівників (поліморфізм)");
        System.out.println("0. Вийти");
        System.out.println("=".repeat(50));
        System.out.print("Вибір: ");
    }

    private static void addContractEmployee() {
        // введення даних (скорочено)
        System.out.print("ПІБ: "); String name = scanner.nextLine();
        System.out.print("Посада: "); String pos = scanner.nextLine();
        System.out.print("Зарплата: "); double sal = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Відділ: "); String dep = scanner.nextLine();
        System.out.print("Стаж: "); int exp = scanner.nextInt(); scanner.nextLine();
        System.out.print("Телефон: "); String phone = scanner.nextLine();
        System.out.print("Повна зайнятість (true/false): "); boolean ft = scanner.nextBoolean(); scanner.nextLine();
        System.out.print("Тривалість контракту (міс): "); int months = scanner.nextInt(); scanner.nextLine();

        employees.add(new ContractEmployee(name, pos, sal, dep, exp, phone, ft, months));
        System.out.println("ContractEmployee додано.");
    }

    private static void addFullTimeEmployee() {
        // аналогічно
        System.out.print("ПІБ: "); String name = scanner.nextLine();
        System.out.print("Посада: "); String pos = scanner.nextLine();
        System.out.print("Зарплата: "); double sal = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Відділ: "); String dep = scanner.nextLine();
        System.out.print("Стаж: "); int exp = scanner.nextInt(); scanner.nextLine();
        System.out.print("Телефон: "); String phone = scanner.nextLine();
        System.out.print("Повна зайнятість: "); boolean ft = scanner.nextBoolean(); scanner.nextLine();
        System.out.print("Бонус (%): "); double bonus = scanner.nextDouble(); scanner.nextLine();

        employees.add(new FullTimeEmployee(name, pos, sal, dep, exp, phone, ft, bonus));
        System.out.println("FullTimeEmployee додано.");
    }

    private static void printAllEmployees() {
        System.out.println("\n=== Всі працівники (поліморфізм) ===");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
